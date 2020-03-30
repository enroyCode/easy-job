/**
 * 版权所有(C)，上海海鼎信息工程股份有限公司，2020，所有权利保留。
 * <p>
 * 项目名：	learn
 * 文件名：	ExecutorMgr.java
 * 模块说明：
 * 修改历史：
 * 2020/3/25 - zhuchao - 创建。
 */
package com.enroy.easy.job.admin.endpoint.api;

import com.enroy.easy.job.api.EasyJobProperties;
import com.enroy.easy.job.api.biz.JobResponse;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhuchao
 */
@RestController
@RequestMapping("/com/enroy/easy/job/api/executor")
public class ExecutorMgr {
  @PostMapping("register")
  public JobResponse register(@RequestBody EasyJobProperties.Executor executor) {
    return JobResponse.ok();
  }
}
