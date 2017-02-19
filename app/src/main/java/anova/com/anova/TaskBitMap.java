package anova.com.anova;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class TaskBitMap extends AsyncTask<String,Void,Bitmap> {


    protected Bitmap doInBackground(String... params) {

        Bitmap bitmap = null;
        URL url = null;
        try {
            url = new URL(params[0]);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setDoInput(true);
            connection.connect();
            InputStream input = connection.getInputStream();
            bitmap = BitmapFactory.decodeStream(input);
        } catch (Exception e) {
            e.printStackTrace();
        }
        //do stuff
        return bitmap;
    }

    @Override
    protected void onPostExecute(Bitmap result) {
        //do stuff
        System.out.println("aaa");
    }
}
