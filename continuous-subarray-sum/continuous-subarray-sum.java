class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        if(nums.length<2)
            return false;
        HashMap<Integer,Integer>hmap=new HashMap<Integer,Integer>();
        for(int i=1;i<nums.length;i++)
            if(nums[i]==0 && nums[i-1]==0)
                return true;
        if(k==0)
            return false;
        int curr_sum=0;
        for(int i=0;i<nums.length;i++)
        {
            curr_sum+=nums[i];
            if(curr_sum%k==0 && i>0)
                return true;
            if(hmap.containsKey(curr_sum%k))
                if(i-hmap.get(curr_sum%k)>1)
                    return true;
            hmap.put(curr_sum%k,i);
        }
        return false;
            
    }
}