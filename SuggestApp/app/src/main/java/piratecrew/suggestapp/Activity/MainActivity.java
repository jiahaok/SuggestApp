package piratecrew.suggestapp.Activity;


import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import piratecrew.suggestapp.Util.DatabaseConnection;
import piratecrew.suggestapp.Util.FileHandler;
import piratecrew.suggestapp.R;


public class MainActivity extends AbstractActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //If the user is logged in, loggedIn is set to true
        if (FileHandler.readFile("Login") != ""){
            loggedIn = true;
            DatabaseConnection.sessionId = FileHandler.readFile("Login");
        }
        //otherwise, loggedIn is set to false
        else{
            loggedIn = false;
        }
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



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        if (loggedIn == true) menu.findItem(R.id.action_login).setTitle("Log Out");
        else menu.findItem(R.id.action_login).setTitle("Log In");
        return true;
    }
}
