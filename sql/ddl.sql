drop table if exists member CASCADE;

create table member
(
  id bigint generated by default as identity,
  name  varchar(255),
  primary key(id)
);


select * from member;

insert into member(name) values ('spring2');