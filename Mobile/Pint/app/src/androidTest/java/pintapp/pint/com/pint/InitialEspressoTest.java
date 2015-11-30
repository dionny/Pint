package pintapp.pint.com.pint;

import android.support.test.InstrumentationRegistry;
import android.support.test.espresso.Espresso;
import android.support.test.espresso.IdlingPolicies;
import android.support.test.espresso.IdlingResource;
import android.test.ActivityInstrumentationTestCase2;

import org.junit.Before;

import java.util.concurrent.TimeUnit;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.doesNotExist;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

/**
 * Created by gregoryjean-baptiste on 11/29/15.
 */
public class InitialEspressoTest extends ActivityInstrumentationTestCase2 {

    private LoginActivity loginActivity;
    private long waitingTime = 3000;

    public InitialEspressoTest() {
        super(LoginActivity.class);
        IdlingPolicies.setMasterPolicyTimeout(waitingTime * 2, TimeUnit.MILLISECONDS);
        IdlingPolicies.setIdlingResourceTimeout(waitingTime * 2, TimeUnit.MILLISECONDS);
    }

    @Before
    public void setUp() throws Exception {
        super.setUp();
        HomeActivity.ListFragment.my_city = "Miami";
        HomeActivity.ListFragment.my_state = "FL";
        injectInstrumentation(InstrumentationRegistry.getInstrumentation());
        loginActivity = (LoginActivity) getActivity();
    }

    public void testWrongUsernameWrongPassword() {
        onView(withId(R.id.loginTextEmail)).perform(typeText("donor"), closeSoftKeyboard());
        onView(withId(R.id.loginTextPassword)).perform(typeText("donor"), closeSoftKeyboard());
        onView(withId(R.id.loginButtonLogin)).perform(click());

        IdlingResource idlingResource = new ElapsedTimeIdlingResource(waitingTime);
        Espresso.registerIdlingResources(idlingResource);

        onView(withId(R.id.loginButtonLogin)).check(matches(isDisplayed()));

        Espresso.unregisterIdlingResources(idlingResource);

    }

    public void testRightUsernameWrongPassword() {
        onView(withId(R.id.loginTextEmail)).perform(typeText("jlui005@fiu.edu"), closeSoftKeyboard());
        onView(withId(R.id.loginTextPassword)).perform(typeText("donor"), closeSoftKeyboard());
        onView(withId(R.id.loginButtonLogin)).perform(click());

        IdlingResource idlingResource = new ElapsedTimeIdlingResource(waitingTime);
        Espresso.registerIdlingResources(idlingResource);

        onView(withId(R.id.loginButtonLogin)).check(matches(isDisplayed()));

        Espresso.unregisterIdlingResources(idlingResource);

    }

    public void testWrongUsernameRightPassword() {
        onView(withId(R.id.loginTextEmail)).perform(typeText("donor"), closeSoftKeyboard());
        onView(withId(R.id.loginTextPassword)).perform(typeText("pineapple"), closeSoftKeyboard());
        onView(withId(R.id.loginButtonLogin)).perform(click());

        IdlingResource idlingResource = new ElapsedTimeIdlingResource(waitingTime);
        Espresso.registerIdlingResources(idlingResource);

        onView(withId(R.id.loginButtonLogin)).check(matches(isDisplayed()));

        Espresso.unregisterIdlingResources(idlingResource);

    }

    public void testRightUsernameRightPassword() {
        onView(withId(R.id.loginTextEmail)).perform(typeText("bpate005@fiu.edu"), closeSoftKeyboard());
        onView(withId(R.id.loginTextPassword)).perform(typeText("bruPINT#111"), closeSoftKeyboard());
        onView(withId(R.id.loginButtonLogin)).perform(click());

        IdlingResource idlingResource = new ElapsedTimeIdlingResource(waitingTime);
        Espresso.registerIdlingResources(idlingResource);

        onView(withId(R.id.loginButtonLogin)).check(doesNotExist());

        Espresso.unregisterIdlingResources(idlingResource);

    }
}
