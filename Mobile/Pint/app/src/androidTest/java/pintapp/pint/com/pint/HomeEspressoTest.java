package pintapp.pint.com.pint;

import android.support.test.InstrumentationRegistry;
import android.support.test.espresso.Espresso;
import android.support.test.espresso.IdlingPolicies;
import android.support.test.espresso.IdlingResource;
import android.support.test.espresso.matcher.BoundedMatcher;
import android.test.ActivityInstrumentationTestCase2;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Before;

import java.util.concurrent.TimeUnit;

import static android.support.test.espresso.Espresso.onData;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.swipeLeft;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.doesNotExist;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDescendantOfA;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.CoreMatchers.allOf;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.Matchers.instanceOf;
import static org.hamcrest.Matchers.is;

/**
 * Created by gregoryjean-baptiste on 11/29/15.
 */
public class HomeEspressoTest extends ActivityInstrumentationTestCase2 {

    private LoginActivity loginActivity;
    private long waitingTime = 3500;

    public HomeEspressoTest() {
        super(LoginActivity.class);
        IdlingPolicies.setMasterPolicyTimeout(waitingTime * 2, TimeUnit.MILLISECONDS);
        IdlingPolicies.setIdlingResourceTimeout(waitingTime * 2, TimeUnit.MILLISECONDS);
    }

    @Before
    public void setUp() throws Exception {
        super.setUp();
        injectInstrumentation(InstrumentationRegistry.getInstrumentation());
        loginActivity = (LoginActivity) getActivity();
        HomeActivity.ListFragment.my_city = "Miami";
        HomeActivity.ListFragment.my_state = "FL";
    }

    public void testHomeMiamiUser() {
        onView(withId(R.id.loginTextEmail)).perform(typeText("bpate005@fiu.edu"), closeSoftKeyboard());
        onView(withId(R.id.loginTextPassword)).perform(typeText("bruPINT#111"), closeSoftKeyboard());
        onView(withId(R.id.loginButtonLogin)).perform(click());

        IdlingResource idlingResource = new ElapsedTimeIdlingResource(waitingTime);
        Espresso.registerIdlingResources(idlingResource);

        onData(allOf(is(instanceOf(JSONObject.class)))).inAdapterView(withId(R.id.homeListViewList)).atPosition(0).check(matches(isDisplayed()));
        onData(allOf(is(instanceOf(JSONObject.class)))).inAdapterView(withId(R.id.homeListViewList)).atPosition(1).check(matches(isDisplayed()));

        onData(allOf(instanceOf(JSONObject.class), myCustomObjectShouldHaveString("FIU-MMC Blood Drive")))
                .inAdapterView(withId(R.id.homeListViewList)).check(matches(isDisplayed()));
        onData(allOf(instanceOf(JSONObject.class), myCustomObjectShouldHaveString("FIU-BBC Blood Drive")))
                .inAdapterView(withId(R.id.homeListViewList)).check(matches(isDisplayed()));

        Espresso.unregisterIdlingResources(idlingResource);
    }

    public void testHomeSFUser() {
        HomeActivity.ListFragment.my_city = "San Francisco";
        HomeActivity.ListFragment.my_state = "CA";
        //lol

        onView(withId(R.id.loginTextEmail)).perform(typeText("calvin121@fiu.edu"), closeSoftKeyboard());
        onView(withId(R.id.loginTextPassword)).perform(typeText("calPINT#231"), closeSoftKeyboard());
        onView(withId(R.id.loginButtonLogin)).perform(click());

        IdlingResource idlingResource = new ElapsedTimeIdlingResource(waitingTime);
        Espresso.registerIdlingResources(idlingResource);

        onData(allOf(is(instanceOf(JSONObject.class)))).inAdapterView(withId(R.id.homeListViewList)).atPosition(0).check(matches(isDisplayed()));

        onData(allOf(instanceOf(JSONObject.class), myCustomObjectShouldHaveString("Red Cross Blood Drive")))
                .inAdapterView(withId(R.id.homeListViewList)).check(matches(isDisplayed()));

        Espresso.unregisterIdlingResources(idlingResource);
    }

