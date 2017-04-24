package com.example.dell.four;


import android.location.Location;
import android.os.AsyncTask;
import android.provider.ContactsContract;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

/**
 * Created by user on 1/11/2017.
 */

class ProfilePost extends AsyncTask <String, String, String> {
    @Override
    protected String doInBackground(String... id) {
        try {

            String url = "http://vipulofindia.vacau.com//profile.php";
            URL obj = new URL(url);
            HttpURLConnection con;
            con = (HttpURLConnection) obj.openConnection();

            //add reuqest header
            con.setRequestMethod("POST");
            con.setRequestProperty("User-Agent", "USER_AGENT");
            con.setRequestProperty("Accept-Language", "en-US,en;q=0.5");

            System.out.println("received submission at ProfilePost :"+ id[0]);
            String urlParameters = "id="+id[0];
            //String para="sn=abs";
            // Send post request
            con.setDoOutput(true);
            DataOutputStream wr = new DataOutputStream(con.getOutputStream());
            wr.writeBytes(urlParameters);
            wr.flush();
            wr.close();

            int responseCode = con.getResponseCode();
            System.out.println("\nSending 'POST' request to URL : " + url);
            System.out.println("Post parameters : " + urlParameters);
            System.out.println("Response Code : " + responseCode);

            BufferedReader in = new BufferedReader(
                    new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            //print result
            String pr=response.toString();
            System.out.println("post result os" +pr);
            return pr;
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }
}
