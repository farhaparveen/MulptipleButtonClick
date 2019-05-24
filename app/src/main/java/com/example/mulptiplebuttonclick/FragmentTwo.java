package com.example.mulptiplebuttonclick;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


public class FragmentTwo extends Fragment {


    OnButtonClickFragmentTwoListener listener;
    Button  buttonfrag2;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

   View v= inflater.inflate(R.layout.fragment_fragment_two, container, false);
        buttonfrag2=v.findViewById(R.id.btnFrag2);

        buttonfrag2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onButtonClickFragTwo();
            }
        });
        return v;
    }



    interface OnButtonClickFragmentTwoListener
    {
        void onButtonClickFragTwo();
    }
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if(context instanceof FragmentOne.OnButtonClickFragmentOneListener)
            listener = (FragmentTwo.OnButtonClickFragmentTwoListener)context;
    }
}
