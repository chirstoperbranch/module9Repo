package com.example.module9assignment;

import android.widget.Button;
import android.widget.EditText;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import static org.junit.Assert.assertEquals;

@RunWith(RobolectricTestRunner.class)
@Config(sdk = {Config.OLDEST_SDK})
public class Activity1Test {

    @Test
    public void clickingButton_shouldLaunchActivity2WithCorrectValue() {
        Activity1 activity1 = Robolectric.setupActivity(Activity1.class);
        EditText numberEditText = activity1.findViewById(R.id.numberEditText);
        Button button = activity1.findViewById(R.id.button);

        // Set the value in the EditText
        numberEditText.setText("5");

        // Perform button click
        button.performClick();

        // Verify that Activity2 is launched with the correct value
        Intent expectedIntent = new Intent(activity1, Activity2.class);
        expectedIntent.putExtra("number", "5");
        ShadowActivity shadowActivity = Shadows.shadowOf(activity1);
        Intent actualIntent = shadowActivity.getNextStartedActivity();
        assertEquals(expectedIntent, actualIntent);
        assertEquals(expectedIntent.getStringExtra("number"), actualIntent.getStringExtra("number"));
    }
}