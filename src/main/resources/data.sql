drop table Entity;
create table Entity (
id INT NOT NULL GENERATED ALWAYS AS IDENTITY,
value varchar(50) not null
);
insert into Entity (value) values ('first');
insert into Entity (value) values ('second');
insert into Entity (value) values ('third');