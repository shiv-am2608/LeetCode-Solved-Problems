class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        HashMap<Integer,Integer>loc=new HashMap<>();
        HashMap<Integer,Integer>sum=new HashMap<>();
        int ans=0;
        int total=0;
        int idx=-1;
        for(int i=0;i<nums.length;i++)
        {
            total+=nums[i];
            if(loc.containsKey(nums[i]))
                idx=Math.max(idx,loc.get(nums[i]));
            if(idx==-1)
                ans=Math.max(ans,total);
            else
                ans=Math.max(ans,total-sum.get(idx));
            loc.put(nums[i],i);
            sum.put(i,total);
        }
        return ans;
    }
}