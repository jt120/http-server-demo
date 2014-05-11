package com.jt.demo.util;

import java.io.*;

/**
 * Created by JT on 2014/5/11.
 */
public class DestroyUtil {

    public static void close(Reader reader) {
        if(reader!=null) {
            try {
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void close(InputStream inputStream) {
        if(inputStream!=null) {
            try {
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void close(Writer writer) {
        if(writer!=null) {
            try {
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void close(OutputStream outputStream) {
        if(outputStream!=null) {
            try {
                outputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
