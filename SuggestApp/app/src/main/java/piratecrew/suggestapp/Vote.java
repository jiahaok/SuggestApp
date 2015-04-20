package piratecrew.suggestapp;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Button;
import android.widget.TextView;


public class Vote extends ActionBarActivity {

    private ImageButton imageButtonLeft, imageButtonRight;
    private TextView leftField, rightField;
    private Button skip;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vote);
        //methods star here:
        setImageButtonLeft();
        setImageButtonRight();
        setLeftField();
        setRightField();
        setSkip();
    }

    public void setLeftField(){
        leftField = (TextView) findViewById(R.id.leftTextField);
    }

    public void setRightField(){
        rightField = (TextView) findViewById(R.id.rightTextField);
    }

    public void setImageButtonLeft(){
        imageButtonLeft = (ImageButton)findViewById(R.id.imageButtonLeft);
        imageButtonLeft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    public void setImageButtonRight(){
        imageButtonRight = (ImageButton)findViewById(R.id.imageButtonRight);
        imageButtonRight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    public void setSkip(){
        skip = (Button)findViewById(R.id.skip);
        skip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_vote, menu);
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
