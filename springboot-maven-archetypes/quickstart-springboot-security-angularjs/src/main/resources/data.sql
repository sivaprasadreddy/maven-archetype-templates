
delete from tags;
delete from comments;
delete from posts;
delete from users;

insert into users(user_id, email, password, name, role) values(1,'admin@gmail.com','admin','Administrator','ROLE_ADMIN');
insert into users(user_id, email, password, name, role) values(2,'siva@gmail.com','siva','Siva Prasad','ROLE_USER');

insert into tags(tag_id, name, description) values
(1,'Java','Java Programming Language'),
(2,'Spring','Spring Framework'),
(3,'JavaEE','Java Enterprise Edition'),
(4,'Hibernate','Hibernate ORM Framework'),
(5,'JPA','Java Persistence API'),
(6,'AngularJS','Angular JS JavaScript Framework')
;

insert into posts(post_id, title, content, created_on, updated_on) values(1,'SpringBoot: Introducing SpringBoot','SpringBoot is a new spring portfolio project which takes opinionated view of building production-ready Spring applications by drastically reducing the amount of configuration required. Spring Boot is taking the convention over configuration style to the next level by registering the default configurations automatically based on the classpath libraries available at runtime.', '2014-06-20', null);
insert into posts(post_id, title, content, created_on, updated_on) values(2,'Exporting Spring Data JPA Repositories as REST Services using Spring Data REST','Spring Data modules provides various modules to work with various types of datasources like RDBMS, NOSQL stores etc in unified way. In my previous article  SpringMVC4 + Spring Data JPA + SpringSecurity configuration using JavaConfig I have explained how to configure Spring Data JPA using JavaConfig.', '2014-06-25', null);
insert into posts(post_id, title, content, created_on, updated_on) values(3,'SpringMVC4 + Spring Data JPA + SpringSecurity configuration using JavaConfig','In this article we will see how to configure and integrate SpringMVC4, Spring Data JPA with Hibernate and SpringSecurity using JavaConfig.', '2014-04-20', now());
insert into posts(post_id, title, content, created_on, updated_on) values(4,'Book Review: Enterprise Application Development with Ext JS and Spring','I was asked to review "Enterprise Application Development with Ext JS and Spring" book by Packtpub guys and here is my review on the book. Actually now I am working on a project which is being developed using ExtJS and I thought of buying this book. But surprisingly on the very next day I was asked to review this book and gave me the ebook :-).', '2014-05-20', null);
insert into posts(post_id, title, content, created_on, updated_on) values(5,'Clean Code: Dont mix different levels of abstractions','We spend more time on reading code than writing. So if the code is more readable then obviously it will increase the developer productivity. Many people associate readability of code with coding conventions like following standard naming conventions, closing file, DB resources etc etc. When it comes to code reviews most of the people focus on these trivial things only, like checking for naming convention violations, properly releasing resources in finally block or not.', '2014-03-20', null);
insert into posts(post_id, title, content, created_on, updated_on) values(6,'PrimeFaces Beginners Guide book published','I am glad to announce that my second book PrimeFaces Beginners Guide is published. As many of us know PrimeFaces is leading JSF component library for JSF based web applications. This PrimeFaces Beginners Guide book targets the Java developers with basic knowledge on JSF and jQuery and covers most of the commonly used PrimeFaces components.',  '2014-03-20', now());
insert into posts(post_id, title, content, created_on, updated_on) values(7,'Packt Publishing "Java Persistence With MyBatis3" published','Hurray...My first book "Java Persistence with MyBatis3" is published. I would like to thank Packt Publishers for giving me this opportunity to write on my favorite framework MyBatis.', '2014-02-20', null);
insert into posts(post_id, title, content, created_on, updated_on) values(8,'Deploying BroadleafCommerce 2.0 on JBoss AS 7','First 2 steps are not really related to Broadleaf specific, but mentioned to make it easy to follow(copy/paste) the steps. Step#1: Configure DataSources in JBoss AS.', '2014-01-20', now());


insert into comments(comment_id, post_id, email, name, content, created_on, updated_on) values(1, 1, 'guest@gmail.com', 'Guest','sample comment 1', now(), null);
insert into comments(comment_id, post_id, email, name, content, created_on, updated_on) values(2, 2, 'test@gmail.com', 'Test','sample comment 2', now(), null);
insert into comments(comment_id, post_id, email, name, content, created_on, updated_on) values(3, 2, 'test@gmail.com', 'Test','sample comment 3', now(), now());

