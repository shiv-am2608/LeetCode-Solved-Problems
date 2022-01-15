// { Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String S = read.readLine();

            Solution ob = new Solution();
            System.out.println(ob.findMaxLen(S));
        }
    }
}

// } Driver Code Ends


//User function Template for Java
class Solution {
    static int findMaxLen(String S) {
        // code here
        int left=0,right=0,max=0;
        for(int i=0;i<S.length();i++)
        {
            if(S.charAt(i)=='(')
                left++;
            else 
                right++;
            if(right>left)
            {
                left=0;
                right=0;
            }
            else if(left==right)
                max=Math.max(max,2*left);
        }
        left=0;
        right=0;
        for(int i=S.length()-1;i>=0;i--)
        {
            if(S.charAt(i)=='(')
                left++;
            else 
                right++;
            if(right<left)
            {
                left=0;
                right=0;
            }
            else if(left==right)
                max=Math.max(max,2*left);
        }
        return max;
    }
};