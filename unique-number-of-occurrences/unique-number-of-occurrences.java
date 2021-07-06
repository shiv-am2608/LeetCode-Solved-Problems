class Solution {
    public boolean uniqueOccurrences(int[] nums) {
        HashMap<Integer,Integer>hmap=new HashMap<Integer,Integer>();
        for(int i=0;i<nums.length;i++)
        {
            if(hmap.containsKey(nums[i]))
                hmap.put(nums[i],hmap.get(nums[i])+1);
            else
                hmap.put(nums[i],1);
        }
        HashSet<Integer>hs=new HashSet<Integer>();
        for(Map.Entry<Integer,Integer>x:hmap.entrySet())
            if(hs.contains(x.getValue()))
                return false;
            else
                hs.add(x.getValue());
        return true;
    }
}