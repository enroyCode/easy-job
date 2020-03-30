package com.enroy.easy.job.admin.daemon.db;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.JdbcUtils;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;

@Slf4j
public class DbVersionService {

  @Autowired
  private JdbcTemplate jdbcTemplate;

  public boolean isTableExist(String tableName) throws SQLException {
    Connection con = null;
    try {
      con = jdbcTemplate.getDataSource().getConnection();
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

//  public long getVersion(String appId) throws SQLException {
//    if (!isTableExist("dbVersion")) {
//      dbVersionDao.createTableDbVersion();
//    }
//    Long version = dbVersionDao.getVersion(appId);
//    if (version == null) {
//      dbVersionDao.insert(appId, 0, new Date());
//      version = 0L;
//    }
//    log.info("Database version: {} {}", appId, version);
//    return version;
//  }
//
//  public void updateVersion(String appId, long version) {
//    dbVersionDao.update(appId, version, new Date());
//    log.info("Database version updated: {} {}", appId, version);
//  }
//
//  public void runScript(String script, boolean throwWaring, String delimiter) {
//    try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
//      ScriptRunner runner = new ScriptRunner(sqlSession.getConnection());
//      runner.setStopOnError(true);
//      runner.setThrowWarning(throwWaring);//此处修改为waring不抛出异常，否则 if not exists会报错
//      if (StringUtils.isNotBlank(delimiter)) {
//        runner.setDelimiter(delimiter);
//      }
//      log.info("Executing SQL script: {}", getClass().getResource(script));
//      Reader reader = new InputStreamReader(getClass().getResourceAsStream(script));
//      runner.runScript(reader);
//    }
//  }
}
