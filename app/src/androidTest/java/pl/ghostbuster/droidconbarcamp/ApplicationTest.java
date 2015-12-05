package pl.ghostbuster.droidconbarcamp;

import android.test.ActivityInstrumentationTestCase2;

public class ApplicationTest extends ActivityInstrumentationTestCase2<MainActivity> {

    public ApplicationTest() {
        super(MainActivity.class);
    }

    public void testShouldShowErrorMessageWhenLoggingByFacebookFail() {
        getActivity();
    }

    public void testShouldShowMessageCanceledWhenLoggingByFacebookCanceled() {
        getActivity();
    }

    public void testShouldShowSuccessMessageWhenLoggingByFacebookSucceed() {
        getActivity();
    }
}