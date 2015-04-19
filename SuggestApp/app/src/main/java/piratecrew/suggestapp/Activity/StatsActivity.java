package piratecrew.suggestapp.Activity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import piratecrew.suggestapp.R;

public class StatsActivity extends AbstractActivity {
    static int before = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(theme);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stats);

    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_stats, menu);
        if (loggedIn == true) menu.findItem(R.id.action_login).setTitle("Log Out");
        else menu.findItem(R.id.action_login).setTitle("Log In");
        return true;
    }
}
