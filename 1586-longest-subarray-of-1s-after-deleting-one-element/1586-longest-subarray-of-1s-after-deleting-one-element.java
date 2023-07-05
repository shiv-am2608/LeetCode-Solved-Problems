class Solution {
    public int longestSubarray(int[] nums) {
        int start = -1, end = 0, count = 0,ans = 0 ;
        while(end<nums.length)
        {
            if(nums[end]==0)
                count++;
            while(count>1 && start<=end)
            {
                start++;
                if(nums[start]==0)
                    count--;
            }
            ans = Math.max(ans,end-start-1);
            end++;
        }
        return ans;
    }
}