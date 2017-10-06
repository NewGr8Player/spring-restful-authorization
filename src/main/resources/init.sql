create table user (
  username varchar(20) unique not null,
  password varchar(20) not null,
  id int unsigned autoincrement,
  nickname varchar(20) not null,
  primary key(id)
);

insert into user (username, password, nickname) values ('admin', 'password', 'admin' );