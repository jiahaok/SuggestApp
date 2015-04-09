package piratecrew.suggestapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
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
import android.widget.Toast;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class CreateActivity extends MainActivity implements Runnable {
    //variables start here:
    private Spinner spinnerDay, spinnerHour, spinnerMinute;
    int requestCodeRun, resultCodeRun, dayPositionP, hourPositionP, minutePositionP;
    long dayIdP, hourIdP, minuteIdP;
    Intent dataRun;
    Button create;

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
        setTheme(theme);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create);

        setButtons();
        setSpinners();
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
                //TODO: add code to verify inputs and upload to server
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
                    public void onItemSelected(AdapterView<?> parent, View view, int dayPosition, long dayId){ // save the spinner position to dayPosition and id to dayId
                        dayPositionP = dayPosition; // save to a class wide variable so all method can use it
                        dayIdP = dayId;
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
                    public void onItemSelected(AdapterView<?> parent, View view, int hourPosition, long hourId){
                        hourPositionP = hourPosition;
                        hourIdP = hourId;
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
        spinnerMinute.setSelection(1);
        spinnerMinute.setOnItemSelectedListener(
                new OnItemSelectedListener() {
                    public void onItemSelected(AdapterView<?> parent, View view, int minutePosition, long minuteId){
                        minutePositionP = minutePosition;
                        minuteIdP = minuteId;
                        if(dayPositionP == 0 && hourPositionP == 0 && minutePositionP == 0){//this checks to see if it is literally a 0 minute on the timer
                            showToast("Can Not Be 0 Minute.");
                            create.setEnabled(false); // grey out submit button
                        }
                        else{
                            create.setEnabled(true);
                        }
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

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        requestCodeRun = requestCode;
        resultCodeRun = resultCode;
        dataRun = data;
        Thread t = new Thread(this);
        t.start();

    }


}
