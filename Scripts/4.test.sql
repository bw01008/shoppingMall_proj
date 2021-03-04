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