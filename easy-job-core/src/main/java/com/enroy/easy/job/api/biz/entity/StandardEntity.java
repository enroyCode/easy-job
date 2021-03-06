/**
 * 版权所有(C)，上海海鼎信息工程股份有限公司，2020，所有权利保留。
 * <p>
 * 项目名：	learn
 * 文件名：	StandardEntity.java
 * 模块说明：
 * 修改历史：
 * 2020/3/25 - zhuchao - 创建。
 */
package com.enroy.easy.job.api.biz.entity;

import lombok.Data;

/**
 * @author zhuchao
 */
@Data
public abstract class StandardEntity extends VersionedEntity {
  private OperateInfo createInfo;
  private OperateInfo lastModifyInfo;
}
