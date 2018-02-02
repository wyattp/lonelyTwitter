package ca.ualberta.cs.lonelytwitter;

/**
 * Created by dezfuli on 1/16/18.
 */
import java.util.Date;

/**
 * Normal tweet. Subclass of Tweet
 *
 * @see Tweet
 */
public class NormalTweet extends Tweet {
    /**
     * Instantiates a new Normal tweet.
     *
     * @param message the message
     */
    NormalTweet(String message){
        super(message);
    }

    /**
     * Instantiates a new Normal tweet.
     *
     * @param message the message
     * @param date    the date
     */
    NormalTweet(String message, Date date){
        super(message, date);
    }

    @Override
    public Boolean isImportant() {
        return Boolean.FALSE;
    }
}
