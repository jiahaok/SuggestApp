package piratecrew.suggestapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


public class LoginActivity extends MainActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        showToast = false;

        setTheme(theme);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        FileSingleton.l = this;

        final TextView status = (TextView) findViewById(R.id.status);
        final EditText username = (EditText) findViewById(R.id.username);
        final EditText password = (EditText) findViewById(R.id.password);

        Button login = (Button) findViewById(R.id.login);

        login.setOnClickListener(new View.OnClickListener() {


            public void onClick(View v) {
                DatabaseConnection.leave = true;
                String usernameField = username.getText().toString();
                String passwordField = password.getText().toString();

                MainActivity.db = new DatabaseConnection(usernameField, passwordField, status);
            }
        });
        //Link to CreateAccount page
        TextView createAccount = (TextView) findViewById(R.id.CreateAccountLink);
        createAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Sorry, this option is not available yet.",
                        Toast.LENGTH_SHORT).show();
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
    //Allows DatabaseConnection to send user to the main Page
    public void leave(){
        showToast = true;
        startActivity(new Intent(LoginActivity.this,MainActivity.class));
    }

}
