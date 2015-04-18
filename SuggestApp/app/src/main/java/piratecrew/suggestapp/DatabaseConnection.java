package piratecrew.suggestapp;


import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.StrictMode;
import android.util.Base64;
import android.util.Log;
import android.widget.TextView;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Brent on 3/30/2015.
 */
public class DatabaseConnection {
    private final String WEB_ROOT = "http://www.brentluker.com/";

    public static String sessionId = null;
    private String successText;
    TextView text;
    public static boolean leave;

    DatabaseConnection(String username, String password, TextView textView){
        if (android.os.Build.VERSION.SDK_INT > 9) {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }
        //Saves the username to a file
        text = textView;
        FileSingleton.writeFile(username, "Username");
        String[] site = {WEB_ROOT+"user.php?action=login"};
        String[] data1 = {"username", username};
        String[] data2 = {"password", password};
        successText = "Logged In";
        new SendPostRequest().execute(site, data1, data2);
        //If the logout parameter is true, the user is logged out
    }
    /**
     * Tests how to make a GET request.
     * @param textView Shows status of GET request
     */
    void getTest(TextView textView){
        text = textView;
        if (android.os.Build.VERSION.SDK_INT > 9) {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }

        new SendGetRequest().execute(WEB_ROOT+"?id=1");

        textView.setText("Loading...");
    }
    void postTest(TextView textView){
        text = textView;
        if (android.os.Build.VERSION.SDK_INT > 9) {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }

        textView.setText("Loading...");
        String[] strings = {WEB_ROOT};
        String[] strings1= {"id", "1"};
        new SendPostRequest().execute(strings, strings1);


    }

    protected void createPoll(String text1, String text2, Bitmap pic1, Bitmap pic2, long end){

        String[] host = {WEB_ROOT+"user.php?action=create"};
        String[] opt1  = {"opt1", text1};
        String[] opt2 = {"opt2", text2};
        String sPic1, sPic2;
        if(pic1 == null || pic2 == null){sPic1 = "null"; sPic2 = "null";}
        else{sPic1 = BitMapToString(pic1); sPic2 =BitMapToString(pic2);}
        String[] bit1 = {"pic1", sPic1};
        String[] bit2 = {"pic2", sPic2};
        String[] endTime = {"length", Long.toString(end)};

        String[] session = {"session", sessionId};

        successText = "Question created successfully.";
        Log.i("Date", Long.toString(end));
        new SendPostRequest().execute(host, opt1, opt2, bit1, bit2, endTime, session);
    }

    //get
    private class SendGetRequest extends AsyncTask<String, Void, String> {
        protected String doInBackground(String... params) {
            try {
                //Get the response
                HttpClient client = new DefaultHttpClient();
                HttpGet request = new HttpGet();
                request.setURI(new URI(params[0]));
                HttpResponse response = client.execute(request);

                //Get content of response
                HttpEntity  entity = response.getEntity();
                InputStream inputStream = entity.getContent();

                ByteArrayOutputStream content = new ByteArrayOutputStream();

                // Read response into a buffered stream
                int readBytes = 0;
                byte[] sBuffer = new byte[512];
                while((readBytes = inputStream.read(sBuffer)) != -1) {
                    content.write(sBuffer, 0, readBytes);
                }

                //Return result from buffered stream
                return new String(content.toByteArray());


            } catch (URISyntaxException e) {
                e.printStackTrace();
            } catch (ClientProtocolException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            return null; //If program gets this far, something didn't work.
        }

        protected void onPostExecute(String result){
            text.setText(result);

        }
    }
    private class SendPostRequest extends AsyncTask<String[], Void, String> {

        protected String doInBackground(String[]... params) {
            try {
                //Create request
                HttpClient client = new DefaultHttpClient();
                HttpPost httpPost = new HttpPost();

                httpPost.setURI(new URI(params[0][0]));


                List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>(params.length-1);
                for(int i = 1; i < params.length; i++) {
                    nameValuePairs.add(new BasicNameValuePair(params[i][0], params[i][1]));
                }
                httpPost.setEntity(new UrlEncodedFormEntity(nameValuePairs));

                //Get the response
                HttpResponse response = client.execute(httpPost);

                //Get content of response
                HttpEntity  entity = response.getEntity();
                InputStream inputStream = entity.getContent();

                ByteArrayOutputStream content = new ByteArrayOutputStream();

                // Read response into a buffered stream
                int readBytes = 0;
                byte[] sBuffer = new byte[512];
                while((readBytes = inputStream.read(sBuffer)) != -1) {
                    content.write(sBuffer, 0, readBytes);
                }

                //Return result from buffered stream
                return new String(content.toByteArray());


            } catch (URISyntaxException e ){
                // TODO Generic catch
                e.printStackTrace();
            }
            catch (ClientProtocolException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            return null; //If program gets this far, something didn't work.
        }

        protected void onPostExecute(String result){
                //NOTE: if result.length() is less then 10, the program
                //will ignore the second half, preventing an error.

                if(result.length() > 10 && result.substring(0, 10).equals("PHP ERROR:")) {
                    try {text.setText(result.substring(11));} catch (Exception e){}
                    Log.e("SERVER ERROR", result);
                    //Clearing the files so that an incorrect login is not saved
                    FileSingleton.writeFile("","Login");
                    FileSingleton.writeFile("","Username");
                }
                else {
                    sessionId = result;
                    try{text.setText(successText);}catch (Exception e){}
                    Log.i("SERVER SUCCESS", successText);
                    //saves the login, brings user to main page
                    MainActivity.loggedIn = true;
                    FileSingleton.writeFile(sessionId,"Login");
                    try {
                        if (leave == true){
                            leave = false;
                            FileSingleton.leave();
                        }
                    }catch (Exception e){}
                }
        }
    }
    public String BitMapToString(Bitmap bitmap){
        ByteArrayOutputStream baos = new  ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG,100, baos);
        byte [] b=baos.toByteArray();
        String temp= Base64.encodeToString(b, Base64.DEFAULT);
        return temp;
    }
    public Bitmap StringToBitMap(String encodedString){
        try {
            byte [] encodeByte=Base64.decode(encodedString,Base64.DEFAULT);
            Bitmap bitmap=BitmapFactory.decodeByteArray(encodeByte, 0, encodeByte.length);
            return bitmap;
        } catch(Exception e) {
            e.getMessage();
            return null;
        }
    }
    boolean loggedOut(){return sessionId == null;}
}
