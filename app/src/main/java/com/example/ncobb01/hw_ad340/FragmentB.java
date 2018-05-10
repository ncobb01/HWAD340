package com.example.ncobb01.hw_ad340;



import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.util.Log;
import java.util.ArrayList;
import android.view.View.OnClickListener;

//public class FragmentB extends Fragment {

// this killing it
  public class FragmentB extends Fragment implements View.OnClickListener{
      // this killing it
    public Button button;

//    }
    private static final String TAG = "FragmentB";

    private ListView mListView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_b, container, false);
        mListView = (ListView) view.findViewById(R.id.listView);


//
//        Button btn1 = (Button) mListView.findViewById(R.id.action_button);
//        btn1.setOnClickListener(new OnClickListener() {
//            public void onClick(View v) {
//                Toast.makeText(getActivity(),"Text!",Toast.LENGTH_SHORT).show();

        ArrayList<Card> list = new ArrayList<>();

        list.add(new Card("drawable://" + R.drawable.tom, "Tom"));
        list.add(new Card("drawable://" + R.drawable.jodie, "Jodie"));
        list.add(new Card("drawable://" + R.drawable.shia, "Shia"));


        CustomListAdapter adapter = new CustomListAdapter(getActivity(), R.layout.card_layout_main, list);
        mListView.setAdapter(adapter);

//// this killing it
        button = (Button) view.findViewById(R.id.action_button);
        //button.setOnClickListener(this);
        button.setOnClickListener(this);



        return view;
    }

// this killing it
        @Override
        public void onClick(View v)
        {
           Toast.makeText(getActivity(), "You've liked frag b" , Toast.LENGTH_LONG ).show();


//
//            CharSequence text = "You Liked " +
//                    new StringBuilder().append(cardTitle.getText()).append("!").toString();
//            int duration = Toast.LENGTH_SHORT;
//
//            Toast toast = Toast.makeText(context, text, duration);
//            toast.show();
        }




    @Override
    public void onStart() {
        super.onStart();
        Log.i(TAG, "onStart()");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.i(TAG, "onResume()");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.i(TAG, "onPause()");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.i(TAG, "onStop()");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.i(TAG, "onDestroyView()");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "onDestroy()");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.i(TAG, "onDetach()");
    }




    }


//    @Override
//    public void onClick(View v) {
//
//
//
//                Toast.makeText(this.getActivity(), "Your answer is correct!", Toast.LENGTH_SHORT).show();
//            }




