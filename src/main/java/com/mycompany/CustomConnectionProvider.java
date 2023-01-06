package com.mycompany;

import javax.net.ssl.HttpsURLConnection;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;


public class CustomConnectionProvider {
    public static URLConnection createConnection(String protocol, String host, String basepath, String queryBuilder) {
        URLConnection connection = null;
        String urlProtocol = "HTTPS".equals(protocol) ? "https://" : "http://";
        try {
            if (queryBuilder.equals("?")) {
                connection = new URL(urlProtocol + host + basepath).openConnection();
                System.out.println("Connection created successfully " + connection.toString());
            } else {
                connection = new URL(urlProtocol + host + basepath + queryBuilder).openConnection();
                System.out.println("Connection created successfully " + connection.toString());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "HTTPS".equals(protocol) ? (HttpsURLConnection) connection : (HttpURLConnection) connection;
    }
}
