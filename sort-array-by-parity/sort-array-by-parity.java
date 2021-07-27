class Solution {
    public int[] sortArrayByParity(int[] nums) {
        int start=0,end=nums.length;
        while(start<end)
        {
            if(nums[start]%2==0)
                start++;
            else
            {
                end--;
                int temp=nums[end];
                nums[end]=nums[start];
                nums[start]=temp;
            }
        }
        return nums;
    }
}