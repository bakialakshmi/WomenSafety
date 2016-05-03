package com.jayasudha.safetygirl.womensafety;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;


public class Help extends ActionBarActivity implements View.OnClickListener{
    ImageView message,call;
    TextView m,c;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help);
        message=(ImageView)findViewById(R.id.message);
        call=(ImageView)findViewById(R.id.call);
        m=(TextView)findViewById(R.id.messagetext);
        c=(TextView)findViewById(R.id.calltext);
        message.setOnClickListener(this);
        call.setOnClickListener(this);
        m.setOnClickListener(this);
        c.setOnClickListener(this);

    }
    public void onClick(View v)
    {
        switch(v.getId())
        {
            case R.id.messagetext:
            case R.id.message :
                Intent i1=new Intent("android.intent.action.SendMessage");
                startActivity(i1);
                break;

            case R.id.calltext:
            case R.id.call :
                Intent i2=new Intent("android.intent.action.Help");
                startActivity(i2);
                break;




        }

    }



}
