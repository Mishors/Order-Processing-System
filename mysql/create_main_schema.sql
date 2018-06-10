create schema if not exists book_store;
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

create index idx_category on books (category);
create index idx_publisher on books (publisher_name);
CREATE INDEX idx_isbn on books (isbn);
CREATE INDEX idx_title on books (title);
CREATE INDEX idx_author on authors (author);

-- each inserted value in gui should be converted to lowercase letters 
insert into categories values ("science");
insert into categories values ("art");
insert into categories values ("religion");
insert into categories values ("history");
insert into categories values ("geography");