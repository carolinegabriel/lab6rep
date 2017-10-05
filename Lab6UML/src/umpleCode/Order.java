package umpleCode;

/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.26.0-fbdb7c7 modeling language!*/



// line 20 "model.ump"
// line 42 "model.ump"
public class Order
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Order Attributes
  private int orderNumber;
  private String dateOfOrder;
  private double price;
  private int numberOfItems;

  //Order Associations
  private Customer customer;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Order(int aOrderNumber, String aDateOfOrder, double aPrice, int aNumberOfItems, Customer aCustomer)
  {
    orderNumber = aOrderNumber;
    dateOfOrder = aDateOfOrder;
    price = aPrice;
    numberOfItems = aNumberOfItems;
    boolean didAddCustomer = setCustomer(aCustomer);
    if (!didAddCustomer)
    {
      throw new RuntimeException("Unable to create order due to customer");
    }
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setOrderNumber(int aOrderNumber)
  {
    boolean wasSet = false;
    orderNumber = aOrderNumber;
    wasSet = true;
    return wasSet;
  }

  public boolean setDateOfOrder(String aDateOfOrder)
  {
    boolean wasSet = false;
    dateOfOrder = aDateOfOrder;
    wasSet = true;
    return wasSet;
  }

  public boolean setPrice(double aPrice)
  {
    boolean wasSet = false;
    price = aPrice;
    wasSet = true;
    return wasSet;
  }

  public boolean setNumberOfItems(int aNumberOfItems)
  {
    boolean wasSet = false;
    numberOfItems = aNumberOfItems;
    wasSet = true;
    return wasSet;
  }

  public int getOrderNumber()
  {
    return orderNumber;
  }

  public String getDateOfOrder()
  {
    return dateOfOrder;
  }

  public double getPrice()
  {
    return price;
  }

  public int getNumberOfItems()
  {
    return numberOfItems;
  }

  public Customer getCustomer()
  {
    return customer;
  }

  public boolean setCustomer(Customer aCustomer)
  {
    boolean wasSet = false;
    if (aCustomer == null)
    {
      return wasSet;
    }

    Customer existingCustomer = customer;
    customer = aCustomer;
    if (existingCustomer != null && !existingCustomer.equals(aCustomer))
    {
      existingCustomer.removeOrder(this);
    }
    customer.addOrder(this);
    wasSet = true;
    return wasSet;
  }

  public void delete()
  {
    Customer placeholderCustomer = customer;
    this.customer = null;
    placeholderCustomer.removeOrder(this);
  }


  public String toString()
  {
    return super.toString() + "["+
            "orderNumber" + ":" + getOrderNumber()+ "," +
            "dateOfOrder" + ":" + getDateOfOrder()+ "," +
            "price" + ":" + getPrice()+ "," +
            "numberOfItems" + ":" + getNumberOfItems()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "customer = "+(getCustomer()!=null?Integer.toHexString(System.identityHashCode(getCustomer())):"null");
  }
}