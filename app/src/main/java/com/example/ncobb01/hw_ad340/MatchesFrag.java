package com.example.ncobb01.hw_ad340;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.squareup.picasso.Picasso;
import java.util.ArrayList;
import android.location.LocationManager;
import android.location.LocationListener;
import android.location.Location;
import android.content.pm.PackageManager;


import com.example.ncobb01.hw_ad340.ViewModel.MatchesViewModel;
import com.example.ncobb01.hw_ad340.Model.Matches;

public class MatchesFrag extends Fragment {

    private static MatchesViewModel viewModel = new MatchesViewModel();
    LocationManager locationManager;



    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        RecyclerView recyclerView = (RecyclerView) inflater.inflate(R.layout.recycler_view, container, false);

        locationManager = (LocationManager) getActivity().getSystemService(Context.LOCATION_SERVICE);
       if(isLocationEnabled()) {

            if (ActivityCompat.checkSelfPermission(getContext(), android.Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED ||
                    ActivityCompat.checkSelfPermission(getContext(), android.Manifest.permission.ACCESS_COARSE_LOCATION) == PackageManager.PERMISSION_GRANTED) {

                Bundle bundle = new Bundle();
                viewModel.getMatches(
                        (ArrayList<Matches> matches) -> {
                            ArrayList<Matches> inMatches = new ArrayList<>();
                            for (int i = 0; i < matches.size(); ++i) {
//
                                    inMatches.add(matches.get(i));
//
                            }

                            bundle.putParcelableArrayList("matches", inMatches);
                            ContentAdapter adapter = new ContentAdapter(bundle);
                            recyclerView.setAdapter(adapter);

                        }

                );
            }
            recyclerView.setHasFixedSize(true);
            recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
            return recyclerView;

        } else {
            Bundle bundle = new Bundle();
            viewModel.getMatches(
                    (ArrayList<Matches> matches) -> {
                        bundle.putParcelableArrayList("matches", matches);
                        ContentAdapter adapter = new ContentAdapter(bundle);
                        recyclerView.setAdapter(adapter);
                    }
            );

            recyclerView.setHasFixedSize(true);
            recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
            return recyclerView;
        }
    }


    public static class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView picture;
        public TextView name;
        public TextView description;
        public ImageButton likeButton;
        public Matches match;

        public ViewHolder(LayoutInflater inflater, ViewGroup parent) {
            super(inflater.inflate(R.layout.item_card, parent, false));
            picture = itemView.findViewById(R.id.card_image);
            name = itemView.findViewById(R.id.card_title);
            description = itemView.findViewById(R.id.card_text);
            likeButton = itemView.findViewById(R.id.like_button);

            likeButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Context context = v.getContext();
                    CharSequence text = "You Liked " + new StringBuilder().append(name.getText()).append("!").toString();
                    int duration = Toast.LENGTH_SHORT;

                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();

                    likeButton.setColorFilter(ContextCompat.getColor(context, R.color.blue), android.graphics.PorterDuff.Mode.SRC_IN);
                    match.liked = true;
                    viewModel.updateMatch(match);
                }

            });

        }
    }

    public static class ContentAdapter extends RecyclerView.Adapter<ViewHolder> {

        private static int length;
        private ArrayList<Matches> myMatches;

        public ContentAdapter(Bundle matches) {

            myMatches = matches.getParcelableArrayList("matches");
            length = myMatches.size();

        }

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            return new ViewHolder(LayoutInflater.from(parent.getContext()), parent);
        }

        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {

            if(myMatches.size() != 0) {
                holder.match = myMatches.get(position);
                String url = holder.match.imageUrl;
                Picasso.get().load(url).into(holder.picture);
                holder.name.setText(holder.match.name);
                boolean liked = holder.match.liked;

            }
        }


        @Override
        public int getItemCount() {
            return length;
        }
    }

    private boolean isLocationEnabled() {
        return locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER);
    }


    };



