package piratecrew.suggestapp;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;


public class About extends ActionBarActivity {

    public static int before;

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
            LoginActivity.before = 0;
            startActivity(new Intent(About.this,LoginActivity.class));
        }
        else if (a ==R.id.action_stats){
            Stats.before = 0;
            startActivity(new Intent(About.this,Stats.class));
        }
        else if (a ==R.id.action_themes){
            Themes.before = 0;
            startActivity(new Intent(About.this,Themes.class));
        }
        else  if (a ==R.id.action_main){
            startActivity(new Intent(About.this,MainActivity.class));
        }
        else{
            if (before == 1)startActivity(new Intent(About.this,CreateActivity.class));
            if (before == 2)startActivity(new Intent(About.this,LoginActivity.class));
            if (before == 3)startActivity(new Intent(About.this,MainActivity.class));
            if (before == 4)startActivity(new Intent(About.this,Stats.class));
            if (before == 5)startActivity(new Intent(About.this,Themes.class));
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
