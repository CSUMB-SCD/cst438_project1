package group_project.csumb.com.autitrak.simone;



public class Task {

    private String description;
    private String skillType;
    private String level;
    private String startdate;
    private String enddate;
    private boolean active;
    private int points;


    public Task() {}


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

    public void setDescription(String description){this.description=description;}

    public void setSkillType(String skillType){this.skillType=skillType;}

    public void setLevel(String level){this.level=level;}

    public void setStartDate(String startdate){this.startdate=startdate;}

    public void setEndDate(String enddate){this.enddate=enddate;}

    public void setActive(boolean active){this.active=active;}

    public void setPoints(int points){this.points=points;}

}
