/**
 * 版权所有(C)，上海海鼎信息工程股份有限公司，2020，所有权利保留。
 * <p>
 * 项目名：	easy-job
 * 文件名：	EasyJobProperites.java
 * 模块说明：
 * 修改历史：
 * 2020/3/12 - zhuchao - 创建。
 */
package com.enroy.easy.job.api;

import lombok.Data;

/**
 * @author zhuchao
 */
@Data
public class EasyJobProperties {
  /** 调度中心地址 */
  private String adminAddress;
  /** 是否开启集群 */
  private boolean clusterEnable = false;
  /** 调度器 */
  private String schedulers;
  /** 执行器属性 */
  private String executors;
  /** 使用的数据库，集群时要求使用相同的数据库 */
  private DataSourceProperties dataSource;

  @Data
  public static class DataSourceProperties {
    private String url;
    private String driverClassName;
    private String username;
    private String password;
    private String validationQuery = "select 1";
    private int initialSize = 0;
    private int minIdle = 0;
    private int maxActive = 8;
    private long maxWait = -1;
    private long timeBetweenEvictionRunsMillis;
    private long minEvictableIdleTimeMillis = 30000;
    private boolean testOnBorrow = false;
    private boolean testOnReturn = false;
  }
}
