class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        TreeSet<Integer>tset1=new TreeSet<Integer>();
        TreeSet<Integer>tset2=new TreeSet<Integer>();
        for(int i=0;i<nums1.length;i++)
            tset1.add(nums1[i]);
        for(int i=0;i<nums2.length;i++)
            if(tset1.contains(nums2[i]))
                tset2.add(nums2[i]);
        int res[]=new int[tset2.size()];
        int i=0;
        for(int x:tset2)
            res[i++]=x;
        return res;
    }
}