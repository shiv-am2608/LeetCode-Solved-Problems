class Solution {
    public void nextPermutation(int[] nums) {
        if(nums.length==1)
            return;     
        int i;
        for(i=nums.length-1;i>0;i--)
        {
            if(nums[i]>nums[i-1])
                break;
        }
        if(i==0)
        {
            Arrays.sort(nums);
            return;
        }
        i--;
        int j=nums.length-1;
        while(nums[j]<=nums[i])
            j--;
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
        Arrays.sort(nums,i+1,nums.length);
        return;
    }
}