/**
 * 版权所有(C)，上海海鼎信息工程股份有限公司，2020，所有权利保留。
 * <p>
 * 项目名：	easy-job
 * 文件名：	JobDataSourceConfiguration.java
 * 模块说明：
 * 修改历史：
 * 2020/3/17 - zhuchao - 创建。
 */
package com.enroy.easy.job.starter.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.enroy.easy.job.api.EasyJobProperties;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

/**
 * @author zhuchao
 */
@Configuration
public class JobDataSourceConfiguration {
  @Bean("easy-job.dataSource")
  @ConditionalOnMissingBean(name = "easy-job.dataSource")
  public DataSource dataSource(EasyJobProperties properties) {
    DruidDataSource dataSource = new DruidDataSource();
    dataSource.setDriverClassName(properties.getDataSource().getDriverClassName());
    dataSource.setUrl(properties.getDataSource().getUrl());
    dataSource.setUsername(properties.getDataSource().getUsername());
    dataSource.setPassword(properties.getDataSource().getPassword());
    dataSource.setInitialSize(properties.getDataSource().getInitialSize());
    dataSource.setMinIdle(properties.getDataSource().getMinIdle());
    dataSource.setMaxActive(properties.getDataSource().getMaxActive());
    dataSource.setMaxWait(properties.getDataSource().getMaxWait());
    dataSource.setTimeBetweenEvictionRunsMillis(properties.getDataSource().getTimeBetweenEvictionRunsMillis());
    dataSource.setMinEvictableIdleTimeMillis(properties.getDataSource().getMinEvictableIdleTimeMillis());
    dataSource.setValidationQuery(properties.getDataSource().getValidationQuery());
    dataSource.setTestOnBorrow(properties.getDataSource().isTestOnBorrow());
    dataSource.setTestOnReturn(properties.getDataSource().isTestOnReturn());
    return dataSource;
  }

  @Bean("easy-job.jdbcTemplate")
  @ConditionalOnMissingBean(name = "easy-job.jdbcTemplate")
  public JdbcTemplate jdbcTemplate(@Qualifier("easy-job.dataSource") DataSource dataSource) {
    return new JdbcTemplate(dataSource);
  }

  @Bean("easy-job.txManager")
  public DataSourceTransactionManager transactionManager(@Qualifier("easy-job.dataSource") DataSource dataSource) {
    return new DataSourceTransactionManager(dataSource);
  }
}
