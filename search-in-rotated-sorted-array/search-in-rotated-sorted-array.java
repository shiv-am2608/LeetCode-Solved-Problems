class Solution {
    public int pivot(int nums[],int low,int high)
    {
        if(high<low)
            return -1;
        if(high==low)
            return low;
        int mid=(low+high)/2;
        if(mid<high && nums[mid]>nums[mid+1])
            return mid;
        else if(mid>low && nums[mid]<nums[mid-1])
            return mid-1;
        else if(nums[mid]>nums[0])
            return pivot(nums,mid+1,high);
        return pivot(nums,low,mid-1);
            
    }
    public int binarySearch(int nums[],int low,int high,int target)
    {
        if(high<low)
            return -1;
        int mid=(low+high)/2;
        if(nums[mid]==target)
            return mid;
        else if(nums[mid]<target)
            return binarySearch(nums,mid+1,high,target);
        return binarySearch(nums,low,mid-1,target);
    }
    public int search(int[] nums, int target) {
        int piv=pivot(nums,0,nums.length-1);
        if(piv==-1)
            return binarySearch(nums,0,nums.length-1,target);
        int left=binarySearch(nums,0,piv,target);
        int right=binarySearch(nums,piv+1,nums.length-1,target);
        if(left!=-1)
            return left;
        if(right!=-1)
            return right;
        return -1;
    }
}