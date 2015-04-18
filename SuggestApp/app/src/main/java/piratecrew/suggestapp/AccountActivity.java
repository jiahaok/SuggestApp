package piratecrew.suggestapp;


import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;


public class AccountActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);
        findViewById(R.id.button4).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Intent intent = new Intent(AccountActivity.this, TermsAndServices.class);
                //startActivity(intent);
            }
        });


        findViewById(R.id.signup).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username  = ((EditText) findViewById(R.id.email   )).getText().toString();
                String password  = ((EditText) findViewById(R.id.password)).getText().toString();
                String checkPassword = ((EditText) findViewById(R.id.rePassword)).getText().toString();
                TextView status = (TextView) findViewById(R.id.status);


                if(username.equals("") || password.equals(""))
                    status.setText("Must have username and password");
                else if(!password.equals(checkPassword))
                    status.setText("Email doesn't match");
                else if(!((RadioButton) findViewById(R.id.radioButton)).isChecked())
                    status.setText("Must agree to terms of use");
                else
                    DatabaseConnection.createUser(username, password, status);


            }
        });




    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_account, menu);
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
