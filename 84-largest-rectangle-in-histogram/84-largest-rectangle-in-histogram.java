class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer>st=new Stack<Integer>();
        int n=heights.length;
        
        //right boundry
        int rb[]=new int[n];
        rb[n-1]=n;
        st.push(n-1);
        for(int i=n-2;i>=0;i--)
        {
            while(!st.isEmpty() && heights[i]<=heights[st.peek()])
                    st.pop();
            rb[i]=st.isEmpty()?n:st.peek();
            st.push(i);
        }
        
        st.clear();
        //left boundry
        int lb[]=new int[n];
        lb[0]=-1;
        st.push(0);
        for(int i=1;i<n;i++)
        {
            while(!st.isEmpty() && heights[i]<=heights[st.peek()])
                    st.pop();
            lb[i]=st.isEmpty()?-1:st.peek();
            st.push(i);
        }
        
        //calculating ans
        int ans=0;
        for(int i=0;i<n;i++)
        {
            int area=heights[i]*(rb[i]-lb[i]-1);
            ans=Math.max(ans,area);
        }
        return ans;
    }
}