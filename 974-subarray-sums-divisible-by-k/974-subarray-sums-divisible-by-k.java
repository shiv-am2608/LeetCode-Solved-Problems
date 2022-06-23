class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        HashMap<Integer,Integer>hmap=new HashMap<Integer,Integer>();
        int presum=0;
        int count=0;
        for(int i=0;i<nums.length;i++)
        {
            presum+=nums[i];
            int mod=presum%k;
            if(mod<0)
                mod+=k;
            if(hmap.containsKey(mod))
                count+=hmap.get(mod);
            if(mod==0)
                count++;
            if(hmap.containsKey(mod))
                hmap.put(mod,hmap.get(mod)+1);
            else
                hmap.put(mod,1);
        }
        return count;
    }
}