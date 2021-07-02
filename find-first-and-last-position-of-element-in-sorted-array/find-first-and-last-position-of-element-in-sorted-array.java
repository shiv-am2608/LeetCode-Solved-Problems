class Solution {
    public int bsStart(int nums[],int target)
    {
        int low=0,high=nums.length-1;
        int res=-1;
        while(low<=high)
        {
            int mid=low+(high-low)/2;
            if(nums[mid]==target)
            {
                res=mid;
                high=mid-1;
            }
            else if(nums[mid]<target)
                low=mid+1;
            else
                high=mid-1;
        }
        return res;
    }
    public int bsEnd(int nums[],int target)
    {
        int low=0,high=nums.length-1;
        int res=-1;
        while(low<=high)
        {
            int mid=low+(high-low)/2;
            if(nums[mid]==target)
            {
                res=mid;
                low=mid+1;
            }
            else if(nums[mid]<target)
                low=mid+1;
            else
                high=mid-1;
        }
        return res;
    }
    public int[] searchRange(int[] nums, int target) {
        int left=bsStart(nums,target);
        int right=bsEnd(nums,target);
        int res[]=new int[2];
        res[0]=left;
        res[1]=right;
        return res;
    }
}