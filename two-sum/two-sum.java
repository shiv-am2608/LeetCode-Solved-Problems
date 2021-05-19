class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> mp = new HashMap<Integer,Integer>();
        for(int i=0;i<nums.length;i++)
            mp.put(nums[i],i);
        for(int i=0;i<nums.length;i++)
            if(mp.containsKey(target - nums[i]) && i!=mp.get(target - nums[i]))
            {
                return new int[]{i,mp.get(target - nums[i])};
            }
        return new int[2];
    }
}