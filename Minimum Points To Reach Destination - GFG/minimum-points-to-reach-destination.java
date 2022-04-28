// { Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*;
class GfG
{
    public static void main(String args[])
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    int m = sc.nextInt();
                    int n = sc.nextInt();
                    int points[][] = new int[m][n];
                    for(int i = 0;i<m;i++)
                    for(int j = 0;j<n;j++)
                    points[i][j] = sc.nextInt();
                    Solution ob = new Solution();
                    System.out.println(ob.minPoints(points,m,n));
                }
        }
}    // } Driver Code Ends


//User function Template for Java

class Solution
{
	public int minPoints(int points[][],int M,int N) 
	{ 
	    // Your code goes here
	   for(int i=M-1;i>=0;i--)
	   {
	       for(int j=N-1;j>=0;j--)
	       {
	            if(i==M-1 && j==N-1)
	                points[i][j]=Math.max(1,1-points[i][j]);
	            else if(i==M-1)
	                points[i][j]=Math.max(1,points[i][j+1]-points[i][j]);
	            else if(j==N-1)
	                points[i][j]=Math.max(1,points[i+1][j]-points[i][j]);
	            else
	                points[i][j]=Math.max(1,Math.min(points[i+1][j],points[i][j+1])-points[i][j]);
	       }
	   }
	   return points[0][0];
	} 
}