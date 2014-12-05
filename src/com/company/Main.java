package com.company;

import com.sun.xml.internal.messaging.saaj.util.Base64;

import java.io.IOException;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {

        Lab2 l2 = new Lab2();
        System.out.println("Начинаем генерацию чисел ...");
        l2.generateNumbers();
        String str = l2.encrypt("Сюда вставляем @любой $текст. english available too#");
        System.out.println(str);
        str = l2.decrypt(str);
        System.out.println(str);
    }
}
