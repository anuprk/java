package com.cc.string;

import java.util.Arrays;

/**
 * User: anup
 */
public class Strings {


    public static void main( String argsp[ ])
    {
        Strings main = new Strings();
//        System.out.println(new Strings().hasUniqueCharsBrutForce("tttesting"));
//        System.out.println(new Strings().ucBitMap("abcdeff"));
//        System.out.println(new Strings().ucBitMap("abcdef"));

        // permutations
//        System.out.println(main.permutation("apple", "pplea"));
//        System.out.println(main.permutation("appale", "pplea"));

        // URLify
        System.out.println(main.URLify("Mr. John Smith    "));
    }

    public boolean hasUniqueCharsBrutForce( String str )
    {

        // str=testing
        boolean hasUnique = true;
        char[] chars = str.toCharArray();
        for( int i = 0 ; i < chars.length; i++ )
        {
            for( int j = i+1; j < chars.length; j++ )
            {
                if( chars[i] == chars[j])
                {
                    hasUnique = false;
                    break;
                }
            }
        }
        return hasUnique;
    }

    // use bitmap. set bit in int/long to on for given
    public boolean ucBitMap( String str )
    {
        int bitmap = 0;
        char[] chars = str.toCharArray();
        for( int i = 0; i < chars.length; i ++ )
        {
            int value = chars[i] - 48; // 'a'
            if( (bitmap & ( 1 << value)) > 0 ) return false;
            bitmap |= 1 << value;

        }
        return true;
    }

    public boolean ucHashMap( String str )
    {
        char[] chars = str.toCharArray();
        boolean[] map = new boolean[128];
        for( int i = 0; i < chars.length; i ++)
        {
            if( map[chars[i] - 48])
                return false;
            map[chars[i]-48] = true;
        }
        return true;
    }

    //
    public boolean permutation( String str1, String str2 )
    {

        char[] mainc = str1.toCharArray();
        char[] oc = str2.toCharArray();

        Arrays.sort(mainc);
        Arrays.sort(oc);

        return Arrays.equals(mainc, oc);

    }

    public String URLify( String input )
    {
        char[] chars = input.toCharArray();
        for( int i = 0; i < chars.length; i++)
        {
            if( chars[i] == ' ')
            {
                chars[i] = '%';
                chars[++i] = '2';
                chars[++i] = '0';
            }
        }
        return new String( chars );
    }
}
