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
insert into login values('root', 'rootroot');
update login set password = '0000' where id = 'root';
delete from login where id = 'root';

create or replace view vw_full_Sale
as 
select s.orderNo, 
	   s.date, 
	   s.csNo, 
	   c.csName, 
	   c.birth, 
	   c.phoneNo, 
	   c.sex, 
	   s.pCode, 
	   p.pName, 
	   p.price, 
	   s.saleAmount, 
	   p.stockAmount,
	   (p.price * s.saleAmount)*1.1 'selling',
	   ((p.price * s.saleAmount)*1.1) - (p.price * s.saleAmount) 'profit'
from sale s join customer c on s.csNo = c.csNo
	 left join product p on s.pCode = p.pCode;
	
	
select * from vw_full_Sale;

select date, csNo, csName, phoneNo, pCode, saleAmount, selling from vw_full_sale where date = 20120420; -- Sale Main 테이블
select date, pCode, pName, saleAmount, price, selling, profit from vw_full_sale;	-- 제품별조회 테이블
select date, pCode, pName, csName, saleAmount, price, selling, profit from vw_full_sale; -- 상세조회 테이블

select * from product;
select * from sale;
update product set stockAmount = 98 where pCode = (select pCode from sale where orderNo = 1);
update sale set saleAmount = 2 where orderNo = 1;

select date, pCode, pName, csNo, csName, saleAmount, price, selling, profit from vw_full_sale;

select * from login;
