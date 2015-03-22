package piratecrew.suggestapp;

import android.graphics.Color;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebHistoryItem;
import android.widget.ArrayAdapter;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;

import static android.graphics.Color.BLUE;
import static android.graphics.Color.CYAN;
import static android.graphics.Color.GRAY;
import static android.graphics.Color.GREEN;
import static android.graphics.Color.LTGRAY;
import static android.graphics.Color.MAGENTA;
import static android.graphics.Color.RED;
import static android.graphics.Color.WHITE;
import static android.graphics.Color.BLACK;
import static android.graphics.Color.YELLOW;

public class CreateActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create);
        RelativeLayout createscreen = (RelativeLayout) findViewById(R.id.createscreen);
        TextView textview = (TextView) findViewById(R.id.textView);
        Spinner spinner = (Spinner) findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.time_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner.setAdapter(adapter);

        if (Themes.t == 0){
            createscreen.setBackgroundColor(WHITE);
            textview.setTextColor(BLACK);
            spinner.setBackgroundColor(LTGRAY);
        }
        else if (Themes.t ==1){
            createscreen.setBackgroundColor(GREEN);
            textview.setTextColor(BLACK);
            spinner.setBackgroundColor(GRAY);
        }
        else if (Themes.t == 2){
            createscreen.setBackgroundColor(BLUE);
            textview.setTextColor(WHITE);
            spinner.setBackgroundColor(CYAN);
        }
        else if (Themes.t == 3){
            createscreen.setBackgroundColor(RED);
            textview.setTextColor(WHITE);
            spinner.setBackgroundColor(MAGENTA);
        }
        else if (Themes.t == 4){
            createscreen.setBackgroundColor(YELLOW);
            textview.setTextColor(BLACK);
            spinner.setBackgroundColor(WHITE);
        }
        else if (Themes.t == 5){
            createscreen.setBackgroundColor(BLACK);
            textview.setTextColor(WHITE);
            spinner.setBackgroundColor(WHITE);
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_create, menu);
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
