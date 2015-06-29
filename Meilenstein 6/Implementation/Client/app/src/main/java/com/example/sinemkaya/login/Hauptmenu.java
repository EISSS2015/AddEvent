package com.example.sinemkaya.login;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


public class Hauptmenu extends Activity {

    private Button karte, wetter, nachrichten, meinerouten, profil, routenerstellen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hauptmenu);

        karte = (Button) findViewById(R.id.karte);
        wetter = (Button) findViewById(R.id.wetter);
        nachrichten = (Button) findViewById(R.id.nachrichten);
        meinerouten = (Button) findViewById(R.id.meinerouten);
        profil = (Button) findViewById(R.id.profil);
        routenerstellen = (Button) findViewById(R.id.routenerstellen);

        Intent intent = getIntent();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_hauptmenu, menu);
        return true;
    }

    //wird aufgerufen, sobald der Benutzer den Button anklickt
    public void activity3(View view) {
        if (karte.isPressed()) {
            Intent intent6 = new Intent(this, Karte.class);
            startActivity(intent6);
        }
        if(wetter.isPressed()){
            Intent intent1 = new Intent(this, Wetter.class);
            startActivity(intent1);
        }
        if(nachrichten.isPressed()){
            Intent intent2 = new Intent(this, Nachrichten.class);
            startActivity(intent2);
        }
        if(profil.isPressed()){
            Intent intent3 = new Intent(this, Profil.class);
            startActivity(intent3);
        }
        if(routenerstellen.isPressed()){
            Intent intent4 = new Intent(this, Routenerstellen.class);
            startActivity(intent4);
        }
        if(meinerouten.isPressed()) {
            Intent intent5 = new Intent(this, Meinerouten.class);
            startActivity(intent5);
        }
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
}
