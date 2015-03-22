package piratecrew.suggestapp;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.view.View.OnClickListener;
import android.content.Intent;


public class login extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        final EditText usernameField = (EditText)findViewById(R.id.username);
        //final String username = usernameField.getText().toString();
        final EditText passwordField = (EditText)findViewById(R.id.password);

        final TextView status = (TextView)findViewById(R.id.status);
        Button back = (Button)findViewById(R.id.back);
        back.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(login.this,MainActivity.class);
            }
        });

        Button logButton = (Button)findViewById(R.id.loginButton);
        logButton.setOnClickListener(new OnClickListener(){
            @Override
            public void onClick(View v) {
                String username = usernameField.getText().toString();
                String password = passwordField.getText().toString();
                //status.setText(username);
                for(int i = 0; i<= 1; i++) {
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
