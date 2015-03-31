package piratecrew.suggestapp;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Log;
import android.widget.ImageView;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;
import java.util.ArrayList;


public class CreateActivity extends Activity {
    //variables here:
    private ImageView viewImageLeft, viewImageRight;
    private Spinner spinnerDay, spinnerHour, spinnerMinute;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        switch (Themes.t) {// themes
            case 1: {
                setTheme(android.R.style.Theme_Holo_NoActionBar);
                break;
            }
            case 2: {
                setTheme(android.R.style.Theme_Holo_Light_NoActionBar);
                break;
            }
            case 3: {
                setTheme(android.R.style.Theme_Holo_Wallpaper_NoTitleBar);
                break;
            }
            default:
                setTheme(android.R.style.Theme_DeviceDefault_NoActionBar);
        }

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create);
        RelativeLayout createscreen = (RelativeLayout) findViewById(R.id.createscreen);

        pictureUploads();
        EditText editTextLeft = (EditText) findViewById(R.id.editText2);
        EditText editTextRight = (EditText) findViewById(R.id.editText);
        spinnerDay();
        spinnerHour();
        spinnerMinute();


    }

    public void pictureUploads(){
        viewImageLeft = (ImageView) findViewById(R.id.imageViewLeft);
        viewImageRight = (ImageView) findViewById(R.id.imageViewRight);
        Button uploadLeft = (Button) findViewById(R.id.uploadLeft); //left upload button
        uploadLeft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //action for left upload button goes here
                selectImageLeft();

            }
        });
        Button uploadRight = (Button) findViewById(R.id.uploadRight); // right upload button
        uploadRight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //action for right upload button goes here
                selectImageRight();

            }
        });

        Button create = (Button) findViewById(R.id.create);
        create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    public void spinnerDay() {
        spinnerDay = (Spinner) findViewById(R.id.spinnerDay);
        List list = new ArrayList();
        list.add("0 day");
        list.add("1 day");
        list.add("2 day");
        list.add("3 day");
        list.add("4 day");
        list.add("5 day");
        list.add("6 day");
        ArrayAdapter dataAdapter = new ArrayAdapter(this,android.R.layout.simple_spinner_item, list);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerDay.setAdapter(dataAdapter);
    }

    public void spinnerHour() {
        spinnerHour = (Spinner) findViewById(R.id.spinnerHour);
        List list = new ArrayList();
        list.add("0 hour");
        list.add("1 hour");
        list.add("2 hour");
        list.add("3 hour");
        list.add("4 hour");
        list.add("5 hour");
        list.add("6 hour");
        list.add("7 hour");
        list.add("8 hour");
        list.add("9 hour");
        list.add("10 hour");
        list.add("11 hour");
        list.add("12 hour");
        list.add("13 hour");
        list.add("14 hour");
        list.add("15 hour");
        list.add("16 hour");
        list.add("17 hour");
        list.add("18 hour");
        list.add("19 hour");
        list.add("20 hour");
        list.add("21 hour");
        list.add("22 hour");
        list.add("23 hour");
        ArrayAdapter dataAdapter = new ArrayAdapter(this,android.R.layout.simple_spinner_item, list);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerHour.setAdapter(dataAdapter);
    }
    public void spinnerMinute() {
        spinnerMinute = (Spinner) findViewById(R.id.spinnerMinute);
        List list = new ArrayList();
        list.add("5 minute");
        list.add("10 minute");
        list.add("15 minute");
        list.add("20 minute");
        list.add("25 minute");
        list.add("30 minute");
        list.add("35 minute");
        list.add("40 minute");
        list.add("45 minute");
        list.add("50 minute");
        list.add("55 minute");
        ArrayAdapter dataAdapter = new ArrayAdapter(this,android.R.layout.simple_spinner_item, list);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerMinute.setAdapter(dataAdapter);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_create, menu);
        return true;
    }

    private void selectImageLeft() { // select image button

        final CharSequence[] options = {"Take Photo", "Choose from Gallery", "Cancel"};

        AlertDialog.Builder builder = new AlertDialog.Builder(CreateActivity.this);
        builder.setTitle("Add Photo!");
        builder.setItems(options, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int item) {
                if (options[item].equals("Take Photo")) {
                    Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                    File f = new File(android.os.Environment.getExternalStorageDirectory(), "temp.jpg");
                    intent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(f));
                    startActivityForResult(intent, 1);
                } else if (options[item].equals("Choose from Gallery")) {
                    Intent intent = new Intent(Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                    startActivityForResult(intent, 2);

                } else if (options[item].equals("Cancel")) {
                    dialog.dismiss();
                }
            }
        });
        builder.show();
    }

    private void selectImageRight() { // select image button

        final CharSequence[] options = {"Take Photo", "Choose from Gallery", "Cancel"};

        AlertDialog.Builder builder = new AlertDialog.Builder(CreateActivity.this);
        builder.setTitle("Add Photo!");
        builder.setItems(options, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int item) {
                if (options[item].equals("Take Photo")) {
                    Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                    File f = new File(android.os.Environment.getExternalStorageDirectory(), "temp.jpg");
                    intent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(f));
                    startActivityForResult(intent, 3);
                } else if (options[item].equals("Choose from Gallery")) {
                    Intent intent = new Intent(Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                    startActivityForResult(intent, 4);

                } else if (options[item].equals("Cancel")) {
                    dialog.dismiss();
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

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            if (requestCode == 1) {   //take a photo left
                File f = new File(Environment.getExternalStorageDirectory().toString());
                for (File temp : f.listFiles()) {
                    if (temp.getName().equals("temp.jpg")) {
                        f = temp;
                        break;
                    }
                }
                try {
                    Bitmap bitmapLeft;
                    BitmapFactory.Options bitmapOptionsLeft = new BitmapFactory.Options();
                    bitmapLeft = BitmapFactory.decodeFile(f.getAbsolutePath(),bitmapOptionsLeft);
                    viewImageLeft.setImageBitmap(bitmapLeft);

                    String path = android.os.Environment
                            .getExternalStorageDirectory()
                            + File.separator
                            + "Xeonjake" + File.separator + "default";
                    f.delete();
                    OutputStream outFile = null;
                    File file = new File(path, String.valueOf(System.currentTimeMillis()) + ".jpg");
                    try {
                        outFile = new FileOutputStream(file);
                        bitmapLeft.compress(Bitmap.CompressFormat.JPEG, 85, outFile);
                        outFile.flush();
                        outFile.close();
                    } catch (FileNotFoundException e) {
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
            else if (requestCode == 3) {   //take photo right
                File f = new File(Environment.getExternalStorageDirectory().toString());
                for (File temp : f.listFiles()) {
                    if (temp.getName().equals("temp.jpg")) {
                        f = temp;
                        break;
                    }
                }
                try {
                    Bitmap bitmapLeft;
                    BitmapFactory.Options bitmapOptionsLeft = new BitmapFactory.Options();
                    bitmapLeft = BitmapFactory.decodeFile(f.getAbsolutePath(),bitmapOptionsLeft);
                    viewImageRight.setImageBitmap(bitmapLeft);

                    String path = android.os.Environment
                            .getExternalStorageDirectory()
                            + File.separator
                            + "Xeonjake" + File.separator + "default";
                    f.delete();
                    OutputStream outFile = null;
                    File file = new File(path, String.valueOf(System.currentTimeMillis()) + ".jpg");
                    try {
                        outFile = new FileOutputStream(file);
                        bitmapLeft.compress(Bitmap.CompressFormat.JPEG, 85, outFile);
                        outFile.flush();
                        outFile.close();
                    } catch (FileNotFoundException e) {
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

            else if (requestCode == 2) {    //choose photo left

                Uri selectedImage = data.getData();
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
                thumbnail.compress(Bitmap.CompressFormat.JPEG,85,compressThumbnail);
                Log.w("image path:", picturePath + "");
                viewImageLeft.setImageBitmap(thumbnail);

            }


            else if (requestCode == 4) {    //choose photo right

                Uri selectedImage = data.getData();
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
                thumbnail.compress(Bitmap.CompressFormat.JPEG,85,compressThumbnail);
                Log.w("image path:", picturePath + "");
                viewImageRight.setImageBitmap(thumbnail);
            }
        }
    }
}