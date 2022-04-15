// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            int N = Integer.parseInt(in.readLine());
            String arr[] = in.readLine().trim().split("\\s+");
            long A[] = new long[N];
            for(int i = 0; i < N; i++)
                A[i] = Long.parseLong(arr[i]);
            
            Solution ob = new Solution();
            System.out.println(ob.countBits(N, A));
        }
    }
}// } Driver Code Ends


//User function Template for Java

class Solution{
    static int countBits(int N, long A[])
    {
        // code here
        int mod=1000000007;
        long sum =0;
        for(int i=0;i<64;i++){
            long ones=0;
            long zeroes=0;
            for(int j=0;j<N;j++){
                if((A[j]&(1<<i))!=0)
                    ones++;
                else
                    zeroes++;
            }
            sum=(((ones*zeroes)%mod)+(sum%mod))%mod;
        }
        return (int)sum;
    }
}