package exam_tp;

import java.util.ArrayList;

 enum Category { 
	Fiction,
	Comics,
	BioMemo,
	Religion,
	ArtPhotography,
	Health,
	History,
	Novel
}
public class Book extends Resource {
 
	protected static int bookcount=0;
    protected String title; // title of the book
    protected ArrayList<Person> authors; // authors of the book
    protected ArrayList<Copy> copies; // copies of the book
    protected Category category; // category of the book
    protected int copyid;
	// constructor wthis no parameters
	public Book()
	{
		
	}

    // constructor without authors
	public Book(String title,Category category)
	{
		this.id = CreateBookId(bookcount,category); // creating book id using CreateBookId method
		this.title = title; 
		this.category = category;
		this.authors = new ArrayList<Person>();
		this.copies = new ArrayList<Copy>();
		this.copyid=0;
        bookcount++;
	}

	// constructor with authors
	public Book(String title,Category category,ArrayList<Person> authors)
	{
		this.id = CreateBookId(bookcount,category);
		this.title = title;
		this.category = category;
		this.authors = new ArrayList<Person>(authors);
		this.copies = new ArrayList<Copy>();
		this.copyid=0;
		bookcount++;
	}

    // method to get the number of category
	public static String categorytonumbercategory(Category category)
    {
        switch(category)
        {
            case Fiction:
            return "1";
            case Comics:
            return "2";
            case BioMemo:
            return "3";
            case Religion:
            return "4";
            case ArtPhotography:
            return "5";
            case Health:
            return "6";
            case History:
            return "7";
            case Novel:
            return "8";
            default:
            System.out.println("category doesn't exist");
            return "0";
        }
    }
	
    //method to create book id
    public static String CreateBookId(int numberofbook,Category category)
    {
        String id = "";
		id = id.concat("B");
		id = id.concat(String.valueOf(numberofbook));
		id = id.concat("C");
		id = id.concat(categorytonumbercategory(category));
		return id;
	}
}
