package com.begentgroup.sampletab;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class ThreeFragment extends Fragment {


    public ThreeFragment() {
        // Required empty public constructor
    }

    TextView messageView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_three, container, false);
        messageView = (TextView)view.findViewById(R.id.text_message);
        return view;
    }

    public void setMessage(String text) {
        if (messageView != null) {
            messageView.setText(text);
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        String message = ((FragmentTabActivity)getActivity()).getSavedMessage();
        if (message != null) {
            messageView.setText(message);
        }
    }
}
