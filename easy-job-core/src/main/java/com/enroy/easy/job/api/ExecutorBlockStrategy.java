/**
 * 版权所有(C)，上海海鼎信息工程股份有限公司，2020，所有权利保留。
 * <p>
 * 项目名：	learn
 * 文件名：	ExecutorBlockStrategy.java
 * 模块说明：
 * 修改历史：
 * 2020/3/25 - zhuchao - 创建。
 */
package com.enroy.easy.job.api;

/**
 * @author zhuchao
 */
public enum ExecutorBlockStrategy {
  SERIAL_EXECUTION("串行"),
  /*CONCURRENT_EXECUTION("并行"),*/
  DISCARD_LATER("放弃后一个"),
  COVER_EARLY("覆盖前一个");

  ExecutorBlockStrategy(String caption) {
    this.caption = caption;
  }

  private String caption;

  public String getCaption() {
    return caption;
  }
}
