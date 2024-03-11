package exam_tp;

public class RegularUser extends User{
    // empty constructor
    public RegularUser()
    {

    }
    
    // constructor with parameters
    public RegularUser(String firstname , String familyname, PlanSubscription typesub, int dayofbirth ,int monthofbirth ,int yearofbirth)
    {
        super(firstname ,familyname, typesub,dayofbirth , monthofbirth ,yearofbirth);
    }
    // we can add methods that are for regular users 


    
}
