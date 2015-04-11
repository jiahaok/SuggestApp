package piratecrew.suggestapp;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.FileInputStream;
import java.io.FileOutputStream;


public class LogoutActivity extends MainActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(theme);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logout);
        TextView user = (TextView) findViewById(R.id.LogText);

        //finds and displays username
        try {
            FileInputStream fin = openFileInput("Login");
            LoginActivity.temp = "";
            while ((LoginActivity.c = fin.read()) != -1) {
                LoginActivity.temp = LoginActivity.temp + Character.toString((char) LoginActivity.c);
            }
            Log.i("Data Read", LoginActivity.temp);
            fin.close();
            user.setText("You are logged in as: " +  LoginActivity.temp);
        } catch (Exception e) {
            Log.e("error", Log.getStackTraceString(e));
            LoginActivity.temp = "";
        }
        LoginActivity.temp = "";

        //When the logout button is pressed, the user is logged out, the files are "cleared", and...
        //...the user is taken back to the login page.
        Button logout = (Button) findViewById(R.id.logout);
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.db = new DatabaseConnection(null, null, null, true);
                loggedIn = false;
                writeFile("", "Login");
                writeFile("","Password");
                startActivity(new Intent(LogoutActivity.this,LoginActivity.class));
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_logout, menu);
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
    //file writing function for logging out
    public void writeFile(String data,String file){
        try {
            FileOutputStream fOut = openFileOutput(file, MODE_PRIVATE);
            fOut.write(data.getBytes());
            fOut.close();

        } catch(Exception e) {
            Log.e("error", Log.getStackTraceString(e));
        }
    }
}
