class Solution {
    public int helper(int start,int count,int prev,int houses[],int cost[][],int m,int n,int target,int dp[][][])
    {
        if(start==houses.length && count==target)
            return 0;
        if(start>=houses.length || count>target)
            return Integer.MAX_VALUE;
        if(dp[start][prev][count]!=0)
            return dp[start][prev][count];
        if(houses[start]!=0)
        {
            if(houses[start]==prev)
                dp[start][prev][count] = helper(start+1,count,houses[start],houses,cost,m,n,target,dp);
            else
                dp[start][prev][count] = helper(start+1,count+1,houses[start],houses,cost,m,n,target,dp);
            return dp[start][prev][count];
        }
        int min=Integer.MAX_VALUE;
        for(int i=1;i<=n;i++)
        {
            int minhere=Integer.MAX_VALUE;
            if(i==prev)
                minhere=helper(start+1,count,i,houses,cost,m,n,target,dp);
            else
                minhere=helper(start+1,count+1,i,houses,cost,m,n,target,dp);
            if(minhere!=Integer.MAX_VALUE)
                minhere+=cost[start][i-1];
            min=Math.min(min,minhere);
        }
        dp[start][prev][count] = min;
        return min;
    }
    public int minCost(int[] houses, int[][] cost, int m, int n, int target) {
        int dp[][][]=new int[houses.length+1][n+1][m+1];
        int ans = helper(0,0,0,houses,cost,m,n,target,dp);
        return ans==Integer.MAX_VALUE?-1:ans;
    }
}