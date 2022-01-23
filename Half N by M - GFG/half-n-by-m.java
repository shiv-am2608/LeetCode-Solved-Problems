// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
import java.lang.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            String a[] = in.readLine().trim().split("\\s+");
            int N = Integer.parseInt(a[0]);
            int M = Integer.parseInt(a[1]);
            
            Solution ob = new Solution();
            System.out.println(ob.mthHalf(N, M));
        }
    }
}// } Driver Code Ends


//User function Template for Java

class Solution{
    static int mthHalf(int N, int M){
        // code here
        for(int i=0;i<M-1;i++)
            N=N>>1;
        return N;
    }
}