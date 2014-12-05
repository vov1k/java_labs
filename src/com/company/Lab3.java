package com.company;

import java.math.BigInteger;

public class Lab3 {
    private BigInteger p; //simple number
    private BigInteger q; //simple number
    private BigInteger n; //simple p * sipmle q
    private BigInteger m; //(p-1)*(q-1)
    private BigInteger d; //private key
    private BigInteger e; //public key

    private long gcd(long a, long b) {
        if (b == 0) return a;
        long x = a % b;
        return gcd(b, x);
    }
}
