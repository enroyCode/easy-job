/**
 * 版权所有(C)，上海海鼎信息工程股份有限公司，2020，所有权利保留。
 * <p>
 * 项目名：	learn
 * 文件名：	PExecutorInfo.java
 * 模块说明：
 * 修改历史：
 * 2020/3/25 - zhuchao - 创建。
 */
package com.enroy.easy.job.core.dao.executor;

import com.enroy.easy.job.core.perz.PStandardEntity;

/**
 * @author zhuchao
 */
public class PExecutorInfo extends PStandardEntity {
  public static final String EXECUTOR_ID = "executor_id";
  public static final String REST_SERVICE_ID = "rest_service_id";
  public static final String REST_URL = "rest_url";
  public static final String REST_USER = "rest_user";
  public static final String REST_PASSWORD = "rest_password";

  public static String[] allColumns() {
    return toColumnArray(PStandardEntity.allColumns(), //
                         EXECUTOR_ID, //
                         REST_SERVICE_ID, //
                         REST_URL, //
                         REST_USER, //
                         REST_PASSWORD);
  }

}
