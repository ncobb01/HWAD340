package com.example.ncobb01.hw_ad340.ViewModel;

import com.example.ncobb01.hw_ad340.Model.Matches;
import com.example.ncobb01.hw_ad340.DataModel.FirebaseMatchesModel;

import com.google.firebase.database.DataSnapshot;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class MatchesViewModel {

    private FirebaseMatchesModel matchModel;

    public MatchesViewModel() {
        matchModel = new FirebaseMatchesModel();
    }

    public void addMatch(Matches match){
        matchModel.addMatch(match);
    }

    public void getMatches(Consumer<ArrayList<Matches>> responseCallback) {
        matchModel.getMatches(
                (DataSnapshot dataSnapshot) -> {
                    ArrayList<Matches> matches = new ArrayList<>();
                    for(DataSnapshot matchSnapshot : dataSnapshot.getChildren()) {
                        Matches match = matchSnapshot.getValue(Matches.class);
                        assert match != null;
                        match.matchId = matchSnapshot.getKey();
                        matches.add(match);
                    }
                    responseCallback.accept(matches);
                },
                (databaseError -> System.out.println("Error reading matches: " + databaseError))
        );
    }

    public void updateMatch(Matches match) {
        matchModel.updateMatchById(match);
    }

    public void clear() {
        matchModel.clear();
    }
}