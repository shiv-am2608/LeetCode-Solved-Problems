// { Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            String s[] = in.readLine().trim().split("\\s+");
            int n = Integer.parseInt(s[0]);
            int m = Integer.parseInt(s[1]);
            String arr[] = in.readLine().trim().split("\\s+");
            int mat[][] = new int[n][m];
            for(int i = 0;i < n*m;i++)
                mat[i/m][i%m] = Integer.parseInt(arr[i]);
            int x = Integer.parseInt(in.readLine());
            
            Solution ob = new Solution();
            System.out.println(ob.isSuperSimilar(n, m, mat, x));
        }
    }
}// } Driver Code Ends


// User function Template for Java

class Solution{
    static void reverse(int arr[],int i,int j)
    {
        while(i<j)
        {
            int temp=arr[i];
            arr[i]=arr[j];
            arr[j]=temp;
            i++;
            j--;
        }
    }
    static void leftRotate(int arr[],int x)
    {
        reverse(arr,0,x-1);
        reverse(arr,x,arr.length-1);
        reverse(arr,0,arr.length-1);
    }
    static void rightRotate(int arr[],int x)
    {
        reverse(arr,0,arr.length-1);
        reverse(arr,0,x-1);
        reverse(arr,x,arr.length-1);
    }
    static int isSuperSimilar(int n, int m, int mat[][], int x)
    {
        // code here
        x=x%m;
        int copy[][]=new int[n][m];
        for(int i=0;i<n;i++)
            for(int j=0;j<m;j++)
                copy[i][j]=mat[i][j];
        for(int i=0;i<mat.length;i+=2)
            leftRotate(mat[i],x);
        for(int i=1;i<mat.length;i+=2)
            rightRotate(mat[i],x);
            
         for(int i=0;i<n;i++)
            for(int j=0;j<m;j++)
                if(copy[i][j]!=mat[i][j])
                    return 0;
        return 1;
    }
}