package piratecrew.suggestapp;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class StatsActivity extends MainActivity {
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
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        menu(id);


        return super.onOptionsItemSelected(item);
    }
}
