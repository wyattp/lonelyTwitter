package ca.ualberta.cs.lonelytwitter;

import android.test.ActivityInstrumentationTestCase2;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by praharen on 2/15/18.
 */

/**
 * test tweet list class
 */
public class TweetListTest extends ActivityInstrumentationTestCase2 {
    public TweetListTest()
    {
        super(LonelyTwitterActivity.class);
    }

    public void testAddTweet()
    {
        TweetList tweets = new TweetList();

        Tweet tweet = new NormalTweet("adding a tweet");

        tweets.add(tweet);
        assertTrue(tweets.hasTweet(tweet));

        /**
         * throw IllegalArgumentException on duplicate add
         */
        Boolean exceptionThrown = Boolean.FALSE;
        try {
            tweets.add(tweet);
        }
        catch (IllegalArgumentException e) {
            exceptionThrown = Boolean.TRUE;
        }
        assertTrue(exceptionThrown);
    }

    public void testHasTweet() {
        TweetList tweets = new TweetList();
        Tweet tweet = new NormalTweet("adding a tweet");
        assertFalse(tweets.hasTweet(tweet));
        tweets.add(tweet);
        assertTrue(tweets.hasTweet(tweet));
    }

    public void testGetTweet() {
        TweetList tweets = new TweetList();
        Tweet tweet = new NormalTweet("test");

        tweets.add(tweet);
        Tweet returnedTweet = tweets.getTweet(0);
        assertEquals(returnedTweet.getDate(),tweet.getDate());
    }

    public void testDeleteTweet() {
        TweetList tweets = new TweetList();
        Tweet tweet = new NormalTweet("test");

        tweets.add(tweet);
        assertTrue(tweets.hasTweet(tweet));
        tweets.deleteTweet(tweet);
        assertFalse(tweets.hasTweet(tweet));
    }

    public void testGetTweets() {
        TweetList tweets = new TweetList();
        Tweet tweet = new NormalTweet("test");
        tweet.setDate(new Date("05/05/17"));
        Tweet tweet2 = new NormalTweet("test");
        tweet2.setDate(new Date("05/05/15"));
        tweets.add(tweet);
        tweets.add(tweet2);

        int inOrder = 0;
        inOrder = tweets.getTweet(0).compareTo(tweets.getTweet(1));
        assertTrue(inOrder > 0);

        ArrayList<Tweet> testList = tweets.getTweets();
        inOrder = testList.get(0).compareTo(testList.get(1));
        assertTrue(inOrder < 0);
    }

    public void testGetCount() {
        TweetList tweets = new TweetList();
        Tweet tweet = new NormalTweet("test");
        tweets.add(tweet);
        assertEquals(1, tweets.getCount());
        Tweet tweet2 = new NormalTweet("test");
        tweets.add(tweet2);
        assertEquals(2, tweets.getCount());
        Tweet tweet3 = new NormalTweet("test");
        tweets.add(tweet3);
        assertEquals(3, tweets.getCount());
    }
}
