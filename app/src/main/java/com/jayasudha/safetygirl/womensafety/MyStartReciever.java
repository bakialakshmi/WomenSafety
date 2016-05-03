package com.jayasudha.safetygirl.womensafety;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.KeyEvent;
import android.widget.Toast;


public class MyStartReciever extends BroadcastReceiver {
    private int count = 0;
    private long time[] = new long[5];

    @Override
    public void onReceive(Context context, Intent intent) {
        if (count==3) {
            Toast.makeText(context, "activity is called", Toast.LENGTH_LONG).show();
            count=0;
            //Intent i = new Intent(context, Try.class);
            //i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
            Intent i=new Intent();
            i.setClassName("com.jayasudha.safetygirl.womensafety","com.jayasudha.safetygirl.womensafety.SendMessage");
            i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(i);


            context.startActivity(i);

        }
        if (intent.getAction().equals(Intent.ACTION_SCREEN_OFF)) {

            count++;

            long dtMili = System.currentTimeMillis();
            long temp = 0;

            if(count == 1)
            {
                time[0] = dtMili;
            }

            else if(count == 2)
            {
                time[1] = dtMili;
                temp = time[1] - time[0];

                if(temp > 1000)
                {
                    count = 0;
                    time[1] = 0;
                    time[0] = 0;
                }
            }
            else if(count == 3)
            {
                time[2] = dtMili;
                temp = time[2] - time[1];

                if(temp > 1000)
                {
                    time[2] = 0;
                    count = 0;
                    time[2] = 0;
                    time[0] = 0;
                }
            }

















            Log.d("In On Receive","screenoff: "+count);
            // Toast.makeText(context, count, Toast.LENGTH_LONG).show();

        } else if (intent.getAction().equals(Intent.ACTION_SCREEN_ON)) {
            count++;



            long dtMili = System.currentTimeMillis();
            long temp = 0;

            if(count == 1)
            {
                time[0] = dtMili;
            }

            else if(count == 2)
            {
                time[1] = dtMili;
                temp = time[1] - time[0];

                if(temp > 1000)
                {
                    count = 0;
                    time[1] = 0;
                    time[0] = 0;
                }
            }
            else if(count == 3)
            {
                time[2] = dtMili;
                temp = time[2] - time[1];

                if(temp > 1000)
                {
                    time[2] = 0;
                    count = 0;
                    time[1] = 0;
                    time[0] = 0;
                }
            }



            //Toast.makeText(context, count, Toast.LENGTH_LONG).show();
            Log.d("In On Receive", "In screen on:"+count);
        } else if (intent.getAction().equals(Intent.ACTION_USER_PRESENT)) {
            Log.e("In On Receive", "In Method USER PRESENT");
        }

    }


}

