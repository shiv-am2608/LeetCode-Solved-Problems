// { Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int K = Integer.parseInt(read.readLine());

            Solution ob = new Solution();
            System.out.println(ob.mindGame(K));
        }
    }
}// } Driver Code Ends


class Solution {
    static int mindGame(int K) {
        // code here
        return K/2;
    }
};