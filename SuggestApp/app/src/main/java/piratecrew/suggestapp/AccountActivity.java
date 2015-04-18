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

import java.lang.reflect.Array;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class AccountActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);
        findViewById(R.id.button4).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AccountActivity.this, TermsAndServices.class);
                startActivity(intent);
            }
        });
        //start local variable declaration
         boolean emailIsUsed = true;
        //end local variable declaration

        findViewById(R.id.signup).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username  = ((EditText) findViewById(R.id.email   )).getText().toString();
                String rPassword = ((EditText) findViewById(R.id.rePassword)).getText().toString();
                String password  = ((EditText) findViewById(R.id.password)).getText().toString();
                TextView status = (TextView) findViewById(R.id.status);

                for(short x = 0; x<=1; x++) {

                    if (username.equals(null)) {//check if email field is empty
                        status.setText("Please enter your Email");
                        break;
                    }
                    else if (!validEmail(username)){// check the email format
                        status.setText("Email is not valid");
                    }
                    else if (!serverEmailCheckUsed()) {//check if email is used
                        status.setText("Email have already been used");
                        break;
                    }
                    else if (password.equals(null) || password.length() < 6) {//check if password is empty or less than 6 character
                        status.setText("Please choose a password 6 character or longer");
                        break;
                    }
                    else if (password.equalsIgnoreCase(rPassword)) {//check retyped password
                        status.setText("Password does not match");
                        break;
                    }
                    else if (!((RadioButton) findViewById(R.id.radioButton)).isChecked()) {//check term of use agreement
                        status.setText("Must agree to terms of use");
                        break;
                    }

                    submitAccountInfo(username,password);


                }

            }

        });

    }

    public void submitAccountInfo(String username, String password){
        String usernameSend = username;
        String passwordSend = password;
        String[] send = new String[1];
        send[0]=usernameSend;
        send[1]=passwordSend;
        //Todo: send the send String Array to server
    }

    public static boolean validEmail(String username) {
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
        boolean serverEmailCheckBooleanReturn = false;// true = not used, false = used
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
