/**
 * 版权所有(C)，上海海鼎信息工程股份有限公司，2020，所有权利保留。
 * <p>
 * 项目名：	learn
 * 文件名：	ClusterClient.java
 * 模块说明：
 * 修改历史：
 * 2020/3/25 - zhuchao - 创建。
 */
package com.enroy.easy.job.core.client;

import com.enroy.easy.job.core.config.ClusterConfiguration;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author zhuchao
 */
@FeignClient(name = "easy-job-admin", configuration = ClusterConfiguration.class)
@RequestMapping("/com/enroy/easy/job/api/cluster")
public interface ClusterClient {
}
