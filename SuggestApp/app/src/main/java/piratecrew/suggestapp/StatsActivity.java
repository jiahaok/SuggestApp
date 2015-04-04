package piratecrew.suggestapp;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.content.Intent;

public class StatsActivity extends ActionBarActivity {
    static int before = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        switch (Themes.t){
            case 1:{
                setTheme(android.R.style.Theme_Holo_NoActionBar);
                break;
            }
            case 2:{
                setTheme(android.R.style.Theme_DeviceDefault_Light_NoActionBar);
                break;
            }
            case 3:{
                setTheme(android.R.style.Theme_DeviceDefault_Wallpaper_NoTitleBar);
                break;
            }
            default: setTheme(android.R.style.Theme_DeviceDefault_NoActionBar);
        }

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stats);

    }
    public void menu(int a){
        if (a ==R.id.action_about){
            AboutActivity.before = 4;
            startActivity(new Intent(StatsActivity.this,AboutActivity.class));
        }
        else if (a ==R.id.action_login){
            LoginActivity.before = 4;
            startActivity(new Intent(StatsActivity.this,LoginActivity.class));
        }
        else if (a ==R.id.action_themes){
            Themes.before = 4;
            startActivity(new Intent(StatsActivity.this,Themes.class));
        }
        else  if (a ==R.id.action_main) startActivity(new Intent(StatsActivity.this,MainActivity.class));
        else{
            if (before == 0)startActivity(new Intent(StatsActivity.this,AboutActivity.class));
            if (before == 1)startActivity(new Intent(StatsActivity.this,CreateActivity.class));
            if (before == 2)startActivity(new Intent(StatsActivity.this,LoginActivity.class));
            if (before == 3)startActivity(new Intent(StatsActivity.this,MainActivity.class));
            if (before == 5)startActivity(new Intent(StatsActivity.this,Themes.class));
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_stats, menu);
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
