/**
 * 版权所有(C)，上海海鼎信息工程股份有限公司，2020，所有权利保留。
 * <p>
 * 项目名：	easy-job
 * 文件名：	JobManageConfiguration.java
 * 模块说明：
 * 修改历史：
 * 2020/3/12 - zhuchao - 创建。
 */
package com.enroy.easy.job.starter.config;

import com.enroy.easy.job.api.EasyJobProperties;
import com.enroy.easy.job.api.JobExecutor;
import com.enroy.easy.job.core.endpoint.JobManager;
import com.enroy.easy.job.core.executor.AbstractJobExecutor;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author zhuchao
 */
@Configuration
@ComponentScan(basePackageClasses = JobManager.class)
public class JobManageConfiguration {

  @Bean
  @ConditionalOnMissingBean(EasyJobProperties.class)
  @ConfigurationProperties(prefix = "easy-job")
  public EasyJobProperties properties() {
    return new EasyJobProperties();
  }

  @Bean("jobExecutor")
  @ConditionalOnMissingBean(JobExecutor.class)
  public JobExecutor jobExecutor(EasyJobProperties properties) {
    return new AbstractJobExecutor(properties);
  }

}
