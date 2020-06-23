public class Book extends Item
{
  protected String title;
  
  
  public Book()
  { 
    super();
    title = "";
  }
  
  
  public Book(String title, double price, long UPC, double percentDiscount)
  { 
    super(price, UPC, percentDiscount);
    this.title = title;
  }
  
  
  public String getTitle()
  {
    return title;
  }
  
  
  public void setTitle(String title)
  { 
    this.title = title;
  }
  
  
  public String toString()
  {
    return "Title is " + getTitle() + ". " + super.toString();
  }
  
  
  public boolean equals(Object x)
  {
    if(!super.equals(x)) 
      return false;
    if (!(x instanceof Book))   // type check and cast
      return false;
    
    Book book = (Book) x;
    
    return title.equals(book.title);
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
