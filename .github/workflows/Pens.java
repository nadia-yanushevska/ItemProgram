public class Pens extends Item
{
  protected String color;
  
  
  public Pens()
  { 
    super();
    color = "";
  }
  
  
  public Pens(String color, double price, long UPC, double percentDiscount)
  { 
    super(price, UPC, percentDiscount);
    this.color = color;
  }
  
  
  public String getColor()
  {
    return color;
  }
  
  
  public void setColor(String color)
  { 
    this.color = color;
  }
  
  
  public String toString()
  {
    return "Color is " + getColor() + ". " + super.toString();
  }
  
  
  public boolean equals(Object x)
  {
    if(!super.equals(x)) 
      return false;
    if (!(x instanceof Pens))   // type check and cast
        return false;

    Pens pen = (Pens) x;
    
    return color.equals(pen.color);
  }
  
  
  public int compareTo(Item y)
 {     
    if (UPC < y.UPC)
        return -1;
    else if (UPC == y.UPC)
             return 0;
    else return 1;
  }
}
