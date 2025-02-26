class Solution {
    public int kadanes(int nums[]){
        int ans = nums[0];
        int val = nums[0];
        for(int i=1;i<nums.length;i++){
            val = Math.max(val+nums[i],nums[i]);
            ans = Math.max(ans,val);

        }
        return ans;
    }

    public int[] transform(int nums[]){
        int copy[] = new int[nums.length];
        for(int i=0;i<nums.length;i++){
            copy[i] = -1 * nums[i];
        }
        return copy;
    }

    public int maxAbsoluteSum(int[] nums) {
       int val1 = kadanes(nums);
       nums = transform(nums);
       int val2 = kadanes(nums);
       return Math.max(val1, val2);
    }
}