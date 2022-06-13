class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int dp[][]=new int[triangle.size()][triangle.size()];
        dp[0][0]=triangle.get(0).get(0);
        for(int i=1;i<triangle.size();i++)
        {
            List<Integer>lvl=triangle.get(i);
            for(int j=0;j<lvl.size();j++)
            {
                if(j==0)
                    dp[i][j]=dp[i-1][0]+lvl.get(j);
                else if(j==lvl.size()-1)
                    dp[i][j]=dp[i-1][j-1]+lvl.get(j);
                else
                    dp[i][j]=Math.min(dp[i-1][j-1],dp[i-1][j])+lvl.get(j);
            }
        }
        int ans=Integer.MAX_VALUE;
        for(int i=0;i<triangle.size();i++)
            ans=Math.min(ans,dp[triangle.size()-1][i]);
        return ans;
    }
}