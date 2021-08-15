class Solution {
    public int maxProduct(int[] nums) {
        if(nums.length==1)
            return nums[0];
        int curr_max=nums[0];
        int curr_min=nums[0];
        int res=nums[0];
        for(int i=1;i<nums.length;i++)
        {
            int temp=curr_max;
            curr_max=Math.max(nums[i],Math.max(curr_min*nums[i],curr_max*nums[i]));
            curr_min=Math.min(nums[i],Math.min(curr_min*nums[i],temp*nums[i]));
            res=Math.max(res,curr_max);
        }
        return res;
    }
}