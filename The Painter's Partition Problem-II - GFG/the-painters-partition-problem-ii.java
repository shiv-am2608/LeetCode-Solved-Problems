// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            String input_line1[] = read.readLine().trim().split("\\s+");
            int k = Integer.parseInt(input_line1[0]);
            int n = Integer.parseInt(input_line1[1]);
            String input_line[] = read.readLine().trim().split("\\s+");
            int arr[]= new int[n];
            for(int i = 0; i < n; i++)
                arr[i] = Integer.parseInt(input_line[i]);
            
            Solution ob = new Solution();
            System.out.println(ob.minTime(arr,n,k));
        }
    }
}

// } Driver Code Ends


//User function Template for Java

 class Solution{

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
    static long minTime(int[] arr,int n,int k){
        //code here
        return findAns(arr,n,k);
    }
}


