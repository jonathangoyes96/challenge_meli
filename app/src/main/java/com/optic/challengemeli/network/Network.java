package com.optic.challengemeli.network;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;

import androidx.core.content.ContextCompat;

/*
 * VERIFICA LA CONEXION A INTERNET
 */
public class Network {

    public static boolean checkNetwork(Context context) {
        try {

            ConnectivityManager manager = ContextCompat.getSystemService(context, ConnectivityManager.class);
            NetworkInfo networkInfo = null;
            if (manager != null) {
                networkInfo = manager.getActiveNetworkInfo();
            }
            return networkInfo != null && networkInfo.isConnected();

        } catch (NullPointerException e) {
            Log.d("NETWORK", "Error: " + e.getMessage());
            return false;
        }
    }

}
