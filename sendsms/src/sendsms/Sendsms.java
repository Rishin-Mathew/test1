/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sendsms;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 *
 * @author Abcd
 */
public class Sendsms {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        try {
            // Construct data
            String apiKey = "apikey=" + "Zm9vOmJhcg==";
            String message = "&message=" + "Greetings from Simplifying Tech! Have a nice day!";
            String sender = "&sender=" + "D7sms";
            String numbers = "&numbers=" + "8296112883";
 
            // Send data
            HttpURLConnection conn = (HttpURLConnection) new URL("https://http-api.d7networks.com/send").openConnection();
            String data = apiKey + numbers + message + sender;
            conn.setDoOutput(true);
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Length", Integer.toString(data.length()));
            conn.getOutputStream().write(data.getBytes("UTF-8"));
             
            BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            StringBuffer stringBuffer = new StringBuffer();
            String line;
            while ((line = rd.readLine()) != null) {
                stringBuffer.append(line).append("\n");
            }
            System.out.println(stringBuffer.toString());
            rd.close();
 
 
        } catch (Exception e) {
           e.printStackTrace();
        }
    }
    }
    

