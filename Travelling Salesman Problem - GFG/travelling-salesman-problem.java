// { Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            int n = Integer.parseInt(br.readLine().trim());
            int[][] cost = new int[n][n];
            for(int i = 0; i < n; i++){
                String[] S = br.readLine().trim().split(" ");
                for(int j = 0; j < n; j++)
                    cost[i][j] = Integer.parseInt(S[j]);
            }
            Solution obj = new Solution();
            int ans = obj.total_cost(cost);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    public int ans = Integer.MAX_VALUE;
    public void findMin(int grid[][],HashSet<Integer>hs,int curr,int sum)
    {
        if(sum>ans)
            return;
        if(hs.size()==grid.length)
        {
            ans=Math.min(sum+grid[curr][0],ans);
            return;
        }
        for(int i=0;i<grid.length;i++)
        {
            if(!hs.contains(i))
            {
                hs.add(i);
                findMin(grid,hs,i,sum+grid[curr][i]);
                hs.remove(i);
            }
        }
    }
    public int total_cost(int[][] cost)
    {
        // Code here 
        ans=Integer.MAX_VALUE;
        HashSet<Integer>hs=new HashSet<Integer>();
        hs.add(0);
        findMin(cost,hs,0,0);
        return ans;
    }
}