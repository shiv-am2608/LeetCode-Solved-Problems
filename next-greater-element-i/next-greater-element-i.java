class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        HashMap<Integer,Integer>hmap=new HashMap<Integer,Integer>();
        for(int i=0;i<nums2.length;i++)
            hmap.put(nums2[i],i);
        int next[]=new int[nums2.length];
        Stack<Integer>st=new Stack<Integer>();
        next[next.length-1]=-1;
        st.push(nums2[next.length-1]);
        for(int i=nums2.length-2;i>=0;i--)
        {
            while(!st.isEmpty() && st.peek()<=nums2[i])
                st.pop();
            if(st.isEmpty())
                next[i]=-1;
            else
                next[i]=st.peek();
            st.push(nums2[i]);
        }
        
        int ans[]=new int[nums1.length];
        for(int i=0;i<nums1.length;i++)
        {
            ans[i]=next[hmap.get(nums1[i])];
        }
        return ans;
    }
}