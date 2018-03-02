package ca.ualberta.cs.lonelytwitter;

import android.app.Activity;
import android.test.ActivityInstrumentationTestCase2;
import android.widget.EditText;
import android.widget.ListView;

import com.robotium.solo.Solo;

import junit.framework.TestCase;

import java.util.ArrayList;

public class LonelyTwitterActivityTest extends ActivityInstrumentationTestCase2 {

    private Solo solo;

    public LonelyTwitterActivityTest() {
        super(ca.ualberta.cs.lonelytwitter.LonelyTwitterActivity.class);
    }

    public void setUp() throws Exception {
        solo = new Solo(getInstrumentation(), getActivity());
    }

    @Override
    public void tearDown() throws Exception {
        solo.finishOpenedActivities();
    }

    public void testTweet() {
        solo.assertCurrentActivity("Wrong Activity", LonelyTwitterActivity.class);

        solo.enterText((EditText) solo.getView(R.id.body), "Test tweet");

        solo.clickOnButton("Save");

        solo.clearEditText((EditText) solo.getView(R.id.body));

        assertTrue(solo.waitForText("Test tweet"));

        solo.clickOnButton("Clear");

        assertFalse(solo.waitForText("Test tweet", 1, 3000));
    }

    public void testClickTweetList() {
        LonelyTwitterActivity activity = (LonelyTwitterActivity)solo.getCurrentActivity();
        solo.assertCurrentActivity("Wrong Activity", LonelyTwitterActivity.class);
        solo.enterText((EditText) solo.getView(R.id.body), "Test tweet");
        solo.clickOnButton("Save");
        solo.clearEditText((EditText) solo.getView(R.id.body));
        assertTrue(solo.waitForText("Test tweet"));
        final ListView oldTweetsList = activity.getOldTweetsList();
        ArrayList<Tweet> tweetList = activity.getTweetList();
        Tweet tweet = (Tweet) tweetList.get(0);

        assertEquals("Test tweet", tweet.getMessage());

        solo.clickInList(0);
        solo.assertCurrentActivity("Wrong Activity", EditTweetActivity.class);
        solo.goBack();
        solo.assertCurrentActivity("Wrong Activity!", LonelyTwitterActivity.class);
    }

    public void testEditTweet() {

        solo.assertCurrentActivity("Wrong Activity", LonelyTwitterActivity.class);

        solo.clickOnButton("Clear");

        solo.enterText((EditText) solo.getView(R.id.body), "Test tweet");

        solo.clickOnButton("Save");

        solo.clearEditText((EditText) solo.getView(R.id.body));

        assertTrue(solo.waitForText("Test tweet"));

        solo.clickInList(0);

        solo.assertCurrentActivity("wrong", EditTweetActivity.class);

        assertTrue(solo.waitForText("Test tweet"));
    }

    public void testStart() throws Exception {
        LonelyTwitterActivity activity = (LonelyTwitterActivity)solo.getCurrentActivity();

    }
}