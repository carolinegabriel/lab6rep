package myCode;

public class Account {
	private int accountNumber;
	private int rewardPoints;
	private String username;
	private String password;

	public Account(int a, int r, String u, String p) {
		accountNumber = a;
		rewardPoints = r;
		username = u;
		password = p;
	}

	public int getAccountNumber() {
		return accountNumber;
	}

	public String getUsername() {
		return username;
	}

	public void changePassword(String newPassword) {
		password = newPassword;

	}

	public void viewRewardPoints() {
		System.out.println(rewardPoints);
	}

}
