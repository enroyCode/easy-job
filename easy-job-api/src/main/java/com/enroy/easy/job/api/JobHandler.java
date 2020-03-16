/**
 * 版权所有(C)，上海海鼎信息工程股份有限公司，2020，所有权利保留。
 * <p>
 * 项目名：	easy-job
 * 文件名：	JobHandler.java
 * 模块说明：
 * 修改历史：
 * 2020/3/12 - zhuchao - 创建。
 */
package com.enroy.easy.job.api;

import org.springframework.core.annotation.AliasFor;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author zhuchao
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface JobHandler {

  String value() default "";

  @AliasFor("value")
  String name() default "";

  /**
   * 任务调度策略
   *
   * @see JobRouterStrategy
   */
  JobRouterStrategy strategy();
}
