package group_project.csumb.com.autitrak.simone;

/**
 * Created by sboyd on 11/13/2017.
 */

public class User {


    private String name;
    private int type;
    private String linkedemail;
    private boolean active;

    public User(){}


    public void setName(String name)
    {
        this.name = name;
    }

    public void setType(int type){this.type=type;}

    public void setLinkedEmail(String linkedemail){this.linkedemail=linkedemail;}

    public void setActive(boolean active){this.active=active;}

    public String getName()
    {
        return name;
    }

    public int getType()
    {
        return type;
    }

    public String getLinkedEmail(){return linkedemail;}

    public boolean isActive(){return active;}

}
