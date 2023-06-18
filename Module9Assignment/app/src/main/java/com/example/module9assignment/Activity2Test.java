package com.example.module9assignment;
import android.content.Intent;
import android.widget.ListView;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;
import org.robolectric.shadows.ShadowLooper;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(RobolectricTestRunner.class)
@Config(sdk = {Config.OLDEST_SDK})
public class Activity2Test {

    @Test
    public void listGeneration_shouldGenerateCorrectNumberOfItems() {
        Activity2 activity2 = Robolectric.setupActivity(Activity2.class);

        // Set the number of items
        int numberOfItems = 5;

        // Call the generateListAsync method with the number of items
        activity2.generateListAsync(numberOfItems);

        // Wait for the list generation to complete
        ShadowLooper.runUiThreadTasksIncludingDelayedTasks();

        // Verify that the ListView has the correct number of items
        ListView listView = activity2.findViewById(R.id.listView);
        assertNotNull(listView.getAdapter());
        assertEquals(numberOfItems, listView.getAdapter().getCount());
    }

    @Test
    public void clickingListItem_shouldLaunchActivity3WithCorrectValue() {
        Activity2 activity2 = Robolectric.setupActivity(Activity2.class);
        ListView listView = activity2.findViewById(R.id.listView);

        // Set the number of items and generate the list
        int numberOfItems = 5;
        activity2.generateListAsync(numberOfItems);
        ShadowLooper.runUiThreadTasksIncludingDelayedTasks();

        // Perform a click on the first list item
        listView.performItemClick(
                listView.getAdapter().getView(0, null, null),
                0,
                listView.getAdapter().getItemId(0)
        );

        // Verify that Activity3 is launched with the correct value
        Intent expectedIntent = new Intent(activity2, Activity3.class);
        expectedIntent.putExtra("selectedItem", "Item 0");
        ShadowActivity shadowActivity = Shadows.shadowOf(activity2);
        Intent actualIntent = shadowActivity.getNextStartedActivity();
        assertEquals(expectedIntent.getComponent(), actualIntent.getComponent());
        assertEquals(expectedIntent.getStringExtra("selectedItem"), actualIntent.getStringExtra("selectedItem"));
    }
}