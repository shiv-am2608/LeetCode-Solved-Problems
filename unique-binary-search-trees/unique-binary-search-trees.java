class Solution {
    public int numTrees(int n) {
        if(n<=1)
            return 1;
        int dp[]=new int[n+1];
        dp[0]=1;
        dp[1]=1;
        for(int i=2;i<=n;i++)
        {
            int sum=0,j;
            for(j=i-1;j>=i/2;j--)
                sum+=2*dp[j]*dp[i-j-1];
            if(i%2!=0)
                dp[i]=sum-(dp[i/2]*dp[i/2]);
            else
                dp[i]=sum;
        }
        return dp[n];
    }
}