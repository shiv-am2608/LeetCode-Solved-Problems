class Solution {
    public int histogram(int arr[])
    {
        Stack<Integer>st=new Stack<Integer>();
        
        int left[]=new int[arr.length];
        left[0]=-1;
        st.push(0);
        for(int i=1;i<arr.length;i++)
        {
            while(!st.isEmpty() && arr[st.peek()]>=arr[i])
                st.pop();
            if(st.isEmpty())
                left[i]=-1;
            else
                left[i]=st.peek();
            st.push(i);
        }
        
        st.clear();
        
        int right[]=new int[arr.length];
        right[arr.length-1]=arr.length;
        st.push(arr.length-1);
        for(int i=arr.length-2;i>=0;i--)
        {
            while(!st.isEmpty() && arr[st.peek()]>=arr[i])
                st.pop();
            if(st.isEmpty())
                right[i]=arr.length;
            else
                right[i]=st.peek();
            st.push(i);
        }
        
        int max=-1;
        for(int i=0;i<arr.length;i++)
        {
            int area=arr[i]*(right[i]-left[i]-1);
            max=Math.max(max,area);
        }
        return max;
        
    }
    public int maximalRectangle(char[][] matrix) {
        if(matrix.length==0 || matrix[0].length==0)
            return 0;
        int dp[][]=new int[matrix.length+1][matrix[0].length];
        for(int i=1;i<=matrix.length;i++)
        {
            for(int j=0;j<matrix[0].length;j++)
            {
                if(matrix[i-1][j]=='0')
                    dp[i][j]=0;
                else
                    dp[i][j]=dp[i-1][j]+1;
            }
        }
        int max=-1;
        for(int i=1;i<=matrix.length;i++)
            max=Math.max(max,histogram(dp[i]));
        return max;
    }
}