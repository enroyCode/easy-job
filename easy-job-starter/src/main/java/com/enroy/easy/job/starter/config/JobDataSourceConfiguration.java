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
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;

import static com.enroy.easy.job.api.biz.EasyJobConsts.BEAN_DATASOURCE;
import static com.enroy.easy.job.api.biz.EasyJobConsts.BEAN_SQL_SESSION_FACTORY;
import static com.enroy.easy.job.api.biz.EasyJobConsts.BEAN_SQL_SESSION_TEMPLATE;
import static com.enroy.easy.job.api.biz.EasyJobConsts.BEAN_TX_MANAGER;

/**
 * @author zhuchao
 */
@Configuration
@MapperScan(basePackages = "com.enroy.easy.job.core.dao", annotationClass = Repository.class)
public class JobDataSourceConfiguration {
  @Bean(BEAN_DATASOURCE)
  @ConditionalOnMissingBean(name = BEAN_DATASOURCE)
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

//  @Bean(BEAN_JDBC_TEMPLATE)
//  @ConditionalOnMissingBean(name = BEAN_JDBC_TEMPLATE)
//  public JdbcTemplate jdbcTemplate(@Qualifier(BEAN_DATASOURCE) DataSource dataSource) {
//    return new JdbcTemplate(dataSource);
//  }

  @Bean(BEAN_TX_MANAGER)
  @ConditionalOnMissingBean(name = BEAN_DATASOURCE)
  public DataSourceTransactionManager transactionManager(@Qualifier(BEAN_DATASOURCE) DataSource dataSource) {
    return new DataSourceTransactionManager(dataSource);
  }

  @Bean(BEAN_SQL_SESSION_FACTORY)
  @ConditionalOnMissingBean(name = BEAN_DATASOURCE)
  public SqlSessionFactory sqlSessionFactory(@Qualifier(BEAN_DATASOURCE) DataSource dataSource) throws Exception {
    SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
    bean.setDataSource(dataSource);
    return bean.getObject();
  }

  @Bean(BEAN_SQL_SESSION_TEMPLATE)
  @ConditionalOnMissingBean(name = BEAN_DATASOURCE)
  public SqlSessionTemplate sqlSessionTemplate(@Qualifier(BEAN_SQL_SESSION_FACTORY) SqlSessionFactory sqlSessionFactory) throws Exception {
    return new SqlSessionTemplate(sqlSessionFactory);
  }
}
