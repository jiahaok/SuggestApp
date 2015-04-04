package piratecrew.suggestapp;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Button;
import android.widget.TextView;


public class LoginActivity extends ActionBarActivity {
    static int before = 0;

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

    public void menu(int a){
        if (a ==R.id.action_about){
            AboutActivity.before = 2;
            startActivity(new Intent(LoginActivity.this,AboutActivity.class));
        }
        else if (a ==R.id.action_stats){
            StatsActivity.before = 2;
            startActivity(new Intent(LoginActivity.this,StatsActivity.class));
        }
        else if (a ==R.id.action_themes){
            Themes.before = 2;
            startActivity(new Intent(LoginActivity.this,Themes.class));
        }
        else  if (a ==R.id.action_main) startActivity(new Intent(LoginActivity.this,MainActivity.class));

        else{
            if (before == 0)startActivity(new Intent(LoginActivity.this,AboutActivity.class));
            if (before == 1)startActivity(new Intent(LoginActivity.this,CreateActivity.class));
            if (before == 3)startActivity(new Intent(LoginActivity.this,MainActivity.class));
            if (before == 4)startActivity(new Intent(LoginActivity.this,StatsActivity.class));
            if (before == 5)startActivity(new Intent(LoginActivity.this,Themes.class));
        }

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
}
