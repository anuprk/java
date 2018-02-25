package com.ci.recursion8;

/**
 * User: anup
 */
public class RecursiveMultiply {

    public int multiplyByAdd( int a, int b) {
        int p = 0;
        for ( int i = 1; i <= b; i++ )
            p = p + a;
        return p;
    }

    //https://en.wikipedia.org/wiki/Multiplication_algorithm#Peasant_or_binary_multiplication
    public int peasantAlgorithm( int a, int b ) {
        if (a < b) return peasantAlgorithm(b, a);
        int p = 0;
        while ( a > 0) {
            if( (a%10)%2 == 1)
                p += b;
            a >>= 1;
            b <<= 1;
        }
        return p;
    }



    public static void main ( String args[] ) {
        RecursiveMultiply rm  = new RecursiveMultiply();
        int r = rm.multiplyByAdd(123,379);
        System.out.println(r);
        System.out.println(rm.peasantAlgorithm(123,379));
    }
}
