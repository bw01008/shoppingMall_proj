select user(), database();

show tables;

desc customer;
desc product;
desc sale;

select * from customer;

select csNo, csName, birth, phoneNo, sex from customer;
select csNo, csName, birth, phoneNo, sex from customer where csNo = 12001;
insert into customer values(12011, "우정아", 19931108, "01077731663", 0);
update customer set sex = 1 where csNo = 12011;
delete from customer where csNo = 12011;

select pCode, pName, price, stockAmount from product;
select pCode, pName, price, stockAmount from product where pCode ='PA';
insert into product values('PI', '아이패드', 50000, 100);
update product set price = 100000 where pCode = 'PI';
delete from product where pCode = 'PI';

select orderNo, date, csNo, pCode, saleAmount from sale;
select orderNo, date, csNo, pCode, saleAmount from sale where orderNo = 1;
insert into sale values (17, 20120502, 12007, 'PA', 1);
update sale set saleAmount = 2 where orderNo = 17;
delete from sale where orderNo =17;

select ID, password from login;
select ID, password from login where ID = 'manager';


