package hska.de.appprogramming;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

/**
 * This class is currently the main entry point for out application (set in the AndroidManifest)
 * It provides no functionality and just calls another activity.
 * We should set another activity to the main entry point and delete this class when we finished the app.
 *
 * Here are some open tasks for the project:
 * 1. Create a document and explain why we used the mockups provided in the Mockups folder
 * 2. Create a layout for tablet and landscape and save is in the res/layout folder
 * 3. There is a bug in the OfferActivity (see todo)
 * 4. Connect the OverviewActivity to the OfferDetailActivity on item click
 */
public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Change OverviewActivity.class to OfferDetailActivity.class if you want
        //to display the Detail page on start
        Intent intent = new Intent(this, OverviewActivity.class);
        startActivity(intent);
        finish();

    }
}
