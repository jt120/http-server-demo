package com.jt.demo.util;

/**
 * Created by JT on 2014/5/11.
 */
public class PrintUtil {

    public static void printByte(byte[] bytes) {

        for (int i = 0; i < bytes.length; i++) {
            if (bytes[i] == 0) {
                break;
            }
            System.out.print((char) bytes[i]);
        }
    }
}
