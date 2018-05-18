package com.example.ncobb01.hw_ad340;


import android.media.Image;
import android.support.annotation.NonNull;
import android.support.v7.util.DiffUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.graphics.Color;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ncobb01.hw_ad340.Model.Matches;
import com.squareup.picasso.Picasso;
import com.example.ncobb01.hw_ad340.MatchesFrag.OnListFragmentInteractionListener;
import java.util.List;



public class MatchesRecyclerAdapter extends RecyclerView.Adapter<MatchesRecyclerAdapter.ViewHolder> {
    private List<Matches> mValues;
    private MatchesFrag.OnListFragmentInteractionListener mListener;





    public void updateMatchListItems(List<Matches> matches) {

        final MatchDiffCallback diffCallback = new MatchDiffCallback(this.mValues, matches);

        final DiffUtil.DiffResult diffResult = DiffUtil.calculateDiff(diffCallback);



        this.mValues.clear();

        this.mValues.addAll(matches);

        diffResult.dispatchUpdatesTo(this);

    }




    public MatchesRecyclerAdapter() {}

    public MatchesRecyclerAdapter(List<Matches> items, MatchesFrag.OnListFragmentInteractionListener listener) {
        mValues = items;
        mListener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_matches, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, final int position) {
        if(mValues == null || mListener == null) {
            return;
        }
        holder.mItem = mValues.get(position);
        holder.mName.setText(mValues.get(position).matchId);
        holder.mImgUrl = mValues.get(position).matchImageURL;
        Picasso.get().load(holder.mImgUrl).into(holder.mImage);
        holder.liked = mValues.get(position).liked;


        holder.likeBtn.setOnClickListener(v -> {
            if (null != mListener) {

        if (!holder.liked) {
            holder.likeBtn.setColorFilter(Color.WHITE);
        } else {
            holder.likeBtn.setColorFilter(Color.GREEN);
        }

            }
        });
    }

    @Override
    public int getItemCount() {
        if(mValues != null) {
            return mValues.size();
        } else {
            return 0;
        }
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        View mView;
        public final TextView mName;
        public final ImageView mImage;
        public final ImageButton likeBtn;
        public String mImgUrl;
        public Matches mItem;
        public Boolean liked;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            mName = view.findViewById(R.id.card_title);
            mImage = view.findViewById(R.id.card_image);
            likeBtn = view.findViewById(R.id.like_button);
        }
    }
}