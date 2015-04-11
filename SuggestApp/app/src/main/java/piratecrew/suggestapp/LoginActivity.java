package piratecrew.suggestapp;


import java.io.FileOutputStream;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Button;
import android.widget.TextView;


public class LoginActivity extends MainActivity {
    static int before = 0;
    static int c;
    static String temp = "";
    static String temp2 = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        setTheme(theme);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        DatabaseConnection.l = this;

        //clears the files if the user is not logged in
        if (loggedIn == false){
            writeFile("","Login");
            writeFile("","Password");
        }

        final TextView status = (TextView) findViewById(R.id.status);
        final EditText username = (EditText) findViewById(R.id.username);
        final EditText password = (EditText) findViewById(R.id.password);

        Button login = (Button) findViewById(R.id.login);

        login.setOnClickListener(new View.OnClickListener() {


            public void onClick(View v) {
                DatabaseConnection.leave = true;
                String usernameField = username.getText().toString();
                String passwordField = password.getText().toString();

                MainActivity.db = new DatabaseConnection(usernameField, passwordField, status, false);
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_login, menu);
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

    //Writes a string to a file; is accessed by DatabaseConnection
    public void writeFile(String data,String file){
        try {
            FileOutputStream fOut = openFileOutput(file, MODE_PRIVATE);
            fOut.write(data.getBytes());
            fOut.close();

        } catch(Exception e) {
            Log.e("error", Log.getStackTraceString(e));
        }
    }
    //Allows DatabaseConnection to send user to the Logout Page
    public void leave(){
        startActivity(new Intent(LoginActivity.this,LogoutActivity.class));
    }

}
