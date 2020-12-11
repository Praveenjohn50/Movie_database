package com.example.praveen.movieupdates.model;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import com.example.praveen.movieupdates.utilities.NetworkUtil;

public class NetworkChangeReceiver extends BroadcastReceiver {

        @Override
        public void onReceive(final Context context, final Intent intent) {

            int status = NetworkUtil.getConnectivityStatusString(context);
            if ("android.net.conn.CONNECTIVITY_CHANGE".equals(intent.getAction())) {
                if (status == NetworkUtil.NETWORK_STATUS_NOT_CONNECTED) {
                    Toast.makeText(context, "Disconnected", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(context, "Connected", Toast.LENGTH_SHORT).show();
                }
            }
        }
    }