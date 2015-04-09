package piratecrew.suggestapp;


import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.StrictMode;
import android.util.Base64;
import android.widget.TextView;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

import java.net.URI;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Brent on 3/30/2015.
 */
public class DatabaseConnection {
    private final String WEB_ROOT = "http://www.brentluker.com/";
    private String sessionId;
    TextView text;
    DatabaseConnection(String username, String password, TextView textView){
        if (android.os.Build.VERSION.SDK_INT > 9) {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }
        text = textView;
        String[] site = {WEB_ROOT+"login.php"};
        String[] data1 = {"username", username};
        String[] data2 = {"password", password};
        new SendPostRequest().execute(site, data1, data2);
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

    protected void createPoll(String text1, String text2, Bitmap pic1, Bitmap pic2, int minutes){
        String[] host = {WEB_ROOT+"create.php"};
        String[] opt1  = {"opt1", text1};
        String[] opt2 = {"opt2", text2};
        String[] bit1 = {"pic1", BitMapToString(pic1)};
        String[] bit2 = {"pic2", BitMapToString(pic2)};
        float end = new Date().getTime();
        String[] endTime = {"end_time", Float.toString(end)};

        new SendPostRequest().execute(host, opt1, opt2, bit1, bit2, endTime);
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
                if(result.length() > 10 && result.substring(0, 10).equals("PHP ERROR:"))
                    text.setText(result.substring(11));
                else {
                    sessionId = result;
                    text.setText("Logged In");
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
}
