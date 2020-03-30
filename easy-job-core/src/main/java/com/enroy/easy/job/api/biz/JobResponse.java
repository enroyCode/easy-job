/**
 * 版权所有(C)，上海海鼎信息工程股份有限公司，2019，所有权利保留。
 * <p>
 * 项目名：	rpg
 * 文件名：	RestResponse.java
 * 模块说明：
 * 修改历史：
 * 2019/10/25 - zhuchao - 创建。
 */
package com.enroy.easy.job.api.biz;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @author zhuchao
 */
@Data
@NoArgsConstructor
@Accessors(chain = true)
public class JobResponse<T> implements Serializable {
  private static final long serialVersionUID = 1215353759832751890L;
  protected boolean success = true;
  protected int code = 200;
  protected String message = "请求成功";
  protected T data;

  public static final JobResponse OK = new JobResponse();

  public static JobResponse ok() {
    return OK;
  }

  public static <T> JobResponse<T> ok(T data) {
    JobResponse<T> r = new JobResponse();
    r.setData(data);
    return r;
  }

  public static JobResponse fail(String message) {
    JobResponse r = new JobResponse();
    r.setSuccess(false);
    r.setMessage(message);
    return r;
  }

  public static JobResponse fail(int code, String message) {
    JobResponse r = new JobResponse();
    r.setSuccess(false);
    r.setCode(code);
    r.setMessage(message);
    return r;
  }
}
