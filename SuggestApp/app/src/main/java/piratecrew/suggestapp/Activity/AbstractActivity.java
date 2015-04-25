package piratecrew.suggestapp.Activity;


import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import piratecrew.suggestapp.Util.DatabaseConnection;
import piratecrew.suggestapp.R;
import piratecrew.suggestapp.Util.FileHandler;

abstract class AbstractActivity extends ActionBarActivity {
    static protected DatabaseConnection db = new DatabaseConnection();
    //this variable shows if the user is logged in based on data read from files
    public static boolean loggedIn = false;
    Toast toast;
    static int theme = android.R.style.Theme_DeviceDefault_NoActionBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(theme);
        super.onCreate(savedInstanceState);
    }

    public void menu(int a){
        switch (a){
            case R.id.action_main:
                startActivity(new Intent(AbstractActivity.this, MainActivity.class));
                break;
            case R.id.action_login:
                if (loggedIn == true)startActivity(new Intent(AbstractActivity.this, LogoutActivity.class));
                else startActivity(new Intent(AbstractActivity.this, LoginActivity.class));
                break;
            case R.id.action_stats:
                startActivity(new Intent(AbstractActivity.this, StatsActivity.class));
                break;
            case R.id.action_themes:
                startActivity(new Intent(AbstractActivity.this, ThemesActivity.class));
                break;
            case R.id.action_about:
                startActivity(new Intent(AbstractActivity.this, AboutActivity.class));
                break;

        }
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
