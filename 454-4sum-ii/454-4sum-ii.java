class Solution {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        HashMap<Integer,Integer>hmap=new HashMap<Integer,Integer>();
        for(int i:nums1)
            for(int j:nums2)
                if(hmap.containsKey(i+j))
                    hmap.put(i+j,hmap.get(i+j)+1);
                else
                    hmap.put(i+j,1);
        int count=0;
        for(int i:nums3)
            for(int j:nums4)
                if(hmap.containsKey(-(i+j)))
                    count+=hmap.get(-(i+j));
        return count;
    }
}