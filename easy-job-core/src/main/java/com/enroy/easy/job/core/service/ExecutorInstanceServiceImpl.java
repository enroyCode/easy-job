/**
 * 版权所有(C)，上海海鼎信息工程股份有限公司，2020，所有权利保留。
 * <p>
 * 项目名：	easy-job
 * 文件名：	ExecutorInstanceService.java
 * 模块说明：
 * 修改历史：
 * 2020/3/17 - zhuchao - 创建。
 */
package com.enroy.easy.job.core.service;

import com.enroy.easy.job.api.EasyJobProperties;
import com.enroy.easy.job.api.biz.job.ExecutorInstanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author zhuchao
 */
@Service
public class ExecutorInstanceServiceImpl implements ExecutorInstanceService {
  @Autowired
  private EasyJobProperties properties;

  public void register() {

  }
}
