select user(), database();

show tables;
desc customer;
desc product;
desc sale;

insert into customer values
(12001, '홍길동', 19770405, '01097415821', 1),
(12002, '김연수', 19850301, '01045685581', 0),
(12003, '김지원', 19860708, '01091115556', 0),
(12004, '문희원', 19800108, '01077777777', 0),
(12005, '유일한', 19790205, '01045668886', 1),
(12006, '김동수', 19811123, '01012311211', 1),
(12007, '배진태', 19820707, '01078777777', 1),
(12008, '류은수', 19830301, '01074441474', 1),
(12009, '김동철', 19870426, '01085251235', 1),
(12010, '최홍석', 19900405, '01032146547', 1);

select * from customer;

insert into product values
('PA', '책상', 10000, 100),
('PB', '냉장고', 36000, 100),
('PC', '세탁기', 22000, 100),
('PD', 'VTR', 30000, 100),
('PE', '자전거', 90000, 100),
('PF', '시계', 6000, 100),
('PG', 'TV', 8000, 100),
('PH', '탁자', 3000, 100);

select * from product;

insert into sale values
(1, 20120324, 12003, 'PA', 2),
(2, 20120327, 12001, 'PA', 1),
(3, 20120403, 12009, 'PC', 1),
(4, 20120407, 12010, 'PF', 5),
(5, 20120413, 12003, 'PF', 4),
(6, 20120414, 12002, 'PE', 3),
(7, 20120414, 12004, 'PH', 10),
(8, 20120415, 12005, 'PG', 7),
(9, 20120417, 12006, 'PG', 2),
(10, 20120419, 12007, 'PA', 9),
(11, 20120420, 12001, 'PB', 3),
(12, 20120420, 12005, 'PD', 2),
(13, 20120420, 12006, 'PG', 2),
(14, 20120422, 12010, 'PH', 1),
(15, 20120426, 12010, 'PH', 5),
(16, 20120501, 12003, 'PB', 7);

select * from sale;

insert into login values ('manager', '1234');

select * from login;
