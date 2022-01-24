// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        
        int t = Integer.parseInt(sc.next());
        while(t>0)
        {
            int n = Integer.parseInt(sc.next());
            Solution T = new Solution();
            List<String> ans = T.AllParenthesis(n);
            String[] sequences = ans.toArray(new String[0]);
            Arrays.sort(sequences);
            int k = sequences.length;
            for(int i=0;i<k;i++)
            {
                System.out.println(sequences[i]);
            }
            
            t--;
            
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    
    public void permute(ArrayList<String>ans,int open,int close,String str)
    {
        if(open==0 && close==0)
        {
            ans.add(str);
            return;
        }
        if(open>0)
            permute(ans,open-1,close,str+'(');
        if(close>open)
            permute(ans,open,close-1,str+')');
    }
    public List<String> AllParenthesis(int n) 
    {
        // Write your code here
        ArrayList<String>ans=new ArrayList<String>();
        permute(ans,n,n,"");
        return ans;
    }
}