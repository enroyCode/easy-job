/**
 * 版权所有(C)，上海海鼎信息工程股份有限公司，2020，所有权利保留。
 * <p>
 * 项目名：	learn
 * 文件名：	Consts.java
 * 模块说明：
 * 修改历史：
 * 2020/3/30 - zhuchao - 创建。
 */
package com.enroy.easy.job.api.biz;

/**
 * 常量定义
 *
 * @author zhuchao
 */
public class EasyJobConsts {
  /** 数据源 */
  public static final String BEAN_DATASOURCE = "easy-job.dataSource";
  /** JdbcTemplate */
  public static final String BEAN_JDBC_TEMPLATE = "easy-job.jdbcTemplate";

  public static final String BEAN_SQL_SESSION_FACTORY = "easy-job.sqlSessionFactory";

  public static final String BEAN_SQL_SESSION_TEMPLATE = "easy-job.sqlSessionTemplate";
  /** 事务管理器 */
  public static final String BEAN_TX_MANAGER = "easy-job.txManager";
}
