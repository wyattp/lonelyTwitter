package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Abstraction for a tweet.
 *
 * @see NormalTweet
 * @see ImportantTweet
 * @author defuzli
 */
public abstract class Tweet implements Tweetable {
    private String message;
    private Date date;

    /**
     * Instantiates a new Tweet with a new message.
     *
     * @param message the message
     */
    Tweet(String message){

        this.message = message;
        date = new Date();
//        message = message;
    }

    /**
     * Instantiates a new Tweet with a new message and date.
     *
     * @param message the message
     * @param date    the date
     */
    Tweet(String message, Date date){
        this.message = message;
        this.date = date;
    }

    public String getMessage(){
        return message;
    }

    /**
     * Sets message of the tweet.
     *
     * @param message the message
     * @throws TweetTooLongException the tweet too long exception
     */
    public void setMessage(String message) throws TweetTooLongException{
        if (message.length() < 140){
            this.message = message;
        }
        else{
            throw new TweetTooLongException();
        }
    }

    public Date getDate(){
        return date;
    }

    /**
     * Set date.
     *
     * @param date the date of the tweet
     */
    public void setDate(Date date){
        this.date = date;
    }

    /**
     * Check if the tweet is important
     *
     * @return true if important and false otherwise
     */
    public abstract Boolean isImportant();

    public String toString() {
        return date.toString() + " |" + message;
    }

}
