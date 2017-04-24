package com.example.dell.four;

import android.location.Location;
import android.os.AsyncTask;

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

class PostTask extends AsyncTask <String, String, String> {
    @Override
    protected String doInBackground(String... loc) {
        try {
            //Location Lc;
            //Lc=loc[0];
            String lati = loc[0];
            String longi = loc[1];
            String url = "http://vipulofindia.vacau.com//android.php";
            URL obj = new URL(url);
            HttpURLConnection con;
            con = (HttpURLConnection) obj.openConnection();

            //add reuqest header
            con.setRequestMethod("POST");
            con.setRequestProperty("User-Agent", "USER_AGENT");
            con.setRequestProperty("Accept-Language", "en-US,en;q=0.5");

            //String urlParameters = "lat="+String.valueOf(Lc.getLatitude())+"&long="+String.valueOf(Lc.getLongitude());
            String urlParameters = "lat="+lati+"&long="+longi+"&id="+loc[2];
            //String para="sn=abs"
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
