package piratecrew.suggestapp;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import android.widget.RadioButton;


public class ThemesActivity extends MainActivity {

    public static int temp;
    static int before = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        setTheme(themes[theme]);

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
                theme = temp;
                recreate();
            }
        });
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
        menu(id);

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}