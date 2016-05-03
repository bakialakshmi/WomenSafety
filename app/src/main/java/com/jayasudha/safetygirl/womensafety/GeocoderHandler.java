package com.jayasudha.safetygirl.womensafety;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;

/**
 * Created by Home on 2/18/2015.
 */
class GeocoderHandler extends Handler {
    @Override
    public void handleMessage(Message message) {
        String locationAddress;
        switch (message.what) {
            case 1:
                Bundle bundle = message.getData();
                locationAddress = bundle.getString("address");
                break;
            default:
                locationAddress = null;
        }
        //  tvAddress.setText(locationAddress);
    }
}
