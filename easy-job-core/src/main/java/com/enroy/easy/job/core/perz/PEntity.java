/**
 * 版权所有(C)，上海海鼎信息工程股份有限公司，2020，所有权利保留。
 * <p>
 * 项目名：	learn
 * 文件名：	PEntity.java
 * 模块说明：
 * 修改历史：
 * 2020/3/25 - zhuchao - 创建。
 */
package com.enroy.easy.job.core.perz;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhuchao
 */
public abstract class PEntity {
  /** “UUID”字段名。 */
  public static String UUID = "uuid";

  /**
   * 取得包含所有来自{@link PEntity}的字段名的数组。
   */
  public static String[] allColumns() {
    return toColumnArray(null, UUID);
  }

  public static String[] toColumnArray(String[] array, String... columns) {
    List<String> list = new ArrayList<String>();
    if (array != null) {
      for (String column : array) {
        if (StringUtils.isBlank(column)) {
          continue;
        }
        list.add(column);
      }
    }
    for (String column : columns) {
      if (StringUtils.isBlank(column)) {
        continue;
      }
      list.add(column);
    }
    return list.toArray(new String[]{});
  }
}
