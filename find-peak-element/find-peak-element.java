class Solution {
    int bs(int nums[],int low,int high)
    {
        if(low>high)
            return -1;
        int mid=low+(high-low)/2;
        if(mid>0 && mid<nums.length-1 && nums[mid]>nums[mid+1] && nums[mid]>nums[mid-1])
            return mid;
        if(mid==0 && nums[mid]>nums[mid+1])
            return mid;
        if(mid==nums.length-1 && nums[mid]>nums[mid-1])
            return mid;
        return Math.max(bs(nums,low,mid-1),bs(nums,mid+1,high));
    }
    public int findPeakElement(int[] nums) {
        if(nums.length==1)
            return 0;
        return bs(nums,0,nums.length-1);
    }
}