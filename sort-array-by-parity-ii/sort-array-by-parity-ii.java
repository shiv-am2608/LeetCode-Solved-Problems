class Solution {
    public int[] sortArrayByParityII(int[] nums) {
        int odd=-1,even=-2,ptr=0;
        while(ptr<nums.length)
        {
            if(nums[ptr]%2==0 && ptr%2==0)
                ptr++;
            else if(nums[ptr]%2!=0 && ptr%2!=0)
                ptr++;
            else if(nums[ptr]%2==0)
            {
                even+=2;
                int temp=nums[even];
                nums[even]=nums[ptr];
                nums[ptr]=temp;
            }
            else
            {
                odd+=2;
                int temp=nums[odd];
                nums[odd]=nums[ptr];
                nums[ptr]=temp;
            }
        }
        return nums;
    }
}