package com.ci.recursion8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * User: anup
 */
public class PowerSet {

    public ArrayList<ArrayList<Integer>> getSubsets(List<Integer> set, int index ) {
        ArrayList<ArrayList<Integer>> allSubsets;
        if(set.size() == index ) {
            allSubsets = new ArrayList<ArrayList<Integer>> ();
            allSubsets.add(new ArrayList<Integer>()) ; // Add empty set
        } else {
            allSubsets = getSubsets(set, index+1);
            int item = set.get(index);
            ArrayList<ArrayList<Integer>> moreSubsets = new ArrayList<ArrayList<Integer>> ();
            for( ArrayList<Integer> subset : allSubsets ) {
                ArrayList<Integer> newSubset = new ArrayList<Integer>();
                newSubset.addAll(subset);
                newSubset.add(item);
                moreSubsets.add(newSubset);
            }
            allSubsets.addAll(moreSubsets);
        }
        return allSubsets;
    }


    public static void main (String args [] ) {

        PowerSet ps = new PowerSet();
        ArrayList<ArrayList<Integer>> result = ps.getSubsets(Arrays.asList(1,2,3,4), 0);
        System.out.print("Result " + result.size() + " , " + result);
    }
}
