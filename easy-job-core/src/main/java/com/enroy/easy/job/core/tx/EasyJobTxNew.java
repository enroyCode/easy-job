package com.enroy.easy.job.core.tx;

import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Transactional(value = "easy-job.txManager", propagation = Propagation.REQUIRES_NEW,
        rollbackFor = Throwable.class, isolation = Isolation.READ_COMMITTED)
public @interface EasyJobTxNew {
}
