// { Driver Code Starts
//Initial template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG
{
    public static void main (String[] args)
	{
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-->0)
        {
            int n = sc.nextInt();
            int arr[]= new int[n];
            for(int i=0; i<n; i++)
                arr[i] = sc.nextInt();
            Solution ob = new Solution();
            if(ob.recreationalSpot(arr,n))
                System.out.println("True");
            else
                System.out.println("False");
        }
	}
}// } Driver Code Ends


//User function template for C++

class Solution{
    static boolean recreationalSpot(int[] arr , int n){
        // Your code goes here 
        int min[]=new int[n];
        
        min[0]=arr[0];
        for(int i=1;i<n;i++)
            min[i]=Math.min(min[i-1],arr[i]);
        
        Stack<Integer>st=new Stack<Integer>();
        for(int i=n-1;i>=0;i--)
        {
            while(!st.isEmpty() && st.peek()<=min[i])
                st.pop();
            if(!st.isEmpty() && st.peek()<arr[i])
                return true;
            st.push(arr[i]);
        }
        return false;
    }
};