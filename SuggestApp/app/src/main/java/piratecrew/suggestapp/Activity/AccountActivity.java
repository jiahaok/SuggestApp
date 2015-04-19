package piratecrew.suggestapp.Activity;


import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import piratecrew.suggestapp.Util.DatabaseConnection;
import piratecrew.suggestapp.R;


public class AccountActivity extends AbstractActivity implements Runnable {

    //beginning of private variable declaration
    private String SUsername,SPassword; // SUsername = send username, SPassword = send password
    //private String setStatus;
    //end of private variable declaration

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
                String rPassword = ((EditText) findViewById(R.id.rPassword)).getText().toString();
                TextView status = (TextView) findViewById(R.id.status);


                for(short x = 0; x<=1; x++) {

                    if (username.equals(null)) {//check if email field is empty
                        status.setText("Please enter your Email");
                        break;
                    } else if (!validEmail(username)) {// check the email format
                        status.setText("Email is not valid");
                    } else if (!serverEmailCheckUsed()) {//check if email is used
                        status.setText("Email have already been used");
                        break;
                    } else if (password.equals(null) || password.length() < 6) {//check if password is empty or less than 6 character
                        status.setText("Please choose a password 6 character or longer");
                        break;
                    } else if (password.equalsIgnoreCase(rPassword)) {//check retyped password
                        status.setText("Password does not match");
                        break;
                    } else if (!((RadioButton) findViewById(R.id.radioButton)).isChecked()) {//check term of use agreement
                        status.setText("Must agree to terms of use");
                        break;
                    }
                    SUsername = username;
                    SPassword = password;
                    run();// run the create user method on a separate thread
                }

            }
        });

    }

    public void submitAccountInfo(String username, String password){
        //turns the string into an array and send to server
        String usernameSend = username;
        String passwordSend = password;
        String[] send = new String[1];
        send[0]=usernameSend;
        send[1]=passwordSend;
        //Todo: send the send String Array to server
    }

    public static boolean validEmail(String username) {//method to validate the email format
        boolean valid;

        String expression = "^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$"; // regex code for email format(i hate this)
        CharSequence usernameIn = username;
        //check format
        Pattern pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(usernameIn);
        if (matcher.matches()) {
            valid = true;
        }
        else{
            valid = false;
        }

        return valid;
    }

    public boolean serverEmailCheckUsed(){ //check if email is used
        boolean serverEmailCheckBooleanReturn = false;// true = used, false = not used
        //Todo: check email with server, also remove ^^ line
        return serverEmailCheckBooleanReturn;
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_account, menu);
        return true;
    }

    @Override
    public void run() { // runs the DatabaseConnection createUser on different thread
        DatabaseConnection.createUser(SUsername, SPassword, null);
        String tempStatus;
        MainActivity.db = new DatabaseConnection(SUsername,SPassword,null);
    }
}
