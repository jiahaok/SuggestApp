package piratecrew.suggestapp;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import static android.graphics.Color.BLACK;
import static android.graphics.Color.BLUE;
import static android.graphics.Color.GREEN;
import static android.graphics.Color.RED;
import static android.graphics.Color.WHITE;
import static android.graphics.Color.YELLOW;


public class LoginActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        RelativeLayout log = (RelativeLayout) findViewById(R.id.logging);
        final TextView status = (TextView)findViewById(R.id.status);
        final EditText username = (EditText)findViewById(R.id.username);
        final EditText password =(EditText)findViewById(R.id.password);
        username.setBackgroundColor(WHITE);
        password.setBackgroundColor(WHITE);
        //Theme
        if (Themes.t==0 ||Themes.t == 1|| Themes.t == 4){
            if (Themes.t == 0) log.setBackgroundColor(WHITE);
            else if (Themes.t == 1) log.setBackgroundColor(GREEN);
            else if (Themes.t == 4) log.setBackgroundColor(YELLOW);
        }
        else if (Themes.t==2 ||Themes.t == 3|| Themes.t == 5){
            if (Themes.t == 2) log.setBackgroundColor(BLUE);
            else if (Themes.t == 3) log.setBackgroundColor(RED);
            else if (Themes.t == 5) log.setBackgroundColor(BLACK);
        }
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
