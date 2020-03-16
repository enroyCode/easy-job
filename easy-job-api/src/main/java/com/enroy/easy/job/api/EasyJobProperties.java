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
  /** 执行器属性 */
  private Executor executor;

  @Data
  public static class Executor {
    /** 服务名 */
    private String appname;
    /** 实例id */
    private String instanceId;
  }
}
