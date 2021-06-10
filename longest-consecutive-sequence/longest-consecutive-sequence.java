class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer>hs=new HashSet<Integer>();
        for(int i=0;i<nums.length;i++)
            hs.add(nums[i]);
        int max=0;
        for(int i=0;i<nums.length;i++)
        {
            if(hs.contains(nums[i]) && hs.contains(nums[i]-1))
                continue;
            int count=0;
            int sub=0;
            while(hs.contains(nums[i]+sub))
            {
                sub++;
                count++;
            }
            max=Math.max(max,count);
        }
        return max;
    }
}