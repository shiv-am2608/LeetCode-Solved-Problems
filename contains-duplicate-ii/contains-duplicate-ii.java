class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer,Integer>hmap=new HashMap<Integer,Integer>();
        for(int i=0;i<nums.length;i++)
        {
            if(hmap.containsKey(nums[i]))
            {
                int getIndex=hmap.get(nums[i]);
                if(i-getIndex<=k)
                    return true;
            }
            hmap.put(nums[i],i);
        }
        return false;
    }
}