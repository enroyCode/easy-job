/**
 * 版权所有(C)，上海海鼎信息工程股份有限公司，2020，所有权利保留。
 * <p>
 * 项目名	easy-job
 * 文件名	JobRouterStrategy.java
 * 模块说明
 * 修改历史
 * 2020/3/12 - zhuchao - 创建。
 */
package com.enroy.easy.job.api;

/**
 * 任务路由策略
 *
 * @author zhuchao
 */
public enum JobRouterStrategy {
  /** 固定选择第一个机器 */
  FIRST("第一个"),
  /** 固定选择最后一个机器 */
  LAST("最后一个"),
  /** 轮询 */
  ROUND("轮询"),
  /** 随机选择在线的机器 */
  RANDOM("随机"),
  /** 每个任务按照Hash算法固定选择某一台机器，且所有任务均匀散列在不同机器上 */
  CONSISTENT_HASH("一致性HASH"),
  /** 使用频率最低的机器优先被选举 */
  LEAST_FREQUENTLY_USED("最不经常使用"),
  /** 最久未使用的机器优先被选举 */
  LEAST_RECENTLY_USED("最近最久未使用"),
  /** 按照顺序依次进行心跳检测，第一个心跳检测成功的机器选定为目标执行器并发起调度 */
  FAIL_OVER("故障转移"),
  /** 按照顺序依次进行空闲检测，第一个空闲检测成功的机器选定为目标执行器并发起调度 */
  BUSY_OVER("忙碌转移"),
  /** 广播触发对应集群中所有机器执行一次任务，同时系统自动传递分片参数；可根据分片参数开发分片任务 */
  SHARDING_BROADCAST("分片广播");

  JobRouterStrategy(String caption) {
    this.caption = caption;
  }

  private String caption;

  public String getCaption() {
    return caption;
  }
}
