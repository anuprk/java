package com.cc.string;

/**
 * User: anup
 */
public class ReverseString
{

    public static void main( String args[] )
    {
        new ReverseString().stringPermutation("slot");
    }

    public void reverseString()
    {
        // use of stack??
//        String str = "1+2*3-20";
//        char[] chars = str.toCharArray();
//        char[] newArray = new char[ chars.length ];
//        for( char c : chars )
//        {
//            if( c != '-' || c != '+' || c != '*' || c != '/')
//            {
//
//            }
//        }
    }

    public void stringPermutation( String str )
    {
        permutation( str, "");
    }

    private void permutation( String str, String prefix )
    {
        if( str.length() == 0 )
            System.out.println(">>>>" + prefix);
        else {
            for( int i = 0; i < str.length(); i++ ) {
                String rem = str.substring(0, i) + str.substring( i+1 );
                System.out.println(str + ", " + prefix + ", " + rem + ", " + prefix + str.charAt(i));
                permutation( rem, prefix + str.charAt( i ));
            }
        }
    }
}
