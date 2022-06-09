class Solution {
    public int[] twoSum(int[] nums, int target) {
        int i=0,j=nums.length-1;
        int res[]=new int[2];
        while(i<j)
        {
            if(nums[i]+nums[j]==target)
            {
                res[0]=i+1;
                res[1]=j+1;
                break;
            }
            else if(nums[i]+nums[j]<target)
                i++;
            else
                j--;
        }
        return res;
    }
}