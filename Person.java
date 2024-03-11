package exam_tp;

public class Person {

    protected String firstname; // name of the person
    protected String familyname; // family name of the person
    
    // empty constructor 
    public Person()
    {

    }
    
    // constructor with parameters
    public Person(String firstname , String familyname)
    {
        this.firstname = firstname;
        this.familyname = familyname;
    }
}
