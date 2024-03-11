package exam_tp;

public class VipUser extends User{

    // empty constructor
    public VipUser(){

    }
    // constructor with parameters
    public VipUser(String firstname , String familyname, PlanSubscription typesub, int dayofbirth ,int monthofbirth ,int yearofbirth)
    {
        super(firstname ,familyname, typesub,dayofbirth , monthofbirth ,yearofbirth);
    }
    // we can add method that are only for vip users here
    

    
}
