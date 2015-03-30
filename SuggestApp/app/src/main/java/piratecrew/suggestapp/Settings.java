package piratecrew.suggestapp;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import static android.graphics.Color.BLACK;
import static android.graphics.Color.BLUE;
import static android.graphics.Color.GREEN;
import static android.graphics.Color.RED;
import static android.graphics.Color.WHITE;
import static android.graphics.Color.YELLOW;

public class Settings extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        switch (Themes.t){
            case 1:{
                setTheme(android.R.style.Theme_Holo_NoActionBar);
                break;
            }
            case 2:{
                setTheme(android.R.style.Theme_Holo_Light_NoActionBar);
                break;
            }
            case 3:{
                setTheme(android.R.style.Theme_Holo_Wallpaper_NoTitleBar);
                break;
            }
            default: setTheme(android.R.style.Theme_DeviceDefault_NoActionBar);
        }
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        //Navigation buttons
        Button log = (Button) findViewById(R.id.log);
        Button stats = (Button) findViewById(R.id.stats);
        Button themes = (Button) findViewById(R.id.themes);
        Button about = (Button) findViewById(R.id.about);
        //to log in
        log.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent (Settings.this,LoginActivity.class);
                startActivity(intent1);
            }
        });
        //to stats
        stats.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i2 = new Intent(Settings.this, Stats.class);
                startActivity(i2);

            }
        });
        //to themes
        themes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i4 = new Intent(Settings.this, Themes.class);
                startActivity(i4);
            }
        });
        //to about page
        about.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i6 = new Intent(Settings.this, About.class);
                startActivity(i6);

            }
        });
    }

    public void menu(int a){
        if (a ==R.id.action_create){
            Intent intentc = new Intent(Settings.this,CreateActivity.class);
            startActivity(intentc);
        }
        else if (a == R.id.action_suggest){
            //Does not work yet, there is no suggest activity

            //Intent intentsug = new Intent(Settings.this,MainActivity.class);
            //startActivity(intentsug);
        }
        if (a ==R.id.action_stats){
            Intent intentst = new Intent(Settings.this,Stats.class);
            startActivity(intentst);
        }
        if (a ==R.id.action_login){
            Intent intentla = new Intent(Settings.this,LoginActivity.class);
            startActivity(intentla);
        }
        if (a ==R.id.action_themes){
            Intent intentth = new Intent(Settings.this,Themes.class);
            startActivity(intentth);
        }
        if (a ==R.id.action_about){
            Intent intenta = new Intent(Settings.this,About.class);
            startActivity(intenta);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_settings, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        menu(id);
        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
