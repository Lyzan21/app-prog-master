package hska.de.appprogramming;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import hska.de.appprogramming.adapter.OfferAdapter;
import hska.de.appprogramming.listeners.MyItemClickListener;
import hska.de.appprogramming.model.Category;
import hska.de.appprogramming.model.Offer;

/**
 * This class shows all offers in a vertical scrollable list. Each item can be scrolled in a
 * horizontal list
 * Created by Alina on 06.05.2018.
 */

public class OverviewActivity extends Activity {

    private RecyclerView timeslot830;
    private RecyclerView timeslot9;
    private RecyclerView timeslot10;
    private RecyclerView timeslot11;
    private RecyclerView timeslot13;
    private RecyclerView timeslot14;
    private RecyclerView timeslot15;
    private RecyclerView timeslot16;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_offer_overview);

        //initialize horizontal scrollable list for each timeslot
        timeslot830 = initializeRecyclerView(R.id.recycler_view_8_30, createSampleData1());
        timeslot9 = initializeRecyclerView(R.id.recycler_view_9, createSampleData2());
        timeslot10 = initializeRecyclerView(R.id.recycler_view_10, createSampleData3());
        timeslot11 = initializeRecyclerView(R.id.recycler_view_11, createSampleData1());
        timeslot13 = initializeRecyclerView(R.id.recycler_view_13, createSampleData2());
        timeslot14 = initializeRecyclerView(R.id.recycler_view_14, createSampleData3());
        timeslot15 = initializeRecyclerView(R.id.recycler_view_15, createSampleData1());
        timeslot16 = initializeRecyclerView(R.id.recycler_view_16, createSampleData2());

        //We want to set the timeslot names programmatically
        setTimeTexts();
    }

    private RecyclerView initializeRecyclerView(final int resource, List<Offer> dataList) {
        RecyclerView rView = findViewById(resource);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this,
                LinearLayoutManager.HORIZONTAL, false);
        rView.setLayoutManager(layoutManager);

        //we pass the click listener to the offer. We must implement the onclick callback here, because
        //this class is an Activity class. Only here we can start and finish activities
        RecyclerView.Adapter adapter = new OfferAdapter(dataList, new MyItemClickListener() {
            //This is an anonymus class. There is no class MyItemClickListener, only an interface.
            //to create an object from this interface we must implement the required methods on
            //initialization

            //every time a user clicks on an item this method is called by the recycler view adapter
            @Override
            public void onItemClick(Offer offer) {
                Intent intent = new Intent(OverviewActivity.this, OfferDetailActivity.class);
                intent = intent.putExtra("room", offer.room.toString());
                intent = intent.putExtra("teacher", offer.teacher.toString());
                intent = intent.putExtra("category", offer.category.toString());
                intent = intent.putExtra("title", offer.title.toString());
                intent = intent.putExtra("imageResource", ((int) offer.imageResource));

                String time;
                switch (resource)
                {
                    case R.id.recycler_view_8_30:
                        time = "8:30";
                        break;
                    case R.id.recycler_view_9:
                        time = "9:00";
                        break;
                    case R.id.recycler_view_10:
                        time = "10:00";
                        break;
                    case R.id.recycler_view_11:
                        time = "11:00";
                        break;
                    case R.id.recycler_view_13:
                        time = "13:00";
                        break;
                    case R.id.recycler_view_14:
                        time = "14:00";
                        break;
                    case R.id.recycler_view_15:
                        time = "15:00";
                        break;
                    case R.id.recycler_view_16:
                        time = "16:00";
                        break;
                    default:
                        time = "no time set";
                }
                intent = intent.putExtra("time", time );

                startActivity(intent);

            }
        });
        rView.setAdapter(adapter);
        return rView;
    }

    private void setTimeTexts() {
        TextView text1 =  findViewById(R.id.timeslot_8_30);
        text1.setText("8:30");

        TextView text2 =  findViewById(R.id.timeslot_9);
        text2.setText("9:00");

        TextView text3 =  findViewById(R.id.timeslot_10);
        text3.setText("10:00");

        TextView text4 =  findViewById(R.id.timeslot_11);
        text4.setText("11:00");

        TextView text5 =  findViewById(R.id.timeslot_12);
        text5.setText("12:00");

        TextView text6 =  findViewById(R.id.timeslot_13);
        text6.setText("13:00");

        TextView text7 =  findViewById(R.id.timeslot_14);
        text7.setText("14:00");

        TextView text8 =  findViewById(R.id.timeslot_15);
        text8.setText("15:00");

        TextView text9 =  findViewById(R.id.timeslot_16);
        text9.setText("16:00");

        //Set the lunch break text
        TextView text10 = findViewById(R.id.lunch_break);
        text10.setText("Mittagspause");
    }


    //This methods create sample Offer objects in a List. The list is handed over to the adapter
    private List<Offer> createSampleData1() {

        Offer offer1 = new Offer("Mathe", R.drawable.maths_transparent, Category.THINKING, "203", "Frau Müller");
        Offer offer2 = new Offer("Deutsch", R.drawable.deutsch_transparent, Category.LANGUAGE, "302", "Herr Schmidt");
        Offer offer3 = new Offer("Werken", R.drawable.werkzeug_transparent, Category.ARTS_AND_CRAFT, "115", "Frau Merkel");

        return new ArrayList<>(Arrays.asList(offer1, offer2, offer3));
    }

    private List<Offer> createSampleData2() {

        Offer offer1 = new Offer("Mathe", R.drawable.maths_transparent, Category.THINKING, "203", "Frau Müller");
        Offer offer2 = new Offer("Englisch", R.drawable.english_transparent, Category.LANGUAGE, "302", "Herr Schmidt");
        Offer offer3 = new Offer("Werken", R.drawable.werkzeug_transparent, Category.ARTS_AND_CRAFT, "115", "Frau Merkel");
        Offer offer4 = new Offer("Musik", R.drawable.music_transparent, Category.MUSIC, "204", "Herr Brinkner");
        Offer offer5 = new Offer("Sport", R.drawable.sport_transparent, Category.SPORTS,"306", "Frau Steinle");

        return new ArrayList<>(Arrays.asList(offer4, offer5, offer1, offer2, offer3));
    }

    private List<Offer> createSampleData3() {
        return new ArrayList<>();
    }
}
