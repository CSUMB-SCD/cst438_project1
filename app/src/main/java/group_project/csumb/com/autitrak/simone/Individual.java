package group_project.csumb.com.autitrak.simone;



import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;



public class Individual{
    private int interpersonal;
    private int intrapersonal;


    public Individual(){}

    public Individual(int interpersonal, int intrapersonal)
    {
        this.interpersonal = interpersonal;
        this.intrapersonal = intrapersonal;
    }

    public int getInterpersonal()
    {
        return interpersonal;
    }

    public int getIntrapersonal()
    {
        return intrapersonal;
    }

    public void setInterpersonal(int interpersonal)
    {
        this.interpersonal = interpersonal;
    }

    public void setIntrapersonal(int intrapersonal)
    {
        this.intrapersonal= intrapersonal;
    }

    //Replaces existing map values with 0
    public void resetSkills()
    {
        interpersonal = 0;
        intrapersonal = 0;
    }




}
