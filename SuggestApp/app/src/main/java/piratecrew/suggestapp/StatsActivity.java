package piratecrew.suggestapp;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class StatsActivity extends MainActivity {
    static int before = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        showToast = false;
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
}
