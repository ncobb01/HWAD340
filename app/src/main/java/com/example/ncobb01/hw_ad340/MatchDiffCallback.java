package com.example.ncobb01.hw_ad340;

import android.support.annotation.Nullable;
import android.support.v7.util.DiffUtil;

import com.example.ncobb01.hw_ad340.Model.Matches;

import java.util.List;




public class MatchDiffCallback extends DiffUtil.Callback {



    private final List<Matches> mOldMatchList;

    private final List<Matches> mNewMatchList;



    public MatchDiffCallback(List<Matches> mOldMatchList, List<Matches> mNewMatchList) {

        this.mOldMatchList = mOldMatchList;

        this.mNewMatchList = mNewMatchList;

    }



    @Override

    public int getOldListSize() {

        return mOldMatchList.size();

    }



    @Override

    public int getNewListSize() {

        return mNewMatchList.size();

    }



    @Override

    public boolean areItemsTheSame(int oldItemPosition, int newItemPosition) {

        return mOldMatchList.get(oldItemPosition).matchId == mNewMatchList.get(

                newItemPosition).matchId;

//          return mOldMatchList.get(oldItemPosition).getId() == mNewMatchList.get(
//
//                newItemPosition).getId();

    }



    @Override

    public boolean areContentsTheSame(int oldItemPosition, int newItemPosition) {

        final Matches oldMatch = mOldMatchList.get(oldItemPosition);

        final Matches newMatch = mNewMatchList.get(newItemPosition);

        return oldMatch.named.equals(newMatch.named);


//        return oldMatch.getName().equals(newMatch.getName());

    }



    @Nullable

    @Override

    public Object getChangePayload(int oldItemPosition, int newItemPosition) {

        // Implement method if you're going to use ItemAnimator

        return super.getChangePayload(oldItemPosition, newItemPosition);

    }

}