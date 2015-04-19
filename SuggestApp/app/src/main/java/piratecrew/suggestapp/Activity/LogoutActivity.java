package piratecrew.suggestapp.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import piratecrew.suggestapp.Util.DatabaseConnection;
import piratecrew.suggestapp.Util.FileHandler;
import piratecrew.suggestapp.R;


public class LogoutActivity extends AbstractActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logout);
        TextView user = (TextView) findViewById(R.id.LogText);

        //finds and displays username
        user.setText("You are logged in as: " + FileHandler.readFile("Username"));
        //When the logout button is pressed, the user is logged out, the files are "cleared", and...
        //...the user is taken back to the login page.
        Button logout = (Button) findViewById(R.id.logout);
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatabaseConnection.sessionId = null;
                loggedIn = false;
                FileHandler.writeFile("", "Login");
                FileHandler.writeFile("", "Username");
                toast = Toast.makeText(getApplicationContext(), "Not logged in.",
                        Toast.LENGTH_LONG);
                toast.setGravity(Gravity.TOP | Gravity.CENTER, 0, 180);
                toast.show();
                startActivity(new Intent(LogoutActivity.this,MainActivity.class));
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_logout, menu);
        return true;
    }
}
