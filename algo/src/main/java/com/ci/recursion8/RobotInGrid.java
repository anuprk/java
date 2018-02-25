package com.ci.recursion8;

import com.sun.tools.javac.util.Assert;

import java.util.ArrayList;
import java.util.HashSet;

/**
 * User: anup
 */
public class RobotInGrid {

    class Point {
        int row;
        int col;
        public Point( int row, int col)
        {
            this.row = row;
            this.col = col;
        }
        public String toString()
        {
            return "[" + row + "," + col + "]";
        }
    }

    //NOTE: failedPath is used to cache result of already visited path.
    // Print row and col and see that the same col is used multiple times.
    private ArrayList<Point> getPath(boolean[][] maze) {
        if ( maze == null || maze.length == 0) return null;
        ArrayList<Point> path = new ArrayList<Point>();
        HashSet<Point> failedPath = new HashSet<Point>();
        if( getPath( maze, maze.length - 1, maze[0].length - 1, path, failedPath))
            return path;
        return null;
    }

    private boolean getPath( boolean[][] maze, int row, int col, ArrayList<Point> path, HashSet<Point> failedPath) {
        if( row < 0 || col < 0 || !maze[row][col]) {
            return false;
        }

        System.out.println("for row " + row + " and col " + col + " " + maze[row][col]) ;
        boolean isAtOrigin = ( row == 0 ) && ( col == 0);

        Point p = new Point( row, col);
        if( failedPath.contains( p))
            return false;

        if( isAtOrigin || getPath(maze, row, col-1, path, failedPath) || getPath( maze, row-1,col, path, failedPath) ) {
            path.add(p);
            return true;
        }
        failedPath.add(p);
        return false;
    }

    public static void main( String args[])
    {
        RobotInGrid rig = new RobotInGrid();
        boolean[][] maze = new boolean[][] {
                {true, true, false},
                {false, true, true},
                {false, false, true}
        };
        ArrayList<Point> path = rig.getPath(maze);
        System.out.println(path);
    }


}
