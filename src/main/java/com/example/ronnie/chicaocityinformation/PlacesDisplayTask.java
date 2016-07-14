package com.example.ronnie.chicaocityinformation;

import android.graphics.Color;
import android.os.AsyncTask;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import org.json.JSONArray;
import org.json.JSONException;
import java.util.HashMap;
import java.util.List;

public class PlacesDisplayTask  extends AsyncTask<Object, Integer, List<HashMap<String, String>>>
         {
    JSONArray PlacesJson;
    GoogleMap googleMap;
    String type;

    @Override
    protected List<HashMap<String, String>> doInBackground(Object... inputObj) {

        List<HashMap<String, String>> PlacesList = null;
        Places placeJsonParser = new Places();

        try {
            googleMap = (GoogleMap) inputObj[0];
            PlacesJson = new JSONArray((String) inputObj[1]);
            type = (String ) inputObj[2];
            PlacesList = placeJsonParser.getPlaces(PlacesJson,type);

        } catch (JSONException e) {
            Log.d("Exception", e.toString());

        }
        return PlacesList;
    }


    @Override
    protected void onPostExecute(List<HashMap<String, String>> list) {
        googleMap.clear();
        googleMap.setMapType(1);


        CameraPosition cameraPosition = new CameraPosition.Builder()
                .target(new LatLng(41.8781,-87.6298))      // Sets the center of the map to Mountain View
                .zoom(12)
                .tilt(45)                   // Sets the tilt of the camera to 30 degrees
                .build();
        googleMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));

        for (int i = 0; i < list.size(); i++) {
            MarkerOptions markerOptions = new MarkerOptions();
            HashMap<String, String> place = list.get(i);
            double lat = Double.parseDouble(place.get("lat"));
            double lng = Double.parseDouble(place.get("lng"));
            String title = place.get("title");
            String snippet = place.get("snippet");
            LatLng latLng = new LatLng(lat, lng);

            //Log.d("title",title);
            //Log.d("location",latLng.toString());

                Marker marker = googleMap.addMarker(new MarkerOptions()
                        .position(latLng)
                        .title(title)
                        .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE))
                        .snippet(snippet)
                );



        }

    }


}

