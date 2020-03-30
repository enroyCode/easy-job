/**
 * 版权所有(C)，上海海鼎信息工程股份有限公司，2020，所有权利保留。
 * <p>
 * 项目名：	learn
 * 文件名：	PVersionedEntity.java
 * 模块说明：
 * 修改历史：
 * 2020/3/25 - zhuchao - 创建。
 */
package com.enroy.easy.job.core.perz;

/**
 * @author zhuchao
 */
public abstract class PVersionedEntity extends PEntity {
  /** “版本号”字段名。 */
  public static String VERSION = "fversion";

  public static String[] allColumns() {
    return toColumnArray(PEntity.allColumns(), VERSION);
  }
}
