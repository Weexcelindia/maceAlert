package com.mace.maceAlert.test;

import android.app.Activity;
import android.content.Intent;
import android.test.ActivityInstrumentationTestCase2;
import android.test.ActivityUnitTestCase;
import android.test.suitebuilder.annotation.MediumTest;
import android.widget.Button;

import com.mace.maceAlert.Loginactivity;
import com.mace.maceAlert.R;

public class LoginactivityUnitTest extends ActivityUnitTestCase<Loginactivity> {


    // Testing with Android api is difficult ,will try to configure Plugins like roboelectric..

    Loginactivity activity;
    Intent mLaunchIntent;

    public LoginactivityUnitTest() {
        super(Loginactivity.class);
    }

    public void setUp() throws Exception {
        super.setUp();
        mLaunchIntent = new Intent(getInstrumentation().getTargetContext(), Loginactivity.class);
        startActivity(mLaunchIntent, null, null);
        activity=getActivity();

    }

    public void testLayout() {
        assertNotNull(activity.findViewById(R.id.email_sign_in_button));
        Button view = (Button) activity.findViewById(R.id.email_sign_in_button);
        assertEquals("Incorrect label of the button", "Log in", view.getText());
    }


    @MediumTest
    public void testNextActivityWasLaunchedWithIntent() {
        startActivity(mLaunchIntent, null, null);
        final Button launchNextButton =
                (Button) getActivity()
                        .findViewById(R.id.email_sign_in_button);
        launchNextButton.performClick();

        final Intent launchIntent = getStartedActivityIntent();
        assertNotNull("Intent was null", launchIntent);
        assertTrue(isFinishCalled());

    }

    public void tearDown() throws Exception {

    }

}