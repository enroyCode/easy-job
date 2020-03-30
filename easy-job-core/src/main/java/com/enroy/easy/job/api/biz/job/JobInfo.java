/**
 * 版权所有(C)，上海海鼎信息工程股份有限公司，2020，所有权利保留。
 * <p>
 * 项目名：	learn
 * 文件名：	JobInfo.java
 * 模块说明：
 * 修改历史：
 * 2020/3/25 - zhuchao - 创建。
 */
package com.enroy.easy.job.api.biz.job;

import com.enroy.easy.job.api.ExecutorBlockStrategy;
import com.enroy.easy.job.api.JobRouterStrategy;
import com.enroy.easy.job.api.biz.entity.StandardEntity;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhuchao
 */
@Data
public class JobInfo extends StandardEntity {
  //job信息
  private String jobGroup;    // 执行器主键ID
  private String jobCron;    // 任务执行CRON表达式
  private String jobDesc;
  //执行配置
  private String executorHandler;        // 执行器，任务Handler名称
  private String executorParam;        // 执行器，任务参数
  private int executorTimeout;        // 任务执行超时时间，单位秒
  private int executorFailRetryCount;    // 失败重试次数
  private JobRouterStrategy executorRouteStrategy;  // 执行器路由策略
  private ExecutorBlockStrategy executorBlockStrategy;  // 阻塞处理策略
  //运行监控
  private int triggerStatus;    // 调度状态：0-停止，1-运行
  private long triggerLastTime;  // 上次调度时间
  private long triggerNextTime;  // 下次调度时间
  private String executorMessage;//job执行结果
  //预警
  private String author;    // 负责人
  private String alarmEmail;  // 报警邮件
  //子任务
  private List<String> childJobIds = new ArrayList<>();    // 子任务ID，多个逗号分隔
}
