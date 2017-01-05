package com.proj.tessa.tzelee.tessaproject3;

import android.os.AsyncTask;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import javax.net.ssl.HttpsURLConnection;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by tzelee on 1/1/17.
 */

public class GetTask extends AsyncTask<String, Void, String> {
    private Exception exception;
    private OkHttpClient client = new OkHttpClient();


    protected String doInBackground(String... urls) {
        try {
            String getResponse = get("https://publicobject.com/helloworld.txt");
            return getResponse;
        } catch (Exception e) {
            this.exception = e;
            return null;
        }
    }

    protected void onPostExecute(String getResponse) {
        System.out.println(getResponse);
    }

    public String get(String url) throws IOException {
        Request request = new Request.Builder()
                .url(url)
                .build();

        Response response = client.newCall(request).execute();
        return response.body().string();
    }
}