package com.enroy.easy.job.starter;

import com.enroy.easy.job.starter.config.JobManageConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @author zhuchao
 */
@Configuration
@ConditionalOnClass
@Import({JobManageConfiguration.class})
public class EasyJobConfiguration {
}
