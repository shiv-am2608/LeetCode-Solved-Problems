class Solution {
    public boolean issubSet(int nums[],int target)
    {
        boolean dp[][]=new boolean[nums.length+1][target+1];
        for(int i=1;i<=target;i++)
            dp[0][i]=false;
        for(int i=0;i<=nums.length;i++)
            dp[i][0]=true;
        for(int i=1;i<=nums.length;i++)
        {
            for(int j=1;j<=target;j++)
            {
                if(nums[i-1]<=j)
                    dp[i][j]=dp[i-1][j-nums[i-1]] || dp[i-1][j];
                else
                    dp[i][j]=dp[i-1][j];
            }
        }
        return dp[nums.length][target];
    }
    public boolean canPartition(int[] nums) {
        int sum=0;
        for(int i=0;i<nums.length;i++)
            sum+=nums[i];
        if(sum%2!=0)
            return false;
        return issubSet(nums,sum/2);
    }
}