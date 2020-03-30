package com.enroy.easy.job.admin.daemon.db;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.Date;

public interface DbVersionDao {
  @Update({
          "create table dbVersion(",
          "  appId varchar(50),",
          "  version int,",
          "  lastModified datetime,",
          "  primary key (appId)",
          ")"
  })
  void createTableDbVersion();

  @Insert({
          "insert into dbVersion (appId, version) values (#{appId}, #{version})"
  })
  void insert(@Param("appId") String appId, @Param("version") long version, @Param("lastModified") Date lastModified);

  @Select({
          "select version from dbVersion where appId=#{appId}"
  })
  Long getVersion(@Param("appId") String appId);

  @Update({
          "update dbVersion set version=#{version}, lastModified=#{lastModified} where appId=#{appId}"
  })
  void update(@Param("appId") String appId, @Param("version") long version, @Param("lastModified") Date lastModified);

}
