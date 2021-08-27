class Solution {
    public int maxProfit(int[] prices) {
        int least=prices[0];
        int profit=0;
        int dp1[]=new int[prices.length];
        dp1[0]=0;
        for(int i=1;i<prices.length;i++)
        {
            if(least>prices[i])
                least=prices[i];
            profit=prices[i]-least;
            if(dp1[i-1]<profit)
                dp1[i]=profit;
            else
                dp1[i]=dp1[i-1];
        }
        int most=prices[prices.length-1];
        profit=0;
        int dp2[]=new int[prices.length];
        dp2[dp2.length-1]=0;
        for(int i=dp2.length-2;i>=0;i--)
        {
            if(most<prices[i])
                most=prices[i];
            profit=most-prices[i];
            if(dp2[i+1]<profit)
                dp2[i]=profit;
            else
                dp2[i]=dp2[i+1];
        }
        int res=0;
        for(int i=0;i<dp1.length;i++)
            res=Math.max(res,dp1[i]+dp2[i]);
        return res;
    }
}