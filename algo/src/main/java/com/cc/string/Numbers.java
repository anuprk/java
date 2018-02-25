package com.cc.string;

import java.util.Arrays;

/**
 * User: anup
 */
public class Numbers {


    public static void main ( String args[] )
    {
        Numbers main = new Numbers();
//        System.out.println(main.convertToBase( "", 6));

        System.out.println(Arrays.toString(main.twoSum( new int[] { 2, 7 ,11, 15}, 27)));

    }

    // this is brute force...can also use hashtable
    public int[] twoSum(int[] nums, int target) {
        for ( int i = 0; i < nums.length; i++)
        {
            for ( int j = i + 1 ; j < nums.length; j++ )
            {
                if( nums[i] + nums[j] == target)
                    return new int[] { i, j };
            }
        }
        return new int[] {0 , 0 };

//        Map<Integer, Integer> map = new HashMap<>();
//        for (int i = 0; i < nums.length; i++) {
//            int complement = target - nums[i];
//            if (map.containsKey(complement)) {
//                return new int[] { map.get(complement), i };
//            }
//            map.put(nums[i], i);
//        }
    }

    // convert 1011 with base 2
    public int convertToBase( String number, int base )
    {
        int value = 0;
        for ( int i = number.length() - 1; i >= 0; i--) {
            int digit = digitToValue ( number.charAt(i));
            if( digit < 0 || digit >= base )
                return -1;
            int exp = number.length() - 1 - i;
            value += digit * Math.pow( base, exp);
            System.out.println(" digit " + digit  + " exp " + exp + " value " + value + " base " + Math.pow( base  , exp));
        }
        return value;
    }

    public int digitToValue( char ch ) {
//        return (int) ch - 48; // Character.getNumericValue( ch );
        return Character.getNumericValue(ch);
    }
}
