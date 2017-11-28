package group_project.csumb.com.autitrak.simone;


import java.util.Map;

public class Individual{

    private Map<String,String> skill_levels;
    private int totalpoints;

    public Individual(){}


    public void setSkillLevels(Map<String,String>skill_levels)
    {
        this.skill_levels = skill_levels;
    }

    public void setTotalPoints(int totalpoints){this.totalpoints=totalpoints;}

    public Map<String,String>getSkillLevels()
    {
        return skill_levels;
    }

    public int getTotalPoints()
    {
        return totalpoints;
    }



}
