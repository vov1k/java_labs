package com.company;

import java.math.BigInteger;
import java.util.Random;

public class Lab3 {
    private BigInteger q; //известное число 1
    private BigInteger n; //известное число 2
    private BigInteger x; //simple number
    private BigInteger y; //simple number
    private BigInteger a; //q^x mod n
    private BigInteger b; //q^y mod n
    private int key_X;
    private int key_Y;

    public Lab3() {
        int size = 80;
        Random rnd = new Random();
        //выбираем случайные простые числа, с помощью волшебной функции в java
        x = BigInteger.probablePrime(size / 2, rnd);
        y = this.x.nextProbablePrime();
        q = BigInteger.valueOf(17);
        n = BigInteger.valueOf(23);
        System.out.println("x: " + x);
        System.out.println("y: " + y);
        System.out.println("n: " + n);
        System.out.println("q: " + q);
    }

    public void write_A_B() {
        this.a = q.modPow(x, n);
        this.b = q.modPow(y, n);
        System.out.println("A="+this.a.toString()+" B="+this.b.toString());
    }

    public String encrypt(String input_str) {
        key_X = a.modPow(y,n).intValue();
        System.out.println("key for encode "+key_X);
        String out_string = "";
        for (int i=0;i<input_str.length();i++) {
            int new_code = (int)input_str.charAt(i);
            BigInteger d2 = BigInteger.valueOf(new_code).pow(key_X);
            out_string += d2.toString()+"O";
        }
        return out_string;
    }

    //Использую метод ньютона для поиcка корня n степени
    public int SqRtN(BigInteger digit, int n)
    {
        // x(k+1) = 1/n * ((n-1)*x(k) + A/x(k)^(n-1));
        int m = n-1;
        BigInteger x1 = new BigInteger("1");
        while (true) {
            BigInteger x_1 = x1.multiply(BigInteger.valueOf(m));
            BigInteger x_2_2 = x1.pow(m);
            BigInteger x_2 = digit.divide(x_2_2);
            BigInteger x_0 = x_1.add(x_2);
            BigInteger res = x_0.divide(BigInteger.valueOf(n));
            if (res.equals(x1)) {
                return res.intValue();
            }
            x1 = res;
        }
    }

    public String decrypt(String input_str) {
        key_Y = b.modPow(x,n).intValue();
        System.out.println("key for decode "+key_Y);
        String[] str_arr = input_str.split("O");
        String output_string = "";
        for(String str: str_arr) {
            BigInteger big = new BigInteger(str);
            int int_code = SqRtN(big, key_Y);
            output_string += (char)int_code;
        }
        return output_string;
    }
}
