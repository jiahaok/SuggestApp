package piratecrew.suggestapp;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Button;
import android.widget.TextView;


public class LoginActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        switch (Themes.t){
            case 1:{
                setTheme(android.R.style.Theme_Holo_NoActionBar);
                break;
            }
            case 2:{
                setTheme(android.R.style.Theme_DeviceDefault_Light_NoActionBar);
                break;
            }
            case 3:{
                setTheme(android.R.style.Theme_DeviceDefault_Wallpaper_NoTitleBar);
                break;
            }
            default: setTheme(android.R.style.Theme_DeviceDefault_NoActionBar);
        }
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        final TextView status = (TextView)findViewById(R.id.status);
        final EditText username = (EditText)findViewById(R.id.username);
        final EditText password =(EditText)findViewById(R.id.password);
        Button login = (Button)findViewById(R.id.login);
        login.setOnClickListener(new View.OnClickListener() {


            public void onClick(View v) {
                String usernameField = username.getText().toString();
                String passwordField = password.getText().toString();
                for(int i = 0; i<= 1; i++) {
                    if (usernameField.equals("username")) {

                        if (passwordField.equals("1234")) {
                            status.setText("Logged In");
                        }
                        else {
                            status.setText("Wrong Log-In");
                        }

                    } else {
                        status.setText("Wrong Log-In");

                    }
              }
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

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
