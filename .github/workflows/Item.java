import java.io.Serializable;

abstract public class Item implements Comparable<Item>, Discount, Serializable
{
  protected double price;
  protected long UPC;
  protected double percentDiscount;
  
  
  public Item()
  { 
    price = 0.0;
    UPC = 0;
    percentDiscount = 0.0;
  }
  
  
  public Item(double price, long UPC, double percentDiscount)
  { 
    this.price = price;
    this.UPC = UPC;
    this.percentDiscount = percentDiscount;
  }
  
  
   public double getPrice()
  {
    return price;
  }
   
  
  public long getUPC()
  { 
    return UPC;
  }
  
  
  public void setPrice(double price)
  { 
    this.price = price;
  }
  
  
  public void setUPC(long UPC)
  { 
    this.UPC = UPC;
  }
  
  
  public void setDiscount(double discount)
  {
    percentDiscount = discount;
  }
  
  
  public double calculateDiscount(double price, double percentDiscount)
  {
    return price - price*percentDiscount/100.0;
  }
  
  
  public String toString()
  {
    return "Price with discount is " + calculateDiscount(price, percentDiscount) + ". UPC is " + getUPC() + ".";
  }
  
  
  public boolean equals(Object x) 
  {
    if (x == null)    // null check
        return false;
    if (this == x)     // self check
        return true;
    if (!(x instanceof Item))   // type check and cast
        return false;

    Item item = (Item) x;

    return  price == item.price && UPC == item.UPC;
  }  
  
  abstract public int compareTo(Item y);

}
