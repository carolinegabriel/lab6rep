package umpleCode;

	/*PLEASE DO NOT EDIT THIS CODE*/
	/*This code was generated using the UMPLE 1.26.0-fbdb7c7 modeling language!*/



	// line 11 "model.ump"
	// line 36 "model.ump"
	public class Account
	{

	  //------------------------
	  // MEMBER VARIABLES
	  //------------------------

	  //Account Attributes
	  private int accountNumber;
	  private int rewardPoints;
	  private String username;
	  private String password;

	  //Account Associations
	  private Customer customer;

	  //------------------------
	  // CONSTRUCTOR
	  //------------------------

	  public Account(int aAccountNumber, int aRewardPoints, String aUsername, String aPassword, Customer aCustomer)
	  {
	    accountNumber = aAccountNumber;
	    rewardPoints = aRewardPoints;
	    username = aUsername;
	    password = aPassword;
	    if (aCustomer == null || aCustomer.getAccount() != null)
	    {
	      throw new RuntimeException("Unable to create Account due to aCustomer");
	    }
	    customer = aCustomer;
	  }

	  public Account(int aAccountNumber, int aRewardPoints, String aUsername, String aPassword, String aNameForCustomer, String aAddressForCustomer, int aCreditCardForCustomer, Account aMyAccountForCustomer)
	  {
	    accountNumber = aAccountNumber;
	    rewardPoints = aRewardPoints;
	    username = aUsername;
	    password = aPassword;
	    customer = new Customer(aNameForCustomer, aAddressForCustomer, aCreditCardForCustomer, aMyAccountForCustomer, this);
	  }

	  //------------------------
	  // INTERFACE
	  //------------------------

	  public boolean setAccountNumber(int aAccountNumber)
	  {
	    boolean wasSet = false;
	    accountNumber = aAccountNumber;
	    wasSet = true;
	    return wasSet;
	  }

	  public boolean setRewardPoints(int aRewardPoints)
	  {
	    boolean wasSet = false;
	    rewardPoints = aRewardPoints;
	    wasSet = true;
	    return wasSet;
	  }

	  public boolean setUsername(String aUsername)
	  {
	    boolean wasSet = false;
	    username = aUsername;
	    wasSet = true;
	    return wasSet;
	  }

	  public boolean setPassword(String aPassword)
	  {
	    boolean wasSet = false;
	    password = aPassword;
	    wasSet = true;
	    return wasSet;
	  }

	  public int getAccountNumber()
	  {
	    return accountNumber;
	  }

	  public int getRewardPoints()
	  {
	    return rewardPoints;
	  }

	  public String getUsername()
	  {
	    return username;
	  }

	  public String getPassword()
	  {
	    return password;
	  }

	  public Customer getCustomer()
	  {
	    return customer;
	  }

	  public void delete()
	  {
	    Customer existingCustomer = customer;
	    customer = null;
	    if (existingCustomer != null)
	    {
	      existingCustomer.delete();
	    }
	  }


	  public String toString()
	  {
	    return super.toString() + "["+
	            "accountNumber" + ":" + getAccountNumber()+ "," +
	            "rewardPoints" + ":" + getRewardPoints()+ "," +
	            "username" + ":" + getUsername()+ "," +
	            "password" + ":" + getPassword()+ "]" + System.getProperties().getProperty("line.separator") +
	            "  " + "customer = "+(getCustomer()!=null?Integer.toHexString(System.identityHashCode(getCustomer())):"null");
	  }
	}

