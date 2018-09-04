insert into COURSE (id, name, last_updated_date, created_date)
  values (10001, 'JPA in 50 steps', sysdate(), sysdate());
insert into COURSE (id, name, last_updated_date, created_date)
  values (10002, 'Hibernate in 50 steps', sysdate(), sysdate());
insert into COURSE (id, name, last_updated_date, created_date)
  values (10003, 'Spring in 50 steps', sysdate(), sysdate());

insert into PASSPORT (id, number)
  values (4001, 'A12345');
insert into PASSPORT (id, number)
  values (4002, 'B12345');
insert into PASSPORT (id, number)
  values (4003, 'C12345');

insert into STUDENT (id, name, passport_id)
  values (2001, 'Ranga', 4001);
insert into STUDENT (id, name, passport_id)
  values (2002, 'Adam', 4002);
insert into STUDENT (id, name, passport_id)
  values (2003, 'Jane', 4003);

insert into REVIEW (id, rating, description)
  values (5001, '5', 'Great Course');
insert into REVIEW (id, rating, description)
  values (5002, '4', 'Wonderful Course');
insert into REVIEW (id, rating, description)
  values (5003, '5', 'Awesome Course');