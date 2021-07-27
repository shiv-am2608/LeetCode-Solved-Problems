class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        int freq[]=new int[1001];
        List<Integer>arr=new ArrayList<Integer>();
        for(int i=0;i<nums1.length;i++)
            freq[nums1[i]]++;
        for(int i=0;i<nums2.length;i++)
        {
            if(freq[nums2[i]]<=0)
                continue;
            else
            {
                freq[nums2[i]]--;
                arr.add(nums2[i]);
            }
        }
        int ans[]=new int[arr.size()];
        for(int i=0;i<arr.size();i++)
            ans[i]=arr.get(i);
        return ans;
    }
}