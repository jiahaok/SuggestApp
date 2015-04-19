package piratecrew.suggestapp.Activity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import piratecrew.suggestapp.R;


public class AboutActivity extends AbstractActivity {

    public static int before;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_about, menu);
        if (loggedIn == true) menu.findItem(R.id.action_login).setTitle("Log Out");
        else menu.findItem(R.id.action_login).setTitle("Log In");
        return true;
    }


}
