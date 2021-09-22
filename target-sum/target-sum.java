class Solution {
    public int countSubsetSum(int arr[],int sum)
    {
        int dp[][]=new int[arr.length+1][sum+1];
        for(int i=1;i<=sum;i++)
            dp[0][i]=0;
        for(int i=0;i<=arr.length;i++)
            dp[i][0]=1;
        for(int i=1;i<=arr.length;i++)
            for(int j=0;j<=sum;j++)
                    if(arr[i-1]<=j)
                        dp[i][j]=dp[i-1][j]+dp[i-1][j-arr[i-1]];
                    else
                        dp[i][j]=dp[i-1][j];
        return dp[arr.length][sum];
    }
    public int findTargetSumWays(int[] nums, int target) {
        int sum=0;
        for(int i:nums)
                sum+=i;
        if(target>sum || target<-sum)
            return 0;
        return (target+sum)%2 ==0? countSubsetSum(nums,(target+sum)/2):0;
    }
}