class Solution {
    public int getNext(int index,boolean isForward,int nums[])
    {
        boolean curr_direction=true;
        if(nums[index]<0)
            curr_direction=false;
        if(curr_direction!=isForward)
            return -1;
        int n=nums.length;
        int next_index=(index+nums[index])%n;
        if(next_index<0)
            next_index=n+next_index;
        if(index==next_index)
            return -1;
        return next_index;
    }
    public boolean circularArrayLoop(int[] nums) {
        int slow=0,fast=0;
        boolean isForward=true;
        for(int i=0;i<nums.length;i++)
        {
            if(nums[i]<0)
                isForward=false;
            else
                isForward=true;
            slow=getNext(i,isForward,nums);
            fast=getNext(i,isForward,nums);
            if(fast!=-1)
                fast=getNext(fast,isForward,nums);
            while(slow!=-1 && fast!=-1 && slow!=fast)
            {
                slow=getNext(slow,isForward,nums);
                fast=getNext(fast,isForward,nums);
                if(fast!=-1)
                    fast=getNext(fast,isForward,nums);
            }
            if(fast!=-1 && slow==fast)
                return true;
        }
        return false;
    }
}