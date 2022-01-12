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
            int N = Integer.parseInt(read.readLine());
            
            Solution ob = new Solution();
            System.out.println(ob.bitMultiply(N));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    static int bitMultiply(int N){
        // coe here
        int c=N;
        int count=0;
        while(c>0)
        {
            if((c&1)==1)
                count++;
            c=c>>1;
        }
        return count*N;
    }
}