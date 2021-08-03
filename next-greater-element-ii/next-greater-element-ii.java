class Solution {
    public static int[] nextLargerElement(int[] arr, int n)
    { 
        // Your code here
        int ans[]=new int[n];
        Stack<Integer>st=new Stack<Integer>();
        for(int i=n-1;i>=0;i--)
        {
            while(!st.isEmpty() && st.peek()<=arr[i])
                st.pop();
            st.push(arr[i]);
        }
        for(int i=n-1;i>=0;i--)
        {
            while(!st.isEmpty() && st.peek()<=arr[i])
                st.pop();
            if(st.isEmpty())
                ans[i]=-1;
            else
                ans[i]=st.peek();
            st.push(arr[i]);
        }
        return ans;
    } 
    public int[] nextGreaterElements(int[] nums) {
        return nextLargerElement(nums,nums.length);
    }
}