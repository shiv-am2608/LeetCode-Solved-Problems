class Solution {
    public int findPivot(int nums[],int k)
    {
        for(int i=0;i<nums.length-1;i++)
            if(nums[i]==k)
                return nums.length;
            else if(nums[i]>nums[i+1])
                return i+1;
        return -1;
    }
    public boolean searchElement(int arr[],int low,int high,int target)
    {
        while(low<=high)
        {
            int pivot=high-(high-low)/2;
            if(arr[pivot]==target)
                return true;
            if(arr[pivot]<target)
                low=pivot+1;
            else
                high=pivot-1;
        }
        return false;
    }
    public boolean search(int[] nums, int target) {
        int pivot=findPivot(nums,target);
        if(pivot==nums.length)
            return true;
        else if(pivot==-1)
            return searchElement(nums,0,nums.length-1,target);
        return searchElement(nums,0,pivot-1,target)||searchElement(nums,pivot,nums.length-1,target);
    }
}