    public void testHomeAtlantaUser() {
        HomeActivity.ListFragment.my_city = "Atlanta";
        HomeActivity.ListFragment.my_state = "GA";

        onView(withId(R.id.loginTextEmail)).perform(typeText("cora337@fiu.edu"), closeSoftKeyboard());
        onView(withId(R.id.loginTextPassword)).perform(typeText("corPINT#671"), closeSoftKeyboard());
        onView(withId(R.id.loginButtonLogin)).perform(click());

        IdlingResource idlingResource = new ElapsedTimeIdlingResource(waitingTime);
        Espresso.registerIdlingResources(idlingResource);

        onView(allOf(withId(R.id.bdTitle), isDescendantOfA(withId(R.id.homeListViewList)))).check(doesNotExist());

        Espresso.unregisterIdlingResources(idlingResource);
    }

    public void testHomeNewYorkUser() {
        HomeActivity.ListFragment.my_city = "New York";
        HomeActivity.ListFragment.my_state = "NY";

        onView(withId(R.id.loginTextEmail)).perform(typeText("dolly999@fiu.edu"), closeSoftKeyboard());
        onView(withId(R.id.loginTextPassword)).perform(typeText("dolPINT#177"), closeSoftKeyboard());
        onView(withId(R.id.loginButtonLogin)).perform(click());

        IdlingResource idlingResource = new ElapsedTimeIdlingResource(waitingTime);
        Espresso.registerIdlingResources(idlingResource);

        onView(allOf(withId(R.id.bdTitle), isDescendantOfA(withId(R.id.homeListViewList)))).check(doesNotExist());

        Espresso.unregisterIdlingResources(idlingResource);
    }

    public void testMMCDetailed() {
        onView(withId(R.id.loginTextEmail)).perform(typeText("bpate005@fiu.edu"), closeSoftKeyboard());
        onView(withId(R.id.loginTextPassword)).perform(typeText("bruPINT#111"), closeSoftKeyboard());
        onView(withId(R.id.loginButtonLogin)).perform(click());

        IdlingResource idlingResource = new ElapsedTimeIdlingResource(waitingTime);
        Espresso.registerIdlingResources(idlingResource);

        onData(allOf(instanceOf(JSONObject.class), myCustomObjectShouldHaveString("FIU-MMC Blood Drive")))
                .inAdapterView(withId(R.id.homeListViewList)).perform(click());

        Espresso.unregisterIdlingResources(idlingResource);
        Espresso.registerIdlingResources(idlingResource);

        onView(Matchers.allOf(withText("FIU-MMC Blood Drive"), isDescendantOfA(withId(R.id.detailList)))).check(matches(isDisplayed()));
        onView(Matchers.allOf(withText("1234 FIU Way"), isDescendantOfA(withId(R.id.detailList)))).check(matches(isDisplayed()));
        onView(Matchers.allOf(withText("We need blood due to the high frequency of accidents in the area."), isDescendantOfA(withId(R.id.detailList)))).check(matches(isDisplayed()));

        onData(allOf(instanceOf(JSONObject.class), myCustomObjectShouldHaveString2("We are here until 6PM today. Please come by and donate.")))
                .inAdapterView(withId(R.id.detailList)).check(matches(isDisplayed()));
        onData(allOf(instanceOf(JSONObject.class), myCustomObjectShouldHaveString2("O+ is a rare blood type and we are lacking. Please come and donate.s")))
                .inAdapterView(withId(R.id.detailList)).check(matches(isDisplayed()));
        onData(allOf(instanceOf(JSONObject.class), myCustomObjectShouldHaveString2("We've got some pineapple pizza.")))
                .inAdapterView(withId(R.id.detailList)).check(matches(isDisplayed()));

        Espresso.unregisterIdlingResources(idlingResource);
    }

