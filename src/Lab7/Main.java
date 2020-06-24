package Lab7;

import java.io.*;

public class Main {

    public static byte byteProcess(byte b) {
        int c = b;
        if ((c & 1) == 0) c = c | 0x80;
        return (byte) c;
    }

    public static String byteToString(byte b) {

        System.out.println("byteToString open\n");//------------------------------------
        String str = "";

        for (int i = 1; i <= 8; i++) {
            System.out.println("1) str\t=== " + str);
            System.out.printf("1) b\t=== %h\n", b);
            str = b < 0 ? str +"1" : str + "0";
            b = (byte) (b << 1);
            System.out.println("2) str\t=== " + str);
            System.out.printf("1) b\t=== %h\n", b);
        }

        System.out.println("byteToString close\n");//------------------------------------

        return str;
    }


    public static void main(String[] args) throws IOException {
        byte b = 0;
        int d = 0;
        FileInputStream fi = null; //ссылка напоток ввода
        FileOutputStream fo = null; //ссылка напоток вывода
        try {
// создаем потоки fi и fo и связываем их с файлами
            fi = new FileInputStream("resources/BytesStream.txt");
            fo = new FileOutputStream("resources/BytesStreamOut.txt");
// пока в потоке ввода есть данные
            while ((d = fi.read()) != -1) { //ввести очередной байт из потока fi
                b = (byte) d; //выделить младший байт из четырех (d – int)
                System.out.print(byteToString(b) + " --> "); // байт до изменения
                b = byteProcess(b); // обработка байта
                System.out.println(byteToString(b)); // байт после изменения
                fo.write(b); //вывести байт в поток fo
            }
        } catch (IOException e) {
            System.out.println("error:\n" + e);
        } //ошибка ввода-
// вывода
        finally {
            if (fi != null) fi.close();
            if (fo != null) fo.close();
        } //закрыть потоки,
//если они открыты
    }
}

