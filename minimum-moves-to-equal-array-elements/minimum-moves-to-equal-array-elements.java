class Solution {
    public int minMoves(int[] nums) {
        int sum=nums[0],smallest=nums[0];
        for(int i=1;i<nums.length;i++)
        {
            sum+=nums[i];
            smallest=Math.min(nums[i],smallest);
        }
        return sum-(nums.length*smallest);
    }
}