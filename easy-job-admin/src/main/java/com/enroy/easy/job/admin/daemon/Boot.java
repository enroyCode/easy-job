/**
 * 版权所有(C)，上海海鼎信息工程股份有限公司，2020，所有权利保留。
 * <p>
 * 项目名：	learn
 * 文件名：	Boot.java
 * 模块说明：
 * 修改历史：
 * 2020/3/30 - zhuchao - 创建。
 */
package com.enroy.easy.job.admin.daemon;

import com.enroy.easy.job.admin.daemon.db.DbVersionService;
import com.enroy.easy.job.admin.daemon.db.SmartLifeCycleAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

/**
 * @author zhuchao
 */
@Component
public class Boot extends SmartLifeCycleAdapter {
  @Autowired
  private DbVersionService dbVersionService;

  @Override
  protected void doStart() throws Exception {
    String APP_ID = "rpg-admin";
    long version = dbVersionService.getVersion(APP_ID);
    long DB_VERSION = 1;
    if (version == 0) {
      dbVersionService.runScript("/mysql/createTables.sql");
      dbVersionService.updateVersion(APP_ID, DB_VERSION);
      version = dbVersionService.getVersion(APP_ID);
    }
    Assert.isTrue(version == DB_VERSION,
                  "Database version mismatch: required=" + DB_VERSION + ", actual=" + version);
  }
}
