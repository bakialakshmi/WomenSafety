package com.jayasudha.safetygirl.womensafety;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;


public class MenuBar extends ActionBarActivity implements View.OnClickListener{
ImageView help,contact,follow;
     TextView h,c,f;
    MyStartReciever myReceiver;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_bar);


        IntentFilter filter= new IntentFilter(Intent.ACTION_SCREEN_ON);
        filter.addAction(Intent.ACTION_SCREEN_OFF);
        filter.addAction(Intent.ACTION_USER_PRESENT);
        myReceiver=new MyStartReciever();
        registerReceiver(myReceiver,filter);


        help=(ImageView)findViewById(R.id.help);
        contact=(ImageView)findViewById(R.id.contact);
        follow=(ImageView)findViewById(R.id.follow);
        h=(TextView)findViewById(R.id.helptext);
        f=(TextView)findViewById(R.id.followtext);
        c=(TextView)findViewById(R.id.contacttext);
        help.setOnClickListener(this);
        contact.setOnClickListener(this);
        follow.setOnClickListener(this);
        h.setOnClickListener(this);
        c.setOnClickListener(this);
        f.setOnClickListener(this);


    }


    public void onClick(View v) {
        // TODO Auto-generated method stub

        switch(v.getId())
        {
            case R.id.help:
            case R.id.helptext :
                Intent ii=new Intent("android.intent.action.Help");
                startActivity(ii);
                break;
            case R.id.contact:
            case R.id.contacttext:
                Intent i2=new Intent("android.intent.action.MContacts");
                startActivity(i2);



        }


    }


}
