package myCode;

public class Order {
	private int orderNumber;
	private String dateOfOrder;
	private double price;
	private int numberOfItems;

	public Order(int o, String d, double p, int n) {
		orderNumber = o;
		dateOfOrder = d;
		price = p;
		numberOfItems = n;
	}

	public int getOrderNumber() {
		return orderNumber;
	}

	public String getDateOfOrder() {
		return dateOfOrder;
	}

	public double getPrice() {
		return price;
	}

	public int getNumberOfItems() {
		return numberOfItems;
	}

}
