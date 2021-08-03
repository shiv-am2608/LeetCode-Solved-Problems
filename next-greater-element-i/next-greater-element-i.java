class Solution {
    public static HashMap<Integer,Integer> nextLargerElement(int[] arr, int n)
    { 
        Stack<Integer>st=new Stack<Integer>();
        HashMap<Integer,Integer>hmap=new HashMap<Integer,Integer>();
        for(int i=n-1;i>=0;i--)
        {
            while(!st.isEmpty() && st.peek()<arr[i])
                st.pop();
            if(st.isEmpty())
                hmap.put(arr[i],-1);
            else
                hmap.put(arr[i],st.peek());
            st.push(arr[i]);
        }
        return hmap;
    } 
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        HashMap<Integer,Integer>hmap=nextLargerElement(nums2,nums2.length);
        int res[]=new int[nums1.length];
        for(int i=0;i<nums1.length;i++)
            res[i]=hmap.get(nums1[i]);
        return res;
    }
}