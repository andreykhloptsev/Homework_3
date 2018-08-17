package ru.geekbrains.level_3.hw_3;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;


public class FiveFilesApp {

    public static void main(String[] args) {
        try {
            byte number;
            for (byte i = 0; i <5 ; i++) {
                 number= i;
                createFile(number);
            }
            concatStreams();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void createFile(byte name) throws IOException {
        DataOutputStream dos = new DataOutputStream(
                new FileOutputStream("./src/ru/geekbrains/level_3/hw_3/"+name+".txt"));
        byte[] arr = new byte[100] ;
        for (byte i = 0; i <100 ; i++) {
            arr[i]=name;
        }
        dos.write(arr);
        dos.close();
    }

    public static void concatStreams() throws IOException{
        FileInputStream fis = new FileInputStream("./src/ru/geekbrains/level_3/hw_3/0.txt");
        FileInputStream fis_1 = new FileInputStream("./src/ru/geekbrains/level_3/hw_3/1.txt");
        FileInputStream fis_2 = new FileInputStream("./src/ru/geekbrains/level_3/hw_3/2.txt");
        FileInputStream fis_3 = new FileInputStream("./src/ru/geekbrains/level_3/hw_3/3.txt");
        FileInputStream fis_4 = new FileInputStream("./src/ru/geekbrains/level_3/hw_3/4.txt");
        ArrayList<InputStream> al = new ArrayList<>();
        al.add(fis); al.add(fis_1); al.add(fis_2); al.add(fis_3); al.add(fis_4);
        Enumeration<InputStream> e = Collections.enumeration(al);
        SequenceInputStream sis = new SequenceInputStream(e);
        DataOutputStream dos = new DataOutputStream(
                new FileOutputStream("./src/ru/geekbrains/level_3/hw_3/final.txt"));
        while(sis.read()!=-1){
            dos.write(sis.read());
        }
        dos.flush();
        dos.close();
    }


}
