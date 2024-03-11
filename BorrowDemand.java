package exam_tp;

enum Statusofdemand{
    Treated,
    Nottreated,
    Refused
}
public class BorrowDemand extends Operation{

    protected String booktitle; // title of the borrowed book
    protected String bookid; // id of the borrowed book
    protected int user_borrowerid; // id of user who borrowed the book
    protected Statusofdemand status; // to show if the borrowdemand is treated,not treated,refused

    //constructor with parameters
	public BorrowDemand(Book book,User user) 
    {
		this.booktitle=book.title;
        this.bookid=book.id;
        this.user_borrowerid=user.id;
        this.status=Statusofdemand.Nottreated;
	}
    
	// show details of the operation
	public String toString() 
    {
		return "operation is borrow demand \n"+"name of book is "+booktitle+"\nid of the book "+bookid+"\nid of user that demanded the book is "
        +user_borrowerid+"\nstatus of the demand "+status+"\n";
	}
    
}
