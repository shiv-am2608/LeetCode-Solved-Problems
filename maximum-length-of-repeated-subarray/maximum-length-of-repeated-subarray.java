class Solution {
    public int findLength(int[] nums1, int[] nums2) {
        int dp[][]=new int[nums1.length+1][nums2.length+1];
        int len=0;
        for(int i=0;i<=nums1.length;i++)
        {
            for(int j=0;j<=nums2.length;j++)
            {
                if(i==0 || j==0)
                    continue;
                if(nums1[i-1]==nums2[j-1])
                {
                    dp[i][j]=dp[i-1][j-1]+1;
                    len=Math.max(len,dp[i][j]);
                }
                else
                    dp[i][j]=0;
            }
        }
        return len;
    }
}