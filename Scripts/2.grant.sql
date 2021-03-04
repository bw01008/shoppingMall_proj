--권한 부여
grant all on ShoppingMall.* to 'manager'@'localhost' identified by 'rootroot';

select user(), database();