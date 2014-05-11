package com.jt.demo.core;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Created by JT on 2014/5/11.
 */
public class Request {

    private InputStream inputStream;
    private String url;

    public Request(InputStream inputStream) {
        this.inputStream = inputStream;
    }

    public String parse() {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        try {
            String s = bufferedReader.readLine();
            url = fetchUrl(s);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return url;
    }

    private String fetchUrl(String s) {
        int start = s.indexOf(' ');
        int end = s.lastIndexOf(' ');
        return s.substring(start+1,end);
    }

    public String getUrl() {
        return url;
    }
}
