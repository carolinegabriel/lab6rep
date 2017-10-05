package myCode;

public class Customer {
	private String name;
	private String address;
	private int creditCard;
	private Account myAccount;

	public Customer(String n, String a, int c, Account m) {
		name = n;
		address = a;
		creditCard = c;
		myAccount = m;
	}

	public String getName() {
		return name;
	}

	public String getAddress() {
		return address;
	}

	public int getCreditCard() {
		return creditCard;
	}

	public Account getAccount() {
		return myAccount;
	}

}
