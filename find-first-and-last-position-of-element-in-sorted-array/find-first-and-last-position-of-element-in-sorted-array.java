class Solution {
    public int bsStart(int arr[],int target)
    {
        int low=0,high=arr.length-1,idex=-1;
        while(low<=high)
        {
            int mid=(low+high)/2;
            if(arr[mid]==target)
                idex=mid;
            if(arr[mid]>=target)
                high=mid-1;
            else
                low=mid+1;
        }
        return idex;
    }
     public int bsEnd(int arr[],int target)
    {
        int low=0,high=arr.length-1,idex=-1;
        while(low<=high)
        {
            int mid=(low+high)/2;
            if(arr[mid]==target)
                idex=mid;
            if(arr[mid]<=target)
                low=mid+1;
            else 
                high=mid-1;
        }
        return idex;
    }
    
    public int[] searchRange(int[] nums, int target) {
        int temp=bsStart(nums,target);
        int temp2=bsEnd(nums,target);
        int arr[]=new int[2];
        arr[0]=temp;
        arr[1]=temp2;
        return arr;
    }
}