package pl.ghostbuster.droidconbarcamp;

import android.app.Application;
import android.test.ApplicationTestCase;

public class ApplicationTest extends ApplicationTestCase<Application> {
    public ApplicationTest() {
        super(Application.class);
    }


    public void testShouldFail() {
        assertEquals(1, 2);
    }
}