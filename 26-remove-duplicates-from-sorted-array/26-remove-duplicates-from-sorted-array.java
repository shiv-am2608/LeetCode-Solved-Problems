class Solution {
    public int removeDuplicates(int[] nums) {
        int curr=0,next=0,count=0;
        while(next<nums.length)
        {
            nums[curr]=nums[next];
            while(next<nums.length && nums[curr]==nums[next])
                next++;
            curr++;
            count++;
        }
        return count;
    }
}