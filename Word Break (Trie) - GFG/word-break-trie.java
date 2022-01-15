// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
public class GfG
{
    public static void main(String args[])
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    int n;
                    n = sc.nextInt();
                    ArrayList<String> arr = new ArrayList<String>();
                    for(int i = 0;i<n;i++)
                        {
                            String p = sc.next();
                            arr.add(p);
                        }
                    String line = sc.next();
                    Solution obj = new Solution();  
                    System.out.println(obj.wordBreak(line,arr));  
                    
                }
        }
}// } Driver Code Ends


//User function Template for Java

class Solution
{
    public static boolean backTrack(String s,List<String> wordDict,HashMap<String,Boolean>hmap)
    {
        if(s.length()==0)
            return true;
        if(hmap.containsKey(s))
            return hmap.get(s);
        boolean ans=false;
        for(int i=1;i<=s.length();i++)
        {
            if(wordDict.contains(s.substring(0,i)))
            {
                if(backTrack(s.substring(i),wordDict,hmap))
                {
                    ans=true;
                    break;
                }
            }
        }
        hmap.put(s,ans);
        return ans;
    }
    public static int wordBreak(String A, ArrayList<String> B )
    {
        //code here
        HashMap<String,Boolean>hmap=new HashMap<String,Boolean>();
        return backTrack(A,B,hmap)?1:0;
    }
}