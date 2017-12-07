package group_project.csumb.com.autitrak.simone;


public class User {


    private String name;
    private long type;
    private String linkedemail;
    private boolean active;

    public User(){}

    public User(String name, long type, String linkedemail, boolean active){this.name=name;this.type=type;this.linkedemail=linkedemail;
    this.active=active;}

    public void setName(String name)
    {
        this.name = name;
    }

    public void setType(long type){this.type=type;}

    public void setLinkedEmail(String linkedemail){this.linkedemail=linkedemail;}

    public void setActive(boolean active){this.active=active;}

    public String getName()
    {
        return name;
    }

    public long getType()
    {
        return type;
    }

    public String getLinkedEmail(){return linkedemail;}

    public boolean isActive(){return active;}

}
