class Solution {
    public int pivot(int nums[])
    {
        int low=0,high=nums.length-1;
        while(low<=high)
        {
            int mid=high-(high-low)/2;
            if(mid>0 && nums[mid]<nums[mid-1])
                return mid;
            if(mid<nums.length-1 && nums[mid]>nums[mid+1])
                return mid+1;
            if(nums[mid]>nums[0])
                low=mid+1;
            else
                high=mid-1;
        }
        return -1;
    }
    public int findMin(int[] nums) {
        int pivot=pivot(nums);
        if(pivot==-1)
            return nums[0];
        return nums[pivot];
    }
}