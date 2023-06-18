package com.example.module9assignment;
import android.content.Intent;
import android.widget.TextView;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import static org.junit.Assert.assertEquals;

@RunWith(RobolectricTestRunner.class)
@Config(sdk = {Config.OLDEST_SDK})
public class Activity3Test {

    @Test
    public void displayedText_shouldContainCorrectValue() {
        Activity3 activity3 = Robolectric.setupActivity(Activity3.class);

        // Set the expected text value
        String expectedText = "You clicked Item 1";

        // Create an intent with the expected text
        Intent intent = new Intent();
        intent.putExtra("selectedItem", "Item 1");
        activity3.setIntent(intent);

        // Retrieve the displayed text
        TextView textView = activity3.findViewById(R.id.textView);
        String displayedText = textView.getText().toString();

        // Verify that the displayed text contains the correct value
        assertEquals(expectedText, displayedText);
    }
}
