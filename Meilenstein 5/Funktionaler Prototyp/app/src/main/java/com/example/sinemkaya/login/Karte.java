package com.example.sinemkaya.login;

import android.app.Activity;
import android.content.Intent;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

import org.osmdroid.bonuspack.overlays.Marker;
import org.osmdroid.util.GeoPoint;
import org.osmdroid.views.MapController;
import org.osmdroid.views.MapView;

import Hilfsklassen.HandleXML2;


public class Karte extends Activity implements LocationListener {

    private LocationManager myLocationManager;
    private MapView mapView;
    private MapController mapController;
    private String url1 = "http://api.openweathermap.org/data/2.5/weather?q=";
    private String url2 = "&mode=xml&APPID=fbc548f0ad7993a7b9a589366a0a84fb";
    public EditText ort;
    private EditText lat;
    private EditText lon;
    private HandleXML2 obj;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_karte);
        ort = (EditText) findViewById(R.id.editText);
        lat = (EditText) findViewById(R.id.lat);
        lon = (EditText) findViewById(R.id.lon);

        mapView = (MapView)findViewById(R.id.mapview);
        mapView.setBuiltInZoomControls(true);
        mapView.setMultiTouchControls(true);
        mapController = (MapController) this.mapView.getController();
        Intent intent6 = getIntent();


        mapController.setZoom(16);
        GeoPoint mapCenter = new GeoPoint(53554070, -2959520);
        mapController.setCenter(mapCenter);


        myLocationManager = (LocationManager) getSystemService(LOCATION_SERVICE);
        myLocationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 1000, 100, this);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_karte, menu);
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

    @Override
    public void onLocationChanged(Location location) {

        int latitude = (int) (location.getLatitude() * 1E6);
        int longitude = (int) (location.getLongitude() * 1E6);
        GeoPoint geopoint = new GeoPoint(latitude, longitude);
        mapController.setCenter(geopoint);

        Marker startMarker = new Marker(mapView);
        startMarker.setPosition(geopoint);
        startMarker.setAnchor(Marker.ANCHOR_CENTER, Marker.ANCHOR_BOTTOM);
        mapView.getOverlays().add(startMarker);
        mapView.invalidate();
        startMarker.setIcon(getResources().getDrawable(R.mipmap.icon));
        startMarker.setTitle("Start point");
        mapView.invalidate();
    }

    public void open(View view){
        String url = ort.getText().toString();
        String finalUrl = url1 + url + url2;
        obj = new HandleXML2(finalUrl);
        obj.fetchXML();
        while(obj.parsingComplete);
        lat.setText(obj.getLat());
        lon.setText(obj.getLon());


        float i = Float.valueOf(lat.getText().toString()).floatValue();
        float b = Float.valueOf(lon.getText().toString()).floatValue();

        GeoPoint geopoint = new GeoPoint(i, b);
        mapController.setCenter(geopoint);

        Marker startMarker = new Marker(mapView);
        startMarker.setPosition(geopoint);
        startMarker.setAnchor(Marker.ANCHOR_CENTER, Marker.ANCHOR_BOTTOM);
        mapView.getOverlays().add(startMarker);
        mapView.invalidate();
        startMarker.setIcon(getResources().getDrawable(R.mipmap.icon));
        startMarker.setTitle("Start point");
        mapView.invalidate();


    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {

    }

    @Override
    public void onProviderEnabled(String provider) {

    }

    @Override
    public void onProviderDisabled(String provider) {

    }
}
