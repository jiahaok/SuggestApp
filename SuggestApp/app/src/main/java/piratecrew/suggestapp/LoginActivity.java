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
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        final TextView status = (TextView)findViewById(R.id.status);
        final EditText username = (EditText)findViewById(R.id.username);
        final EditText password =(EditText)findViewById(R.id.password);
        Button login = (Button)findViewById(R.id.login);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            String usernameField = username.getText().toString();
            String usernameField = password.getText().toString();
            public void onClick(View v) {
                /*for(int i = 0; i<= 1; i++) {
                    if (username.equals("username")) {

                        if (password.equals("1234")) {
                            status.setText("logedin");
                        }
                        else {
                            status.setText("incorrect login");
                            break;
                        }



                    } else {
                        status.setText("incorrect login");
                        break;

                    }
                }*/
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
