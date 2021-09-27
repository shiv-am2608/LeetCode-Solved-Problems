// { Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t =
            Integer.parseInt(br.readLine().trim()); // Inputting the testcases
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());

            System.out.println(new Solution().getNthUglyNo(n));
        }
    }
}// } Driver Code Ends


class Solution {
    /* Function to get the nth ugly number*/
    long getNthUglyNo(int n) {
        // code here
        long dp[]=new long[n];
        dp[0]=1L;
        int i2=0,i3=0,i5=0;
        long next2=2,next3=3,next5=5;
        for(int i=1;i<n;i++)
        {
            long curr=Math.min(next2,Math.min(next3,next5));
            dp[i]=curr;
            if(curr==next2)
            {
                i2++;
                next2=dp[i2]*2;
            }
            if(curr==next3)
            {
                i3++;
                next3=dp[i3]*3;
            }
            if(curr==next5)
            {
                i5++;
                next5=dp[i5]*5;
            }
        }
        return dp[n-1];
    }
}