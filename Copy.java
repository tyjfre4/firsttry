package exam_tp;

enum Status{
    Available,
    Notavailable;
}

public class Copy extends Book {
    
    protected Status state; // to indicate if the copy is available or not
    // constuctor without parameters
    public Copy()
    {

    }

    // constructor with parameters
    public Copy (Book book)
    {
        super(book.title,book.category,book.authors);// call of constructor of class Book
		this.state = Status.Available;
        this.id = CreateCopyId(book.copyid+1,book.id);// create id of copy
		book.copies.add(this);// add the copy to arraylist of book copies
        book.copyid++;
    }
    
    // method to create copy id
    public static String CreateCopyId(int copynumber,String bookid) {
		String id = "";
		id = id.concat("E");
		id = id.concat(String.valueOf(copynumber));
		id = id.concat(bookid);
		return id;
	}
}
