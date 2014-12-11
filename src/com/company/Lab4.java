package com.company;

import java.io.UnsupportedEncodingException;

public class Lab4 {
    private static int blockSize = 2; //кол-во бит / 8
    private static String key_code = "qw"; //ключ шифрования

    public static byte[][] getByteBlocks(String text) throws UnsupportedEncodingException {

    /* Весь текст в байтах */
        byte[] textBytes = text.getBytes();

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

    public byte[] encrypt(String in_str) throws UnsupportedEncodingException {
        byte[] byte_array = in_str.getBytes();

        byte[] key = key_code.getBytes();

        for (int i=0;i<byte_array.length;i++) {
            byte_array[i] = (byte)((byte_array[i]^key[i % key.length]));
                System.out.print(byte_array[i]+" ");
        }

        return byte_array;
    }

    public byte[] decrypt(byte[] byte_array) throws UnsupportedEncodingException {
      //  char[] char_array = in_str.toCharArray();
     //   byte[] byte_array = new byte[char_array.length];
        for (int i=0; i<byte_array.length;i++) {
            byte_array[i]  = (byte)(int)byte_array[i];
        }

        byte[] key = key_code.getBytes();

        for (int i=0;i<byte_array.length;i++) {
            byte_array[i] = (byte)((byte_array[i]^key[i % key.length]));
            System.out.print(byte_array[i]+" ");
        }

        return byte_array;
    }

}
