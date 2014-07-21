package com.jt.demo.core;

import com.jt.demo.util.DestroyUtil;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by JT on 2014/5/11.
 */
public class HttpServer {
    public static final String WEB_ROOT = System.getProperty("user.dir") + "\\" + "webroot";
    private static final int PORT = 9999;
    private static final String IP_ADDRESS = "127.0.0.1";
    private static final String CLOSE_FLAG = "/close";

    private Request request;
    private Response response;

    private boolean close = false;

    public static void main(String[] args) {
        new HttpServer().await();
    }

    public void await() {
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(PORT, 100, InetAddress.getByName(IP_ADDRESS));
            while(!close) {
                Socket socket = serverSocket.accept();
                InputStream inputStream = socket.getInputStream();
                OutputStream outputStream = socket.getOutputStream();

                request = new Request(inputStream);
                String url = request.parse();
                if(url.equals(CLOSE_FLAG)) {
                    close = true;
                    continue;
                }
                response = new Response(outputStream, url);
                response.response();
                DestroyUtil.close(inputStream);
                DestroyUtil.close(outputStream);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                serverSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

}
