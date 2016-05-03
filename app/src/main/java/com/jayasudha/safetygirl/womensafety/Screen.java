package com.jayasudha.safetygirl.womensafety;

import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;

import com.jayasudha.safetygirl.womensafety.MyStartReciever;
import com.jayasudha.safetygirl.womensafety.R;


public class Screen extends ActionBarActivity {
    MyStartReciever myReceiver;
    private int count=0;
    private boolean bool;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen);
        IntentFilter filter= new IntentFilter(Intent.ACTION_SCREEN_ON);
        filter.addAction(Intent.ACTION_SCREEN_OFF);
        filter.addAction(Intent.ACTION_USER_PRESENT);
        myReceiver=new MyStartReciever();
        registerReceiver(myReceiver,filter);


    }



    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_VOLUME_DOWN || keyCode == KeyEvent.KEYCODE_VOLUME_UP) {
            count++;
            if (count == 4) {
                //Toast.makeText(, "activity is called", Toast.LENGTH_LONG).show();
                Log.e("In on key down ", "volume press check ");
                bool=true;
            }
            else
                bool=false;
        }
        return bool;
    }
    protected void onDestroy()
    {
        if(myReceiver!=null)
        {
            unregisterReceiver(myReceiver);
            myReceiver=null;

        }
        super.onDestroy();
    }
/*

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }*/
}
