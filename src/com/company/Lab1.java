package com.company;

public class Lab1 {
    private String str_in;
    private String str_out;

    public Lab1(String str_in) {
        this.str_in = str_in;
    }

    public String Encrypt() {
        char[] ary = this.str_in.toCharArray();
        char ch;
        for(int i = 0; i < ary.length; i++) {
            if(i == 0 || i%2 == 0) {
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
        this.str_out = String.valueOf(ary);
        return this.str_out;
    }

    public String GetResult() {
        return this.str_out;
    }
}