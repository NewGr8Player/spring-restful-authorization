CREATE TABLE user (
  id       VARCHAR(50)        NOT NULL,
  username VARCHAR(20) UNIQUE NOT NULL,
  password VARCHAR(20)        NOT NULL,
  nickname VARCHAR(20)        NOT NULL,
  PRIMARY KEY (id)
);

INSERT INTO user (username, password, nickname) VALUES ('1', 'admin', 'password', 'admin');