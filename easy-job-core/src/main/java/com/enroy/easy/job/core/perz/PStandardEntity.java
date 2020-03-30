/**
 * 版权所有(C)，上海海鼎信息工程股份有限公司，2020，所有权利保留。
 * <p>
 * 项目名：	learn
 * 文件名：	PStandardEntity.java
 * 模块说明：
 * 修改历史：
 * 2020/3/25 - zhuchao - 创建。
 */
package com.enroy.easy.job.core.perz;

/**
 * @author zhuchao
 */
public abstract class PStandardEntity extends PVersionedEntity {
  /** “创建时间”字段名。 */
  public static String CREATE_INFO_TIME = "created";
  public static String CREATE_INFO_UUID = "creator_uuid";
  public static String CREATE_INFO_CODE = "creator_code";
  public static String CREATE_INFO_NAME = "creator_name";

  public static String LAST_MODIFY_INFO_TIME = "lastModified";
  public static String LAST_MODIFY_INFO_UUID = "lastModifier_uuid";
  public static String LAST_MODIFY_INFO_CODE = "lastModifier_code";
  public static String LAST_MODIFY_INFO_NAME = "lastModifier_name";

  public static String[] allColumns() {
    return toColumnArray(PVersionedEntity.allColumns(), //
                         CREATE_INFO_TIME, //
                         CREATE_INFO_UUID, //
                         CREATE_INFO_CODE, //
                         CREATE_INFO_NAME, //
                         LAST_MODIFY_INFO_TIME, //
                         LAST_MODIFY_INFO_UUID, //
                         LAST_MODIFY_INFO_CODE, //
                         LAST_MODIFY_INFO_NAME);
  }
}
