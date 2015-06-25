package com.example.sinemkaya.login;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

import Hilfsklassen.HandleXML;


public class Wetter extends Activity {

    private String url1 = "http://api.openweathermap.org/data/2.5/forecast/?q=";
    private String url2 = "&mode=xml&APPID=fbc548f0ad7993a7b9a589366a0a84fb";
    private EditText location, country, temperature, humidity, windSpeed, clouds;
    private HandleXML obj;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wetter);

        location = (EditText)findViewById(R.id.editText1);
        country = (EditText)findViewById(R.id.editText2);
        temperature = (EditText)findViewById(R.id.editText3);
        humidity = (EditText)findViewById(R.id.editText4);
        windSpeed = (EditText)findViewById(R.id.editText5);
        clouds = (EditText)findViewById(R.id.editText6);

        Intent intent1 = getIntent();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main_activity2, menu);
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

    public void open(View view){
        String url = location.getText().toString();
        String finalUrl = url1 + url + url2;
        country.setText(finalUrl);
        obj = new HandleXML(finalUrl);
        obj.fetchXML();
        while(obj.parsingComplete);
        country.setText(obj.getCountry());
        temperature.setText(obj.getTemperature() + " C°");
        humidity.setText(obj.getHumidity() + " %");
        windSpeed.setText(obj.getwindSpeed());
        clouds.setText(obj.getClouds());

    }
}
