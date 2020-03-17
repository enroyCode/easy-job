/**
 * 版权所有(C)，上海海鼎信息工程股份有限公司，2020，所有权利保留。
 * <p>
 * 项目名：	easy-job
 * 文件名：	JobInstance.java
 * 模块说明：
 * 修改历史：
 * 2020/3/17 - zhuchao - 创建。
 */
package com.enroy.easy.job.api.biz.job;

import lombok.Data;

/**
 * 执行器实例
 *
 * @author zhuchao
 */
@Data
public class ExecutorInstance {
  private String url;
  private String username;
  private String password;
  private boolean online;
}
