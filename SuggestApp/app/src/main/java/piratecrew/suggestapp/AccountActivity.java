package piratecrew.suggestapp;

import android.accounts.Account;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.text.Editable;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;


public class AccountActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);
        TextView status = (TextView)findViewById(R.id.textView2);
        Button signup = (Button)findViewById(R.id.signup);
        Button terms = (Button)findViewById(R.id.button4);
        RadioButton accept = (RadioButton)findViewById(R.id.radioButton);
        EditText emailn = (EditText)findViewById(R.id.email);
        String email = emailn.getText().toString();
        EditText reEmailn = (EditText)findViewById(R.id.reEmail);
        String reEmail = reEmailn.getText().toString();
        EditText passwordn = (EditText)findViewById(R.id.password);
        String password = passwordn.getText().toString();
        EditText birthdayn = (EditText)findViewById(R.id.birthday);
        String birthday = birthdayn.getText().toString();
        terms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AccountActivity.this, TermsAndServices.class);
                startActivity(intent);
            }
        });
        final boolean[] acceptOn = {false};
        accept.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                acceptOn[0] = true;
            }
        });

        if(email != " " || email != "" && reEmail != " " && email == reEmail && password != " " && birthday != " " && acceptOn.equals(true)){
            signup.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(AccountActivity.this,MainActivity.class);
                    startActivity(intent);
                }
            });
        }
        else{
            status.setText("YOU MUST FILL EVERY SINGLE BOX / RADIO BUTTON IN!");
            acceptOn.equals(false);
        }




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
