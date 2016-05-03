package com.jayasudha.safetygirl.womensafety;

import android.content.Context;
import android.content.SharedPreferences;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationManager;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.text.util.Linkify;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;


public class SendMessage extends ActionBarActivity {
    private static final String MYPREFERENCES = "UserDetails";
    SharedPreferences stor;
    LinearLayout ll;
    protected LocationManager locationManager;
    Location location;
    GPSTracker gps;
    String uri;
    public  static String result = "";


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_message);
        stor = getSharedPreferences(MYPREFERENCES, Context.MODE_PRIVATE);
        double latitude = 0, longitude = 0;
        gps = new GPSTracker(SendMessage.this);

        // check if GPS enabled
        if (gps.canGetLocation()) {

            latitude = gps.getLatitude();
            longitude = gps.getLongitude();
            getAddressFromLocation(latitude, longitude,
                    getApplicationContext(), new GeocoderHandler());

            // \n is for new line
            Toast.makeText(getApplicationContext(), "Your Location is - \nLat: " + latitude + "\nLong: " + longitude, Toast.LENGTH_LONG).show();
        } else {
            // can't get location
            // GPS or Network is not enabled
            // Ask user to enable GPS/network in settings
            gps.showSettingsAlert();
        }


        dynamic();

    }


    private void dynamic() {
        //  SendMessage sm=new SendMessage(this);


        /*List<HashMap<String,String>> aList = new ArrayList<HashMap<String,String>>();*/

        int siz = stor.getInt("Size", 0);
        String n = "", s = "";
        for (int i = 1; i <= siz; i++) {
            n = stor.getString("number_" + i, "");
            //  s=sm.getLocation();


            try {
                //  Toast.makeText("hii",Toast.LENGTH_LONG);
                String msg = "I am in danger.. Please help me soon" + result;
                SmsManager smsManager = SmsManager.getDefault();
                smsManager.sendTextMessage(n, null, msg, null, null);
                Toast.makeText(getApplicationContext(), "SMS sent.",
                        Toast.LENGTH_LONG).show();
            } catch (Exception e) {
                //  Toast.makeText(getApplicationContext(),
                //  "SMS failed, please try again.",
                //  Toast.LENGTH_LONG).show();
                e.printStackTrace();
            }


        }

    }

    public static void getAddressFromLocation(final double latitude, final double longitude,
                                              final Context context, final Handler handler) {
        Thread thread = new Thread() {
            @Override
            public void run() {
                Geocoder geocoder = new Geocoder(context, Locale.getDefault());
                try {
                    List<Address> addressList = geocoder.getFromLocation(
                            latitude, longitude, 1);
                    if (addressList != null && addressList.size() > 0) {
                        Address address = addressList.get(0);
                        StringBuilder sb = new StringBuilder();
                        for (int i = 0; i < address.getMaxAddressLineIndex(); i++) {
                            sb.append(address.getAddressLine(i)).append("\n");
                        }
                        sb.append(address.getLocality()).append("\n");
                        sb.append(address.getPostalCode()).append("\n");
                        sb.append(address.getCountryName());
                        result = sb.toString();
                    }
                } catch (IOException e) {
                    Log.e("", "Unable connect to Geocoder", e);
                }
            }
        };
        thread.start();
    }
}









