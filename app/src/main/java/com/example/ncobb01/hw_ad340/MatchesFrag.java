package com.example.ncobb01.hw_ad340;



import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Bundle;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.support.v4.app.Fragment;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.ncobb01.hw_ad340.ViewModel.MatchesViewModel;
import com.example.ncobb01.hw_ad340.Model.Matches;

import java.util.ArrayList;
import java.util.List;



public class MatchesFrag extends Fragment {



        // TODO: Customize parameter argument names
        public static final String ARG_COLUMN_COUNT = "column-count";
        public static final String ARG_DATA_SET = "data-set";
        // TODO: Customize parameters
        private int mColumnCount = 3;
        private List<Matches> mDataSet;
        private OnListFragmentInteractionListener mListener;
        private MatchesRecyclerAdapter adapter;

        /**
         * Mandatory empty constructor for the fragment manager to instantiate the
         * fragment (e.g. upon screen orientation changes).
         */
        public MatchesFrag() {
        }

        // TODO: Customize parameter initialization
        @SuppressWarnings("unused")
        public static MatchesFrag newInstance(int columnCount) {
            MatchesFrag fragment = new MatchesFrag();
            Bundle args = new Bundle();
            args.putInt(ARG_COLUMN_COUNT, columnCount);
            fragment.setArguments(args);
            return fragment;
        }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        RecyclerView recyclerView = (RecyclerView) inflater.inflate(R.layout.recycler_view, container, false);
        MatchesRecyclerAdapter adapter = new MatchesRecyclerAdapter();
        recyclerView.setAdapter(adapter);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        MatchesViewModel viewModel = new MatchesViewModel();
        viewModel.getMatches((ArrayList<Matches> matches) -> {
         //   adapter.update(matches);


            adapter.updateMatchListItems(matches);


        });

        return recyclerView;
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnListFragmentInteractionListener) {
            mListener = (OnListFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnListFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }


    public static class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView picture;
        public TextView name;

        public ImageButton likeButton;

        public ViewHolder(LayoutInflater inflater, ViewGroup parent) {
            super(inflater.inflate(R.layout.fragment_matches, parent, false));
            picture = itemView.findViewById(R.id.card_image);
            name = itemView.findViewById(R.id.card_title);

            likeButton = itemView.findViewById(R.id.like_button);

            likeButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Context context = v.getContext();
                    CharSequence text = "You liked " +
                            new StringBuilder().append(name.getText()).append(" :-)").toString();
                    int duration = Toast.LENGTH_SHORT;

                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();


                }

            });

        }
    }

    public static class ContentAdapter extends RecyclerView.Adapter<ViewHolder> {

        private static final int LENGTH = 3;
        private final String[] mMatches;

        private final Drawable[] mPlacePictures;

        public ContentAdapter(Context context) {
            Resources resources = context.getResources();
            mMatches = resources.getStringArray(R.array.match);

            TypedArray a = resources.obtainTypedArray(R.array.match_pic);
            mPlacePictures = new Drawable[a.length()];
            for (int i = 0; i < mPlacePictures.length; i++) {
                mPlacePictures[i] = a.getDrawable(i);
            }
            a.recycle();
        }

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            return new ViewHolder(LayoutInflater.from(parent.getContext()), parent);
        }

        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {
            holder.picture.setImageDrawable(mPlacePictures[position % mPlacePictures.length]);
            holder.name.setText(mMatches[position % mMatches.length]);

        }

        @Override
        public int getItemCount() {
            return LENGTH;
        }
    }


    public interface OnListFragmentInteractionListener {
        // TODO: Update argument type and name
        void onListFragmentInteraction(Matches item);
    }
}



