package piratecrew.suggestapp.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Log;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import piratecrew.suggestapp.R;
import piratecrew.suggestapp.Util.FileHandler;

public class CreateActivity extends ResponsiveActivity implements Runnable {
    //variables start here:
    private Spinner spinnerDay, spinnerHour, spinnerMinute;
    int requestCodeRun, resultCodeRun, dayValue, hourValue, minuteValue;
    Intent dataRun;
    Button create;
    EditText text1, text2;
    Bitmap thumb, bit;
    //end of variable

    @Override
    public void run() {
        super.onActivityResult(requestCodeRun, resultCodeRun, dataRun);
        if (resultCodeRun == RESULT_OK) {
            if (requestCodeRun == 1) {   //took a photo
                File f = new File(Environment.getExternalStorageDirectory().toString());
                for (File temp : f.listFiles()) {
                    if (temp.getName().equals("temp.jpg")) {
                        f = temp;
                        break;
                    }
                }
                try {
                    Bitmap bitmap;
                    BitmapFactory.Options bitmapOptions = new BitmapFactory.Options();
                    bitmap = BitmapFactory.decodeFile(f.getAbsolutePath(),bitmapOptions);
                    bit = bitmap;
                    runOnUiThread(new Runnable(){
                        @Override
                        public void run() {
                            ((ImageView) findViewById(imageToSet)).setImageBitmap(bit);
                        }
                    });

                    String path = android.os.Environment
                            .getExternalStorageDirectory()
                            + File.separator
                            + "createAct" + File.separator + "default"; //create the file name
                    f.delete();
                    OutputStream outFile = null;
                    File file = new File(path, String.valueOf(System.currentTimeMillis()) + ".jpg");
                    try {
                        outFile = new FileOutputStream(file);
                        bitmap.compress(Bitmap.CompressFormat.JPEG, 85, outFile); //compress captured image
                        outFile.flush();
                        outFile.close();
                    } catch (FileNotFoundException e) { //idk what these are it just had to be there
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
            else if (requestCodeRun == 2) {    //choose photo

                Uri selectedImage = dataRun.getData();
                String[] filePath = {MediaStore.Images.Media.DATA};
                Cursor c = getContentResolver().query(selectedImage, filePath, null, null, null);
                c.moveToFirst();
                int columnIndex = c.getColumnIndex(filePath[0]);
                String picturePath = c.getString(columnIndex);
                c.close();
                Bitmap thumbnail = (BitmapFactory.decodeFile(picturePath));
                OutputStream compressThumbnail = null;
                try {
                    compressThumbnail = new FileOutputStream(picturePath);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
                thumbnail.compress(Bitmap.CompressFormat.JPEG,85,compressThumbnail); //use to compress the display image
                Log.w("image path:", picturePath + "");
                thumb = thumbnail;
                runOnUiThread(new Runnable(){
                    @Override
                    public void run() {
                        ((ImageView) findViewById(imageToSet)).setImageBitmap(thumb);
                    }
                });

            }
        }
        Log.i("Running", "Thread is running");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create);

        text1 = (EditText) findViewById(R.id.editText1);
        text2 = (EditText) findViewById(R.id.editText2);

        setSpinners();
        setButtons();

    }

    public void setButtons(){
        //left upload button
        findViewById(R.id.uploadLeft).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectImage(R.id.imageViewLeft);
            }
        });
        // right upload button
        findViewById(R.id.uploadRight).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectImage(R.id.imageViewRight);
            }
        });
        //Submit button
        create =(Button)findViewById(R.id.create);
        create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Turn the time into milliseconds
                long time = 60_000 * (minuteValue + 60 * (hourValue + 24 * dayValue));

                for(byte i = 0;i<=1;i++) {
                    //TODO: add code to verify inputs and upload to server

                    //Verify that there is a length of time selected
                    if (time == 0) {
                        showToast("Can not Be 0 minutes.");
                        break;
                    }
                        //If no database has been made, or if one was made and isn't logged in, log in.
                    else if (db == null || db.loggedOut()) {
                        startActivity(new Intent(CreateActivity.this, LoginActivity.class));
                        break;
                    }
                        //TODO add additional verification for text boxes
                    else if (text1.getText().toString().equals("") || text2.getText().toString().equals("")) {
                        showToast("Must describe both options.");
                        break;
                    }
                    else {

                    }

                    db.createPoll(text1.getText().toString(),
                            text2.getText().toString(),
                            null, null, time);
                }
            }
        });
    }

    void showToast(CharSequence msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

    public void setSpinners() {
        ArrayAdapter<CharSequence> adapter;
        spinnerDay = (Spinner) findViewById(R.id.spinnerDay);
        adapter = ArrayAdapter.createFromResource(this,
                R.array.spinner_day,
                android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerDay.setAdapter(adapter);
        spinnerDay.setOnItemSelectedListener(  //a on listener for spinners
                new OnItemSelectedListener() {  //<---self explanatory
                    public void onItemSelected(AdapterView<?> parent, View view, int pos, long id){ // save the spinner position to dayPosition and id to dayId
                        //Take the spinner, get the selected panel, read the panel's text,
                        //remove all non-number parts of that text, and convert into an int.
                        dayValue = Integer.parseInt(parent
                                .getItemAtPosition(pos)
                                .toString()
                                .replaceAll("[^0-9]", "")); // save to a class wide variable so all method can use it
                    }
                    public void onNothingSelected(AdapterView<?> parent) { // this is for if nothing is selected, which is impossible for this app
                        showToast("ERROR: day: unselected"); //display those little dark flippy text on the bottom
                    }
                });
                //code below repeats the exact same thing except with different variable
        spinnerHour = (Spinner) findViewById(R.id.spinnerHour);
        adapter = ArrayAdapter.createFromResource(this,
                R.array.spinner_hour,
                android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerHour.setAdapter(adapter);
        spinnerHour.setOnItemSelectedListener(
                new OnItemSelectedListener() {
                    public void onItemSelected(AdapterView<?> parent, View view, int pos, long id){
                        //Take the spinner, get the selected panel, read the panel's text,
                        //remove all non-number parts of that text, and convert into an int.
                        hourValue = Integer.parseInt(parent
                                .getItemAtPosition(pos)
                                .toString()
                                .replaceAll("[^0-9]", "")); // save to a class wide variable so all method can use it
                    }
                    public void onNothingSelected(AdapterView<?> parent) {
                        showToast("ERROR: hour = unselected");
                    }
                });
        spinnerMinute = (Spinner) findViewById(R.id.spinnerMinute);
        adapter = ArrayAdapter.createFromResource(this,
                R.array.spinner_minute,
                android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerMinute.setAdapter(adapter);
        spinnerMinute.setSelection(1); // set the default position to be 5 minute
        spinnerMinute.setOnItemSelectedListener(
                new OnItemSelectedListener() {
                    public void onItemSelected(AdapterView<?> parent, View view, int pos, long id){
                        //Take the spinner, get the selected panel, read the panel's text,
                        //remove all non-number parts of that text, and convert into an int.
                        minuteValue =  Integer.parseInt(parent
                                .getItemAtPosition(pos)
                                .toString()
                                .replaceAll("[^0-9]", "")); // save to a class wide variable so all method can use it
                    }
                    public void onNothingSelected(AdapterView<?> parent) {
                        showToast("ERROR: minute = unselected");
                    }
                });
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_create, menu);
        if (loggedIn == true) menu.findItem(R.id.action_login).setTitle("Log Out");
        else menu.findItem(R.id.action_login).setTitle("Log In");
        return true;
    }


    int imageToSet;
    private void selectImage(int im) { // select image button
        //im is the right image id when the right button is pressed.
        //im is the left  image id when the left  button is pressed.
        imageToSet = im;

        //Build prompt to take a photo
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(R.string.photo_dialog_title);
        builder.setItems(R.array.photo_options, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int item) {
                Intent intent;
                switch(item){
                    //Take a photo
                    case 0:
                        intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                        File f = new File(android.os.Environment.getExternalStorageDirectory(), "temp.jpg");
                        intent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(f));
                        startActivityForResult(intent, 1);
                        break;
                    //Chose a photo from gallery
                    case 1:
                        intent = new Intent(Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                        startActivityForResult(intent, 2);
                        break;
                    case 2:
                        dialog.cancel();
                }
            }
        });
        builder.show();
    }

    public void onWebResponse(int code, int isError) {
        {
            TextView status = (TextView) findViewById(R.id.status);
            if(isError == 1){ //If an error came up...
                if(code == 0)
                    status.setText("There's a problem with the server. Try again later!");
                else if (code == 1)
                    status.setText("There might be a problem with what you submitted.");
            }
            else if (isError == 0){//If server succeeded but didn't process request completely
                if(code == 0)
                    status.setText("Question Created");
            }

        }
    }
}