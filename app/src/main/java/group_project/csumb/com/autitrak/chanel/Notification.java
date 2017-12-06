package group_project.csumb.com.autitrak.chanel;

/**
 * Created by chanel on 12/5/17.
 */

public class Notification {

    private String subject;
    private String sender;
    private String recipient;
    private String message;
    private String date;
    private int status;

    /**
     *
     * @param subject
     * @param sender
     * @param recipient
     * @param message
     *      notification message (condense to two lines of text in preview)
     * @param date
     *      format: Month DD, YYYY (ex. "Dec 15, 2017")
     * @param status
     *      0: unread, 1: read, 2: sent
     */
    public Notification(String subject, String sender, String recipient, String message, String date, int status) {
        this.subject = subject;
        this.sender = sender;
        this.recipient = recipient;
        this.message = message;
        this.date = date;
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

    public String getDate() {
        return date;
    }

    public int getStatus() {
        return status;
    }
}
