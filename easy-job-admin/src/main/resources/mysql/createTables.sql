create table if not exists ej_executor (
  executor_id varchar(38) not null,
  rest_service_id varchar(100),
  rest_url varchar(255),
  rest_user varchar(255),
  rest_password varchar(255),
  primary key (executor_id),
  unique(path)
) engine=InnoDB character set=utf8mb4;