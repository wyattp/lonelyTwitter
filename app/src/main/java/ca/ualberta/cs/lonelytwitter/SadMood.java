package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Created by praharen on 1/18/18.
 */

public class SadMood extends Mood {

    public SadMood(Date date) {
        super(date);
    }

    public SadMood() {
        super();
    }

    public String getMood() {
        return "Sad";
    }

}
