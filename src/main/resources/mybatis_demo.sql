# 删除mybatis_demo数据库
drop database if exists mybatis_demo;

# 创建mybatis_demo数据库
create database mybatis_demo;

# 使用mybatis_demo数据库
use mybatis_demo;

# 创建account表
create table user (
    id int auto_increment primary key,
    username varchar(20),
    age int,
    score int
);

# 新增数据
insert into user (id, username, age, score) values
(1,'peter', 18, 100), (2,'pedro', 24, 200),
(3,'jerry', 28, 500), (4,'mike', 12, 300),
(5,'tom', 27, 1000);