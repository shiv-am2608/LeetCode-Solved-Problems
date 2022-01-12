// { Driver Code Starts
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
            ArrayList<ArrayList<String>> allPart = ob.allPalindromicPerms(S);
            
            for (int i=0; i<allPart.size(); i++)  
            { 
                for (int j=0; j<allPart.get(i).size(); j++) 
                { 
                    System.out.print(allPart.get(i).get(j) + " "); 
                } 
                System.out.println(); 
            } 
        }
    }
}// } Driver Code Ends


//User function Template for Java

class Solution {
    static boolean isPallindrome(String s)
    {
        int i=0,j=s.length()-1;
        while(i<j)
        {
            if(s.charAt(i)!=s.charAt(j))
                return false;
            i++;
            j--;
        }
        return true;
    }
    static void backTrack(ArrayList<ArrayList<String>>ans,ArrayList<String>res,String s)
    {
        if(s.length()==0)
        {
            ans.add(new ArrayList<String>(res));
            return;
        }
        for(int i=1;i<=s.length();i++)
        {
            if(isPallindrome(s.substring(0,i)))
            {
                res.add(s.substring(0,i));
                backTrack(ans,res,s.substring(i));
                res.remove(res.size()-1);
            }
        }
    }
    static ArrayList<ArrayList<String>> allPalindromicPerms(String S) {
        // code here
        ArrayList<ArrayList<String>>ans=new ArrayList<ArrayList<String>>();
        ArrayList<String>res=new ArrayList<String>();
        backTrack(ans,res,S);
        return ans;
    }
};