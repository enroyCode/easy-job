package com.enroy.easy.job.admin.daemon.db;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.SmartLifecycle;

import java.util.concurrent.atomic.AtomicBoolean;

@Slf4j
public abstract class SmartLifeCycleAdapter implements SmartLifecycle {
  protected abstract void doStart() throws Exception;

  private final AtomicBoolean initialized = new AtomicBoolean(false);

  @Override
  public boolean isAutoStartup() {
    return true;
  }

  @Override
  public void stop(Runnable callback) {
    callback.run();
  }

  @Override
  public void start() {
    if (!initialized.get()) {
      log.info("Starting...");
      try {
        doStart();
      } catch (Exception e) {
        log.error("Failed", e);
        System.exit(1);
      }
      initialized.set(true);
      log.info("Started");
    }
  }

  @Override
  public void stop() {
    initialized.set(false);
  }

  @Override
  public boolean isRunning() {
    return initialized.get();
  }

}
