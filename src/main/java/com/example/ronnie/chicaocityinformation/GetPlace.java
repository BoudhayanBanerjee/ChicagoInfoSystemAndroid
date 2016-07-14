package com.example.ronnie.chicaocityinformation;

import android.os.AsyncTask;
import android.util.Log;

import com.google.android.gms.maps.GoogleMap;

/**
 * Created by Ronnie on 6/29/2016.
 */
public class GetPlace extends AsyncTask<Object, Integer, String> {

    GoogleMap googleMap;
    String type;
    String placeData = null;

    @Override
    protected String doInBackground(Object... inputObj) {
        try {
            googleMap = (GoogleMap) inputObj[0];
            String PlacesUrl = (String) inputObj[1];
            type = (String) inputObj[2];
            Http http = new Http();
            placeData = http.read(PlacesUrl);
        } catch (Exception e) {
            Log.d("Place Read", e.toString());
        }
        return placeData;
    }

    @Override
    protected void onPostExecute(String result) {
        PlacesDisplayTask placesDisplayTask = new PlacesDisplayTask();
        Object[] toPass = new Object[3];
        toPass[0] = googleMap;
        toPass[1] = result;
        toPass[2] = type;

        Log.d("Result",result.toString());
        placesDisplayTask.execute(toPass);
    }
}
