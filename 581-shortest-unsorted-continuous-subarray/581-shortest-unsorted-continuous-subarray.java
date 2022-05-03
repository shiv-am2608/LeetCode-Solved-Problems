class Solution {
    public int findUnsortedSubarray(int[] nums) {
        int left=0,right=-1;
        int max=nums[0];
        for(int i=1;i<nums.length;i++)
        {
            if(nums[i]<max)
                right=i;
            max=Math.max(max,nums[i]);
        }
        
        int min=nums[nums.length-1];
        for(int i=nums.length-2;i>=0;i--)
        {
            if(nums[i]>min)
                left=i;
            min=Math.min(min,nums[i]);
        }
        return right-left+1;
    }
}