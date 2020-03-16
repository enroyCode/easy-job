/**
 * 版权所有(C)，上海海鼎信息工程股份有限公司，2020，所有权利保留。
 * <p>
 * 项目名：	easy-job
 * 文件名：	JobExecutor.java
 * 模块说明：
 * 修改历史：
 * 2020/3/12 - zhuchao - 创建。
 */
package com.enroy.easy.job.core.executor;

import com.enroy.easy.job.api.EasyJobProperties;
import com.enroy.easy.job.api.JobExecutor;

/**
 * @author zhuchao
 */
public class AbstractJobExecutor implements JobExecutor {
  private EasyJobProperties properties;

  public AbstractJobExecutor(EasyJobProperties properties) {
    this.properties = properties;
  }

  public EasyJobProperties getProperties() {
    return properties;
  }
}
