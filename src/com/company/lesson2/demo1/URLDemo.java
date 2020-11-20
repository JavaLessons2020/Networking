package com.company.lesson2.demo1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.StandardCharsets;

public class URLDemo {

    static final String url = "https://itstep.dp.ua/";

    static URL itstep;

    static {
        try {
            itstep = new URL(url);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws Exception {
        getUrlInfo();
        //readingDirectlyFromUrl();
        //readingUsingConnection();
    }

    private static void readingUsingConnection() throws IOException, UnsupportedEncodingException {
        HttpURLConnection connection = (HttpURLConnection) itstep.openConnection();
        try (BufferedReader in = new BufferedReader(
                new InputStreamReader(connection.getInputStream(), StandardCharsets.UTF_8));
        ) {
            String line;
            while ((line = in.readLine()) != null){
                System.out.println(line);
            }
        }

    }

    private static void readingDirectlyFromUrl() throws MalformedURLException, IOException {
        try (BufferedReader in = new BufferedReader(
                new InputStreamReader(itstep.openStream(), StandardCharsets.UTF_8));
             PrintWriter printWriter = new PrintWriter("index.html");
        ) {
            String line;
            while ((line = in.readLine()) != null){
                //System.out.println(line);
                printWriter.println(line);
            }
        }
    }

    private static void getUrlInfo() throws MalformedURLException {
        URL aURL = new URL("http://example.com:80/docs/books/tutorial" + "/index.html?name=networking#DOWNLOADING");
        System.out.println("Protocol = " + aURL.getProtocol());
        System.out.println("Ref = " + aURL.getRef());
        System.out.println("File = " + aURL.getFile());

    }

}