    public void testBBCDetailed() {
        onView(withId(R.id.loginTextEmail)).perform(typeText("jliu005@fiu.edu"), closeSoftKeyboard());
        onView(withId(R.id.loginTextPassword)).perform(typeText("pineapple"), closeSoftKeyboard());
        onView(withId(R.id.loginButtonLogin)).perform(click());

        IdlingResource idlingResource = new ElapsedTimeIdlingResource(waitingTime);
        Espresso.registerIdlingResources(idlingResource);

        onData(allOf(instanceOf(JSONObject.class), myCustomObjectShouldHaveString("FIU-BBC Blood Drive")))
                .inAdapterView(withId(R.id.homeListViewList)).perform(click());

        Espresso.unregisterIdlingResources(idlingResource);
        Espresso.registerIdlingResources(idlingResource);

        onView(Matchers.allOf(withText("FIU-BBC Blood Drive"), isDescendantOfA(withId(R.id.detailList)))).check(matches(isDisplayed()));
        onView(Matchers.allOf(withText("1234 FIU Way"), isDescendantOfA(withId(R.id.detailList)))).check(matches(isDisplayed()));
        onView(Matchers.allOf(withText("We need blood and we need it now."), isDescendantOfA(withId(R.id.detailList)))).check(matches(isDisplayed()));

        onData(allOf(instanceOf(JSONObject.class), myCustomObjectShouldHaveString2("A patient of thrombocytopenia is in a very critical condition and needs A negative blood. Please come and donate.")))
                .inAdapterView(withId(R.id.detailList)).check(matches(isDisplayed()));
        onData(allOf(instanceOf(JSONObject.class), myCustomObjectShouldHaveString2("Let's get more blood donations.")))
                .inAdapterView(withId(R.id.detailList)).check(matches(isDisplayed()));

        Espresso.unregisterIdlingResources(idlingResource);
    }

    public void testHomeDallasUser() {
        HomeActivity.ListFragment.my_city = "Dallas";
        HomeActivity.ListFragment.my_state = "TX";

        onView(withId(R.id.loginTextEmail)).perform(typeText("david888@gmail.com"), closeSoftKeyboard());
        onView(withId(R.id.loginTextPassword)).perform(typeText("davPINT#345"), closeSoftKeyboard());
        onView(withId(R.id.loginButtonLogin)).perform(click());

        IdlingResource idlingResource = new ElapsedTimeIdlingResource(waitingTime);
        Espresso.registerIdlingResources(idlingResource);

        onView(allOf(withId(R.id.bdTitle), isDescendantOfA(withId(R.id.homeListViewList)))).check(doesNotExist());

        Espresso.unregisterIdlingResources(idlingResource);
    }

    public void testViewNotificationsSF() {
        HomeActivity.ListFragment.my_city = "San Francisco";
        HomeActivity.ListFragment.my_state = "CA";

        onView(withId(R.id.loginTextEmail)).perform(typeText("frank004@fiu.edu"), closeSoftKeyboard());
        onView(withId(R.id.loginTextPassword)).perform(typeText("fraPINT#567"), closeSoftKeyboard());
        onView(withId(R.id.loginButtonLogin)).perform(click());

        IdlingResource idlingResource = new ElapsedTimeIdlingResource(waitingTime);
        Espresso.registerIdlingResources(idlingResource);

        onView(withId(R.id.viewpager)).perform(swipeLeft());

        Espresso.unregisterIdlingResources(idlingResource);
        idlingResource = new ElapsedTimeIdlingResource(waitingTime);
        Espresso.registerIdlingResources(idlingResource);

        onData(allOf(is(instanceOf(JSONObject.class)))).inAdapterView(withId(R.id.homeListViewList2)).atPosition(0).check(matches(isDisplayed()));
        onData(allOf(is(instanceOf(JSONObject.class)))).inAdapterView(withId(R.id.homeListViewList2)).atPosition(1).check(matches(isDisplayed()));

        onData(allOf(instanceOf(JSONObject.class), myCustomObjectShouldHaveString3("We need a lot more blood.")))
                .inAdapterView(withId(R.id.homeListViewList2)).check(matches(isDisplayed()));
        onData(allOf(instanceOf(JSONObject.class), myCustomObjectShouldHaveString3("Thank you very much for your donations.")))
                .inAdapterView(withId(R.id.homeListViewList2)).check(matches(isDisplayed()));

        Espresso.unregisterIdlingResources(idlingResource);
    }

