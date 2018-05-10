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
create trigger 	insert_order_pk_trigger
before insert on store_orders
for each row begin
 	if(exists (select isbn from store_orders where isbn = new.isbn)) then
 		delete from store_orders where isbn = new.isbn;
     end if;
 end;;


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


-- Searching procedures which will be called in the front end to support the user with the required information
CREATE PROCEDURE search_by_isbn (ISBN int)
BEGIN
	SELECT * from books where books.isbn = ISBN;
END;;

CREATE PROCEDURE search_by_title (Title varchar(100))
BEGIN
	SELECT * from books where books.title = Title;
END;;

CREATE PROCEDURE search_by_category (category varchar(20))
BEGIN
	SELECT * from books where books.category = category;
END;;

CREATE PROCEDURE search_by_author (author varchar(100))
BEGIN
	SELECT * from authors join books on authors.isbn = books.isbn where authors.author = author;
END ;;

CREATE PROCEDURE search_by_publisher (publisher varchar(100))
BEGIN
	SELECT * from books where books.publisher_name = publisher;
END ;;

DELIMITER ;
