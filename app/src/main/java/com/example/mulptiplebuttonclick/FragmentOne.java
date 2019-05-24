package com.example.mulptiplebuttonclick;


import android.content.Context;
import android.os.Bundle;


import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


public class FragmentOne extends Fragment {


Button buttonfrag1;
    OnButtonClickFragmentOneListener listener;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

       View v=inflater.inflate(R.layout.fragment_fragment_one, container, false);
       buttonfrag1=v.findViewById(R.id.btnFrag1);
       buttonfrag1.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
listener.onButtonClickFragOne();
           }
       });
       return v;
    }

    interface OnButtonClickFragmentOneListener
    {
        void onButtonClickFragOne();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if(context instanceof OnButtonClickFragmentOneListener)
            listener = (OnButtonClickFragmentOneListener) context;
    }
}
