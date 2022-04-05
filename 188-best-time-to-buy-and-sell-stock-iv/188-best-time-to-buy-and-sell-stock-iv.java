class Solution {
    public int maxProfit(int k, int[] prices) {
        if(prices.length<=1)
            return 0;
        int dp[][]=new int[k+1][prices.length];
        for(int i=1;i<k+1;i++){
            for(int j=1;j<prices.length;j++){
                int max=dp[i][j-1];
                for(int p=0;p<j;p++)
                    max=Math.max(max,dp[i-1][p]+(prices[j]-prices[p]));
                dp[i][j]=max;
            }
        }
        return dp[k][prices.length-1];
    }
}