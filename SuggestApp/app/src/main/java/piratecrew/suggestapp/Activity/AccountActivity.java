package piratecrew.suggestapp.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import piratecrew.suggestapp.Util.DatabaseConnection;
import piratecrew.suggestapp.R;


public class AccountActivity extends AbstractActivity implements Runnable{

    //beginning of private variable declaration
    private String PUsername, PPassword,PRPassword;
    private String SUsername,SPassword; // SUsername = send username, SPassword = send password
    //end of private variable declaration

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);
        findViewById(R.id.button4).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*
                Intent intent = new Intent(AccountActivity.this, TermsAndServices.class);
                startActivity(intent);
                */
            }
        });


        findViewById(R.id.signup).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username  = ((EditText) findViewById(R.id.email   )).getText().toString();
                String password  = ((EditText) findViewById(R.id.password)).getText().toString();
                String rPassword = ((EditText) findViewById(R.id.rPassword)).getText().toString();
                TextView status = (TextView) findViewById(R.id.status);
                PUsername = username;
                PPassword = password;
                PRPassword = rPassword;

                run();

                DatabaseConnection.createUser(SUsername, SPassword, null);
                startActivity(new Intent(AccountActivity.this, LoginActivity.class));                }

        });

    }
    public void run(){
        for (short i = 0; i <= 1; i++) {

            if (PUsername.equals("")) {//check if email field is empty
                toast.setText("Please enter your Email");
                break;
            } else if (!validEmail(PUsername)) {// check the email format
                toast.setText("Email is not valid");
            } else if (!serverEmailCheckUsed()) {//check if email is used
                toast.setText("Email have already been used");
                break;
            } else if (PPassword.equals("") || PPassword.length() < 6) {//check if password is empty or less than 6 character
                toast.setText("Please choose a password 6 character or longer");
                break;
            } else if (PPassword != PRPassword) {//check retyped password
               // toast.setText("Password does not match");
                break;
            } else if (!((RadioButton) findViewById(R.id.radioButton)).isChecked()) {//check term of use agreement
                toast.setText("Must agree to terms of use");
                break;
            }
            else if (PPassword == PRPassword) {
                SUsername = PUsername;
                SPassword = PPassword;
            }
        }
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
        boolean serverEmailCheckBooleanReturn = true;// true = used, false = not used
        //Todo: check email with server, also remove ^^ line
        return serverEmailCheckBooleanReturn;
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_account, menu);
        return true;
    }

}