    public void testViewNotificationsIndex() {
        HomeActivity.ListFragment.my_city = "Index";
        HomeActivity.ListFragment.my_state = "WA";

        onView(withId(R.id.loginTextEmail)).perform(typeText("Xuejiao@gmail.com"), closeSoftKeyboard());
        onView(withId(R.id.loginTextPassword)).perform(typeText("Xuejiao12345"), closeSoftKeyboard());
        onView(withId(R.id.loginButtonLogin)).perform(click());

        IdlingResource idlingResource = new ElapsedTimeIdlingResource(waitingTime);
        Espresso.registerIdlingResources(idlingResource);

        onView(withId(R.id.viewpager)).perform(swipeLeft());

        Espresso.unregisterIdlingResources(idlingResource);
        idlingResource = new ElapsedTimeIdlingResource(waitingTime);
        Espresso.registerIdlingResources(idlingResource);

        onData(allOf(is(instanceOf(JSONObject.class)))).inAdapterView(withId(R.id.homeListViewList2)).atPosition(0).check(matches(isDisplayed()));
        onData(allOf(is(instanceOf(JSONObject.class)))).inAdapterView(withId(R.id.homeListViewList2)).atPosition(1).check(matches(isDisplayed()));

        onData(allOf(instanceOf(JSONObject.class), myCustomObjectShouldHaveString3("Hurricane Devistation")))
                .inAdapterView(withId(R.id.homeListViewList2)).check(matches(isDisplayed()));
        onData(allOf(instanceOf(JSONObject.class), myCustomObjectShouldHaveString3("We are collecting blood for thalassemia patients.")))
                .inAdapterView(withId(R.id.homeListViewList2)).check(matches(isDisplayed()));

        Espresso.unregisterIdlingResources(idlingResource);
    }

    public void testViewNotificationsNewYork() {
        HomeActivity.ListFragment.my_city = "New York";
        HomeActivity.ListFragment.my_state = "NY";

        onView(withId(R.id.loginTextEmail)).perform(typeText("david888@gmail.com"), closeSoftKeyboard());
        onView(withId(R.id.loginTextPassword)).perform(typeText("davPINT#345"), closeSoftKeyboard());
        onView(withId(R.id.loginButtonLogin)).perform(click());

        IdlingResource idlingResource = new ElapsedTimeIdlingResource(waitingTime);
        Espresso.registerIdlingResources(idlingResource);

        onView(withId(R.id.viewpager)).perform(swipeLeft());

        Espresso.unregisterIdlingResources(idlingResource);
        idlingResource = new ElapsedTimeIdlingResource(waitingTime);
        Espresso.registerIdlingResources(idlingResource);

        onView(allOf(withId(R.id.bdTitle), isDescendantOfA(withId(R.id.homeListViewList2)))).check(doesNotExist());

        Espresso.unregisterIdlingResources(idlingResource);
    }

