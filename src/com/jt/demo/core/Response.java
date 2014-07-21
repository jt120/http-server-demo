package com.jt.demo.core;

import com.jt.demo.util.DestroyUtil;

import java.io.*;

/**
 * Created by JT on 2014/5/11.
 */
public class Response {

    private OutputStream outputStream;
    private String url;
    private final String NOT_FOUND = "<h1>file is not existed</h1>";

    public Response(OutputStream outputStream, String url) {
        this.outputStream = outputStream;
        this.url = url;
    }

    public void response() {
        PrintWriter pw = new PrintWriter(new OutputStreamWriter(outputStream));
        BufferedReader bufferedReader = null;
        try {
            bufferedReader = new BufferedReader(new FileReader(new File(HttpServer.WEB_ROOT + url)));
            String s;
            StringBuilder stringBuilder = new StringBuilder();
            while((s = bufferedReader.readLine())!=null) {
                stringBuilder.append(s);
            }
            pw.write(stringBuilder.toString());
        } catch (FileNotFoundException e) {
            pw.write(NOT_FOUND);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            DestroyUtil.close(bufferedReader);
            DestroyUtil.close(pw);
        }

    }
}
