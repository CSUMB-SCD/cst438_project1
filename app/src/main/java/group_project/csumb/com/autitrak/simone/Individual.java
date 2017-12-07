package group_project.csumb.com.autitrak.simone;


import java.util.Map;

public class Individual{

    private Map<String,Object> skill_levels;
    private long totalpoints;

    public Individual(){}

    public Individual(long totalpoints, Map<String,Object> skills_levels)
    {this.totalpoints=totalpoints;this.skill_levels=skills_levels;}

    public void setSkillLevels(Map<String,Object>skill_levels)
    {
        this.skill_levels = skill_levels;
    }

    public void setTotalPoints(long totalpoints){this.totalpoints=totalpoints;}

    public Map<String,Object>getSkillLevels()
    {
        return skill_levels;
    }

    public long getTotalPoints()
    {
        return totalpoints;
    }



}
