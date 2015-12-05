package pl.ghostbuster.droidconbarcamp;

import android.test.ActivityInstrumentationTestCase2;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static pl.ghostbuster.droidconbarcamp.TextViewMatchers.hasText;

public class ApplicationTest extends ActivityInstrumentationTestCase2<MainActivity> {

    public ApplicationTest() {
        super(MainActivity.class);
    }

    public void testShouldShowErrorMessageWhenLoggingByFacebookFail() {
        MainActivity.provider = new FailingFacebookLoginButtonProvider();
        getActivity();

        onView(withId(R.id.login_button)).perform(click());

        onView(withId(R.id.login_result_descritpion)).check(matches(hasText("Error :(")));
    }

    public void testShouldShowSuccessMessageWhenLoggingByFacebookSucceed() {
        MainActivity.provider = new SuccessFacebookLoginButtonProvider();
        getActivity();

        onView(withId(R.id.login_button)).perform(click());

        onView(withId(R.id.login_result_descritpion)).check(matches(hasText("Success :)")));
    }
}