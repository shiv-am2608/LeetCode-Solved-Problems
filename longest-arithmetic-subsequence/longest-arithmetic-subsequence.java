class Solution {
    public int longestArithSeqLength(int[] nums) {
        int ans=2;
        HashMap<Integer,Integer>hmap[]=new HashMap[nums.length];
        for(int i=0;i<nums.length;i++)
            hmap[i]=new HashMap<Integer,Integer>();
        for(int i=1;i<nums.length;i++)
        {
            for(int j=0;j<i;j++)
            {
                int diff=nums[i]-nums[j];
                int temp=2;
                if(hmap[j].containsKey(diff))
                    temp=hmap[j].get(diff)+1;
                ans=Math.max(ans,temp);
                hmap[i].put(diff,temp);
            }
        }
        return ans;
    }
}