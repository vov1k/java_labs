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

    public String encrypt(String in_str) throws UnsupportedEncodingException {
        byte[] byte_array = in_str.getBytes();
        String result = "";
        byte[] key = key_code.getBytes();

        for (int i=0;i<byte_array.length;i++) {
            byte_array[i] = (byte)((byte_array[i]^key[i % key.length]));
            result += byte_array[i]+"O";
        }

        return result;
    }

    public String decrypt(String in_str) throws UnsupportedEncodingException {
        String[] arr_in = in_str.split("O");
        byte[] key = key_code.getBytes();
        byte[] byte_in = new byte[arr_in.length];
        for(int i=0; i<arr_in.length; i++) {
            byte b = Byte.parseByte(arr_in[i]);
            byte_in[i] = (byte)((b^key[i % key.length]));
        }
        String result = new String(byte_in);

        return result;
    }

}
