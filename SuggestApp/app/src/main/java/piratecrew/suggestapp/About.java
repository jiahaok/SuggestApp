package piratecrew.suggestapp;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;


public class About extends ActionBarActivity {

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
        setContentView(R.layout.activity_about);
    }
    public void menu(int a){
        if (a ==R.id.action_log){
            Intent intentl = new Intent(About.this,LoginActivity.class);
            startActivity(intentl);
        }
        else if (a == R.id.action_create){
            Intent intentc = new Intent(About.this,CreateActivity.class);
            startActivity(intentc);
        }
        else if (a == R.id.action_suggest){
            //Does not work yet, there is no suggest activity

            //Intent intents = new Intent(Settings.this,MainActivity.class);
            //startActivity(intents);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_about, menu);
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
