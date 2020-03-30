/**
 * 版权所有(C)，上海海鼎信息工程股份有限公司，2020，所有权利保留。
 * <p>
 * 项目名：	learn
 * 文件名：	EasyJobApp.java
 * 模块说明：
 * 修改历史：
 * 2020/3/25 - zhuchao - 创建。
 */
package com.enroy.easy.job.admin;

import com.enroy.easy.job.admin.filter.JwtAuthFilter;
import com.enroy.easy.job.admin.filter.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

import javax.servlet.Filter;

/**
 * @author zhuchao
 */
@SpringBootApplication
public class EasyJobApp {
  public static void main(String[] args) {
    SpringApplication.run(EasyJobApp.class, args);
  }

  @Bean
  public FilterRegistrationBean jwtAuthFilter(@Autowired TokenService tokenService) {
    FilterRegistrationBean<Filter> registrationBean = new FilterRegistrationBean();
    registrationBean.setFilter(new JwtAuthFilter(tokenService));
    registrationBean.setName("jwtAuthFilter");
    registrationBean.addUrlPatterns("/web/*");
    registrationBean.setOrder(2);
    return registrationBean;
  }
}
