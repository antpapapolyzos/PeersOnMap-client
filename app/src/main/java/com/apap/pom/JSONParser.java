package com.apap.pom;

import android.content.ContentValues;
import android.util.Log;

import com.google.firebase.crash.FirebaseCrash;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;


/**
 * Get response from server and produce JSON object
 */

public class JSONParser {

    //Debug Tag
    public static final String TAG = JSONParser.class.getSimpleName();

    private static final int ReadHttpReadTimeout = 10000; // milliseconds
    private static final int ReadHttpConTimeout  = 15000; // milliseconds

    private  InputStream is = null;   //Read data from network
    private  JSONObject jObj = null;  //json object
    private  String json = "";        //json string for server response
    private  BufferedWriter writer = null;
    private  OutputStream os = null;
    private  OutputStreamWriter osw = null;

    // constructor
    public JSONParser() {}


    // Given a URL, establishes an HttpUrlConnection and retrieves
    // content as an InputStream, which it returns as json object
    public JSONObject getJSONFromUrl(String url, ContentValues params) throws IOException {

        Log.d("JSON Parser", "---> getJSONFromUrl url:" + url);

        is = null;
        json = null;
        try {
            URL url_ = new URL(url);

            HttpURLConnection conn = (HttpURLConnection) url_.openConnection(); //New connection
            conn.setReadTimeout(ReadHttpReadTimeout);                           //Set http read timeout
            conn.setConnectTimeout(ReadHttpConTimeout);                         //Set connect timeout
            conn.setRequestMethod("POST");                                      //Set http method
            conn.setDoInput(true);                                              //Use the URL connection for input
            conn.setDoOutput(true);                                             //Use the URL connection for output

            // Query data
            os = conn.getOutputStream();                           //Get an output stream

            if(url.endsWith("/storeReview.php"))
            {
                osw = new OutputStreamWriter(os);
            }else{
                osw = new OutputStreamWriter(os, "UTF-8");
            }

            writer = new BufferedWriter(osw);//set encoding to UTF-8

            String param_str = (params.toString().replace(' ', '&')).replace('^', ' ');


            writer.write(param_str);                                    //Write parameter data to send
            writer.flush();
            writer.close();
            osw.close();
            os.close();

            json = null;



            //Get response code
            if(conn.getResponseCode() == HttpURLConnection.HTTP_OK)      //200 OK parse data
            {
                //Get json response data and add to buffer
                String line = "";
                json = "";
                BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
                while ((line = br.readLine()) != null) {
                    json += line;
                }
            }else {
                json=null;
            }

        }catch (Exception e){
            e.printStackTrace();
            FirebaseCrash.logcat(Log.ERROR, TAG, "getJSONFromUrl 1");
            FirebaseCrash.report(e);
            return null;
        }
        finally {
            if( is != null){
                is.close();
            }
            if( writer != null) {
                writer.close();
            }
            if( os != null) {
                os.close();
            }
            if (osw != null) {
                osw.close();
            }
        }

        if(json.equals("")|| json==null) return null;

        //Parse return data as json object
        try{
            jObj = new JSONObject(json);
        }catch(JSONException je){
            Log.e("JSON Parser", "Error parsing data " + je.toString());
            FirebaseCrash.logcat(Log.ERROR, TAG, "getJSONFromUrl 2");
            FirebaseCrash.report(je);
            return null;
        }

        //Return json object
        return jObj;
    }



