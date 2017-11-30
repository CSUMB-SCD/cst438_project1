package group_project.csumb.com.autitrak.brittany;

/**
 * Created by britt on 11/25/2017.
 */

public class ListItem {
    private String name;
    private String info;
    private int imageID;

    public ListItem(String name, String info, int imageID) {
        this.name = name;
        this.info = info;
        this.imageID = imageID;
    }

    public String getName() {return name;}

    public void setName(String name) {this.name = name;}

    public String getInfo() {return info;}

    public void setInfo(String info) {this.info = info;}

    public int getImageID() {return imageID;}

    public void setImageID(int imageID) {this.imageID = imageID;}
}
