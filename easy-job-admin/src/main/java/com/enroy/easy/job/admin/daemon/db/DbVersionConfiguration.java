package com.enroy.easy.job.admin.daemon.db;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;

public class DbVersionConfiguration {
  @Bean
  @ConditionalOnMissingBean
  DbVersionService dbVersionService() {
    return new DbVersionService();
  }
}
