package piratecrew.suggestapp;


import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.webkit.WebHistoryItem;
import android.widget.Button;
import android.widget.RelativeLayout;

import static android.graphics.Color.BLACK;
import static android.graphics.Color.BLUE;
import static android.graphics.Color.GREEN;
import static android.graphics.Color.RED;
import static android.graphics.Color.WHITE;
import static android.graphics.Color.YELLOW;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Background-Setting
        Button setting = (Button) findViewById(R.id.setting);
        final RelativeLayout back = (RelativeLayout) findViewById(R.id.back);
        if (Themes.t==0 ||Themes.t == 1|| Themes.t == 4){
            if (Themes.t == 0) back.setBackgroundColor(WHITE);
            else if (Themes.t == 1) back.setBackgroundColor(GREEN);
            else if (Themes.t == 4) back.setBackgroundColor(YELLOW);
        }
        else if (Themes.t==2 ||Themes.t == 3|| Themes.t == 5){
            if (Themes.t == 2) back.setBackgroundColor(BLUE);
            else if (Themes.t == 3) back.setBackgroundColor(RED);
            else if (Themes.t == 5) back.setBackgroundColor(BLACK);
        }
        setting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i7 = new Intent(MainActivity.this, Settings.class);
                startActivity(i7);
            }
        });


        Button createBtn = (Button) findViewById(R.id.button);
        createBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, CreateActivity.class);
                startActivity(intent);
            }
        });
    }




    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
