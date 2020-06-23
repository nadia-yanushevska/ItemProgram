public class Novel extends Book
{
  private String genera;
  
  public Novel()
  { 
    super();
    genera = "";
  }  
  
  public Novel(String title, double price, long UPC, String genera, double percentDiscount)
  { 
    super(title, price, UPC, percentDiscount);
    this.genera = genera;
  }  
   
  public String getGenera()
  { 
    return genera;
  }
    
  public void setGenera(String genera)
  { 
    this.genera = genera;
  }
  
  public String toString()
  { 
    return super.toString() + " Genera is " + getGenera() + ".";
  }
  
  public boolean equals(Object x)
  {
    if(!super.equals(x)) 
      return false;
    if (!(x instanceof Novel))   // type check and cast
        return false;

    Novel novel = (Novel) x;
    
    return genera.equals(novel.genera);
  }
  
}
