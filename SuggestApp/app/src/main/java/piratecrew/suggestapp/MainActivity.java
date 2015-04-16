package piratecrew.suggestapp;


import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.io.FileInputStream;


public class MainActivity extends ActionBarActivity {
    static protected DatabaseConnection db = null;
    //this variable shows if the user is logged in based on data read from files
    public static boolean loggedIn = false;
    Toast toast;
    public Boolean showToast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        setTheme(theme);
        try{
            if(showToast != false) showToast = true;
            else showToast = false;} catch (Exception e){ showToast = true;}

            super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //If the user is logged in, the program displays the username using a toast
            if (FileSingleton.readFile("Login") != ""){
                loggedIn = true;
                DatabaseConnection.sessionId = FileSingleton.readFile("Login");
                if (showToast == true) {
                    toast = Toast.makeText(getApplicationContext(), "Logged in as: " + FileSingleton.readFile("Username") + "",
                            Toast.LENGTH_LONG);
                    toast.setGravity(Gravity.TOP | Gravity.CENTER, 0, 180);
                    toast.show();
                }
            }
            //otherwise, the toast displays "Not logged in."
            else{
                loggedIn = false;
                if (showToast == true) {
                    toast = Toast.makeText(getApplicationContext(), "Not logged in.",
                            Toast.LENGTH_LONG);
                    toast.setGravity(Gravity.TOP | Gravity.CENTER, 0, 180);
                    toast.show();
                }
            }
        showToast = false;
        Button createBtn = (Button) findViewById(R.id.button);
        createBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, CreateActivity.class));
            }
        });
    }

    public void menu(int a){
        switch (a){
            case R.id.action_main:
                startActivity(new Intent(MainActivity.this, MainActivity.class));
                break;
            case R.id.action_login:
                if (loggedIn == true)startActivity(new Intent(MainActivity.this, LogoutActivity.class));
                else startActivity(new Intent(MainActivity.this, LoginActivity.class));
                break;
            case R.id.action_stats:
                startActivity(new Intent(MainActivity.this, StatsActivity.class));
                break;
            case R.id.action_themes:
                startActivity(new Intent(MainActivity.this, ThemesActivity.class));
                break;
            case R.id.action_about:
                startActivity(new Intent(MainActivity.this, AboutActivity.class));
                break;

        }
    }


    static int theme = android.R.style.Theme_DeviceDefault_NoActionBar;



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        if (loggedIn == true) menu.findItem(R.id.action_login).setTitle("Log Out");
        else menu.findItem(R.id.action_login).setTitle("Log In");
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
