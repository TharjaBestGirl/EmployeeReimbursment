create table logins (
id serial primary key, username varchar(255) , pass varchar(255), manager bool);

create table reimbursements (
id serial primary key,
emp_id integer,
man_id integer,
type varchar,
amount numeric, 
description varchar(30),
submit timestamp not null default CURRENT_TIMESTAMP,
resolve_time date,
resolved boolean,
accepted boolean,
foreign key (emp_id) references logins(id)
);

insert into logins(username, pass, manager) values ('Employee', '12345',false);
insert into logins(username, pass, manager) values ('Manager', 'abcde',true);
