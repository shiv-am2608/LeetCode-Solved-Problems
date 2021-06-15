class Solution {
    public int largestRectangleArea(int[] height) {
        int n=height.length;
        int res=0;
        Stack<Integer>st=new Stack<Integer>();
        for(int i=0;i<n;i++)
        {
            while(!st.isEmpty() && height[i]<=height[st.peek()])
            {
                int tp=st.pop();
                int curr=height[tp]*(st.isEmpty()?i:(i-st.peek()-1));
                res=Math.max(res,curr);
            }
            st.push(i);
        }
        while(!st.isEmpty())
        {
            int tp=st.pop();
            int curr=height[tp]*(st.isEmpty()?n:(n-st.peek()-1));
            res=Math.max(res,curr);
        }
        return res;
    }
}