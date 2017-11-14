package group_project.csumb.com.autitrak.simone;

import java.util.Map;

/**
 * Created by sboyd on 11/13/2017.
 */

public class Individual extends User {
    private Map<String,Integer>skills;

    public Individual(){}

    public Individual(String uid, String name)
    {
        //"1" indicates that the user is the Individual with autism
        super(uid,name,1);
        skills.put("Interpersonal",0);
        skills.put("Intrapersonal",0);
    }

    public Map<String,Integer>getSkills()
    {
        return skills;
    }

    //Replaces existing map values with 0
    public void resetSkills()
    {
        skills.put("Interpersonal",0);
        skills.put("Intrapersonal",0);
    }

    //Gets existing map value and adds accumulated points
    public boolean updateSkill(String skill_type, int points)
    {
        if(skills.containsKey(skill_type) && points > 0)
        {
            skills.put(skill_type,skills.get(skill_type)+ points);
            return true;
        }
        return false;
    }


}
