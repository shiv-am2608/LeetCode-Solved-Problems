// { Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class Driver
{
    public static void main(String args[]) 
	{ 
	    Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int []a = new int[n];
            for (int i = 0; i < n; i++) a[i] = sc.nextInt();
            
            int  m= sc.nextInt();
            int []b = new int[m];
            for (int i = 0; i < m; i++) b[i] = sc.nextInt();
            
            double res = new GFG().medianOfArrays(n, m, a, b);
            
            if (res == (int)res) System.out.println ((int)res);
            else System.out.println (res);
        }
    		
	} 
}// } Driver Code Ends


//User function Template for Java

class GFG 
{ 
    static double medianOfArrays(int n, int m, int a[], int b[]) 
    {
        // Your Code Here
        if(n>m)
            return medianOfArrays(m,n,b,a);
        int low=0,high=n;
        while(low<=high){
            int m1=high-(high-low)/2;
            int m2=(n+m)/2-m1;
            
            int l1= m1==0?Integer.MIN_VALUE:a[m1-1];
            int l2= m2==0?Integer.MIN_VALUE:b[m2-1];
            
            int r1= m1==n?Integer.MAX_VALUE:a[m1];
            int r2= m2==m?Integer.MAX_VALUE:b[m2];
            
            if(l1<=r2 && l2<=r1){
                if((n+m)%2!=0)
                    return Math.min(r1,r2);
                return (Math.max(l1,l2)+Math.min(r1,r2))/(double)2;
            }
            if(l1>r2)
                high = m1-1;
            else
                low = m1+1;
        }
        return -1;
    }
}