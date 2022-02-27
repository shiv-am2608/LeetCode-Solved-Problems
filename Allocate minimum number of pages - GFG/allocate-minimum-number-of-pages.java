// { Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
class GFG {
	public static void main (String[] args) {
		Scanner sc=new Scanner(System.in);
		
		int t=sc.nextInt();
		
		while(t-->0)
		{
		    int n=sc.nextInt();
		    int a[]=new int[n];
		    
		    for(int i=0;i<n;i++)
		    {
		        a[i]=sc.nextInt();
		    }
		    int m=sc.nextInt();
		    Solution ob = new Solution();
		    System.out.println(ob.findPages(a,n,m));
		}
	}
}// } Driver Code Ends


//User function Template for Java

class Solution 
{
    //Function to find minimum number of pages.
    static boolean isPossible(int arr[],int k,long curr)
    {
        long sum=0;
        int count=1;
        for(int i=0;i<arr.length;i++)
        {
            if(sum+arr[i]<=curr)
                sum+=arr[i];
            else
            {
                count++;
                sum=arr[i];
            }
        }
        return count<=k;
    }
    
    static long findAns(int arr[],int n,int k)
    {
       long low=Integer.MIN_VALUE;
       long high=0;
       for(int i=0;i<n;i++)
       {
           low=Math.max(low,arr[i]);
           high+=arr[i];
       }
       while(low<=high)
       {
            long mid=high-(high-low)/2;
            if(isPossible(arr,k,mid))
                high=mid-1;
            else
                low=mid+1;
       }
       return low;
    }
    public static int findPages(int[]A,int N,int M)
    {
        //Your code here
        return (int)findAns(A,N,M);
    }
};