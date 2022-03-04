class Solution {
    public double champagneTower(int poured, int query_row, int query_glass) {
        double dp[][]=new double[101][101];
        dp[0][0]=poured;
        for(int i=0;i<query_row;i++)
        {
            for(int j=0;j<=i;j++)
            {
                double rem = 0;
                if(dp[i][j]>=1)
                {
                    rem=dp[i][j]-1;
                    dp[i][j]=1;
                }
                dp[i+1][j] += rem/(double)2;
                dp[i+1][j+1] += rem/(double)2;
            }
        }
        return dp[query_row][query_glass]>=1?1.0:dp[query_row][query_glass];
    }
}