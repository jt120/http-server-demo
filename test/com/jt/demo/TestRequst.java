package com.jt.demo;

import com.jt.demo.core.Request;
import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * Created by JT on 2014/5/11.
 */
public class TestRequst {

    @Test
    public void test01() {

        try {
            Request request = new Request(new FileInputStream(new File("src/hello.txt")));
            String s = request.parse();
            System.out.println(s);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }
}
