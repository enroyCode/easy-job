/**
 * 版权所有(C)，上海海鼎信息工程股份有限公司，2020，所有权利保留。
 * <p>
 * 项目名：	rpg
 * 文件名：	TokenConfig.java
 * 模块说明：
 * 修改历史：
 * 2020/2/26 - zhuchao - 创建。
 */
package com.enroy.easy.job.admin.config;

import com.enroy.easy.job.admin.biz.TokenProps;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author zhuchao
 */
@Configuration
public class TokenConfiguration {
  @Bean
  @ConfigurationProperties(prefix = "token")
  public TokenProps tokenProps() {
    return new TokenProps();
  }
}
