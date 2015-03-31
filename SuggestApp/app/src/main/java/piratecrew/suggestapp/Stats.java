package piratecrew.suggestapp;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.content.Intent;
import android.widget.RelativeLayout;
import android.widget.TextView;

import static android.graphics.Color.BLACK;
import static android.graphics.Color.BLUE;
import static android.graphics.Color.GREEN;
import static android.graphics.Color.RED;
import static android.graphics.Color.WHITE;
import static android.graphics.Color.YELLOW;

public class Stats extends ActionBarActivity {

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

        //back to settings page
        Button toSettings = (Button) findViewById(R.id.toSettings);
        toSettings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i1 = new Intent(Stats.this, Settings.class);
                startActivity(i1);
            }
        });
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

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
