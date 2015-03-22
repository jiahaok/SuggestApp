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
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        final RelativeLayout set = (RelativeLayout) findViewById(R.id.set);
        final TextView title = (TextView) findViewById(R.id.title);
        //Setting colors based on theme
        if (Themes.t == 0){
            set.setBackgroundColor(WHITE);
            title.setTextColor(BLACK);
        }
        else if (Themes.t == 1){
            set.setBackgroundColor(GREEN);
            title.setTextColor(BLACK);
        }
        else if (Themes.t == 2){
            set.setBackgroundColor(BLUE);
            title.setTextColor(WHITE);
        }
        else if (Themes.t == 3){
            set.setBackgroundColor(RED);
            title.setTextColor(WHITE);
        }
        else if (Themes.t == 4){
            set.setBackgroundColor(YELLOW);
            title.setTextColor(BLACK);
        }
        else if (Themes.t == 5){
            set.setBackgroundColor(BLACK);
            title.setTextColor(WHITE);
        }
        else{
            set.setBackgroundColor(WHITE);
            title.setTextColor(BLACK);
        }
        //Navigation buttons
        Button log = (Button) findViewById(R.id.log);
        Button stats = (Button) findViewById(R.id.stats);
        Button themes = (Button) findViewById(R.id.themes);
        Button about = (Button) findViewById(R.id.about);
        Button back = (Button) findViewById(R.id.back);
        //to log in
        log.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

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
        //to main page
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i8 = new Intent(Settings.this, MainActivity.class);
                startActivity(i8);
            }
        });
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

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
