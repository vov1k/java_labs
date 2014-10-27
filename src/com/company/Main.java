package com.company;


public class Main {

    public static void main(String[] args) {
        Lab2 l2 = new Lab2();
        System.out.println("Начинаем генерацию чисел ...");
        l2.generateNumbers();
        String str = l2.encrypt("abc");
        str = l2.decrypt(str);
    }
}
