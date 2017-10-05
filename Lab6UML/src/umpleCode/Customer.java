package umpleCode;

/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.26.0-fbdb7c7 modeling language!*/


import java.util.*;

// line 2 "model.ump"
// line 30 "model.ump"
public class Customer
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Customer Attributes
  private String name;
  private String address;
  private int creditCard;
  private Account myAccount;

  //Customer Associations
  private List<Order> orders;
  private Account account;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Customer(String aName, String aAddress, int aCreditCard, Account aMyAccount, Account aAccount)
  {
    name = aName;
    address = aAddress;
    creditCard = aCreditCard;
    myAccount = aMyAccount;
    orders = new ArrayList<Order>();
    if (aAccount == null || aAccount.getCustomer() != null)
    {
      throw new RuntimeException("Unable to create Customer due to aAccount");
    }
    account = aAccount;
  }

  public Customer(String aName, String aAddress, int aCreditCard, Account aMyAccount, int aAccountNumberForAccount, int aRewardPointsForAccount, String aUsernameForAccount, String aPasswordForAccount)
  {
    name = aName;
    address = aAddress;
    creditCard = aCreditCard;
    myAccount = aMyAccount;
    orders = new ArrayList<Order>();
    account = new Account(aAccountNumberForAccount, aRewardPointsForAccount, aUsernameForAccount, aPasswordForAccount, this);
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setName(String aName)
  {
    boolean wasSet = false;
    name = aName;
    wasSet = true;
    return wasSet;
  }

  public boolean setAddress(String aAddress)
  {
    boolean wasSet = false;
    address = aAddress;
    wasSet = true;
    return wasSet;
  }

  public boolean setCreditCard(int aCreditCard)
  {
    boolean wasSet = false;
    creditCard = aCreditCard;
    wasSet = true;
    return wasSet;
  }

  public boolean setMyAccount(Account aMyAccount)
  {
    boolean wasSet = false;
    myAccount = aMyAccount;
    wasSet = true;
    return wasSet;
  }

  public String getName()
  {
    return name;
  }

  public String getAddress()
  {
    return address;
  }

  public int getCreditCard()
  {
    return creditCard;
  }

  public Account getMyAccount()
  {
    return myAccount;
  }

  public Order getOrder(int index)
  {
    Order aOrder = orders.get(index);
    return aOrder;
  }

  public List<Order> getOrders()
  {
    List<Order> newOrders = Collections.unmodifiableList(orders);
    return newOrders;
  }

  public int numberOfOrders()
  {
    int number = orders.size();
    return number;
  }

  public boolean hasOrders()
  {
    boolean has = orders.size() > 0;
    return has;
  }

  public int indexOfOrder(Order aOrder)
  {
    int index = orders.indexOf(aOrder);
    return index;
  }

  public Account getAccount()
  {
    return account;
  }

  public static int minimumNumberOfOrders()
  {
    return 0;
  }

  public Order addOrder(int aOrderNumber, String aDateOfOrder, double aPrice, int aNumberOfItems)
  {
    return new Order(aOrderNumber, aDateOfOrder, aPrice, aNumberOfItems, this);
  }

  public boolean addOrder(Order aOrder)
  {
    boolean wasAdded = false;
    if (orders.contains(aOrder)) { return false; }
    Customer existingCustomer = aOrder.getCustomer();
    boolean isNewCustomer = existingCustomer != null && !this.equals(existingCustomer);
    if (isNewCustomer)
    {
      aOrder.setCustomer(this);
    }
    else
    {
      orders.add(aOrder);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeOrder(Order aOrder)
  {
    boolean wasRemoved = false;
    //Unable to remove aOrder, as it must always have a customer
    if (!this.equals(aOrder.getCustomer()))
    {
      orders.remove(aOrder);
      wasRemoved = true;
    }
    return wasRemoved;
  }

  public boolean addOrderAt(Order aOrder, int index)
  {  
    boolean wasAdded = false;
    if(addOrder(aOrder))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfOrders()) { index = numberOfOrders() - 1; }
      orders.remove(aOrder);
      orders.add(index, aOrder);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveOrderAt(Order aOrder, int index)
  {
    boolean wasAdded = false;
    if(orders.contains(aOrder))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfOrders()) { index = numberOfOrders() - 1; }
      orders.remove(aOrder);
      orders.add(index, aOrder);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addOrderAt(aOrder, index);
    }
    return wasAdded;
  }

  public void delete()
  {
    for(int i=orders.size(); i > 0; i--)
    {
      Order aOrder = orders.get(i - 1);
      aOrder.delete();
    }
    Account existingAccount = account;
    account = null;
    if (existingAccount != null)
    {
      existingAccount.delete();
    }
  }


  public String toString()
  {
    return super.toString() + "["+
            "name" + ":" + getName()+ "," +
            "address" + ":" + getAddress()+ "," +
            "creditCard" + ":" + getCreditCard()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "myAccount" + "=" + (getMyAccount() != null ? !getMyAccount().equals(this)  ? getMyAccount().toString().replaceAll("  ","    ") : "this" : "null") + System.getProperties().getProperty("line.separator") +
            "  " + "account = "+(getAccount()!=null?Integer.toHexString(System.identityHashCode(getAccount())):"null");
  }
}