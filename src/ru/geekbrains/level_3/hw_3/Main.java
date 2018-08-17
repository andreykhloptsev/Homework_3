package ru.geekbrains.level_3.hw_3;


import java.io.*;

public class Main {

    public static void main(String[] args) {
        try {
            createFileWithData("datafile.txt");
            readFromFile("datafile.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    public static void createFileWithData(String name) throws IOException{
        File f = new File(name);
        f.createNewFile();
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(f));
        byte[] arr= new byte[127];
        for (byte i = 0; i <127 ; i++) {
            arr[i]=i;
        }
        bos.write(arr);
        bos.flush();
    }

    public static void readFromFile(String name) throws IOException{
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(name));
        byte[] array = new byte[127];
        bis.read(array);
        for (int i = 0; i <array.length ; i++) {
            System.out.print(array[i]);
            System.out.print(' ');
        }



    }


}
