class Solution {
    public int findMaxLength(int[] nums) {
        int len=0;
        int pre=0;
        HashMap<Integer,Integer>hmap=new HashMap<Integer,Integer>();
        for(int i=0;i<nums.length;i++)
        {
            pre+=nums[i]==0?-1:1;
            if(pre==0)
                len=i+1;
            if(hmap.containsKey(pre))
                len=Math.max(len,i-hmap.get(pre));
            else
                hmap.put(pre,i);
        }
        return len;
    }
}