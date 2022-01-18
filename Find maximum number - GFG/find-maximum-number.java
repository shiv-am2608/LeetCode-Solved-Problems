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
            String N = read.readLine();

            Solution ob = new Solution();
            System.out.println(ob.findMax(N));
        }
    }
}// } Driver Code Ends


//User function Template for Java

class Solution {
    static String findMax(String N) {
        // code here
        char ch[]=N.toCharArray();
        Arrays.sort(ch);
        StringBuilder sb=new StringBuilder();
        for(int i=ch.length-1;i>=0;i--)
            sb.append(ch[i]);
        return sb.toString();
    }
};