    // Given a URL, establishes an HttpUrlConnection and retrieves
    // content as an InputStream, which it returns as json object
    public JSONObject getJSONFromUrlNoParams(String url) throws IOException {

        Log.d("JSON Parser", "---> getJSONFromUrl url:" + url);

        is = null;
        json = null;
        try {
            URL url_ = new URL(url);
            HttpURLConnection conn = (HttpURLConnection) url_.openConnection(); //New connection
            conn.setReadTimeout(ReadHttpReadTimeout);                           //Set http read timeout
            conn.setConnectTimeout(ReadHttpConTimeout);                         //Set connect timeout
            conn.setRequestMethod("POST");                                      //Set http method
            conn.setDoInput(true);                                              //Use the URL connection for input
            conn.setDoOutput(true);                                             //Use the URL connection for output

            json = null;


            //Get response code
            if(conn.getResponseCode() == HttpURLConnection.HTTP_OK)             //200 OK parse data
            {
                //Get json response data and add to buffer
                String line = "";
                json = "";
                BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
                while ((line = br.readLine()) != null) {
                    json += line;
                }
            }else {
                json=null;
            }

        }catch (Exception e){
            e.printStackTrace();
            FirebaseCrash.logcat(Log.ERROR, TAG, "getJSONFromUrlNoParams 1");
            FirebaseCrash.report(e);
        }
        finally {
            if( is != null){
                is.close();
            }
        }

        if(json.equals("") || json==null) return null;

        //Parse return data as json object
        try{
            jObj = new JSONObject(json);
        }catch(JSONException je){
            Log.e("JSON Parser", "Error parsing data " + je.toString());
            FirebaseCrash.logcat(Log.ERROR, TAG, "getJSONFromUrlNoParams 2");
            FirebaseCrash.report(je);
        }

        //Return json object
        return jObj;
    }

