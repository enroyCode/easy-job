package com.enroy.easy.job.admin.filter;

import com.enroy.easy.job.admin.biz.TokenContext;
import com.enroy.easy.job.admin.biz.TokenData;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

@Slf4j
public class JwtAuthFilter extends OncePerRequestFilter {
  private TokenService tokenService;
  private ApplicationContext appCtx;

  @Autowired
  public JwtAuthFilter(TokenService tokenService) {
    this.tokenService = tokenService;
  }

  @Override
  protected void initFilterBean() {
    this.appCtx = WebApplicationContextUtils.getWebApplicationContext(getServletContext());
  }

  @Override
  protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response,
                                  FilterChain chain) throws ServletException, IOException {
    URI uri;
    try {
      uri = new URI(request.getRequestURI());
    } catch (URISyntaxException e) {
      throw new ServletException(e);
    }
    String path = uri.getPath();
    // 请求方法是OPTIONS，跳过
    if ("OPTIONS".equals(request.getMethod())) {
      log.debug("url {} method is option, need not authenticate, ignored", request.getRequestURI());
      chain.doFilter(request, response);
      return;
    }
    // 如果指定的地址不进行授权控制，跳过
    if (ignorePath(getPathInfo(request, this.appCtx))) {
      if (log.isDebugEnabled()) {
        log.debug("url {} need not authenticate, ignored", request.getRequestURI());
      }
      chain.doFilter(request, response);
      return;
    }
    // 先清除上下文的token数据
    TokenContext.remove();
    // 从cookie中获得token
    String token = tokenService.extractTokenFromCookie(request);
    if (token == null) {
      log.warn("cookie中没有token");
      tokenRejected(response);
      return;
    }
    // 验证token
    TokenData tokenData = tokenService.verifyToken(token);
    if (tokenData == null) {
      log.warn("token验证不通过: {}", token);
      tokenRejected(response);
      return;
    }
    // 检查token身份
    String newToken = tokenService.refreshToken(token, tokenData);
    if (newToken == null) {
      log.warn("token身份无效: {}", tokenData);
      tokenRejected(response);
      return;
    }

    // 更新token
    if (!newToken.equals(token)) {
      log.debug("刷新token: {}", newToken);
      tokenService.createCookie(request, response, newToken);
    }
    // token验证通过
    tokenAccepted(tokenData);
    chain.doFilter(request, response);
  }

  public boolean ignorePath(String path) {
    if (StringUtils.isBlank(path)) {
      return true;
    }
    return path.startsWith("/web/login");
  }

  private String getPathInfo(HttpServletRequest request, ApplicationContext applicationContext) {
    String contextPath = applicationContext.getEnvironment()
            .getProperty("server.servlet.context-path");
    if (StringUtils.isNotBlank(contextPath)) {
      return request.getRequestURI().replaceAll("//", "/").replace(contextPath, "");
    } else {
      return request.getRequestURI().replaceAll("//", "/");
    }
  }

  private void tokenAccepted(TokenData tokenData) {
    // 放入token上下文
    TokenData targetToken = new TokenData();
    targetToken.putAll(tokenData.getMap());
    TokenContext.set(targetToken);
  }

  private void tokenRejected(HttpServletResponse response) {
    response.setStatus(401);
  }
}
