package ca.ualberta.cs.lonelytwitter;

/**
 * Created by dezfuli on 1/16/18.
 */
import java.util.Date;

/**
 * The type Important tweet.
 *
 * @see Tweet
 */
public class ImportantTweet extends Tweet {
    /**
     * Instantiates a new Important tweet.
     *
     * @param message the message
     */
    ImportantTweet(String message){
        super(message);
    }

    /**
     * Instantiates a new Important tweet.
     *
     * @param message the message
     * @param date    the date
     */
    ImportantTweet(String message, Date date){
        super(message, date);
    }

    @Override
    public Boolean isImportant() {
        return Boolean.TRUE;
    }
}