    /*
     * Given a URL, establishes an HttpUrlConnection and retrieves
     * content as an InputStream, which it returns as json object
     */
    public JSONObject getJSONFromUrlFile(String url, ContentValues params, File file, String fileName) throws IOException {

        //Check files validity before continue
        if(!file.isFile()) {
            Log.e("JSON Parser", "getJSONFromUrlFile: file is not a file");
            return null;
        }

        String boundary = "*****";
        int bytesAvailable=0;
        int maxBufferSize = 1024;
        int bufferSize=0;
        byte[ ] buffer;
        int bytesRead=0;
        FileInputStream fileInputStream=null;
        DataOutputStream dos=null;

        try {

            URL url_ = new URL(url);
            HttpURLConnection conn = (HttpURLConnection) url_.openConnection(); //New connection
            conn.setReadTimeout(ReadHttpReadTimeout);                           //Set http read timeout
            conn.setConnectTimeout(ReadHttpConTimeout);                         //Set connect timeout
            conn.setRequestMethod("POST");                                      //Set http method
            conn.setDoInput(true);                                              //Use the URL connection for input
            conn.setDoOutput(true);                                             //Use the URL connection for output
            conn.setUseCaches(false);                                           // Don't use a Cached Copy

            conn.setRequestProperty("Connection", "Keep-Alive");
            conn.setRequestProperty("ENCTYPE", "multipart/form-data");
            conn.setRequestProperty("Content-Type", "multipart/form-data;boundary=" + boundary);

            // Query data
            dos = new DataOutputStream(conn.getOutputStream());


            //Send Parameter "tag"
            dos.writeBytes("--" + boundary + "\r\n");
            dos.writeBytes("Content-Disposition: form-data; name=\"tag\""+ "\r\n");
            dos.writeBytes("\r\n");
            dos.writeBytes(params.getAsString("tag"));
            dos.writeBytes("\r\n");
            dos.writeBytes("--" + boundary + "\r\n");

            //Send Parameter "player_id"
            dos.writeBytes("--" + boundary + "\r\n");
            dos.writeBytes("Content-Disposition: form-data; name=\"player_id\""+ "\r\n");
            dos.writeBytes("\r\n");
            dos.writeBytes(params.getAsString("player_id"));
            dos.writeBytes("\r\n");
            dos.writeBytes("--" + boundary + "\r\n");

            //Send Parameter "tagsOfPath"
            dos.writeBytes("--" + boundary + "\r\n");
            dos.writeBytes("Content-Disposition: form-data; name=\"tagsOfPath\""+ "\r\n");
            dos.writeBytes("\r\n");
            dos.writeBytes(params.getAsString("tagsOfPath"));
            dos.writeBytes("\r\n");
            dos.writeBytes("--" + boundary + "\r\n");

            //Send Parameter "meters"
            dos.writeBytes("--" + boundary + "\r\n");
            dos.writeBytes("Content-Disposition: form-data; name=\"meters\""+ "\r\n");
            dos.writeBytes("\r\n");
            dos.writeBytes(params.getAsString("meters"));
            dos.writeBytes("\r\n");
            dos.writeBytes("--" + boundary + "\r\n");

            //Send first file
            dos.writeBytes("--" + boundary + "\r\n");

            //Send File
            fileInputStream = new FileInputStream(file);
            dos.writeBytes("Content-Disposition: form-data; name=\"fileGoogle\";filename=\"" + fileName +"\"" + "\r\n");
            dos.writeBytes("\r\n");
            bytesAvailable = fileInputStream.available();              //returns no. of bytes present in fileInputStream
            bufferSize = Math.min(bytesAvailable, maxBufferSize);       //selecting the buffer size as minimum of available bytes or 1 MB
            buffer = new byte[bufferSize];                              //setting the buffer as byte array of size of bufferSize
            bytesRead = fileInputStream.read(buffer, 0, bufferSize);   //read file and write it into form...
            while (bytesRead > 0)                                       //loop repeats till bytesRead = -1, i.e., no bytes are left to read
            {
                dos.write(buffer, 0, bufferSize);                       //write the bytes read from inputstream
                bytesAvailable = fileInputStream.available();
                bufferSize = Math.min(bytesAvailable,maxBufferSize);
                bytesRead = fileInputStream.read(buffer, 0,bufferSize);
            }
            fileInputStream.close();                                   //close input stream
            dos.writeBytes("\r\n");
            dos.writeBytes("--" + boundary + "--" + "\r\n");

            //Close output stream
            dos.flush();
            dos.close();

            Log.e("JSON Parser", "Files Sent, Response: " + String.valueOf(conn.getResponseCode()));

            json = "";
            if(conn.getResponseCode() == HttpURLConnection.HTTP_OK)             //Get response code, only with 200 OK parse data
            {
                //Get json response data and add to buffer
                String line = "";
                BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
                while ((line = br.readLine()) != null) {
                    json += line;
                }
            }else {
                json="";
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
            FirebaseCrash.logcat(Log.ERROR, TAG, "getJSONFromUrlFile 1");
            FirebaseCrash.report(e);
            Log.e("JSON Parser", "FileNotFoundException: File Not Found");
        } catch (IOException e) {
            e.printStackTrace();
            //Toast.makeText(context, "Cannot Read/Write File!", Toast.LENGTH_SHORT).show();
            Log.e("JSON Parser", "IOException: Cannot Read/Write File!");
            FirebaseCrash.logcat(Log.ERROR, TAG, "getJSONFromUrlFile 2");
            FirebaseCrash.report(e);
        }catch (Exception e){
            e.printStackTrace();
            Log.e("JSON Parser", "Exception: !!!");
            FirebaseCrash.logcat(Log.ERROR, TAG, "getJSONFromUrlFile 3");
            FirebaseCrash.report(e);
        }
        finally {
            if( fileInputStream != null){
                fileInputStream.close();
            }
            if( dos != null){
                dos.close();
            }
        }

        if(json==null || json.equals("")) return null;

        //Parse return data as json object
        try{
            jObj = new JSONObject(json);
        }catch(JSONException je){
            Log.e("JSON Parser", "Error parsing data " + je.toString());
            FirebaseCrash.logcat(Log.ERROR, TAG, "getJSONFromUrlFile 4");
            FirebaseCrash.report(je);
        }
        //Return json object
        return jObj;
    }

}
