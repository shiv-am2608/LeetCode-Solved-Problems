class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int prod=1;
        int count=0;
        int i=0,j=0;
        while(j<nums.length)
        {
            prod*=nums[j];
            while(prod>=k && i<=j)
            {
                prod/=nums[i];
                i++;
            }
            count+=j-i+1;
            j++;
        }
        return count;
    }
}