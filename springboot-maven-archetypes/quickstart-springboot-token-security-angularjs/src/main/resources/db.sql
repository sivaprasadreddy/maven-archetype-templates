
CREATE TABLE roles (
  id bigint(20) NOT NULL AUTO_INCREMENT,
  name varchar(50) NOT NULL,
  PRIMARY KEY (id)
);


INSERT INTO roles (id,name) VALUES 
 (1,'ROLE_ADMIN'),
 (2,'ROLE_USER');


CREATE TABLE users (
  id bigint(20) NOT NULL AUTO_INCREMENT,
  email varchar(100) DEFAULT NULL,
  login varchar(50) NOT NULL,
  password varchar(60) NOT NULL,
  PRIMARY KEY (id),
  UNIQUE KEY UK_login (login),
  UNIQUE KEY UK_email (email)
);

INSERT INTO users (id,email,login,password) VALUES 
 (1,'admin@gmail.com','admin','$2a$10$gSAhZrxMllrbgj/kkK9UceBPpChGWJA7SYIb1Mqo.n5aNLq1/oRrC'),
 (2,'user@gmail.com','user','$2a$10$VEjxo0jq2YG9Rbk2HmX9S.k1uZBGYUHdUcid3g/vfiEl7lwWgOH/K');


CREATE TABLE user_role (
  user_id bigint(20) NOT NULL,
  role_id varchar(50) NOT NULL,
  PRIMARY KEY (user_id,role_id),
  FOREIGN KEY (user_id) REFERENCES users (id),
  FOREIGN KEY (authority_name) REFERENCES roles (id)
);

INSERT INTO user_role (user_id,role_id) VALUES 
 (1,1),
 (1,2),
 (2,2);

