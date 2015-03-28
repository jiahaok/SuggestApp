package piratecrew.suggestapp;

import android.graphics.Color;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebHistoryItem;
import android.widget.ArrayAdapter;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.ImageButton;
import android.widget.Button;
import android.widget.EditText;

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
        ImageButton imageButtonLeft = (ImageButton) findViewById(R.id.imageButtonLeft);
        imageButtonLeft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        ImageButton imageButtonRight = (ImageButton) findViewById(R.id.imageButtonRight);
        imageButtonRight.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){

            }
        });
        Button create =(Button)findViewById(R.id.create);
        create.setOnClickListener(new View.OnClickListener(){
           @Override
            public void onClick(View v){

           }
        });
        EditText editTextLeft = (EditText)findViewById(R.id.editText2);
        EditText editTextRight = (EditText)findViewById(R.id.editText);


        if (Themes.t==0 ||Themes.t == 1|| Themes.t == 4){
            textview.setTextColor(BLACK);
            if (Themes.t == 0) createscreen.setBackgroundColor(WHITE);
            else if (Themes.t == 1) createscreen.setBackgroundColor(GREEN);
            else if (Themes.t == 4) createscreen.setBackgroundColor(YELLOW);
        }
        else if (Themes.t==2 ||Themes.t == 3|| Themes.t == 5){
            textview.setTextColor(WHITE);
            if (Themes.t == 2) createscreen.setBackgroundColor(BLUE);
            else if (Themes.t == 3) createscreen.setBackgroundColor(RED);
            else if (Themes.t == 5) createscreen.setBackgroundColor(BLACK);
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
