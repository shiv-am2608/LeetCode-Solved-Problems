// { Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;
import java.lang.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0) {
            int n = Integer.parseInt(in.readLine());
            
            Solution ob = new Solution();
            ArrayList<ArrayList<Integer>> ans = ob.nQueen(n);
            if(ans.size() == 0)
                System.out.println("-1");
            else {
                for(int i = 0;i < ans.size();i++){
                    System.out.print("[");
                    for(int j = 0;j < ans.get(i).size();j++)
                        System.out.print(ans.get(i).get(j) + " ");
                    System.out.print("] ");
                }
                System.out.println();
            }
        }
    }
}// } Driver Code Ends


// User function Template for Java

class Solution{
    static boolean isSafe(int row,int col,int n,ArrayList<Integer>res){
        for(int i=row-1,j=col-1;i>=0 && j>=0;i--,j--)
            if(res.get(j)==i)
                return false;
        for(int i=row+1,j=col-1;i<n && j>=0;i++,j--)
            if(res.get(j)==i)
                return false;
        for(int i=0;i<col;i++)
            if(res.get(i)==row)
                return false;
        return true;
            
    }
    static void solve(int n,int col,ArrayList<Integer>res,ArrayList<ArrayList<Integer>>ans){
        // for(int i:res)
        //     System.out.print(i+" ");
        // System.out.print(n+"->"+col);
        // System.out.println();
        if(col==n){
            ArrayList<Integer>temp=new ArrayList<Integer>();
            for(int i:res)
                temp.add(i+1);
            ans.add(temp);
            return;
        }
        for(int i=0;i<n;i++)
        {
            if(isSafe(i,col,n,res)){
                res.add(i);
                solve(n,col+1,res,ans);
                res.remove(res.size()-1);
            }
        }
    }
    static ArrayList<ArrayList<Integer>> nQueen(int n) {
        // code here
        ArrayList<ArrayList<Integer>>ans=new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer>res=new ArrayList<Integer>();
        solve(n,0,res,ans);
        return ans;
    }
}