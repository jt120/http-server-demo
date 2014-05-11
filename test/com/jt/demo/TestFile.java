package com.jt.demo;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * Created by JT on 2014/5/11.
 */
public class TestFile {

    public static void main(String[] args) throws IOException {
        Path path = FileSystems.getDefault().getPath("d:/test/log.txt");
        BufferedReader bufferedReader = null;
        try {
            bufferedReader = Files.newBufferedReader(path, Charset.forName("UTF-8"));
            String s;
            while ((s = bufferedReader.readLine()) != null) {
                System.out.println(s);
            }
        } finally {
            if (bufferedReader != null)
                bufferedReader.close();
        }
    }
}
