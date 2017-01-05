package com.proj.tessa.tzelee.tessaproject3;

/**
 * Created by tzelee on 1/1/17.
 */

import android.os.AsyncTask;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import javax.net.ssl.HttpsURLConnection;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.RequestBody;
import okhttp3.MediaType;
import java.net.URL;

public class PostTask extends AsyncTask <String, Void, String>  {

    private Exception exception;
    MediaType JSON;
    private OkHttpClient client = new OkHttpClient();

    protected String doInBackground(String... urls) {
        try {
            String getResponse = post("http://www.roundsapp.com/post", bowlingJson("Me", "You"));
            return getResponse;
        } catch (Exception e) {
            this.exception = e;
            return null;
        }
    }
    protected void onPostExecute(String getResponse) {
        System.out.println(getResponse);
    }
    private String post(String url, String json) throws IOException {
        RequestBody body = RequestBody.create(JSON, json);
        Request request = new Request.Builder()
                .url(url)
                .post(body)
                .build();
        Response response = client.newCall(request).execute();
        return response.body().string();
    }
    public String bowlingJson(String player1, String player2) {
        return "{'winCondition':'HIGH_SCORE',"
                + "'name':'Bowling',"
                + "'round':4,"
                + "'lastSaved':1367702411696,"
                + "'dateStarted':1367702378785,"
                + "'players':["
                + "{'name':'" + player1 + "','history':[10,8,6,7,8],'color':-13388315,'total':39},"
                + "{'name':'" + player2 + "','history':[6,10,5,10,10],'color':-48060,'total':41}"
                + "]}";
    }
}


