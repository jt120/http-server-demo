package com.jt.demo;

import com.jt.demo.util.DestroyUtil;
import org.junit.Test;

import java.io.*;

/**
 * Created by JT on 2014/5/11.
 */
public class TestEnter {

    @Test
    public void test() {
        String s = "hello\n\nyou";
        BufferedReader bufferedReader = new BufferedReader(new StringReader(s));
        String w;
        String before = "";
        int count = 1;
        try {
            while(true) {
                w = bufferedReader.readLine();
                if(w.equals(before)&&w.equals("\n")) {
                    break;
                }
                before = w;
                System.out.print(++count + ":");
                printChar(w.toCharArray());
                Thread.sleep(1000);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            DestroyUtil.close(bufferedReader);
        }

    }

    public void printChar(char[] chars) {
        for (int i = 0; i < chars.length; i++) {
            System.out.print(chars[i] + ":" + (int) chars[i]);
        }
        System.out.println();
    }

    @Test
    public void test01() {
        String s1 = "\n";
        String s2 = "\n";
        System.out.println(s1.equals(s2));
    }

    @Test
    public void test02() {
        String s1 = "\r";
        String s2 = "\r";
        System.out.println(s1.equals(s2));
    }

    @Test
    public void test03() {
        String s1 = "\n\r";
        String s2 = "\n\r";
        System.out.println(s1.equals(s2));
    }


    @Test
    public void test04() throws FileNotFoundException {
        String s = "hello\n\ryou";
        DataInputStream inputStream = new DataInputStream(new FileInputStream(new File("src/hello.txt")));
        byte[] buff= new byte[1024];
        int end = 0;
        try {
            while ((end = inputStream.read(buff))!=-1) {
                String tmp = new String(buff);
                System.out.print(s + ":");
                printByte(buff);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            DestroyUtil.close(inputStream);
        }

    }

    public void printByte(byte[] bytes) {

        for (int i = 0; i < bytes.length; i++) {
            if(bytes[i]==0) {
                break;
            }
            System.out.print(bytes[i] + ":" + (char) bytes[i]);
            System.out.println();
        }
        System.out.println();
    }

    @Test
    public void test05() {
        File file = new File(".");
        System.out.println(file.getAbsolutePath());

    }

    @Test
    public void test06() {
       String WEBROOT = System.getProperty("user.dir") + "\\" + "webroot";
        System.out.println(WEBROOT);
    }

}
