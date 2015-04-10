package piratecrew.suggestapp;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


public class ThemesActivity extends MainActivity {

    private int temp;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        setTheme(theme);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_themes);


        Button set = (Button) findViewById(R.id.set_theme);
        set.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                theme = temp;
                recreate();
            }
        });
    }

    //Code is ran whenever a radio button is pressed. View is the button that was pressed.
    public void onRadioButtonClicked(View v){
        switch(v.getId()){
            case R.id.def:
                temp = android.R.style.Theme_DeviceDefault_NoActionBar;
                break;
            case R.id.holo:
                temp = android.R.style.Theme_Holo_NoActionBar;
                break;
            case R.id.light:
                temp = android.R.style.Theme_DeviceDefault_Light_NoActionBar;
                break;
            case R.id.wall:
                temp = android.R.style.Theme_DeviceDefault_Wallpaper_NoTitleBar;
                break;
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
        menu(id);



        return super.onOptionsItemSelected(item);
    }
}