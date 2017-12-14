package group_project.csumb.com.autitrak;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.support.v4.app.FragmentTransaction;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import group_project.csumb.com.autitrak.simone.MainFragment;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

/**
 * Instrumentation test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {

    @Rule
    public ActivityTestRule<FragmentActivity> activityTestRule =
            new ActivityTestRule<>(FragmentActivity.class, true, true);


    @Test
    public void launchMainFragment()
    {
        activityTestRule.getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                MainFragment mf = initMainFragment();
            }
        });

        onView(withId(R.id.login_fragment_button)).check(matches(isDisplayed()));
        onView(withId(R.id.signup_fragment_button)).check(matches(isDisplayed()));
    }
    private MainFragment initMainFragment()
    {
        FragmentActivity activity = (FragmentActivity)activityTestRule.getActivity();
        FragmentTransaction transaction = activity.getSupportFragmentManager().beginTransaction();
        MainFragment mf = new MainFragment();
        transaction.add(mf,"menu_frag");
        transaction.commit();
        return mf;
    }


}
