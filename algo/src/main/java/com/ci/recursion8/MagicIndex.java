package com.ci.recursion8;

/**
 * User: anup
 */
public class MagicIndex {

    private int magicFast( int[] array )
    {
        return magicFast( array, 0, array.length - 1);
    }

    //a[-40,-10,-1,1,2,3,5,7,9,12,13]
    // this algo works with distict array    - binary search
    private int magicFast( int[] array, int start, int end )
    {
        if( end < start )
            return -1;
        int mid = ( start + end )/2;
        if( array[mid] == mid)
            return mid;
        else if( array[mid] < mid )
            return magicFast( array, mid+1, end);
        else
            return magicFast( array, start, mid-1);

    }

    //a[-40,-10,2,2,2,3,5,7,9,12,13]
    // this algo works with non-distict array
    private int magicFastNonDistinct( int[] array, int start, int end )
    {
        if( end < start )
            return -1;
        int mid = ( start + end )/2;
        if( array[mid] == mid)
            return mid;

        //search in both sides

        // search left
        int leftIndex = Math.min(mid-1, array[mid]);
        int left = magicFast(array, start, leftIndex);
        if( left >=0 )
            return left;

        // search right
        int rightIndex = Math.min( mid+1, array[mid]);
        int right = magicFastNonDistinct(array, rightIndex, end);

        return right;

    }


    public static void main ( String args[]) {
        MagicIndex mi = new MagicIndex();

        int[] a = new int[] { -40,-10,-1,1,2,3,5,7,9,12,13 };
        System.out.println(mi.magicFast(a));

        a = new int[] { -40,-10,2,2,2,3,5,7,9,12,13 };
        System.out.println(mi.magicFastNonDistinct(a, 0, a.length));
    }

}
