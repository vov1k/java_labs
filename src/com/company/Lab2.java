package com.company;

import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;
import com.sun.xml.internal.messaging.saaj.packaging.mime.util.BASE64DecoderStream;
import sun.misc.BASE64Decoder;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Random;

import static java.lang.StrictMath.abs;

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
        this.d = e.modInverse(m);

        System.out.println("p: " + p);
        System.out.println("q: " + q);
        System.out.println("m: " + m);
        System.out.println("n: " + n);
        System.out.println("Public key: " + e);
        System.out.println("Private key: " + d);
    }

    public String encrypt(String input_str) throws UnsupportedEncodingException {
        ArrayList<Integer> chars = new ArrayList<Integer>();
        for (int i=0;i<input_str.length();i++) {
            chars.add((int)input_str.charAt(i));
        }
        ArrayList<String> blocks = new ArrayList<String>();
        String str = "";
        String output_str = "";
        for (int i = 0; i < chars.size(); i++) {
            String short_str = chars.get(i).toString();
            while(short_str.length() < 4) {
                short_str = "0"+short_str;
            }
            str += short_str;

            if (i == chars.size() - 1 && (i+1)%4 != 0) {
                long data = Long.parseLong(str);
                BigInteger ch = BigInteger.valueOf(data);
                BigInteger encode_block = ch.modPow(d, n);
                blocks.add(encode_block.toString());
                break;
            }
            if ((i+1)%4 == 0) {
                long data = Long.parseLong(str);
                BigInteger ch = BigInteger.valueOf(data);
                BigInteger encode_block = ch.modPow(d, n);
                blocks.add(encode_block.toString());
                str = "";
            }
        }
        for(String block: blocks) {
            output_str += block+"O";
        }
        return output_str;
    }

    public String decrypt(String input_str) throws IOException {

        String[] str_arr = input_str.split("O");
        String output_string = "";
        for (int i=0; i<str_arr.length; i++) {
            BigInteger dig_block = new BigInteger(str_arr[i]);
            BigInteger decode_ch = dig_block.modPow(e, n);
            str_arr[i] = decode_ch.toString();
        }
        for(String block_decode: str_arr) {
            while(block_decode.length()%4 != 0) {
                block_decode = "0"+block_decode;
            }
            String temp_str = "";
            for(int i=0; i<block_decode.length(); i++) {
                temp_str += block_decode.charAt(i);
                if ((i+1)%4 == 0) {
                    output_string += (char)Integer.parseInt(temp_str);
                    temp_str = "";
                }
            }
        }
        return output_string;
    }

 }
