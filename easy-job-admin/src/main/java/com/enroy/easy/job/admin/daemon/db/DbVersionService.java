package com.enroy.easy.job.admin.daemon.db;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.EncodedResource;
import org.springframework.jdbc.datasource.DataSourceUtils;
import org.springframework.jdbc.datasource.init.ScriptUtils;
import org.springframework.jdbc.support.JdbcUtils;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.io.File;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import static com.enroy.easy.job.api.biz.EasyJobConsts.BEAN_DATASOURCE;

@Slf4j
@Service
public class DbVersionService {

  @Autowired
  @Qualifier(BEAN_DATASOURCE)
  private DataSource dataSource;
  @Autowired
  private DbVersionDao dbVersionDao;

  public boolean isTableExist(String tableName) throws SQLException {
    Connection con = null;
    try {
      con = dataSource.getConnection();
      DatabaseMetaData dbmd = con.getMetaData();
      ResultSet rs = dbmd.getTables(con.getCatalog(), con.getSchema(), tableName, new String[]{"TABLE"});
      if (rs.next()) return true;
      rs = dbmd.getTables(con.getCatalog(), con.getSchema(), tableName.toUpperCase(), new String[]{"TABLE"});
      if (rs.next()) return true;
    } finally {
      JdbcUtils.closeConnection(con);
    }
    return false;
  }

  public long getVersion(String appId) throws SQLException {
    if (!isTableExist("dbVersion")) {
      dbVersionDao.createTableDbVersion();
    }
    Long version = dbVersionDao.getVersion(appId);
    if (version == null) {
      dbVersionDao.insert(appId, 0, new Date());
      version = 0L;
    }
    log.info("Database version: {} {}", appId, version);
    return version;
  }

  public void updateVersion(String appId, long version) {
    dbVersionDao.update(appId, version, new Date());
    log.info("Database version updated: {} {}", appId, version);
  }

  public void runScript(String filePath) throws SQLException {
    Connection conn = null;
    try {
      conn = dataSource.getConnection();
      File newfile = new File(filePath);
      Resource resource = new FileSystemResource(newfile);
      EncodedResource resourceDelegate = new EncodedResource(resource);
      ScriptUtils.executeSqlScript(conn, resource);
    } catch (Exception e) {
      log.error("", e);
      throw e;
    } finally {
      DataSourceUtils.releaseConnection(conn, dataSource);
    }
  }
}
