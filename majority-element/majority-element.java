class Solution {
    public int majorityElement(int[] nums) {
        int index=0;
        int count=1;
        for(int i=1;i<nums.length;i++)
        {
            if(nums[i]!=nums[index])
                count--;
            else 
                count++;
            if(count==0)
            {
                count=1;
                index=i;
            }
        }
        return nums[index];
    }
}