package hska.de.appprogramming.adapter;

import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import hska.de.appprogramming.R;
import hska.de.appprogramming.listeners.MyItemClickListener;
import hska.de.appprogramming.model.Offer;

/**
 * This adapter sets List of offer titles and Images to the RecyclerView
 * Created by Alina on 06.05.2018.
 */

public class OfferAdapter extends RecyclerView.Adapter<OfferAdapter.ViewHolder> {


    private List<Offer> mContent = Collections.emptyList();
    private List<Integer> mColors;
    private MyItemClickListener mListener;

    //The viewholder holds each changeable view object. The objects are only initialized once
    //in the constructor.
    public static class ViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public TextView mTextView;
        public ImageView mImageView;
        public View v;

        public ViewHolder(View v) {
            super(v);
            this.v = v;
            mTextView = v.findViewById(R.id.simple_text);
            mImageView = v.findViewById(R.id.image_view);
        }

        //this method is called in onBindViewHolder.
        //it sets the listener to an item
        //and yes it is not very intuitive to have a listener which calls a listener...
        public void bindListener(final Offer offer, final MyItemClickListener mListener) {
            v.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mListener.onItemClick(offer);
                }
            });
        }
    }

    //The actual data is the example list and its handed over in the Adapter constructor
    public OfferAdapter(List<Offer> exampleList, MyItemClickListener listener) {
        mContent = exampleList;

        //the listener waits for user interactions and reacts on every item click
        mListener = listener;

        //this is the background color for the items in the list
        mColors = new ArrayList<>(Arrays.asList(
                R.color.thinking, R.color.artsAndCraft, R.color.music, R.color.socialScience,
                R.color.sports, R.color.languages, R.color.science, R.color.others));
    }


    // Here we set the layout resource of one single list item
    @Override
    public OfferAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v =  LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item_single_offer, parent, false);

        ViewHolder vh = new ViewHolder(v);
        return vh;

    }

    //Here we declare what is shown every time a user scrolls through the list
    @Override
    public void onBindViewHolder(OfferAdapter.ViewHolder holder, int position) {
        Offer offer = mContent.get(position);
        holder.bindListener(offer, mListener);
        holder.mTextView.setText(offer.title);
        //TODO Setting the image programmatically crashes
        //Drawable resource = holder.v.getResources().getDrawable(R.drawable.ic_launcher_foreground);
        //holder.mImageView.setImageDrawable(resource);
        int color = holder.v.getResources().getColor(mColors.get(offer.category.ordinal()));
        holder.v.setBackgroundColor(color);
        holder.mImageView.setImageResource(offer.imageResource);

    }

    @Override
    public int getItemCount() {
        return mContent.size();
    }
}
