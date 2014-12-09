package com.company;

import com.sun.xml.internal.messaging.saaj.util.Base64;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException, ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {
    /*    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Lab1 lab1 = new Lab1();
        Lab2 lab2 = new Lab2(); lab2.generateNumbers();
        Lab3 lab3 = new Lab3(); lab3.write_A_B();


        String help_text = "Справка по использованию:\n";
        help_text += "lab1 - Проверить 1 лаб. работу\n";
        help_text += "encode - закодировать сообщение\n";
        help_text += "decode - раскодировать сообщение\n";
        help_text += "Пример: lab1 encode text\n";
        help_text += "exit - Выход\n";
        help_text += "==================================================\n";
        System.out.println(help_text);

        while(true) {
            try {
                String command = reader.readLine();
                String[] arr_command = command.split(" ");
                String result = "";

                if (arr_command[0].equals("exit")) {
                    System.out.println("Buy ...");
                    break;
                }
                if (arr_command[0].equals("help")) {
                    System.out.println(help_text);
                    continue;
                }

                String in_str = "";
                for(int i=2; i<arr_command.length; i++) {
                    in_str += arr_command[i]+" ";
                }
                in_str = in_str.substring(0,in_str.length()-1);

                switch(arr_command[0].charAt(3)) {
                    case '1' :
                        if(arr_command[1].equals("encode"))
                            result = lab1.encrypt(in_str);
                        else if (arr_command[1].equals("decode"))
                            result = lab1.decrypt(in_str);
                        else
                            System.out.println("Ошибка. неверная команда "+arr_command[0]+" "+arr_command[1]+" "+arr_command[2]);
                        break;
                    case '2' :
                        if(arr_command[1].equals("encode"))
                            result = lab2.encrypt(in_str);
                        else if (arr_command[1].equals("decode"))
                            result = lab2.decrypt(in_str);
                        else
                            System.out.println("Ошибка. неверная команда "+arr_command[0]+arr_command[1]+arr_command[2]);
                        break;
                    case '3' :
                        if(arr_command[1].equals("encode"))
                            result = lab3.encrypt(in_str);
                        else if (arr_command[1].equals("decode"))
                            result = lab3.decrypt(in_str);
                        else
                            System.out.println("Ошибка. неверная команда "+arr_command[0]+" "+arr_command[1]+" "+arr_command[2]);
                        break;
                    case '4' :
                        break;
                    case '5' :
                        break;
                }
                System.out.println(result);


            } catch (Exception e) {
                System.out.println("Ошибка. Неверная команда. "+e.toString());
            }
        }*/


        Lab4 l4 = new Lab4();
        String code = l4.encrypt("разный текст");
        System.out.println(code);
        code = l4.decrypt(code);
        System.out.println(code);
    }
}
