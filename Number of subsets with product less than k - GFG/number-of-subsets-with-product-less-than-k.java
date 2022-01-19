// { Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int N = Integer.parseInt(read.readLine());
            
            String S[] = read.readLine().split(" ");
            int[] arr = new int[N];
            
            int K = Integer.parseInt(read.readLine());
            
            for(int i=0; i<N; i++)
                arr[i] = Integer.parseInt(S[i]);

            Solution ob = new Solution();
            System.out.println(ob.numOfSubsets(arr,N,K));
        }
    }
}// } Driver Code Ends


//User function Template for Java

class Solution {
    static int recur(int arr[],int start,int n,int k,int prod,int dp[][])
    {
        if(prod>k)
            return 0;
        if(start==n)
        {
            if(prod<=k)
                return 1;
            return 0;
        }
        if(dp[start][prod]!=-1)
            return dp[start][prod];
        int include=0,exclude=0;
        include=recur(arr,start+1,n,k,prod*arr[start],dp);
        exclude=recur(arr,start+1,n,k,prod,dp);
        dp[start][prod]=include+exclude;
        return include+exclude;
    }
    static int numOfSubsets(int[] arr, int N, int K) {
        // code here
        int dp[][]=new int[N+1][1000001];
        for(int i[]:dp)
            Arrays.fill(i,-1);
        return recur(arr,0,N,K,1,dp)-1;
    }
};