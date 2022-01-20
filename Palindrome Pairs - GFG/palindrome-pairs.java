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
            int N = Integer.parseInt(read.readLine());
            
            String arr[] = new String[N];
            
            for(int i=0; i<N; i++)
                arr[i] = read.readLine();

            Solution ob = new Solution();
            
            System.out.println(ob.palindromepair(N,arr));
        }
    }
}// } Driver Code Ends


//User function Template for Java

class Solution {
    static boolean isPallindrome(String x)
    {
        int i=0,j=x.length()-1;
        while(i<j)
        {
            if(x.charAt(i)!=x.charAt(j))
                return false;
            i++;
            j--;
        }
        return true;
    }
    static int palindromepair(int N, String arr[]) {
        // code here
        HashMap<String,Integer>hs=new HashMap<String,Integer>();
        for(String x:arr)
        {
            if(hs.containsKey(x))
                hs.put(x,hs.get(x)+1);
            else
                hs.put(x,1);
        }
        int count=0;
        for(int i=0;i<N;i++)
        {
            //Case1
            if(hs.containsKey("") && isPallindrome(arr[i]))
                return 1;
            
            //Case2
            String sb=new StringBuilder(arr[i]).reverse().toString();
            if(hs.containsKey(sb))
            {
                if(!isPallindrome(arr[i]))
                    return 1;
                else if(hs.get(arr[i])>1)
                    return 1;
            }
            
            //Case3
            String curr=arr[i];
            for(int cut=1;cut<curr.length();cut++)
            {
                String left=curr.substring(0,cut);
                String right=curr.substring(cut);
                
                if(isPallindrome(left))
                {
                    String temp=new StringBuilder(right).reverse().toString();
                    if(hs.containsKey(temp))
                        return 1;
                }
                
                if(isPallindrome(right))
                {
                    String temp=new StringBuilder(left).reverse().toString();
                    if(hs.containsKey(temp))
                        return 1;
                }
            }
        }
        return 0;
    }
};