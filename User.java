package exam_tp;

import java.time.LocalDate;
import java.util.ArrayList;


enum PlanSubscription {
	Basic_plan,
	Vip_plan
}

public class User extends Person{
    
    protected static int idcount=0; // to create user id
    protected int id; // id of user
    protected LocalDate birthdate; // birthdate of user
    protected PlanSubscription typesub; // type of subs
    protected double totalfinetopay; // represent how much fine user has to pay
    protected ArrayList<Book> books_borrowed_by_user; // arraylist to save the books each user borrowed
    protected ArrayList<LocalDate> dateof_borrowing; // arraylist to save the day of loan
    
    //empty constructor 
    public User()
    {
      
    }

    //constructor with parameters
    public User(String firstname , String familyname, PlanSubscription typesub, int dayofbirth ,int monthofbirth ,int yearofbirth)
    {
        super(firstname, familyname); // call of class Person constructor to initializate name and family name of the user
        this.id=idcount;
        this.totalfinetopay=0;
        this.typesub=typesub;
        this.birthdate=LocalDate.of(yearofbirth, monthofbirth, dayofbirth);
        this.books_borrowed_by_user = new ArrayList<Book>();
        this.dateof_borrowing = new ArrayList<LocalDate>();
        idcount++;
    }

    // method to search for book using name of the book
    public void findBookByTitle(String booktitle) 
    {
      for(Book book : Library.books)
      {
        System.out.println("the books that has the title "+booktitle+" are :");
        if(book.title.equals(booktitle))
        {
            System.out.println("id of the book "+ book.id);
            for(Person author : book.authors)
            {
                System.out.println("author of the book: "+ author.firstname+" "+author.familyname);
            }
            System.out.println("number of copies: "+ book.copies.size());
            System.out.println("category of the book: "+ book.category);
        }
      }
	  }
  
	  // method to search for book using category of the book
	  public void findBooksByCategory(Category category) 
    {
        System.out.println("the books that are from the category "+category+" are:");
        for(Book book : Library.books)
        {
          if(book.category==category)
          {
            System.out.println("id of the book: "+ book.id);
            System.out.println("title of the book: "+book.title);
            for(Person author : book.authors)
            {
                System.out.println("author of the book: "+ author.firstname+" "+author.familyname);
            }
            System.out.println("number of copies: "+ book.copies.size());
          }
        }
	  }
    
    // method for borrowing a book 
    public void Borrow(String bookid,ArrayList<Operation> operations) 
    {
		     // find the books first and then launch borrow demand, we will suppose the name is correct..
         Book foundbook = Library.FindBooks(bookid);
         if(foundbook==null)
         {
         System.out.println("this book doesn't exist");
         }
         else
         {
         Library.registerBorrowDemand(foundbook,this,operations);
         }
	  }

}
