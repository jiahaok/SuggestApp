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


public class About extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        //buttons,text
        Button toSettings3 = (Button) findViewById(R.id.toSettings3);
        final RelativeLayout about1 = (RelativeLayout) findViewById(R.id.about1);
        final TextView abouttitle = (TextView) findViewById(R.id.abouttitle);
        final TextView atext = (TextView) findViewById(R.id.atext);
        //setting colors
        if (Themes.t == 0){
            about1.setBackgroundColor(WHITE);
            abouttitle.setTextColor(BLACK);
            atext.setTextColor(BLACK);
        }
        else if (Themes.t == 1){
            about1.setBackgroundColor(GREEN);
            abouttitle.setTextColor(BLACK);
            atext.setTextColor(BLACK);
        }
        else if (Themes.t == 2){
            about1.setBackgroundColor(BLUE);
            abouttitle.setTextColor(WHITE);
            atext.setTextColor(WHITE);
        }
        else if (Themes.t == 3){
            about1.setBackgroundColor(RED);
            abouttitle.setTextColor(WHITE);
            atext.setTextColor(WHITE);
        }
        else if (Themes.t == 4){
            about1.setBackgroundColor(YELLOW);
            abouttitle.setTextColor(BLACK);
            atext.setTextColor(BLACK);
        }
        else if (Themes.t == 5){
            about1.setBackgroundColor(BLACK);
            abouttitle.setTextColor(WHITE);
            atext.setTextColor(WHITE);
        }
        else{
            about1.setBackgroundColor(WHITE);
            abouttitle.setTextColor(BLACK);
            atext.setTextColor(BLACK);
        }
        //back to settings
        toSettings3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i5 = new Intent(About.this, Settings.class);
                startActivity(i5);
            }
        });
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

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
