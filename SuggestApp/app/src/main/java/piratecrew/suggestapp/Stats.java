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
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stats);
        //All text
        final RelativeLayout stat = (RelativeLayout) findViewById(R.id.stat);
        final TextView stat1 = (TextView) findViewById(R.id.stat1);
        final TextView stat2 = (TextView) findViewById(R.id.stat2);
        final TextView stat3 = (TextView) findViewById(R.id.stat3);
        final TextView stattitle = (TextView) findViewById((R.id.stattitle));
        //Setting colors based on theme
        if (Themes.t == 0){
            stat.setBackgroundColor(WHITE);
            stattitle.setTextColor(BLACK);
            stat1.setTextColor(BLACK);
            stat2.setTextColor(BLACK);
            stat3.setTextColor(BLACK);
        }
        else if (Themes.t == 1){
            stat.setBackgroundColor(GREEN);
            stattitle.setTextColor(BLACK);
        }
        else if (Themes.t == 2){
            stat.setBackgroundColor(BLUE);
            stattitle.setTextColor(WHITE);
            stat1.setTextColor(WHITE);
            stat2.setTextColor(WHITE);
            stat3.setTextColor(WHITE);
        }
        else if (Themes.t == 3){
            stat.setBackgroundColor(RED);
            stattitle.setTextColor(WHITE);
            stat1.setTextColor(WHITE);
            stat2.setTextColor(WHITE);
            stat3.setTextColor(WHITE);
        }
        else if (Themes.t == 4){
            stat.setBackgroundColor(YELLOW);
            stattitle.setTextColor(BLACK);
            stat1.setTextColor(BLACK);
            stat2.setTextColor(BLACK);
            stat3.setTextColor(BLACK);
        }
        else if (Themes.t == 5){
            stat.setBackgroundColor(BLACK);
            stattitle.setTextColor(WHITE);
            stat1.setTextColor(WHITE);
            stat2.setTextColor(WHITE);
            stat3.setTextColor(WHITE);
        }
        else{
            stat.setBackgroundColor(WHITE);
            stattitle.setTextColor(BLACK);
            stat1.setTextColor(BLACK);
            stat2.setTextColor(BLACK);
            stat3.setTextColor(BLACK);
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

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
