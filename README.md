# blog
create table topic(
   id INT NOT NULL AUTO_INCREMENT,
   topic_name VARCHAR(50),
   short_desc VARCHAR(100),
   PRIMARY KEY ( id )
);


select * from topic;


select * from article;
select * from content;
select * from comments;
select * from reply;
 create table article (
 id INT NOT NULL AUTO_INCREMENT,
 topic_id INT,
auther VARCHAR(20),
created DATE,
modified DATE,
heading VARCHAR(200),
 primary key (id),
 FOREIGN KEY (topic_id) REFERENCES topic(id)
 );
 
  create table content (
 id INT NOT NULL AUTO_INCREMENT,
 article_id INT,
content_text VARCHAR(1000),
views  INT default 0,
 primary key (id),
 FOREIGN KEY (article_id) REFERENCES article(id)
 );
 
  create table comments (
 id INT NOT NULL AUTO_INCREMENT,
 article_id INT,
comment_text VARCHAR(400),
likes  INT default 0,
dislikes  INT default 0,
comment_date DATE,
 primary key (id),
 FOREIGN KEY (article_id) REFERENCES article(id)
 );
 
   create table reply (
 id INT NOT NULL AUTO_INCREMENT,
 comment_id INT,
reply_text VARCHAR(400),
likes  INT default 0,
dislikes  INT default 0,
reply_date DATE,
 primary key (id),
 FOREIGN KEY (comment_id) REFERENCES comments(id)
 );
