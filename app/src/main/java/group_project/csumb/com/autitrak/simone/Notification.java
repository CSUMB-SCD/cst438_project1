package group_project.csumb.com.autitrak.simone;

/**
 * Created by sboyd on 12/5/2017.
 */

public class Notification {

    private String sender;
    private String recipient;
    private String message;
    private String timestamp;
    //0 is unread, 1 is read, 2 sent
    private int status;

    public Notification(){}

    public Notification(String sender, String recipient, String message, String timestamp, int status)
    {
        this.sender=sender;
        this.recipient=recipient;
        this.message=message;
        this.timestamp=timestamp;
        this.status=status;
    }

    public String getSender(){return sender;}

    public String getRecipient(){return recipient;}

    public String getMessage(){return message;}

    public String getTimestamp(){return timestamp;}

    public int getStatus(){return status;}

    public void setSender(String sender){this.sender=sender;}

    public void setRecipient(String recipient){this.recipient=recipient;}

    public void setMessage(String message){this.message=message;}

    public void setTimestamp(String timestamp){this.timestamp=timestamp;}

    public void setStatus(int status){this.status=status;}



}
