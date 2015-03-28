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
    public static int temp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_themes);
        final TextView themetitle = (TextView) findViewById(R.id.themetitle);
        final RelativeLayout theme = (RelativeLayout) findViewById(R.id.theme);
        //all buttons
        final RadioButton def = (RadioButton) findViewById(R.id.def);
        final RadioButton green = (RadioButton) findViewById(R.id.green);
        final RadioButton blue = (RadioButton) findViewById(R.id.blue);
        final RadioButton red = (RadioButton) findViewById(R.id.red);
        final RadioButton yel = (RadioButton) findViewById(R.id.yel);
        final RadioButton in = (RadioButton) findViewById(R.id.in);
        Button set = (Button) findViewById(R.id.settheme);

        //setting page colors
        if (t==0 ||t == 1|| t == 4){
            themetitle.setTextColor(BLACK);
            def.setTextColor(BLACK);
            green.setTextColor(BLACK);
            blue.setTextColor(BLACK);
            red.setTextColor(BLACK);
            yel.setTextColor(BLACK);
            in.setTextColor(BLACK);
            if (t == 0) theme.setBackgroundColor(WHITE);
            else if (t == 1) theme.setBackgroundColor(GREEN);
            else if (t == 4) theme.setBackgroundColor(YELLOW);
        }
        else if (t==2 ||t == 3|| t == 5){
            themetitle.setTextColor(WHITE);
            def.setTextColor(WHITE);
            green.setTextColor(WHITE);
            blue.setTextColor(WHITE);
            red.setTextColor(WHITE);
            yel.setTextColor(WHITE);
            in.setTextColor(WHITE);
            if (t == 2) theme.setBackgroundColor(BLUE);
            else if (t == 3) theme.setBackgroundColor(RED);
            else if (t == 5) theme.setBackgroundColor(BLACK);
        }
        //Allows user to set theme
        def.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (temp!=0) {
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

                    temp = 0;
                }
                else{
                    def.setSelected(true);
                    def.setChecked(true);
                    temp = 0;
                }

            }
        });
        green.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(temp!=1) {
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
                    temp = 1;
                }
                else{
                    def.setSelected(true);
                    def.setChecked(true);
                    green.setSelected(false);
                    green.setChecked(false);
                    temp = 0;
                }
            }
        });
        blue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(temp!=2) {
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
                    temp = 2;
                }
                else{
                    def.setSelected(true);
                    blue.setSelected(false);
                    def.setChecked(true);
                    blue.setChecked(false);
                    temp = 0;
                }
            }
        });
        red.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (temp!=3) {
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
                    temp = 3;
                }
                else{
                    def.setSelected(true);
                    def.setChecked(true);
                    red.setChecked(false);
                    red.setSelected(false);
                    temp = 0;
                }
            }
        });
        yel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (temp!=4) {
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
                    temp = 4;
                }
                else{
                    def.setSelected(true);
                    def.setChecked(true);
                    yel.setChecked(false);
                    yel.setSelected(false);
                    temp = 0;
                }
            }
        });
        in.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (temp!=5) {
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
                    temp = 5;
                }
                else{
                    def.setSelected(true);
                    def.setChecked(true);
                    in.setChecked(false);
                    in.setSelected(false);
                    temp = 0;
                    theme.setBackgroundColor(WHITE);

                }
            }
        });
        set.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                t = temp;
                if (t==0 ||t == 1|| t == 4){
                    themetitle.setTextColor(BLACK);
                    def.setTextColor(BLACK);
                    green.setTextColor(BLACK);
                    blue.setTextColor(BLACK);
                    red.setTextColor(BLACK);
                    yel.setTextColor(BLACK);
                    in.setTextColor(BLACK);
                    if (t == 0) theme.setBackgroundColor(WHITE);
                    else if (t == 1) theme.setBackgroundColor(GREEN);
                    else if (t == 4) theme.setBackgroundColor(YELLOW);
                }
                else if (t==2 ||t == 3|| t == 5){
                    themetitle.setTextColor(WHITE);
                    def.setTextColor(WHITE);
                    green.setTextColor(WHITE);
                    blue.setTextColor(WHITE);
                    red.setTextColor(WHITE);
                    yel.setTextColor(WHITE);
                    in.setTextColor(WHITE);
                    if (t == 2) theme.setBackgroundColor(BLUE);
                    else if (t == 3) theme.setBackgroundColor(RED);
                    else if (t == 5) theme.setBackgroundColor(BLACK);
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

    public void menu(int a){
        if (a ==R.id.action_log){
            Intent intentl = new Intent(Themes.this,LoginActivity.class);
            startActivity(intentl);
        }
        else if (a == R.id.action_create){
            Intent intentc = new Intent(Themes.this,CreateActivity.class);
            startActivity(intentc);
        }
        else if (a == R.id.action_suggest){
            //Does not work yet, there is no suggest activity

            //Intent intents = new Intent(Settings.this,MainActivity.class);
            //startActivity(intents);
        }
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