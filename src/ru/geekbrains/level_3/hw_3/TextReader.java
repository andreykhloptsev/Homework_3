package ru.geekbrains.level_3.hw_3;


import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

public class TextReader{

    public static void main(String[] args) {
        int pageNumber;
        Scanner scr = new Scanner(System.in);
        System.out.println("Enter page number: ");
        pageNumber = scr.nextInt();
        try {
            printPage(pageNumber);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void printPage(int number) throws IOException {
        RandomAccessFile raf = new RandomAccessFile("./src/ru/geekbrains/level_3/hw_3/lotr.txt", "r");
        raf.seek(number*1800);
        StringBuffer str = new StringBuffer();
        int size=0;
        while (size<=1800) {
            str.append(raf.readLine());
            size = str.length();
        }
        System.out.println(str.toString());
    }

}
