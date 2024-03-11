package exam_tp;

import java.util.ArrayList;

public class Library {

    static public ArrayList<Book> books; // arraylist of the books in the library
	static public ArrayList<User> users; // arraylist of the user of the library
    static public double fineofvip = 100; // fine to pay each late day for vip user
    static public double fineofregular = 200; // fine to pay each late day for regular user

    // constructor
    public Library()
    {
        books = new ArrayList<Book>();
        users = new ArrayList<User>();
    }
    
    // method to search for a book by id 
    public static Book FindBooks(String bookid) 
    {
        for(Book book : Library.books)
        {
            if(book.id.equals(bookid))
            {
              return book;
            }
        }
        return null;
	}

    // method to search for a copie of a book 
    public static Copy FindCopies(String bookid)
    {
        Book findcopy=Library.FindBooks(bookid);
        if (findcopy==null)
        {
            return null;
        }
        else 
        {
            for(Copy foundcopy : findcopy.copies)
            {
                if(foundcopy.state==Status.Available)
                {
                    return foundcopy;
                }
            }
            return null;
        }
    }

    // method to seach for user by id
    public static User Searchforuser(int userid)
    {
        User hello=null;
        for (User user : Library.users)
        {
        if(user.id==userid)
        {
            hello=user;
        }
        }
        return hello;
    }
    
    // method to register a borrow demand in operations arraylist
    public static void registerBorrowDemand(Book book,User user, ArrayList<Operation> operations) 
    {
		BorrowDemand bd = new BorrowDemand(book,user);
		operations.add(bd);
	}

    // method to register a loan in operations arraylist
    public static void registerLoad(Copy copie,User user, ArrayList<Operation> operations) 
    {
		Loan loan = new Loan(copie,user);
		operations.add(loan);
	}
    
    // method to check if we can loan the user a book
    public static boolean checkpossibility(BorrowDemand demand,User user,int maxnumberofbooksborrowed)
    {
   
        if(user.books_borrowed_by_user.size()< maxnumberofbooksborrowed && user.totalfinetopay==0)
        {
            demand.status=Statusofdemand.Treated;
            return true;
        }
        else
        {
            demand.status=Statusofdemand.Refused;
            return false;
        }
    }
}
