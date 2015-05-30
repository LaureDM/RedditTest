package com.gettingstarted.lauresoft.reddittest.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by Laure on 18/01/2015.
 */
public class RemoteData
{
    private static HttpURLConnection hcon = null;

    public static HttpURLConnection getConnection(String url)
    {
        System.out.println("URL: "+url);

        try {
            hcon=(HttpURLConnection)new URL(url).openConnection();
            hcon.setReadTimeout(30000); // Timeout at 30 seconds
            hcon.setRequestProperty("User-Agent", "Alien V1.0");
        }
        catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return hcon;
    }

    public static String readContents(String url)
    {
        hcon = getConnection(url);
        StringBuffer sb = null;
        if(hcon==null)
        {
            return null;
        }

        try
        {
            sb = new StringBuffer(8192);
            String tmp="";
            BufferedReader br=new BufferedReader(
                    new InputStreamReader(hcon.getInputStream())
            );
            while((tmp=br.readLine())!=null)
                sb.append(tmp).append("\n");
            br.close();

        }
        catch (IOException e) {
            e.printStackTrace();

        }

        return sb.toString();
    }
}
