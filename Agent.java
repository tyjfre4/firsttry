package exam_tp;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

public class Agent {

    public ArrayList<Operation> operations; // there is two operations : borrow demand book , Loan book
    public ArrayList<Operation> operationsofloan;
    // constructor
    public Agent()
    {
        operations = new ArrayList<Operation>();
        operationsofloan = new ArrayList<Operation>();
    }

    // method to clear all the operations to start fresh
    public void ProcessStartofDay() 
    {
		// clean all queues...
        operations.clear();
	}

    //method to show all the operations of the day
    public void ProcessEndofDay() 
    {
		//this process will be launched at the end of every day
		displayOperationReport();
		CalculateDebtOfLoanedUser();
	}

    //method to add a book to the data base
    public void AddBook(Book book)
    {
        Library.books.add(book);
	}

    // method to add copy of a book to the data base
    public void AddNewCopy(Book book)
    {
		Copy newcopy = new Copy(book);
	}

    //method to add a new user to data base
    public void AddNewUser(String firstname,String lastname,PlanSubscription plansub,int dayofbirth , int monthofbirth,int yearofbirth) 
    {
		if(plansub==PlanSubscription.Basic_plan)
        {
        RegularUser user = new RegularUser(firstname, lastname, plansub, dayofbirth, monthofbirth, yearofbirth);
        Library.users.add(user);
	    }
        else
        {
        VipUser user = new VipUser(firstname,lastname, plansub,dayofbirth , monthofbirth, yearofbirth);
        Library.users.add(user);
        }
    }

    //method to show an operations report
    public void displayOperationReport() 
    {
		// at the end of every day, agent need to display all operation (borrow demand, loan book) that happened in that day // toString
        for(Operation show :operations)
        {
            System.out.println(show.toString());
        }
        System.out.println("report ended");
	}

    //method to calculate loan of each user
    public void CalculateDebtOfLoanedUser() 
    {
        LocalDate timeofnow =  LocalDate.now();
        for(User user : Library.users)
        {
            user.totalfinetopay=0;
            for(LocalDate dateofborrow : user.dateof_borrowing)
            {
             long daysDifference = ChronoUnit.DAYS.between(dateofborrow,timeofnow);
             if(user.typesub==PlanSubscription.Basic_plan)
             {
                if(daysDifference>14)
                {
                    user.totalfinetopay=user.totalfinetopay+Library.fineofregular*(daysDifference-14);
                }
             }
             else
             {
                if(daysDifference>30)
                {
                    user.totalfinetopay=user.totalfinetopay+Library.fineofregular*(daysDifference-30);
                }
             }
            }
	    }
    }  
    //method to treat borrow demands
    public void Loan() 
    {
		// find if there is not treated borrow demands
        boolean launchlloan;
        for (Operation check : operations) // so we do an iteration of all the operations in the arraylist operations
        {
        
            if (check instanceof BorrowDemand) // we check if the operation is a borrow demand operation iif it's not we skip
            {
                BorrowDemand demandcheck=(BorrowDemand)check;// the operations is a borrow demand operation
        
                if (demandcheck.status==Statusofdemand.Nottreated)// we check it status if it's treated or refused we skip
                {
                    User treatuser = Library.Searchforuser(demandcheck.user_borrowerid);
                    // we check the type of subscription for this user 
                    // if it's a basic sub he can borrow a book if the number of books he has rn is less than 2 and the total fine he has to pay is 0
                    // if not he can't borrow the book 
                    //if it's a vip sub he can borrow a book if the number of books he has rn is less than 5 and the total fine he has to pay is 0
                    // if not he can't borrow the book
                    if(treatuser.typesub==PlanSubscription.Basic_plan)
                    {
                    launchlloan=Library.checkpossibility(demandcheck,treatuser,2);
                    }
                    else
                    {
                    launchlloan=Library.checkpossibility(demandcheck,treatuser,5);
                    }
                    if(launchlloan==false)
                    {
                        // user has max number of books he can borrow or he is in debt
                        System.out.println("launch loan failed because user is in debt or has max number of books\n");
                    }
                    else
                    {
                        // we check if there is a copie available
                        Copy checkcopy=Library.FindCopies(demandcheck.bookid);
                        if(checkcopy==null)
                        {
                            System.out.println("launch loan failed because there are no available copies");
                        }
                        else
                        {
                            System.out.println("launch loan success");
                            checkcopy.state=Status.Notavailable;
                            Library.registerLoad(checkcopy,treatuser,operationsofloan);
                        }
                    }
                }
            }
        }
        operations.addAll(operationsofloan);
    }
}
