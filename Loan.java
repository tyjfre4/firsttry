package exam_tp;

import java.time.LocalDate;



public class Loan extends Operation{

    protected String copy_loaned; // id of copy loanded
	protected int user_borrower; // id of the user that got the copy
	protected LocalDate start_loan; // date of the loan

    // constructor
    public Loan(Copy cp,User user) 
    {
		this.copy_loaned = cp.id;
		this.user_borrower = user.id;
        this.start_loan=LocalDate.now();
	    cp.state=Status.Notavailable;
        user.books_borrowed_by_user.add(cp);
        user.dateof_borrowing.add(start_loan);

	}

    // show details about operation
    public String toString() 
    {
		return "operation is loan \n"+ "id of the copy loaned is: "+copy_loaned+"\nid of borrower is: "+user_borrower+"\ndate of loan is: "+start_loan+"\n";
	}
}
