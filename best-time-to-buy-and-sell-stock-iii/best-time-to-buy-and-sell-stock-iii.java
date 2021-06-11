class Solution {
    public int maxProfit(int[] prices) {
       int least = prices[0];
        int mpst = 0;
        int dp1[] = new int[prices.length];
        dp1[0] = 0;
        for(int i=1;i<prices.length;i++)
        {
            if(prices[i]<least)
            {
                least = prices[i];
            }
            mpst = prices[i] - least;
            if(mpst>dp1[i-1])
            {
                dp1[i] = mpst; 
            }
            else 
            {
                dp1[i] = dp1[i-1];
            }
        }
        int max = prices[prices.length-1];
        int mpbt = 0;
        int dp2[] = new int[prices.length];
        dp2[prices.length-1] = 0;
        for(int i=prices.length-2;i>=0;i--)
        {
            if(prices[i]>max)
            {
                max = prices[i];
            }
            mpbt = max - prices[i];
            if(mpbt>dp2[i+1])
            {
                dp2[i] = mpbt; 
            }else 
            {
                dp2[i] = dp2[i+1];
            }
        }
        
        int m =0;
        for(int i=0;i<prices.length;i++)
        {
            m = Math.max(dp1[i]+dp2[i],m);
        }
        return m;
    }
}