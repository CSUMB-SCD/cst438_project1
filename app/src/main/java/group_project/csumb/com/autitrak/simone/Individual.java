package group_project.csumb.com.autitrak.simone;


import java.util.Map;

public class Individual{

    private Map<String,Integer> skills;

    public Individual(){}

    public Individual(Map<String,Integer>skills)
    {
        this.skills = skills;
    }

    public void setSkills(Map<String,Integer>skills)
    {
        this.skills = skills;
    }

    public Map<String,Integer>getSkills()
    {
        return skills;
    }

    //Replaces existing map values with 0
    public void resetSkills()
    {
        if(skills.get("interpersonal") != null && skills.get("intrapersonal")==null)
        {
            skills.put("interpersonal",0);
            skills.put("intrapersonal",0);
        }
    }




}
