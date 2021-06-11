class Solution {
    public int subarraySum(int[] nums, int k) {
       HashMap<Integer,Integer>hs=new HashMap<Integer,Integer>();
        int pre_sum=0;
        int count=0;
        for(int i=0;i<nums.length;i++)
        {
            pre_sum+=nums[i];
            if(pre_sum==k)
                count++;
            if(hs.containsKey(pre_sum-k))
                count+=hs.get(pre_sum-k);
            if(hs.containsKey(pre_sum))
                hs.put(pre_sum,hs.get(pre_sum)+1);
            else
                hs.put(pre_sum,1);
        }
        return count;
    }
}