class Solution {
    public void moveZeroes(int[] nums) {
        if(nums.length<=1)
            return;
        int n=nums.length;
        int i=0;
        int j=0;
        while(i<n && j<n)
        {
            while(i<n && nums[i]==0)
                i++;
            while(j<n && nums[j]!=0)
                j++;
            if(i<n && j<n && i>j)
            {
                int temp=nums[i];
                nums[i]=nums[j];
                nums[j]=temp;
            }
            i++;
        }
    }
}