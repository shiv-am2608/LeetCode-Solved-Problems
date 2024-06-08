class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        //if length of array is less than 2 then answer not possible
        if(nums.length<2)
            return false;
        HashMap<Integer,Integer>hmap=new HashMap<Integer,Integer>();
        
        //if we get 2 consecutive 0's for any k,return true
        //since (0+0)%k=0
        for(int i=1;i<nums.length;i++)
            if(nums[i]==0 && nums[i-1]==0)
                return true;
        
        //for k=0,only two or more consecutive 0's were possible
        if(k==0)
            return false;
        
        int curr_sum=0;
        for(int i=0;i<nums.length;i++)
        {
            curr_sum+=nums[i];
            
            //if subarray starting fron index 0 is a multiple of k
            if(curr_sum%k==0 && i>0)
                return true;
            if(hmap.containsKey(curr_sum%k))
                if(i-hmap.get(curr_sum%k)>1)//size of subarray should be more than 1
                    return true;
            hmap.put(curr_sum%k,i);
        }
        return false;
            
    }
}