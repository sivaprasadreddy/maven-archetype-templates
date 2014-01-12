
DROP TABLE IF EXISTS users;

CREATE TABLE  users 
(
  user_id int(10) NOT NULL auto_increment,
  username varchar(45) NOT NULL,
  password varchar(45) NOT NULL,
  email varchar(45) default NULL,
  PRIMARY KEY  (user_id)
);

insert into users(user_id, username, password, email) values(1, 'siva', 'prasad', 'sivaprasadreddy.k@gmail.com');
insert into users(user_id, username, password, email) values(2, 'admin', 'admin', 'admin@gmail.com');

