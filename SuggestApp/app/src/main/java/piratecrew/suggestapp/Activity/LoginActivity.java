package piratecrew.suggestapp.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import piratecrew.suggestapp.Util.DatabaseConnection;
import piratecrew.suggestapp.Util.FileHandler;
import piratecrew.suggestapp.R;


public class LoginActivity extends AbstractActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        FileHandler.l = this;

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
                startActivity(new Intent(LoginActivity.this, AccountActivity.class));
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_login, menu);
        return true;
    }
    //Allows DatabaseConnection to send user to the main Page
    public void leave(){
        toast = Toast.makeText(getApplicationContext(), "Logged in as: " + FileHandler.readFile("Username") + "",
                Toast.LENGTH_LONG);
        toast.setGravity(Gravity.TOP | Gravity.CENTER, 0, 180);
        toast.show();
        startActivity(new Intent(LoginActivity.this,MainActivity.class));
    }

}
