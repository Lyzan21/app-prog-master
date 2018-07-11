package hska.de.appprogramming;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.TextView;

import hska.de.appprogramming.model.Offer;

/**
 * Created by Alina on 06.05.2018.
 */

public class OfferDetailActivity extends AppCompatActivity {

    //this are the text view objects from the layout resource file
    TextView textviewCategory;
    TextView textviewCategoryContent;
    TextView textviewTeacher;
    TextView textviewTeacherContent;
    TextView textviewRoom;
    TextView textviewRoomContent;
    TextView textviewTime;
    TextView textviewTimeContent;

    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //here we bind the layout resource to the activity
        setContentView(R.layout.activity_offer_detail);

        Intent intent = getIntent();
        String category = intent.getStringExtra("category");
        String teacher = intent.getStringExtra("teacher");
        String time = intent.getStringExtra("time");
        String room = intent.getStringExtra("room");
        String title = intent.getStringExtra("title");

        int resource = intent.getIntExtra("imageResource", 1);

        //set a toolbar
        Toolbar toolbar = (Toolbar) findViewById(R.id.my_toolbar);
        toolbar.setTitle(title);
        setSupportActionBar(toolbar);

        //set the back button (currently the button has no action)
        if (getSupportActionBar() != null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(false);
        }

        //initializing the text view objects works a little bit like in JavaScript ;)
        textviewCategory = findViewById(R.id.textview_category);
        textviewCategoryContent = findViewById(R.id.textview_category_content);
        textviewTeacher = findViewById(R.id.textview_teacher);
        textviewTeacherContent = findViewById(R.id.textview_teacher_content);
        textviewRoom = findViewById(R.id.textview_room);
        textviewRoomContent = findViewById(R.id.textview_room_content);
        textviewTime = findViewById(R.id.textview_time);
        textviewTimeContent = findViewById(R.id.textview_time_content);

        imageView = findViewById(R.id.imageView);

        //It was  requirement in the task to set the texts programmatically. Thats whats done here:
        textviewCategory.setText("Kategorie:");
        textviewCategoryContent.setText(category);
        textviewTeacher.setText("Lehrer:");
        textviewTeacherContent.setText(teacher);
        textviewRoom.setText("Raum:");
        textviewRoomContent.setText(room);
        textviewTime.setText("Uhrzeit:");
        textviewTimeContent.setText(time);

        imageView.setImageResource(resource);
    }
}