    public void testSelectNotifications() {
        onView(withId(R.id.loginTextEmail)).perform(typeText("accha004@fiu.edu"), closeSoftKeyboard());
        onView(withId(R.id.loginTextPassword)).perform(typeText("pint#pint"), closeSoftKeyboard());
        onView(withId(R.id.loginButtonLogin)).perform(click());

        IdlingResource idlingResource = new ElapsedTimeIdlingResource(waitingTime);
        Espresso.registerIdlingResources(idlingResource);

        onView(withId(R.id.viewpager)).perform(swipeLeft());

        Espresso.unregisterIdlingResources(idlingResource);
        idlingResource = new ElapsedTimeIdlingResource(waitingTime);
        Espresso.registerIdlingResources(idlingResource);

        onData(allOf(instanceOf(JSONObject.class), myCustomObjectShouldHaveString3("We need A- blood.")))
                .inAdapterView(withId(R.id.homeListViewList2)).perform(click());

        Espresso.unregisterIdlingResources(idlingResource);
        idlingResource = new ElapsedTimeIdlingResource(waitingTime);
        Espresso.registerIdlingResources(idlingResource);

        onView(Matchers.allOf(withText("FIU-BBC Blood Drive"), isDescendantOfA(withId(R.id.detailList)))).check(matches(isDisplayed()));
        onView(Matchers.allOf(withText("1234 FIU Way"), isDescendantOfA(withId(R.id.detailList)))).check(matches(isDisplayed()));
        onView(Matchers.allOf(withText("We need blood and we need it now."), isDescendantOfA(withId(R.id.detailList)))).check(matches(isDisplayed()));

        onData(allOf(instanceOf(JSONObject.class), myCustomObjectShouldHaveString2("A patient of thrombocytopenia is in a very critical condition and needs A negative blood. Please come and donate.")))
                .inAdapterView(withId(R.id.detailList)).check(matches(isDisplayed()));
        onData(allOf(instanceOf(JSONObject.class), myCustomObjectShouldHaveString2("Let's get more blood donations.")))
                .inAdapterView(withId(R.id.detailList)).check(matches(isDisplayed()));

        Espresso.unregisterIdlingResources(idlingResource);
    }

    public void testSelectNotifications2() {
        onView(withId(R.id.loginTextEmail)).perform(typeText("accha004@fiu.edu"), closeSoftKeyboard());
        onView(withId(R.id.loginTextPassword)).perform(typeText("pint#pint"), closeSoftKeyboard());
        onView(withId(R.id.loginButtonLogin)).perform(click());

        IdlingResource idlingResource = new ElapsedTimeIdlingResource(waitingTime);
        Espresso.registerIdlingResources(idlingResource);

        onView(withId(R.id.viewpager)).perform(swipeLeft());

        Espresso.unregisterIdlingResources(idlingResource);
        idlingResource = new ElapsedTimeIdlingResource(waitingTime);
        Espresso.registerIdlingResources(idlingResource);

        onData(allOf(instanceOf(JSONObject.class), myCustomObjectShouldHaveString3("The son of one of our employees needs blood urgently.")))
                .inAdapterView(withId(R.id.homeListViewList2)).perform(click());

        Espresso.unregisterIdlingResources(idlingResource);
        idlingResource = new ElapsedTimeIdlingResource(waitingTime);
        Espresso.registerIdlingResources(idlingResource);

        onView(Matchers.allOf(withText("FIU-MMC Blood Drive"), isDescendantOfA(withId(R.id.detailList)))).check(matches(isDisplayed()));
        onView(Matchers.allOf(withText("1234 FIU Way"), isDescendantOfA(withId(R.id.detailList)))).check(matches(isDisplayed()));
        onView(Matchers.allOf(withText("We need blood due to the high frequency of accidents in the area."), isDescendantOfA(withId(R.id.detailList)))).check(matches(isDisplayed()));

        onData(allOf(instanceOf(JSONObject.class), myCustomObjectShouldHaveString2("We've got some pineapple pizza.")))
                .inAdapterView(withId(R.id.detailList)).check(matches(isDisplayed()));
        onData(allOf(instanceOf(JSONObject.class), myCustomObjectShouldHaveString2("O+ is a rare blood type and we are lacking. Please come and donate.s")))
                .inAdapterView(withId(R.id.detailList)).check(matches(isDisplayed()));
        onData(allOf(instanceOf(JSONObject.class), myCustomObjectShouldHaveString2("We are here until 6PM today. Please come by and donate.")))
                .inAdapterView(withId(R.id.detailList)).check(matches(isDisplayed()));

        Espresso.unregisterIdlingResources(idlingResource);
    }

