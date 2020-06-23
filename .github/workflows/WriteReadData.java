import java.util.Scanner;
import java.io.File;
import java.io.*;
import java.io.IOException;

public class WriteReadData
{
  public static void main(String[] args) throws IOException
  {
    //  Implementing variables:
    String temp = "";
    int row = 0;
    String[][] strBook = new String[10][5];
    String n;
    Double p;
    Long l;
    double d;
    Book[] books = new Book[10];
    Book[] books2 = new Book[10];
    
    
    
    //  Reading data from Books.txt file and storing it into array book:
    
    System.out.println("Reading data from Books.txt file and storing it into array book.");  
    
    try
    {
    Scanner bookScan = new Scanner(new File("Books.txt"));   
    
    while(bookScan.hasNextLine())
    {
      temp = bookScan.nextLine();
      strBook[row] = temp.split(",");
      
      n = strBook[row][0];
      p = Double.parseDouble(strBook[row][1]);
      l = Long.parseLong(strBook[row][2]);
      d = Double.parseDouble(strBook[row][3]);
      
      books[row] = new Book(n, p, l, d);
      
      row++;
    }
    
    System.out.println("Done.");    
    bookScan.close();    
    }
    catch(FileNotFoundException e)
    {
      System.out.println(e.getMessage());
      System.exit(1);
    }    
    
    
    
    //  Priting the array book:
    
    System.out.println("\nPriting the array book:");
    
    for(int i = 0; i < row; i++)
         System.out.println(books[i]);
    
    
    
    
    //  Writing the objects to Books.dat:
    System.out.println("\nWriting the objects to Books.dat.");
    
    FileOutputStream ostream = new FileOutputStream("Books.dat");
    ObjectOutputStream outputf = new ObjectOutputStream(ostream);

    for (int i = 0; i < row; i++)
      outputf.writeObject(books[i]);
    
    System.out.println("Done.");
    outputf.close();
    ostream.close();
    
    
    
    //  Printing data stored in Books.dat:
    System.out.println("\nPrinting data stored in Books.dat:");
    try 
    {
      InputStream inputStream = new FileInputStream("Books.dat");
       
      int byteRead;
      while ((byteRead = inputStream.read()) != -1) 
      {
        System.out.print(byteRead + " ");
      }
      inputStream.close();
    }
    catch (Exception e) 
    {
      System.out.println(e.getMessage());
    }
    
    
    
    //  Reading objects from Books.dat, storing them into book2 array and printing this array:
    System.out.println("\n\nReading objects from Books.dat, storing them into book2 array and printing this array:");
    
    FileInputStream istream = new FileInputStream("Books.dat");
    ObjectInputStream inputf = new ObjectInputStream(istream);
    
    for(int i = 0; i < row; i++)
    {
      try
      {
        books2[i] = (Book) inputf.readObject(); 
      }
      catch (Exception e)
      {
       System.out.println(e.getMessage());
      }
      System.out.println(books2[i]);
    }
   
    System.out.println("Done.");
    inputf.close();
    istream.close();
    
  }
}
