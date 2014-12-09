package com.company;

public class Lab1 {

    public String encrypt(String str_encode) {
        char[] ary = str_encode.toCharArray();
        char ch;
        for(int i = 0; i < ary.length; i++) {
            if(i == 0 || i%2 == 0) { //test commit
                if (i == ary.length - 1) {
                    break;
                }
                ch = ary[i];
                ary[i] = ary[i+1];
                ary[i+1] = ch;
            }
            else {
                continue;
            }
        }
        String result = String.valueOf(ary);
        return result;
    }

    public String decrypt(String str_decode) {
        return encrypt(str_decode);
    }
}