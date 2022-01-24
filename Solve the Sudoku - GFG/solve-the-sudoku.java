// { Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class Driver_class
{
    public static void main(String args[])
    {
        
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int grid[][] = new int[9][9];
            for(int i = 0; i < 9; i++)
            {
                for(int j = 0; j < 9; j++)
                grid[i][j] = sc.nextInt();
            }
            
            Solution ob = new Solution();
            
            if(ob.SolveSudoku(grid) == true)
                ob.printGrid(grid);
            else
                System.out.print("NO solution exists");
            System.out.println();
            
        }
    }
}



// } Driver Code Ends


//User function Template for Java

class Solution
{
    //Function to find a solved Sudoku. 
    static boolean isSafe(int grid[][],int i,int j,int k)
    {
        for(int l=0;l<9;l++)
            if(grid[i][l]==k || grid[l][j]==k)
                return false;
        i=i-i%3;
        j=j-j%3;
        for(int p=0;p<3;p++)
        {
            for(int q=0;q<3;q++)
            {
                if(grid[i+p][j+q]==k)
                    return false;
            }
        }
        return true;
    }
    static boolean SolveSudoku(int grid[][])
    {
        // add your code here
        int i=0,j=0;
        aa:
        for(i=0;i<9;i++)
            for(j=0;j<9;j++)
                if(grid[i][j]==0)
                    break aa;
        if(i==9 && j==9)
            return true;
        for(int k=1;k<=9;k++)
        {
            if(isSafe(grid,i,j,k))
            {
                grid[i][j]=k;
                if(SolveSudoku(grid))
                    return true;
                grid[i][j]=0;
            }
        }
        return false;
    }
    
    //Function to print grids of the Sudoku.
    static void printGrid (int grid[][])
    {
        // add your code here
        for(int i=0;i<9;i++)
        {
            for(int j=0;j<9;j++)
                System.out.print(grid[i][j]+" ");
        }
    }
}