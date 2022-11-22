create  database if not exists shop;
use shop;
drop table if exists goods;
create table goods(
                      number bigint primary key auto_increment,
                      name varchar(10),
                      madetime date,
                      price double
)