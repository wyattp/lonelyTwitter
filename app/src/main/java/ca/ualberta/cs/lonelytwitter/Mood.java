package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Created by praharen on 1/18/18.
 */

public abstract class Mood {

    private Date date;
    private String mood;

    public Mood(String mood, Date date) {
        this.date = date;
        this.mood = mood;
    }

    public Mood(String mood) {
        this.date = new Date();
        this.mood = mood;
    }

    public String getMood() {
        return this.mood;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

}