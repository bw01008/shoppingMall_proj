package shoppingMall_proj.dto;

import java.sql.Date;

public class Sale {
	// Field
	private int orderNo;
	private Date date;
	private Customer csNo;
	private Product pCode;
	private int saleAmount;
	private int totalSelling;
	private int totalProfit;

	// Constructor
	public Sale() {
		// TODO Auto-generated constructor stub
	}

	public Sale(int orderNo) {
		this.orderNo = orderNo;
	}

	public Sale(int orderNo, Date date, Customer csNo, Product pCode, int saleAmount) {
		this.orderNo = orderNo;
		this.date = date;
		this.csNo = csNo;
		this.pCode = pCode;
		this.saleAmount = saleAmount;
	}

	// Getter / Setter
	public int getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(int orderNo) {
		this.orderNo = orderNo;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Customer getCsNo() {
		return csNo;
	}

	public void setCsNo(Customer csNo) {
		this.csNo = csNo;
	}

	public Product getpCode() {
		return pCode;
	}

	public void setpCode(Product pCode) {
		this.pCode = pCode;
	}

	public int getSaleAmount() {
		return saleAmount;
	}

	public void setSaleAmount(int saleAmount) {
		this.saleAmount = saleAmount;
	}

	// Method
	// 판매액
	public int selling() {
		Product p = new Product();
		return (int) ((p.getPrice() * 1.1) * saleAmount);
	}

	// 이익금액
	public int profit() {
		Product p = new Product();
		return selling() - (p.getPrice() * saleAmount);
	}

	// 총 주문건수
	public int totalOrder() {
		return 0;
	}

	// 총 주문수량
	public int totalSaleAmount() {
		return 0;
	}

	// 총 판매액
	public int totalSelling() {
		Product p = new Product();
		return (int) ((p.getPrice() * 1.1) * saleAmount);
	}

	// 총 이익금액

	public int totalProfit() {
		Product p = new Product();
		return (int) ((p.getPrice() * 1.1) * saleAmount);
	}

	// toString
	@Override
	public String toString() {
		return String.format("Sale [orderNo=%s, date=%s, csNo=%s, pCode=%s, saleAmount=%s]", orderNo, date, csNo, pCode,
				saleAmount);
	}

}
