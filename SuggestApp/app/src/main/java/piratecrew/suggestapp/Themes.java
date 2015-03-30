package piratecrew.suggestapp;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import android.widget.RadioButton;


public class Themes extends ActionBarActivity {

    public static int t;
    public static int temp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        switch (t){
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
        setContentView(R.layout.activity_themes);
        //all buttons
        final RadioButton def = (RadioButton) findViewById(R.id.def);
        final RadioButton black = (RadioButton) findViewById(R.id.black);
        final RadioButton holo = (RadioButton) findViewById(R.id.lt);
        final RadioButton light = (RadioButton) findViewById(R.id.wall);
        Button set = (Button) findViewById(R.id.settheme);

        //Allows user to set theme
        def.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (temp!=0) {
                    def.setSelected(true);
                    def.setChecked(true);
                    black.setSelected(false);
                    black.setChecked(false);
                    light.setSelected(false);
                    light.setChecked(false);
                    holo.setSelected(false);
                    holo.setChecked(false);
                    temp = 0;
                }
                else{
                    def.setSelected(true);
                    def.setChecked(true);
                    temp = 0;
                }

            }
        });
        black.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (temp != 1) {
                    light.setSelected(false);
                    light.setChecked(false);
                    holo.setSelected(false);
                    holo.setChecked(false);
                    def.setSelected(false);
                    def.setChecked(false);
                    temp = 1;
                } else {
                    def.setSelected(true);
                    def.setChecked(true);
                    black.setSelected(false);
                    black.setChecked(false);
                    temp = 0;
                }
            }
        });
        holo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (temp != 2) {
                    holo.setSelected(true);
                    holo.setChecked(true);
                    light.setSelected(false);
                    black.setSelected(false);
                    def.setSelected(false);
                    light.setChecked(false);
                    black.setChecked(false);
                    def.setChecked(false);
                    temp = 2;
                } else {
                    def.setSelected(true);
                    holo.setSelected(false);
                    def.setChecked(true);
                    holo.setChecked(false);
                    temp = 0;
                }
            }
        });
        light.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (temp != 3) {
                    black.setSelected(false);
                    holo.setSelected(false);
                    def.setSelected(false);
                    black.setChecked(false);
                    holo.setChecked(false);
                    def.setChecked(false);
                    temp = 3;
                } else {
                    def.setSelected(true);
                    def.setChecked(true);
                    light.setChecked(false);
                    light.setSelected(false);
                    temp = 0;
                }
            }
        });

        set.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                t = temp;
                temp= 6;
                Intent reset = new Intent(Themes.this,Themes.class);
                startActivity(reset);
            }
        });
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