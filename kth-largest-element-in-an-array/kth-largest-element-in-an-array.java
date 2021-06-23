class Solution {
    public int lomuto(int nums[],int left,int right)
    {
        int i=left-1;
        for(int j=left;j<right;j++)
        {
            if(nums[right]<=nums[j])
            {
                i++;
                int temp=nums[i];
                nums[i]=nums[j];
                nums[j]=temp;
            }
        }
        int temp=nums[i+1];
        nums[i+1]=nums[right];
        nums[right]=temp;
        return i+1;
    }
    public int findKthLargest(int[] nums, int k) {
        int left=0,right=nums.length-1;
        while(left<=right)
        {
            int pivot=lomuto(nums,left,right);
            if(pivot==k-1)
                return nums[pivot];
            if(pivot>k-1)
                right=pivot-1;
            else
                left=pivot+1;
        }
        return nums[0];
    }
}