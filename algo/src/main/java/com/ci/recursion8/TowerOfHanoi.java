package com.ci.recursion8;

import java.util.Stack;

/**
 * User: anup
 */
public class TowerOfHanoi {

    public static void main ( String args[] )
    {
        int n = 10;
        Tower[] towers = new Tower[3];
        for(int i = 0; i<3; i++) {
            towers[i] = new Tower(i);
        }

        for ( int i = n -1 ; i >= 0; i--) {
            towers[0].add(i);
        }
        System.out.println("Tower of Hanoi tower 0" + towers[0].disks);
        towers[0].moveDisks(n, towers[2], towers[1]);

        System.out.println("Tower of Hanoi tower 0 " + towers[0].disks);
        System.out.println("Tower of Hanoi tower 1 " + towers[1].disks);
        System.out.println("Tower of Hanoi tower 2 " + towers[2].disks);
    }

    static class Tower {
        private Stack<Integer> disks;
        int index;

        public Tower( int i) {
            disks = new Stack<Integer>();
            index = i;
        }

        public void add( int disk ) {
            if( !disks.isEmpty() && disks.peek() <= disk ) {
                System.out.println("Error in placing disk" + disk);
                return;
            }
            disks.push(disk);
        }

        public void moveTopTo( Tower destination ) {
            int top = disks.pop();
            destination.add(top);
        }

        public void moveDisks( int n, Tower destination, Tower buffer) {
            if( n > 0 ) {
                moveDisks( n - 1, buffer, destination );
                moveTopTo( destination );
                buffer.moveDisks( n -1, destination, this );
            }
        }

    }

}
