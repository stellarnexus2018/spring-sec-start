insert into my_users (username, password, enabled) values ('igor', '111', true);
insert into my_users (username, password, enabled) values ('admin', '222', true);

insert into my_authorities (username, authority) values ('igor', 'ROLE_USER');
insert into my_authorities (username, authority) values ('admin', 'ROLE_ADMIN');