// { Driver Code Starts
//Initial Template for Java


import java.io.*;
import java.util.*;


class Array {
	public static void main (String[] args) {
        
        Scanner sc = new Scanner(System.in);
        
        int t = sc.nextInt();
        while(t-- > 0)
        {
            int n = sc.nextInt();
            int a[] = new int[n + 1];
            
            for(int i=0;i<n;i++){
                a[i] = sc.nextInt();
            }
            
            Solution ob = new Solution();
            
            System.out.println(ob.print2largest(a,n));
        }
        
	}
}// } Driver Code Ends


//User function Template for Java

class Solution
{ 
    public static int print2largest(int A[],int N) 
    {
        //CODE HERE
        int first=Integer.MIN_VALUE,second=Integer.MIN_VALUE;
        for(int i=0;i<N;i++)
        {
            if(first<A[i])
            {
                second=first;
                first=A[i];
            }
            else if(A[i]<first && A[i]>second)
                second=A[i];
        }
        return second==Integer.MIN_VALUE?-1:second;
    }
}
        
