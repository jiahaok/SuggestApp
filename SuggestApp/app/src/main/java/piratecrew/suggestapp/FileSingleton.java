package piratecrew.suggestapp;

import android.util.Log;

import java.io.FileInputStream;
import java.io.FileOutputStream;

/**
 * Created by Naomi on 4/13/15.
 */
public class FileSingleton {
    private static FileSingleton ourInstance = new FileSingleton();

    public static FileSingleton getInstance() {
        return ourInstance;
    }

    private FileSingleton() {}

    static LoginActivity l = new LoginActivity();

    public static void writeFile(String data, String file){
        try {
            FileOutputStream fOut = new FileOutputStream(file);
            fOut.write(data.getBytes());
            fOut.close();
            Log.i("Write", data);

        } catch(Exception e) {
            Log.e("Error", Log.getStackTraceString(e));
        }
    }
    public static String readFile(String file){
        int c;
        String temp = "";
        try {
            FileInputStream fin = new FileInputStream(file);
            while ((c = fin.read()) != -1) {
                temp = temp + Character.toString((char) c);
            }
            Log.i("Data Read", temp);
            fin.close();
        } catch (Exception e) {
            Log.e("error", Log.getStackTraceString(e));
            temp = "";
        }
        return temp;
    }
    public static void leave(){l.leave();}
}

