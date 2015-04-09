package piratecrew.suggestapp;


import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


public class MainActivity extends ActionBarActivity {
    static protected DatabaseConnection db = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        setTheme(theme);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button createBtn = (Button) findViewById(R.id.button);
        createBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, CreateActivity.class));
            }
        });
    }

    public void menu(int a){
        switch (a){
            case R.id.action_main:
                startActivity(new Intent(MainActivity.this, MainActivity.class));
                break;
            case R.id.action_login:
                startActivity(new Intent(MainActivity.this, LoginActivity.class));
                break;
            case R.id.action_stats:
                startActivity(new Intent(MainActivity.this, StatsActivity.class));
                break;
            case R.id.action_themes:
                startActivity(new Intent(MainActivity.this, ThemesActivity.class));
                break;
            case R.id.action_about:
                startActivity(new Intent(MainActivity.this, AboutActivity.class));
                break;

        }
    }


    static int theme = android.R.style.Theme_DeviceDefault_NoActionBar;



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
