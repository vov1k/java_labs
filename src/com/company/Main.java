package com.company;

import com.sun.xml.internal.messaging.saaj.util.Base64;

import java.io.IOException;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        Lab3 l3 = new Lab3();
        l3.write_A_B();
        String res = l3.encrypt("Какой-то text @#$");
        System.out.println(res);
        String res2 = l3.decrypt(res);
        System.out.println(res2);
    }
}
