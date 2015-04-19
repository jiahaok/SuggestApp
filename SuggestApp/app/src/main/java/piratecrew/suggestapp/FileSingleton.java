package piratecrew.suggestapp;

import android.util.Log;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by Naomi on 4/13/15.
 */
public class FileSingleton {
    //singleton code
    private static FileSingleton ourInstance = new FileSingleton();

    public static FileSingleton getInstance() {
        return ourInstance;
    }

    private FileSingleton() {}

    static LoginActivity l = new LoginActivity();

    //Writing data to a file
    public static void writeFile(String data, String file){
        try {
            FileOutputStream fOut = new FileOutputStream(new File("/data/data/piratecrew.suggestapp/"+file+".txt"),false);
            fOut.write(data.getBytes());
            fOut.close();
            Log.i("Write", data);

        }catch(Exception e) {
            Log.e("Error", Log.getStackTraceString(e));
        }
    }
    //Reading a file
    public static String readFile(String file){
        int c;
        String temp = "";
        try {
            FileInputStream fin = new FileInputStream(new File("/data/data/piratecrew.suggestapp/"+file+".txt"));
            while ((c = fin.read()) != -1) {
                temp = temp + Character.toString((char) c);
            }
            Log.i("Data Read", temp);
            fin.close();
        } catch (FileNotFoundException e) {
            temp = "";
            try {
                FileOutputStream fOut = new FileOutputStream(new File("/data/data/piratecrew.suggestapp/" + file + ".txt"), false);
                fOut.write("".getBytes());
                fOut.close();
                Log.i("Write", "Created empty file.");
            } catch (Exception e1){
                Log.e("error", Log.getStackTraceString(e1));
            }
        } catch (Exception e){
            Log.e("error", Log.getStackTraceString(e));
        }
        return temp;
    }
    //The DatabaseConnection class uses this to leave the LoginActivity
    public static void leave(){l.leave();}
}

