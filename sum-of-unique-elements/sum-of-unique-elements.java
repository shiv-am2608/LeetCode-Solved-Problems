class Solution {
    public int sumOfUnique(int[] nums) {
        HashMap<Integer,Integer>hmap=new HashMap<>();
        int sum=0;
        for(int i=0;i<nums.length;i++)
        {
            if(hmap.containsKey(nums[i]))
                hmap.put(nums[i],hmap.get(nums[i])+1);
            else
                hmap.put(nums[i],1);
        }
        for(Map.Entry<Integer,Integer> h : hmap.entrySet())
            if(h.getValue()==1)
                sum+=h.getKey();
        return sum;
    }
}