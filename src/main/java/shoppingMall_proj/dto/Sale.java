package shoppingMall_proj.dto;

public class Sale {
	// Field
	private int orderNo;
	private String date;
	private Customer csNo;
	private Product pCode;
	private int saleAmount;
	private int Selling;
	private int Profit;

	// Constructor
	public Sale() {
		// TODO Auto-generated constructor stub
	}

	public Sale(int orderNo) {
		this.orderNo = orderNo;
	}

	// 날짜별 조회
	public Sale(String date) {
		this.date = date;
	}

	public Sale(int orderNo, String date, Customer csNo, Product pCode, int saleAmount) {
		this.orderNo = orderNo;
		this.date = date;
		this.csNo = csNo;
		this.pCode = pCode;
		this.saleAmount = saleAmount;
	}
	
	

	public Sale(int orderNo, String date, Customer csNo, Product pCode, int saleAmount, int selling, int profit) {
		this.orderNo = orderNo;
		this.date = date;
		this.csNo = csNo;
		this.pCode = pCode;
		this.saleAmount = saleAmount;
		Selling = selling;
		Profit = profit;
	}

	// Getter / Setter
	public int getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(int orderNo) {
		this.orderNo = orderNo;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
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

	public int getSelling() {
		return Selling;
	}

	public void setSelling(int selling) {
		Selling = selling;
	}

	public int getProfit() {
		return Profit;
	}

	public void setProfit(int profit) {
		Profit = profit;
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
		return String.format("Sale [orderNo=%s, date=%s, csNo=%s, pCode=%s, saleAmount=%s]", orderNo, date, csNo, pCode,saleAmount);
	}

}
