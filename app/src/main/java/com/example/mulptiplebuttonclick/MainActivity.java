package com.example.mulptiplebuttonclick;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.Button;
import android.widget.Toast;

import java.util.List;


public class MainActivity extends AppCompatActivity implements FragmentOne.OnButtonClickFragmentOneListener, FragmentTwo.OnButtonClickFragmentTwoListener ,FragmentManager.OnBackStackChangedListener{

    Toolbar toolbar;
    Button b;
    Fragment f1,f2,f3;
    Fragment fragment1,fragment2,fragment3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar=findViewById(R.id.toolbar);

        toolbar.setTitle("Fragment1");
 setSupportActionBar(toolbar);
  //toolbar.setSubtitle("ToolBar subtitle");




        FragmentOne fragmentOne=new FragmentOne();

        FragmentManager manager=getSupportFragmentManager();


        FragmentTransaction  transaction=manager.beginTransaction();
        transaction.add(R.id.frag1,fragmentOne,"FragmentOneTag");
        manager.addOnBackStackChangedListener(this);
        transaction.commit();



    }





    @Override
    public void onButtonClickFragOne() {
        FragmentManager manager=getSupportFragmentManager();
        FragmentTransaction transaction=manager.beginTransaction();
        transaction.replace(R.id.frag1,new FragmentTwo(),"Fragment2");
        transaction.addToBackStack("FragmentOneTag");
        transaction.commit();
        toolbar.setTitle("Fragment2");

    }

    @Override
    public void onButtonClickFragTwo() {
        FragmentManager manager=getSupportFragmentManager();
        FragmentTransaction transaction=manager.beginTransaction();
        transaction.replace(R.id.frag1,new FragmentThree(),"Fragment3");
        transaction.addToBackStack("FragmentTwoTag");



        transaction.commit();
        toolbar.setTitle("Fragment3");

    }

    @Override
    public void onBackStackChanged() {
        Toast.makeText(this,"Hello",Toast.LENGTH_SHORT).show();
        FragmentManager manager=getSupportFragmentManager();
       Fragment currentFragment= manager.findFragmentById(R.id.frag1);
       if(currentFragment instanceof FragmentThree)
       {

           toolbar.setTitle("Fragment3");
       }

        if(currentFragment instanceof FragmentTwo)
        {
            toolbar.setTitle("Fragment2");
        }
        if(currentFragment instanceof FragmentOne)
        {
            toolbar.setTitle("Fragment1");
        }

    }
}
