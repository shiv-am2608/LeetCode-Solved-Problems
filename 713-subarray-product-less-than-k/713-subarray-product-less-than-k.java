class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        long prod=1;
        int ans=0;
        int left=0,right=0;
        while(right<nums.length)
        {
            prod*=nums[right];
            while(prod>=k && left<=right)
            {
                prod/=nums[left];
                left++;
            }
            ans+=right-left+1;
            right++;
        }
        return ans;
    }
}