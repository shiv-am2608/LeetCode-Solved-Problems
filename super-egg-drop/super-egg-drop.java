class Solution {
    public int solve(int k,int n,int dp[][])
    {
        if(n==0 || n==1 || k==1)
            return n;
        if(dp[k][n]!=-1)
            return dp[k][n];
        int low=1,high=n-1;
        int ans=Integer.MAX_VALUE;
        while(low<=high)
        {
            int mid=high-(high-low)/2;
            int left=solve(k-1,mid-1,dp);
            int right=solve(k,n-mid,dp);
            int temp=1+Math.max(left,right);
            ans=Math.min(ans,temp);
            if(left<right)
                low=mid+1;
            else
                high=mid-1;
        }
        return dp[k][n]=ans;
    }
    public int superEggDrop(int k, int n) {
       int dp[][]=new int[k+1][n+1];
        for(int i[]:dp)
            Arrays.fill(i,-1);
        return solve(k,n,dp);
    }
}