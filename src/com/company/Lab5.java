package com.company;

import java.util.Arrays;

public class Lab5 {
    public String encrypt(String in_str) {
        byte[] byte_arr = in_str.getBytes();
        String[] bin_str = new String[byte_arr.length];
        for(int i=0; i<byte_arr.length; i++) {
            bin_str[i] = Integer.toBinaryString((int)byte_arr[i]);
            while(bin_str[i].length() < 8) {
                bin_str[i] = "0"+bin_str[i];
            }
            bin_str[i] = bin_str[i].substring(bin_str[i].length()-8, bin_str[i].length());
        }
        bin_str = setBit(bin_str);
        String result = "";
        for(String s: bin_str) {
            result += s+" ";
        }
        return result;
    }

    public String[] setBit(String[] in_arr) {
            for(int i=0; i < in_arr.length; i++) {
                int sum_1 = 0;
                char[] c = in_arr[i].toCharArray();
                for(char ch: c) {
                    if (ch == '1')
                        sum_1++;
                }
                if (sum_1%2 == 0)
                    in_arr[i] = in_arr[i]+'1';
                else
                    in_arr[i] = in_arr[i]+'0';
            }
        return in_arr;
    }

    public String decrypt(String in_str) {
        String[] bin_str = in_str.split(" ");

        for(int i=0; i<bin_str.length; i++) {
            System.out.println(bin_str[i]);
            char[] c = bin_str[i].toCharArray();
            int sum_1 = 0;
            for (int j=0; j<8; j++) {
                    if (c[j] == '1')
                        sum_1++;
            }
            char bit = '0';
            if (sum_1%2 == 0)
                bit = '1';

            if (bit != c[8])
                bin_str[i] += "(Ошибка)";
        }
        String result = "";
        for(String s: bin_str) {
            result += s+" ";
        }
        return result;
    }
}
