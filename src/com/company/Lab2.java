package com.company;

import java.math.BigInteger;
import java.util.Random;

public class Lab2 {
    private BigInteger p; //simple number
    private BigInteger q; //simple number
    private BigInteger n; //simple p * sipmle q
    private BigInteger m; //(p-1)*(q-1)
    private BigInteger d; //private key
    private BigInteger e; //public key

    //Алгоритм Евклида. Алгоритм для нахождения наибольшего
    //общего делителя двух целых чисел. Используется для проверки
    //чисел на взаимопростоту.
    private long gcd(long a, long b) {
        if (b == 0) return a;
        long x = a % b;
        return gcd(b, x);
    }

    //Получаем взаимопростое чилсло с m, это будет число e
    public static BigInteger getCoprime(BigInteger m) {
        Random rnd = new Random();
        int length = m.bitLength()-1;
        BigInteger e = BigInteger.probablePrime(length,rnd);
        while (! (m.gcd(e)).equals(BigInteger.ONE) ) {
            e = BigInteger.probablePrime(length,rnd);
        }
        return e;
    }

    // Генерация ключей для кодирования/декодирования
    public void generateNumbers() {
        int size = 80;
        Random rnd = new Random();

        //выбираем случайные простые числа, с помощью волшебной функции в java
        p = BigInteger.probablePrime(size / 2, rnd);
        q = this.p.nextProbablePrime();

        //Получаем n как произведение p*q
        n = p.multiply(q);

        //Получаем m как произведение (p-1)*(q-1)
        m = (p.subtract(BigInteger.ONE)).multiply(
                q.subtract(BigInteger.ONE));
        e = getCoprime(m);

        //Ищем такое d, при котором будет верно выражение e*d % (p-1)*(q-1) = 1
        //В java для этого уже есть чудесная функция
        BigInteger d = e.modInverse(m);

        System.out.println("p: " + p);
        System.out.println("q: " + q);
        System.out.println("m: " + m);
        System.out.println("n: " + n);
        System.out.println("Public key: " + e);
        System.out.println("Private key: " + d);
    }

    public String encrypt(String input_str) {
        byte[] input_chars = input_str.getBytes();
        String output_str = "";
        for(int i=0; i<input_chars.length; i++) {
            BigInteger ch = BigInteger.valueOf((int)input_chars[i]);
            BigInteger encode_ch = ch.modPow(e, n);
            System.out.println("encode = "+encode_ch);
        }
        System.out.println("encode str = : " + output_str);
        return output_str;
    }

    public String decrypt(String input_str) {
        byte[] input_chars = input_str.getBytes();
        String output_str = "";
        for(int i=0; i<input_chars.length; i++) {
            BigInteger ch = BigInteger.valueOf((int)input_chars[i]);
            BigInteger encode_ch = ch.modPow(d, n);
            System.out.println("encode = "+encode_ch);
            output_str += Character.toString((char)encode_ch.intValue());
        }
        System.out.println("encode str = : " + output_str);
        return output_str;
    }

 }
