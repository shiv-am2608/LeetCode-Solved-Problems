class Solution {
    public int[] sortArrayByParity(int[] nums) {
        int i=-1,j=0;
        while(j<nums.length)
        {
            if(nums[j]%2==0)
            {
                i++;
                int temp=nums[i];
                nums[i]=nums[j];
                nums[j]=temp;
            }
            j++;
        }
        return nums;
    }
}