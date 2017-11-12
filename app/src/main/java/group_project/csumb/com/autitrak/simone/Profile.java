package group_project.csumb.com.autitrak.simone;


public class Profile {

    private String id;
    private String name;
    private String email;

    public Profile(String id, String name, String email)
    {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public Profile(){}

    String getId()
    {
        return id;
    }

    String getName()
    {
        return name;
    }

    String getEmail()
    {
        return email;
    }


}

