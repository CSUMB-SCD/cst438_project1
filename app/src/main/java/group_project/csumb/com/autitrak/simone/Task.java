package group_project.csumb.com.autitrak.simone;



public class Task {

    private String description;
    private String skillType;
    private String level;
    private String startdate;
    private String enddate;
    private boolean active;
    private int points;
    private String reward;


    public Task() {}

    public Task(String description,String skillType,String level,String startdate,String enddate,boolean active,int points,String reward)
    {this.description=description;this.skillType=skillType;this.level=level;this.startdate=startdate;this.enddate=enddate;this.active=active;
    this.points=points;this.reward=reward;}

    public String getDescription()
    {
        return description;
    }

    public String getSkillType()
    {
        return skillType;
    }

    public String getLevel(){return level;}

    public String getStartDate()
    {
        return startdate;
    }

    public String getEndDate(){return enddate;}

    public boolean isActive()
    {
        return active;
    }

    public int getPoints(){return points;}

    public String getReward(){return reward;}

    public void setDescription(String description){this.description=description;}

    public void setSkillType(String skillType){this.skillType=skillType;}

    public void setLevel(String level){this.level=level;}

    public void setStartDate(String startdate){this.startdate=startdate;}

    public void setEndDate(String enddate){this.enddate=enddate;}

    public void setActive(boolean active){this.active=active;}

    public void setPoints(int points){this.points=points;}

    public void setReward(String reward){this.reward=reward;}

}
