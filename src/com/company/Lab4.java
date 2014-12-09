package com.company;

import java.io.UnsupportedEncodingException;

public class Lab4 {
    private static int blockSize = 1; //кол-во бит / 8
    private static String key_code = "qw"; //ключ шифрования

    public static byte[][] getByteBlocks(String text) throws UnsupportedEncodingException {

    /* Весь текст в байтах */
        byte[] textBytes = text.getBytes("UTF-8");

    /* Если текст слишком маленький для блока */
        if(blockSize > textBytes.length) {
            return new byte[][] { textBytes };
        }

    /* Количество блоков на которое будет происходить разбиение */
        int blockCount = textBytes.length / blockSize;
        if(blockCount % textBytes.length > 0) blockCount++;

    /* Создаем новый массив, в котором будут храниться данные разбитые по блокам */
        byte[][] finalArray = new byte[blockCount][blockSize];

        int pos = 0;

        try {

            for(int i=0; i<finalArray.length; i++) {
                for(int j=0; j<finalArray[i].length; j++) {
                    finalArray[i][j] = textBytes[pos++];
                }
            }

        } catch(ArrayIndexOutOfBoundsException e) {
            return finalArray;
        }

        return finalArray;
    }

    public String encrypt(String in_str) throws UnsupportedEncodingException {
        byte[][] byte_array = this.getByteBlocks(in_str);

        byte[] key = key_code.getBytes("UTF-8");
        int[][] res = new int[byte_array.length][blockSize];

        for (int i=0;i<byte_array.length;i++) {
            for(int j=0; j<byte_array[i].length; j++) {
                res[i][j] = byte_array[i][j]^key[j];
                System.out.print(byte_array[i][j]+" ");
            }
        }

        String result = "";
        for (int i=0;i<res.length;i++) {
            for(int j=0; j<res[i].length; j++) {
                result += (char)((byte)res[i][j]);
            }
        }

        return result;
    }

    public String decrypt(String in_str) throws UnsupportedEncodingException {
        byte[][] byte_array = this.getByteBlocks(in_str);

        byte[] key = key_code.getBytes("UTF-8");
        int[][] res = new int[byte_array.length][blockSize];

        for (int i=0;i<byte_array.length;i++) {
            for(int j=0; j<byte_array[i].length; j++) {
                res[i][j] = byte_array[i][j]^key[j];
            }
        }

        String result = "";
        for (int i=0;i<res.length;i++) {
            for(int j=0; j<res[i].length; j++) {
                result += (char)((byte)res[i][j]);
            }
        }

        return result;
    }

}
