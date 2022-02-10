class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer,Integer>hmap=new HashMap<Integer,Integer>();
        int pre_sum=0,count=0;
        for(int i=0;i<nums.length;i++)
        {
            pre_sum+=nums[i];
            if(pre_sum==k)
                count++;
            if(hmap.containsKey(pre_sum-k))
                count+=hmap.get(pre_sum-k);
            if(hmap.containsKey(pre_sum))
                hmap.put(pre_sum,hmap.get(pre_sum)+1);
            else
                hmap.put(pre_sum,1);
        }
        return count;
    }
}