// { Driver Code Starts
// Initial Template for Java

// Initial Template for Java

import java.util.*;
import java.io.*;

  public class validip {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            String s = sc.next();
            Solution obj = new Solution();

            if (obj.isValid(s))
                System.out.println(1);
            else
                System.out.println(0);
        }
    }
}// } Driver Code Ends


// User function Template for Java

class Solution {

    public boolean isValid(String s) {
        // Write your code here
        String str[]=s.split("\\.");
        if(str.length!=4 || s.charAt(s.length()-1)=='.')
            return false;
        for(int i=0;i<4;i++)
        {
            // System.out.println(str[i]);
            if(str[i].length()==0)
                return false;
            int val=0;
            try{val=Integer.parseInt(str[i]);}
            catch(Exception e){
                return false;
            }
            if(val<0 || val>255)
                return false;
            if(str[i].length()!=1 && str[i].charAt(0)=='0')
                return false;
        }
        return true;
    }
}