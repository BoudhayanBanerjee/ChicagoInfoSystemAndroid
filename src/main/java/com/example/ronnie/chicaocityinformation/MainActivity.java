package com.example.ronnie.chicaocityinformation;

import android.app.ActivityManager;
import android.app.FragmentManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.util.Log;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, OnMapReadyCallback {

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */

    SupportMapFragment MapFragment;
    GoogleMap googleMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);



        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        MapFragment = SupportMapFragment.newInstance();
        MapFragment.getMapAsync(this);

        FragmentManager fm = getFragmentManager();
        android.support.v4.app.FragmentManager sFm = getSupportFragmentManager();
        sFm.beginTransaction().replace(R.id.content_frame, MapFragment).commit();

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
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
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        String api_key ="5jAXVDrqioq27hiwZXOY2wpBt";

        if (id == R.id.nav_ps) {
            SupportMapFragment mapFragment =
                    (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.content_frame);
            googleMap = mapFragment.getMap();

            Object[] topass = new Object[3];
            topass[0] = googleMap;
            topass[1] = getResources().getString(R.string.url_ps)+api_key;
            topass[2] = "ps";

            Log.d("URL",topass[1].toString());

            GetPlace getPlace = new GetPlace();

            getPlace.execute(topass);

        } /*else if (id == R.id.nav_food) {

        }*/ else if (id == R.id.nav_home) {

            SupportMapFragment mapFragment =
                    (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.content_frame);
            googleMap = mapFragment.getMap();

            Object[] topass = new Object[3];
            topass[0] = googleMap;
            topass[1] = getResources().getString(R.string.url_home)+api_key;
            topass[2] ="home";

            Log.d("URL",topass[1].toString());

            GetPlace getPlace = new GetPlace();

            getPlace.execute(topass);


        } else if (id == R.id.nav_wclinic) {

            SupportMapFragment mapFragment =
                    (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.content_frame);
            googleMap = mapFragment.getMap();

            Object[] topass = new Object[3];
            topass[0] = googleMap;
            topass[1] = getResources().getString(R.string.url_wclinic)+api_key;
            topass[2] ="wclinic";

            GetPlace getPlace = new GetPlace();

            getPlace.execute(topass);

        } else if (id == R.id.nav_health) {
            SupportMapFragment mapFragment =
                    (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.content_frame);
            googleMap = mapFragment.getMap();

            Object[] topass = new Object[3];
            topass[0] = googleMap;
            topass[1] = getResources().getString(R.string.url_health)+api_key;
            topass[2] ="health";

            Log.d("URL",topass[1].toString());

            GetPlace getPlace = new GetPlace();

            getPlace.execute(topass);

        } else if (id == R.id.nav_connect) {

            SupportMapFragment mapFragment =
                    (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.content_frame);
            googleMap = mapFragment.getMap();

            Object[] topass = new Object[3];
            topass[0] = googleMap;
            topass[1] = getResources().getString(R.string.url_connect)+api_key;
            topass[2] ="connect";

            Log.d("URL",topass[1].toString());

            GetPlace getPlace = new GetPlace();

            getPlace.execute(topass);

        }else if (id == R.id.nav_community) {

            SupportMapFragment mapFragment =
                    (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.content_frame);
            googleMap = mapFragment.getMap();

            Object[] topass = new Object[3];
            topass[0] = googleMap;
            topass[1] = getResources().getString(R.string.url_community)+api_key;
            topass[2] ="community";

            Log.d("URL",topass[1].toString());

            GetPlace getPlace = new GetPlace();

            getPlace.execute(topass);


        } else if (id == R.id.nav_work) {

            SupportMapFragment mapFragment =
                    (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.content_frame);
            googleMap = mapFragment.getMap();

            Object[] topass = new Object[3];
            topass[0] = googleMap;
            topass[1] = getResources().getString(R.string.url_work)+api_key;
            topass[2] ="work";

            Log.d("URL",topass[1].toString());

            GetPlace getPlace = new GetPlace();

            getPlace.execute(topass);

        } else if (id == R.id.nav_traffic) {

            SupportMapFragment mapFragment =
                    (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.content_frame);
            googleMap = mapFragment.getMap();

            Object[] topass = new Object[3];
            topass[0] = googleMap;
            topass[1] = getResources().getString(R.string.url_traffic)+api_key;
            topass[2] ="traffic";

            GetPlace getPlace = new GetPlace();

            getPlace.execute(topass);

        } else if (id == R.id.nav_crime) {
            SupportMapFragment mapFragment =
                    (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.content_frame);
            googleMap = mapFragment.getMap();

            Object[] topass = new Object[3];
            topass[0] = googleMap;
            topass[1] = getResources().getString(R.string.url_crime)+api_key;
            topass[2] ="crime";

            GetPlace getPlace = new GetPlace();

            getPlace.execute(topass);

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.

        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "Main Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app URL is correct.
                Uri.parse("android-app://com.example.ronnie.chicaocityinformation/http/host/path")
        );

    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "Main Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app URL is correct.
                Uri.parse("android-app://com.example.ronnie.chicaocityinformation/http/host/path")
        );

    }

    @Override
    public void onMapReady(GoogleMap googleMap) {

        googleMap.setMapType(1);

        googleMap.getUiSettings().setMapToolbarEnabled(false);

        CameraPosition cameraPosition = new CameraPosition.Builder()
                .target(new LatLng(41.8781,-87.6298))      // Sets the center of the map to Mountain View
                .zoom(14)
                .tilt(45)                   // Sets the tilt of the camera to 30 degrees
                .build();
        googleMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));

    }
}
