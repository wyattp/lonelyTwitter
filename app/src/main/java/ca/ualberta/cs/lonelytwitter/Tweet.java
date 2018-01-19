package ca.ualberta.cs.lonelytwitter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by praharen on 1/18/18.
 */

public abstract class Tweet implements Tweetable {

    private String message;
    private Date date;
    private List<Mood> moods;

    public Tweet(String message) {
        this.message = message;
        this.date = new Date();
        this.moods = new ArrayList<Mood>();
    }

    public Tweet(String message, Date date) {
        this.date = date;
        this.message = message;
        this.moods = new ArrayList<Mood>();
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) throws TweetTooLongException {
        if (message.length() > 140) {
            throw new TweetTooLongException();
        } else {
            this.message = message;
        }
    }

    public void addMood(Mood mood) {
        this.moods.add(mood);
    }

    public abstract Boolean isImportant();
}