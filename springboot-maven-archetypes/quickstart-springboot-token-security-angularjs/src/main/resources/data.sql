
delete from user_role;
delete from roles;
delete from users;


INSERT INTO roles (id,name) VALUES 
 (1,'ROLE_ADMIN'),
 (2,'ROLE_USER');


INSERT INTO users (id,email,login,password) VALUES 
 (1,'admin@gmail.com','admin','$2a$10$gSAhZrxMllrbgj/kkK9UceBPpChGWJA7SYIb1Mqo.n5aNLq1/oRrC'),
 (2,'user@gmail.com','user','$2a$10$VEjxo0jq2YG9Rbk2HmX9S.k1uZBGYUHdUcid3g/vfiEl7lwWgOH/K');

INSERT INTO user_role (user_id,role_id) VALUES 
 (1,1),
 (1,2),
 (2,2);

