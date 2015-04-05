package piratecrew.suggestapp;


import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

import android.os.AsyncTask;
import android.os.StrictMode;
import android.widget.TextView;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;
import java.net.URI;

/**
 * Created by Brent on 3/30/2015.
 */
public class DatabaseConnection {
    private final String WEB_ROOT = "http://10.0.0.4/";
    TextView text;
    DatabaseConnection(String username, String password, TextView textView){
        if (android.os.Build.VERSION.SDK_INT > 9) {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
            text = textView;
        }
        new SendGetRequest().execute(WEB_ROOT+"login.php?username="+username+"&password="+password);
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

}
