/**
 * 版权所有(C)，上海海鼎信息工程股份有限公司，2020，所有权利保留。
 * <p>
 * 项目名：	learn
 * 文件名：	ClusterConfiguration.java
 * 模块说明：
 * 修改历史：
 * 2020/3/25 - zhuchao - 创建。
 */
package com.enroy.easy.job.core.config;

import feign.Logger;
import feign.Request;
import feign.RequestInterceptor;
import feign.Retryer;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.MDC;
import org.springframework.context.annotation.Bean;

/**
 * @author zhuchao
 */
@Slf4j
public class ClusterConfiguration {

//  @Bean
//  public BasicAuthRequestInterceptor basicAuthorizationInterceptor(@Autowired EasyJobProperties properties) {
//    return new BasicAuthRequestInterceptor(properties.getAdmin().getUser(), properties.getAdmin().getPassword());
//  }

  @Bean
  public RequestInterceptor traceInterceptor() {
    return requestTemplate -> requestTemplate.header("trace_id", MDC.get("trace_id"));
  }

  /**
   * connectionTimeout为100s,readTimeout为100s
   */
  @Bean
  Request.Options options() {
    return new Request.Options(100000, 100000);
  }

  /**
   * 重试次数
   */
  @Bean
  Retryer retryer() {
    return Retryer.NEVER_RETRY;
  }

  @Bean
  Logger.Level feignLoggerLevel() {
    return Logger.Level.FULL;
  }
}
