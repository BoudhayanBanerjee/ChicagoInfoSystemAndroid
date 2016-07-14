package com.example.ronnie.chicaocityinformation;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
public class Places {


    public List<HashMap<String, String>> getPlaces(JSONArray jsonArray,String type) {
        int placesCount = jsonArray.length();
        List<HashMap<String, String>> placesList = new ArrayList<HashMap<String, String>>();

        for (int i = 0; i < placesCount; i++) {
            try {
                //placeMap = getPlace((JSONObject) jsonArray.get(i));
                //placesList.add(placeMap);
                HashMap<String, String> placeMap = new HashMap<String, String>();

                JSONObject data = jsonArray.getJSONObject(i);


                if(type == "ps") {

                    String district_name = data.getString("district_name");
                    String phone = data.getString("phone");

                    Double longitude = data.getDouble("longitude");
                    Double latitude = data.getDouble("latitude");

                    placeMap.put("title", district_name);
                    placeMap.put("snippet", "Phone : "+phone);
                    placeMap.put("lat", Double.toString(latitude));
                    placeMap.put("lng", Double.toString(longitude));
                }
                else if(type == "work" || type=="health" || type=="wclinic")
                {
                    String site_name = data.getString("site_name");
                    String hours_of_operation = data.getString("hours_of_operation");

                    Double longitude = data.getJSONObject("location").getJSONArray("coordinates").getDouble(0);
                    Double latitude = data.getJSONObject("location").getJSONArray("coordinates").getDouble(1);

                    Log.d("SITE",site_name);
                    placeMap.put("title", site_name);
                    placeMap.put("snippet", "Hours : "+hours_of_operation);
                    placeMap.put("lat", Double.toString(latitude));
                    placeMap.put("lng", Double.toString(longitude));
                }
                else if(type == "community")
                {
                    String site = data.getString("site");
                    String hours_of_operation = data.getString("hours_of_operation");

                    Double longitude = data.getJSONObject("location").getJSONArray("coordinates").getDouble(0);
                    Double latitude = data.getJSONObject("location").getJSONArray("coordinates").getDouble(1);

                    Log.d("title",site);
                    placeMap.put("title", site);
                    placeMap.put("snippet", "Hours : "+hours_of_operation);
                    placeMap.put("lat", Double.toString(latitude));
                    placeMap.put("lng", Double.toString(longitude));
                }
                else if(type == "connect")
                {
                    String organization_name = data.getString("organization_name");
                    String hours = data.getString("hours");

                    Double longitude = data.getJSONObject("location").getJSONArray("coordinates").getDouble(0);
                    Double latitude = data.getJSONObject("location").getJSONArray("coordinates").getDouble(1);


                    placeMap.put("title", organization_name);
                    placeMap.put("snippet", "Hours : "+hours);
                    placeMap.put("lat", Double.toString(latitude));
                    placeMap.put("lng", Double.toString(longitude));
                }
                else if(type == "home")
                {
                    String management_company = data.getString("management_company");
                    String property_name = data.getString("property_name");
                    String phone_number = data.getString("phone_number");

                    Double longitude = data.getJSONObject("location").getJSONArray("coordinates").getDouble(0);
                    Double latitude = data.getJSONObject("location").getJSONArray("coordinates").getDouble(1);


                    placeMap.put("title", management_company+" "+property_name);
                    placeMap.put("snippet", "Phone : "+phone_number);
                    placeMap.put("lat", Double.toString(latitude));
                    placeMap.put("lng", Double.toString(longitude));
                }
                else if(type == "crime")
                {
                    String location_description=null;
                    int year = data.getInt("year");


                        String primary_type = data.getString("primary_type");
                        String description = data.getString("description");

                        location_description = data.getString("location_description");

                        Double longitude = data.getJSONObject("location").getJSONArray("coordinates").getDouble(0);
                        Double latitude = data.getJSONObject("location").getJSONArray("coordinates").getDouble(1);


                        placeMap.put("title", primary_type + ", " + description);
                        placeMap.put("snippet", "Location : " + location_description);
                        placeMap.put("lat", Double.toString(latitude));
                        placeMap.put("lng", Double.toString(longitude));


                }
                else if(type == "traffic"){
                    String violations = data.getString("violations");

                    Double longitude = data.getDouble("longitude");
                    Double latitude = data.getDouble("latitude");

                    placeMap.put("title", "Violations : "+violations);
                    placeMap.put("snippet"," ");
                    placeMap.put("lat", Double.toString(latitude));
                    placeMap.put("lng", Double.toString(longitude));
                }



                placesList.add(placeMap);
                //Log.d("MAP",placeMap.toString());

            } catch (JSONException e) {
                e.printStackTrace();
            }
        }


        //Log.d("LIST",placesList.toString());
        return placesList;
    }
}

