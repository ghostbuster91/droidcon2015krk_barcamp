package pl.ghostbuster.droidconbarcamp.utlis;

import android.support.test.espresso.matcher.BoundedMatcher;
import android.support.v7.widget.AppCompatTextView;
import android.view.View;

import org.hamcrest.Description;
import org.hamcrest.Matcher;

public class TextViewMatchers {

    public static Matcher<View> hasText(final String text) {
        return new BoundedMatcher<View, AppCompatTextView>(AppCompatTextView.class) {

            @Override
            protected boolean matchesSafely(AppCompatTextView textView) {
                return textView.getText().toString().equals(text);
            }

            @Override
            public void describeTo(Description description) {
            }
        };
    }
}
