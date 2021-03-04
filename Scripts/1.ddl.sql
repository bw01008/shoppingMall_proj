-- ShoppingMall
DROP SCHEMA IF EXISTS ShoppingMall;

-- ShoppingMall
CREATE SCHEMA ShoppingMall;

-- 회원정보
CREATE TABLE ShoppingMall.customer (
	csNo    INTEGER(5)  NOT NULL COMMENT '회원번호', -- 회원번호
	csName  VARCHAR(4)  NULL     COMMENT '회원명', -- 회원명
	birth   DATE        NULL     COMMENT '생년월일', -- 생년월일
	phoneNo VARCHAR(13) NULL     COMMENT '휴대전화', -- 휴대전화
	sex     INTEGER(1)  NULL     COMMENT '성별' -- 성별
)
COMMENT '회원정보';

-- 회원정보
ALTER TABLE ShoppingMall.customer
	ADD CONSTRAINT PK_customer -- 회원정보 기본키
		PRIMARY KEY (
			csNo -- 회원번호
		);

-- 제품정보
CREATE TABLE ShoppingMall.product (
	pCode       VARCHAR(2)  NOT NULL COMMENT '제품코드', -- 제품코드
	pName       VARCHAR(20) NULL     COMMENT '제품명', -- 제품명
	price       INTEGER(10) NULL     COMMENT '단가', -- 단가
	stockAmount INTEGER(3)  NULL     COMMENT '재고수량' -- 재고수량
)
COMMENT '제품정보';

-- 제품정보
ALTER TABLE ShoppingMall.product
	ADD CONSTRAINT PK_product -- 제품정보 기본키
		PRIMARY KEY (
			pCode -- 제품코드
		);

-- 판매내역
CREATE TABLE ShoppingMall.sale (
	orderNo    INTEGER    NOT NULL COMMENT '주문번호', -- 주문번호
	date       DATE       NULL     COMMENT '날짜', -- 날짜
	csNo       INTEGER(5) NULL     COMMENT '회원번호', -- 회원번호
	pCode      VARCHAR(2) NULL     COMMENT '제품코드', -- 제품코드
	saleAmount INTEGER(3) NULL     COMMENT '판매수량' -- 판매수량
)
COMMENT '판매내역';

-- 판매내역
ALTER TABLE ShoppingMall.sale
	ADD CONSTRAINT PK_sale -- 판매내역 기본키
		PRIMARY KEY (
			orderNo -- 주문번호
		);

ALTER TABLE ShoppingMall.sale
	MODIFY COLUMN orderNo INTEGER NOT NULL AUTO_INCREMENT COMMENT '주문번호';

-- 판매내역
ALTER TABLE ShoppingMall.sale
	ADD CONSTRAINT FK_customer_TO_sale -- 회원정보 -> 판매내역
		FOREIGN KEY (
			csNo -- 회원번호
		)
		REFERENCES ShoppingMall.customer ( -- 회원정보
			csNo -- 회원번호
		);

-- 판매내역
ALTER TABLE ShoppingMall.sale
	ADD CONSTRAINT FK_product_TO_sale -- 제품정보 -> 판매내역
		FOREIGN KEY (
			pCode -- 제품코드
		)
		REFERENCES ShoppingMall.product ( -- 제품정보
			pCode -- 제품코드
		);
	