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
            System.out.println();
            printPageSV(pageNumber);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void printPage(int number) throws IOException {
        //не понятно что делать с очень длинными строками
        //размер страницы очень сильно плавает
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

    public static void printPageSV(int number) throws IOException {
        //при считывании образуются непонятные символы типа "ﾑ" или "ﾒ". Кажется они весят больше одного байта
        RandomAccessFile raf = new RandomAccessFile("./src/ru/geekbrains/level_3/hw_3/lotr.txt", "r");
        raf.seek(number*1800);
        StringBuffer str = new StringBuffer();
        for (int i = 0; i <1800 ; i++) {
            str.append((char)raf.readByte());
        }
        System.out.println(str.toString());
    }

}
