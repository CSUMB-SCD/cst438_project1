package group_project.csumb.com.autitrak;

/**
 * Created by britt on 11/25/2017.
 */

public class ListItem {
    private String description;
    private String level;
    private String startDate;
    private String endDate;
    private int points;

    public ListItem(String description, String level, String startDate, String endDate, int points) {
        this.description = description;
        this.level = level;
        this.startDate = startDate;
        this.endDate = endDate;
        this.points = points;
    }

    public ListItem(String description, String endDate) {
        this.description = description;
        this.endDate = endDate;
    }

    public ListItem(String description, String endDate, int points) {
        this.description = description;
        this.endDate = endDate;
        this.points = points;
    }

    public String getDescription() {return description;}
    public void setDescription(String description) {this.description = description;}

    public String getLevel() {return level;}
    public void setLevel(String level) {this.level = level;}

    public String getStartDate() {return startDate;}
    public void setStartDate(String startDate) {this.startDate = startDate;}

    public String getEndDate() {return endDate;}
    public void setEndDate(String endDate) {this.endDate = endDate;}

    public int getPoints() {return points;}
    public void setPoints(int points) {this.points = points;}
}
