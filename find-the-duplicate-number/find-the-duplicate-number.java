class Solution {
    public int findDuplicate(int[] nums) {
        int slow=nums[nums[0]];
        int fast=nums[nums[nums[0]]];
        while(slow!=fast)
        {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } 
        fast=nums[0];
        while(fast!=slow)
        {
            slow=nums[slow];
            fast=nums[fast];
        }
        return slow;
    }
}