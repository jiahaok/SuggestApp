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
        showToast = false;
        setTheme(theme);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logout);
        TextView user = (TextView) findViewById(R.id.LogText);

        //finds and displays username
        user.setText("You are logged in as: " + FileSingleton.readFile("Username"));
        //When the logout button is pressed, the user is logged out, the files are "cleared", and...
        //...the user is taken back to the login page.
        Button logout = (Button) findViewById(R.id.logout);
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatabaseConnection.sessionId = null;
                loggedIn = false;
                FileSingleton.writeFile("", "Login");
                FileSingleton.writeFile("","Username");
                showToast = true;
                startActivity(new Intent(LogoutActivity.this,MainActivity.class));
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
}
