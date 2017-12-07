package group_project.csumb.com.autitrak.chanel;

/**
 * Created by chanel on 12/5/17.
 */

public class Notification {

    private String subject;
    private String sender;
    private String recipient;
    private String message;
    private String timestamp;
    private int status;

    /**
     *
     * @param subject
     * @param sender
     * @param recipient
     * @param message
     *      notification message (condense to two lines of text in preview)
     * @param timestamp
     *      format: Month DD, YYYY (ex. "Dec 15, 2017")
     * @param status
     *      0: unread, 1: read, 2: sent
     */
    public Notification(String subject, String sender, String recipient, String message, String timestamp, int status) {
        this.subject = subject;
        this.sender = sender;
        this.recipient = recipient;
        this.message = message;
        this.timestamp = timestamp;
        this.status = status;
    }

    public String getSubject() {
        return subject;
    }
    public String getSender() {
        return sender;
    }

    public String getRecipient() {
        return recipient;
    }

    public String getMessage() {
        return message;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public int getStatus() {
        return status;
    }

    public void setSubject(String subject){this.subject=subject;}

    public void setSender(String sender){this.sender=sender;}

    public void setRecipient(String recipient){this.recipient=recipient;}

    public void setMessage(String message){this.message=message;}

    public void setTimestamp(String timestamp){this.timestamp=timestamp;}

    public void setStatus(int status){this.status=status;}
}