    public void testSelectNotifications3() {
        HomeActivity.ListFragment.my_city = "Atlanta";
        HomeActivity.ListFragment.my_state = "GA";

        onView(withId(R.id.loginTextEmail)).perform(typeText("cora337@fiu.edu"), closeSoftKeyboard());
        onView(withId(R.id.loginTextPassword)).perform(typeText("corPINT#671"), closeSoftKeyboard());
        onView(withId(R.id.loginButtonLogin)).perform(click());

        IdlingResource idlingResource = new ElapsedTimeIdlingResource(waitingTime);
        Espresso.registerIdlingResources(idlingResource);

        onView(withId(R.id.viewpager)).perform(swipeLeft());

        Espresso.unregisterIdlingResources(idlingResource);
        idlingResource = new ElapsedTimeIdlingResource(waitingTime);
        Espresso.registerIdlingResources(idlingResource);

        onView(allOf(withId(R.id.unTitle), isDescendantOfA(withId(R.id.homeListViewList2)))).check(doesNotExist());

        Espresso.unregisterIdlingResources(idlingResource);
    }

    public static Matcher<Object> myCustomObjectShouldHaveString( String expectedTest) {
        return myCustomObjectShouldHaveString(equalTo(expectedTest));
    }

    private static Matcher<Object> myCustomObjectShouldHaveString(final Matcher<String> expectedObject) {
        return new BoundedMatcher<Object, JSONObject>( JSONObject.class) {
            @Override
            public boolean matchesSafely(final JSONObject actualObject) {
                // next line is important ... requiring a String having an "equals" method
                try {
                    if( expectedObject.matches( actualObject.getString("title")) ) {
                        return true;
                    } else {
                        return false;
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                    return false;
                }
            }

            @Override
            public void describeTo(final Description description) {
                // could be improved, of course
                description.appendText("getnumber should return ");
            }
        };
    }

    public static Matcher<Object> myCustomObjectShouldHaveString2( String expectedTest) {
        return myCustomObjectShouldHaveString2(equalTo(expectedTest));
    }

    private static Matcher<Object> myCustomObjectShouldHaveString2(final Matcher<String> expectedObject) {
        return new BoundedMatcher<Object, JSONObject>( JSONObject.class) {
            @Override
            public boolean matchesSafely(final JSONObject actualObject) {
                // next line is important ... requiring a String having an "equals" method
                try {
                    if( expectedObject.matches( actualObject.getString("longDescription")) ) {
                        return true;
                    } else {
                        return false;
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                    return false;
                }
            }

            @Override
            public void describeTo(final Description description) {
                // could be improved, of course
                description.appendText("getnumber should return ");
            }
        };
    }

    public static Matcher<Object> myCustomObjectShouldHaveString3( String expectedTest) {
        return myCustomObjectShouldHaveString3(equalTo(expectedTest));
    }

    private static Matcher<Object> myCustomObjectShouldHaveString3(final Matcher<String> expectedObject) {
        return new BoundedMatcher<Object, JSONObject>( JSONObject.class) {
            @Override
            public boolean matchesSafely(final JSONObject actualObject) {
                // next line is important ... requiring a String having an "equals" method
                try {
                    if( expectedObject.matches( actualObject.getString("shortDescription")) ) {
                        return true;
                    } else {
                        return false;
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                    return false;
                }
            }

            @Override
            public void describeTo(final Description description) {
                // could be improved, of course
                description.appendText("getnumber should return ");
            }
        };
    }
}
