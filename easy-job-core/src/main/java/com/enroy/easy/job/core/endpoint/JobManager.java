/**
 * 版权所有(C)，上海海鼎信息工程股份有限公司，2020，所有权利保留。
 * <p>
 * 项目名：	easy-job
 * 文件名：	JobMananger.java
 * 模块说明：
 * 修改历史：
 * 2020/3/12 - zhuchao - 创建。
 */
package com.enroy.easy.job.core.endpoint;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.actuate.endpoint.web.annotation.RestControllerEndpoint;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author zhuchao
 */
@Slf4j
@RestControllerEndpoint(id = "job")
public class JobManager {
  public JobManager() {
    log.info("JobManager");
  }

  @GetMapping("test")
  public String test() {
    return "ok";
  }
}
