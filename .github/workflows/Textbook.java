public class Textbook extends Book
{
  private String course;
  
  public Textbook()
  { 
    super();
    course = "";
  }  
  
  public Textbook(String title, double price, long UPC, String course, double percentDiscount)
  { 
    super(title, price, UPC, percentDiscount);
    this.course = course;
  }  
   
  public String getCourse()
  { 
    return course;
  }
    
  public void setCourse(String course)
  { 
    this.course = course;
  }
  
  public String toString()
  { 
    return super.toString() + " Course is " + getCourse() + ".";
  }
  
  public boolean equals(Object x)
  {
    if(!super.equals(x)) 
      return false;
    if (!(x instanceof Textbook))   // type check and cast
        return false;

    Textbook textbook = (Textbook) x;
    
    return course.equals(textbook.course);
  }
}
