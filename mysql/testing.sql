call search_by_category('art');
use book_store;

select * from store_orders;
select * from books;
delete from store_orders where isbn=2;
select * from store_orders;
select * from managers;
select * from users;
select * from user_phones;

update books set no_of_copies=50 where isbn=3;
insert into authors values(1, 'ta7seen');
delete from user_phones;
select * from publishers;
select * from publisher_phones;

delete from users where email = 'test';
select * from customer_orders;
insert into user_phones values ('f@c.o', '010'),('f@c.o', '011'),('f@c.o', '012'),('y@c.o', '013');

delete from users where email='h@c.o';
delete from authors;
delete from books where isbn=20;

update books set no_of_copies=100;
delete from customer_orders;
select * from store_orders;
delete from store_orders;
select * from customer_orders;
insert into customer_orders (isbn, cstmr_email, no_of_copies, sale_date) values(1, "y@c.o", 1, now());
select * from books;
select * from users;
select * from customer_orders;

delete from store_orders where isbn=1;
update books set no_of_copies=10 where isbn=1;

insert into publishers values("pubB", "addB");
insert into publishers values("pub", "add");

insert into books values(1, "C pogramming", "pubB", 2000, 9.5, "art", 20, 50);
insert into authors values(1,"Denis Richie");
insert into books values(2, " Do Androids Dream of Electric Sheep?", "pubB", 1000, 5, "science", 10, 30);
insert into authors values(2," Philip K. Dick");
insert into books values(3, " Everything I Never Told You", "pub", 2000, 9.5, "History", 20, 50);
insert into authors values(3,"Celeste Ng");
insert into books values(4, "Harry Potter", "pubB", 2000, 9.5, "art", 20, 50);
insert into authors values(4,"J.K Rowling");
insert into books values(5, "Effective Java", "pub", 2000, 9.5, "art", 20, 50);
insert into authors values(5,"John");
-- SET FOREIGN_KEY_CHECKS=0;
-- SET SQL_SAFE_UPDATES = 0;
-- delete from books;
-- delete from authors;
delete from users;
insert into users values("a@c.o", "yz","1234","y", "z", "alex");
insert into users values("b@c.o", "yz","1234","y", "z", "alex");
insert into users values("c@c.o", "yz","1234","y", "z", "alex");
insert into users values("d@c.o", "yz","1234","y", "z", "alex");
insert into users values("e@c.o", "yz","1234","y", "z", "alex");
insert into users values("f@c.o", "yz","1234","y", "z", "alex");
delete from managers;
insert into managers values("y@c.o"),("a@c.o");
update books set no_of_copies = 10 where isbn = 3;

select * from books;


select * from categories where (category='science' or category='art') and (category='science' or category='do');