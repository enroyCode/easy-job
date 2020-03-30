package com.enroy.easy.job.admin.daemon.db;

import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Date;

//@enable
public interface DbVersionDao extends CrudRepository {
  @Modifying
  @Query(
          value = "create table dbVersion( appId varchar(50), version int, lastModified datetime, primary key (appId))"
  )
  void createTableDbVersion();

  void insert(String appId, @Param("version") long version, @Param("lastModified") Date lastModified);

  //
  Long getVersion(@Param("appId") String appId);

  //
  void update(@Param("appId") String appId, @Param("version") long version, @Param("lastModified") Date lastModified);

}
