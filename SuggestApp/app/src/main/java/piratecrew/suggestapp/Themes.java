package piratecrew.suggestapp;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import android.content.Context;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import android.widget.TextView;

import static android.graphics.Color.BLACK;
import static android.graphics.Color.BLUE;
import static android.graphics.Color.GREEN;
import static android.graphics.Color.RED;
import static android.graphics.Color.WHITE;
import static android.graphics.Color.YELLOW;


public class Themes extends ActionBarActivity {

    public static int t;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_themes);
        Button toSettings2 = (Button) findViewById(R.id.toSettings2);
        final TextView themetitle = (TextView) findViewById(R.id.themetitle);
        final RelativeLayout theme = (RelativeLayout) findViewById(R.id.theme);
        //all buttons
        final RadioButton def = (RadioButton) findViewById(R.id.def);
        final RadioButton green = (RadioButton) findViewById(R.id.green);
        final RadioButton blue = (RadioButton) findViewById(R.id.blue);
        final RadioButton red = (RadioButton) findViewById(R.id.red);
        final RadioButton yel = (RadioButton) findViewById(R.id.yel);
        final RadioButton in = (RadioButton) findViewById(R.id.in);
        //setting page colors
        if (t == 0){
            def.setChecked(true);
            def.setSelected(true);
            theme.setBackgroundColor(WHITE);
            themetitle.setTextColor(BLACK);
            def.setTextColor(BLACK);
            green.setTextColor(BLACK);
            blue.setTextColor(BLACK);
            red.setTextColor(BLACK);
            yel.setTextColor(BLACK);
            in.setTextColor(BLACK);
        }
        else if (t == 1){
            green.setChecked(true);
            green.setSelected(true);
            theme.setBackgroundColor(GREEN);
            themetitle.setTextColor(BLACK);
            def.setTextColor(BLACK);
            green.setTextColor(BLACK);
            blue.setTextColor(BLACK);
            red.setTextColor(BLACK);
            yel.setTextColor(BLACK);
            in.setTextColor(BLACK);
        }
        else if (t == 2){
            blue.setChecked(true);
            blue.setSelected(true);
            theme.setBackgroundColor(BLUE);
            themetitle.setTextColor(WHITE);
            def.setTextColor(WHITE);
            green.setTextColor(WHITE);
            blue.setTextColor(WHITE);
            red.setTextColor(WHITE);
            yel.setTextColor(WHITE);
            in.setTextColor(WHITE);
        }
        else if (t == 3){
            red.setChecked(true);
            red.setSelected(true);
            theme.setBackgroundColor(RED);
            themetitle.setTextColor(WHITE);
            def.setTextColor(WHITE);
            green.setTextColor(WHITE);
            blue.setTextColor(WHITE);
            red.setTextColor(WHITE);
            yel.setTextColor(WHITE);
            in.setTextColor(WHITE);
        }
        else if (t == 4){
            yel.setChecked(true);
            yel.setSelected(true);
            theme.setBackgroundColor(YELLOW);
            themetitle.setTextColor(BLACK);
            def.setTextColor(BLACK);
            green.setTextColor(BLACK);
            blue.setTextColor(BLACK);
            red.setTextColor(BLACK);
            yel.setTextColor(BLACK);
            in.setTextColor(BLACK);
        }
        else if (t == 5){
            in.setChecked(true);
            in.setSelected(true);
            theme.setBackgroundColor(BLACK);
            themetitle.setTextColor(WHITE);
            def.setTextColor(WHITE);
            green.setTextColor(WHITE);
            blue.setTextColor(WHITE);
            red.setTextColor(WHITE);
            yel.setTextColor(WHITE);
            in.setTextColor(WHITE);
        }
        //back to settings
        toSettings2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i3 = new Intent(Themes.this, Settings.class);
                startActivity(i3);
            }
        });
        //Allows user to set theme
        def.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (t!=0) {
                    def.setSelected(true);
                    def.setChecked(true);
                    green.setSelected(false);
                    green.setChecked(false);
                    red.setSelected(false);
                    red.setChecked(false);
                    yel.setSelected(false);
                    yel.setChecked(false);
                    blue.setSelected(false);
                    blue.setChecked(false);
                    in.setSelected(false);
                    in.setChecked(false);
                    theme.setBackgroundColor(WHITE);
                    themetitle.setTextColor(BLACK);
                    def.setTextColor(BLACK);
                    green.setTextColor(BLACK);
                    blue.setTextColor(BLACK);
                    red.setTextColor(BLACK);
                    yel.setTextColor(BLACK);
                    in.setTextColor(BLACK);

                    t = 0;
                }
                else{
                    def.setSelected(true);
                    def.setChecked(true);
                    t = 0;
                    theme.setBackgroundColor(WHITE);
                    themetitle.setTextColor(BLACK);
                    def.setTextColor(BLACK);
                    green.setTextColor(BLACK);
                    blue.setTextColor(BLACK);
                    red.setTextColor(BLACK);
                    yel.setTextColor(BLACK);
                    in.setTextColor(BLACK);
                }

            }
        });
        green.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(t!=1) {
                    red.setSelected(false);
                    red.setChecked(false);
                    blue.setSelected(false);
                    blue.setChecked(false);
                    def.setSelected(false);
                    def.setChecked(false);
                    yel.setSelected(false);
                    yel.setChecked(false);
                    in.setSelected(false);
                    in.setChecked(false);
                    theme.setBackgroundColor(Color.GREEN);
                    themetitle.setTextColor(BLACK);
                    def.setTextColor(BLACK);
                    green.setTextColor(BLACK);
                    blue.setTextColor(BLACK);
                    red.setTextColor(BLACK);
                    yel.setTextColor(BLACK);
                    in.setTextColor(BLACK);
                    t = 1;
                }
                else{
                    def.setSelected(true);
                    def.setChecked(true);
                    green.setSelected(false);
                    green.setChecked(false);
                    t = 0;
                    theme.setBackgroundColor(WHITE);
                    themetitle.setTextColor(BLACK);
                    def.setTextColor(BLACK);
                    green.setTextColor(BLACK);
                    blue.setTextColor(BLACK);
                    red.setTextColor(BLACK);
                    yel.setTextColor(BLACK);
                    in.setTextColor(BLACK);
                }
            }
        });
        blue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(t!=2) {
                    blue.setSelected(true);
                    blue.setChecked(true);
                    red.setSelected(false);
                    green.setSelected(false);
                    def.setSelected(false);
                    red.setChecked(false);
                    green.setChecked(false);
                    def.setChecked(false);
                    yel.setSelected(false);
                    yel.setChecked(false);
                    in.setSelected(false);
                    in.setChecked(false);
                    theme.setBackgroundColor(Color.BLUE);
                    themetitle.setTextColor(WHITE);
                    def.setTextColor(WHITE);
                    green.setTextColor(WHITE);
                    blue.setTextColor(WHITE);
                    red.setTextColor(WHITE);
                    yel.setTextColor(WHITE);
                    in.setTextColor(WHITE);
                    t = 2;
                }
                else{
                    def.setSelected(true);
                    blue.setSelected(false);
                    def.setChecked(true);
                    blue.setChecked(false);
                    t = 0;
                    theme.setBackgroundColor(WHITE);
                    themetitle.setTextColor(BLACK);
                    def.setTextColor(BLACK);
                    green.setTextColor(BLACK);
                    blue.setTextColor(BLACK);
                    red.setTextColor(BLACK);
                    yel.setTextColor(BLACK);
                    in.setTextColor(BLACK);
                }
            }
        });
        red.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (t!=3) {
                    green.setSelected(false);
                    blue.setSelected(false);
                    def.setSelected(false);
                    green.setChecked(false);
                    blue.setChecked(false);
                    def.setChecked(false);
                    yel.setSelected(false);
                    yel.setChecked(false);
                    in.setSelected(false);
                    in.setChecked(false);
                    theme.setBackgroundColor(Color.RED);
                    themetitle.setTextColor(WHITE);
                    def.setTextColor(WHITE);
                    green.setTextColor(WHITE);
                    blue.setTextColor(WHITE);
                    red.setTextColor(WHITE);
                    yel.setTextColor(WHITE);
                    in.setTextColor(WHITE);
                    t = 3;
                }
                else{
                    def.setSelected(true);
                    def.setChecked(true);
                    red.setChecked(false);
                    red.setSelected(false);
                    t = 0;
                    theme.setBackgroundColor(WHITE);
                    themetitle.setTextColor(BLACK);
                    def.setTextColor(BLACK);
                    green.setTextColor(BLACK);
                    blue.setTextColor(BLACK);
                    red.setTextColor(BLACK);
                    yel.setTextColor(BLACK);
                    in.setTextColor(BLACK);
                }
            }
        });
        yel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (t!=4) {
                    green.setSelected(false);
                    blue.setSelected(false);
                    def.setSelected(false);
                    green.setChecked(false);
                    blue.setChecked(false);
                    def.setChecked(false);
                    red.setSelected(false);
                    red.setChecked(false);
                    in.setSelected(false);
                    in.setChecked(false);
                    theme.setBackgroundColor(Color.YELLOW);
                    themetitle.setTextColor(BLACK);
                    def.setTextColor(BLACK);
                    green.setTextColor(BLACK);
                    blue.setTextColor(BLACK);
                    red.setTextColor(BLACK);
                    yel.setTextColor(BLACK);
                    in.setTextColor(BLACK);
                    t = 4;
                }
                else{
                    def.setSelected(true);
                    def.setChecked(true);
                    yel.setChecked(false);
                    yel.setSelected(false);
                    t = 0;
                    theme.setBackgroundColor(WHITE);
                    themetitle.setTextColor(BLACK);
                    def.setTextColor(BLACK);
                    green.setTextColor(BLACK);
                    blue.setTextColor(BLACK);
                    red.setTextColor(BLACK);
                    yel.setTextColor(BLACK);
                    in.setTextColor(BLACK);
                }
            }
        });
        in.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (t!=5) {
                    green.setSelected(false);
                    blue.setSelected(false);
                    def.setSelected(false);
                    green.setChecked(false);
                    blue.setChecked(false);
                    def.setChecked(false);
                    yel.setSelected(false);
                    yel.setChecked(false);
                    red.setSelected(false);
                    red.setChecked(false);
                    theme.setBackgroundColor(Color.BLACK);
                    themetitle.setTextColor(WHITE);
                    def.setTextColor(WHITE);
                    green.setTextColor(WHITE);
                    blue.setTextColor(WHITE);
                    red.setTextColor(WHITE);
                    yel.setTextColor(WHITE);
                    in.setTextColor(WHITE);
                    t = 5;
                }
                else{
                    def.setSelected(true);
                    def.setChecked(true);
                    in.setChecked(false);
                    in.setSelected(false);
                    t = 0;
                    theme.setBackgroundColor(WHITE);
                    themetitle.setTextColor(BLACK);
                    def.setTextColor(BLACK);
                    green.setTextColor(BLACK);
                    blue.setTextColor(BLACK);
                    red.setTextColor(BLACK);
                    yel.setTextColor(BLACK);
                    in.setTextColor(BLACK);
                }
            }
        });

        //experimental file code
        String FILENAME = "file";
        String string = String.valueOf(t);

        FileOutputStream fos = null;
        try {
            fos = openFileOutput(FILENAME, Context.MODE_PRIVATE);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            fos.write(string.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_themes, menu);
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