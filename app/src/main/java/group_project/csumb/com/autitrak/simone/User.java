package group_project.csumb.com.autitrak.simone;

/**
 * Created by sboyd on 11/13/2017.
 */

public class User {

    private String uid;
    private String name;
    private int type;

    public User(){};

    public User(String uid, String name, int type){this.uid=uid;this.name=name;this.type=type;}

    public void setName(String name)
    {
        this.name = name;
    }

    public String getUid()
    {
        return uid;
    }

    public String getName()
    {
        return name;
    }

    public int getType()
    {
        return type;
    }

}
