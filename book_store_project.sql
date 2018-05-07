create schema book_store;
use book_store;

create table books(
	isbn int not null,
    title varchar(100) not null,
    publisher_name varchar(100) not null,
    publishing_year int not null,
    price float not null,
    category varchar(20) not null,
    threshold int not null,
    no_of_copies int not null,
	primary key (isbn)
);

create table categories(
	category varchar(20),
    primary key (category)
);

create table authors(
	isbn int not null,
    author varchar(100) not null,
    primary key (isbn, author)
);

create table publishers(
	publisher_name varchar(100) not null,
    address varchar(200) not null,
    primary key (publisher_name)
);

create table publisher_phones(
	publisher_name varchar(100) not null,
    phone varchar(20) not null,
    primary key (publisher_name, phone)
);

create table users(
	email varchar(320) not null,
    user_name varchar(100) not null,
    user_password varchar(100) not null,
    first_name varchar(100) not null,
    last_name varchar(100) not null,
    shipping_add varchar(200) not null,
    primary key (email)
);

create table user_phones(
	email varchar(320) not null,
    phone varchar(20) not null,
    primary key (email, phone)
);

create table managers(
	mngr_email varchar(320) not null,
    primary key (mngr_email)
);

create table store_orders(
	isbn int not null,
    no_of_copies int not null,
    primary key (isbn)
);

create table customer_orders(
	id int not null,
    isbn int not null,
    cstmr_email varchar(320) not null,
    no_of_copies int not null,
    sale_date datetime not null,
    primary key (id)
);

alter table books add constraint books_categories_fk foreign key (category) references categories(category);
alter table books add constraint books_publishers_fk foreign key (publisher_name) references publishers(publisher_name);
alter table publisher_phones add constraint publisher_phones_publishers_fk foreign key (publisher_name) references publishers(publisher_name);
alter table authors add constraint authors_books_fk foreign key (isbn) references books(isbn);
alter table store_orders add constraint store_orders_books_fk foreign key (isbn) references books(isbn);
alter table customer_orders add constraint customer_orders_books_fk foreign key (isbn) references books(isbn);
alter table customer_orders add constraint customer_orders_users_fk foreign key (cstmr_email) references users(email);
alter table user_phones add constraint user_phones_users_fk foreign key (email) references users(email);
alter table managers add constraint managers_users_fk foreign key (mngr_email) references users(email);

-- each inserted value in gui should be converted to lowercase letters 
insert into categories values ("science");
insert into categories values ("art");
insert into categories values ("religion");
insert into categories values ("history");
insert into categories values ("geography");

DELIMITER ;;
-- when update no_of_copies, check the threshold
create trigger 	update_quantity_threshold_trigger
before update on books
for each row begin
	if(new.no_of_copies < new.threshold) then
		insert into store_orders 
		values(new.isbn, new.threshold - new.no_of_copies + 20);
    end if;
end;;

-- when insert new rows, check no_of_copies with the threshold
create trigger 	insert_quantity_threshold_trigger
after insert on books
for each row begin
	if(new.no_of_copies < new.threshold) then
		insert into store_orders 
		values(new.isbn, new.threshold - new.no_of_copies + 20);
    end if;
end;;


-- if the book is ordered already, update the no_of_copies value
-- create trigger 	insert_order_pk_trigger
-- before insert on store_orders
-- for each row begin
-- 	if(exists (select isbn from store_orders where isbn = new.isbn)) then
-- 		delete from store_orders where isbn = new.isbn;
--     end if;
-- end;;


-- if the user want to update no_of_copies with -ve values, reject
create trigger 	negative_quantity_trigger
before update on books
for each row begin
	if(new.no_of_copies < 0) then
 		signal sqlstate '45000';
     end if;
end;;
-- 
-- delimiter ;;
-- drop trigger store_orders_deletion_trigger;;
-- -- when delete an store order, increase the no_of_copies in the books table
-- create trigger 	store_orders_deletion_trigger 
-- on store_orders 
-- for delete as
-- begin
-- 	declare no_of_copies_ordered int;
--     declare isbn_ordered int;
--     select store_orders.no_of_copies into no_of_copies_ordered from deleted;
--     select isbn into isbn_ordered from deleted;
--     update books set no_of_copies=no_of_copies_ordered where isbn=isbn_ordered;
-- end;;

DELIMITER ;

select * from store_orders;
select * from books;
delete from store_orders where isbn=2;
select * from store_orders;
select * from books;

insert into publishers values("pubB", "addB");
insert into publishers values("pub", "add");

insert into books values(2, "B", "pubB", 1000, 5, "art", 10, 30);
insert into books values(3, "a", "pub", 2000, 9.5, "art", 20, 13);
