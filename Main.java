package exam_tp;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) 
    {
        // create an agent object
        Agent agent = new Agent();
        
        Library lib = new Library();
        // create some books
        // create book1
        ArrayList<Person> authorsofbook1 = new ArrayList<Person>();
        authorsofbook1.add(new Person("Abdallah","Family name of Abdallah"));
        Book book1 = new Book("book3",Category.Novel,authorsofbook1);
        // create book2
        Book book2 =new Book("book2",Category.ArtPhotography); 
        Person author1ofbook2=new Person();// author1
        author1ofbook2.firstname="kamal";
        author1ofbook2.familyname="Family name of Kamal";
        Person author2ofbook2=new Person("Zakaria","Family name of Zakaria");//author2
        book2.authors.add(author1ofbook2);
        book2.authors.add(author2ofbook2);

        // create book3
        ArrayList<Person> authorsofbook3 = new ArrayList<Person>();
        authorsofbook3.add(new Person("Abdallah","Family name of Abdallah"));
        authorsofbook3.add(new Person("Salma","Family name of Salma"));
        authorsofbook3.add(new Person("Sadak","Family name of Sadak"));
        Book book3 = new Book("book3",Category.Health,authorsofbook3);

        //adding book1 and book2 and book3 to library by addbook method for agent
        agent.AddBook(book1);
        agent.AddBook(book2);
        agent.AddBook(book3);

        // show books in librery
        showbookinlibrary();

        // create some users
        //create user1 using addnewuser method for agent
        agent.AddNewUser("user1","Family name of user1",PlanSubscription.Basic_plan,10,12,2000);
        //create user2 using addnewuser method for agent
        agent.AddNewUser("user2","Family name of user2",PlanSubscription.Vip_plan,12,8,1990);
        // create user3 using addnewuser method for agent
        agent.AddNewUser("user3","Family name of user3",PlanSubscription.Basic_plan,23,11,2002);
        //create user4 
        User user4 = new User("user4","Family name of user4",PlanSubscription.Basic_plan,13,10,2005);
        Library.users.add(user4);
        // show user
        showuserinlibrary();

        // create some copies
        // copies for book1
        agent.AddNewCopy(book1);
        agent.AddNewCopy(book1);
        agent.AddNewCopy(book1);
        //show copies of book1
        showcopyiesofabook(book1);
        // copies for book2
        agent.AddNewCopy(book2);
        agent.AddNewCopy(book2);
        //show copies of book2
        showcopyiesofabook(book2);
        //copies for book3
        agent.AddNewCopy(book3);
        //show copies of book3
        showcopyiesofabook(book3);

        // test operation
        // test for search book by title in class user
        user4.findBookByTitle("book1");
        // test for search book by category 
        user4.findBooksByCategory(Category.Health);
        // test for borrow 
        user4.Borrow(book1.id,agent.operations);
        user4.Borrow(book2.id,agent.operations);
        user4.Borrow(book3.id,agent.operations);
        // test to show if borrow operations happened
        agent.displayOperationReport();
        // test for loan
        agent.Loan();
        // show if operation of loan happened
        agent.displayOperationReport();
        // display of all the operation of the day and calculate the debt
        agent.ProcessEndofDay();
        // show the debt of user4 for example
        System.out.println("the debt of user4 is: "+user4.totalfinetopay);
        // clear the queue at the start of the day
        agent.ProcessStartofDay();
        // show that it worked
        System.out.println("the fresh list");
        // display
        agent.displayOperationReport();
 
    }










    public static void showuserinlibrary()
    {
        for(User user: Library.users)
        {
            System.out.println("user id is :"+user.id+" user name is :"+user.firstname+" user family name is :"+user.familyname+"\n");
        }
    }

    public static void showbookinlibrary()
    {
        for(Book book: Library.books)
        {
            System.out.println("book id is :"+book.id+" book title is :"+book.title+" book category is :"+book.category+"\n");
        }
    }

    public static void showcopyiesofabook(Book book)
    {
        for(Copy copie : book.copies)
        {
            System.out.println("copy id is :"+copie.id+"copy title is :"+copie.title+"copy category is :"+copie.category+"\n");
        }
    }
    
}
