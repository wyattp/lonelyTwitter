package ca.ualberta.cs.lonelytwitter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * Created by praharen on 2/15/18.
 */

public class TweetList {

    private ArrayList<Tweet> tweets = new ArrayList<Tweet>();

    public void add(Tweet tweet) {
        if (this.hasTweet(tweet))
            throw new IllegalArgumentException();
        else
            tweets.add(tweet);
    }

    public Boolean hasTweet(Tweet tweet) {
        return tweets.contains(tweet);
    }

    public Tweet getTweet(Integer i) {
        return tweets.get(i);
    }

    public ArrayList<Tweet> getTweets() {
        Collections.sort(tweets);
        return this.tweets;
    }

    public void deleteTweet(Tweet tweet) {
        tweets.remove(tweet);
    }

    public int getCount() {
        return this.tweets.size();
    }
}
