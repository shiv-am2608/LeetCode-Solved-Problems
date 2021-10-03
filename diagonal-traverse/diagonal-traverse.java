class Solution {
    public int[] findDiagonalOrder(int[][] mat) {
        int m=mat.length,n=mat[0].length;
        int r=-1,c=0;
        Stack<Integer>st=new Stack<Integer>();
        int res[]=new int[m*n];
        int k=0;
        boolean flag=true;
        for(int i=0;i<m+n-1;i++)
        {
            if(r!=m-1)
                r++;
            else
                c++;
            int r1=r,c1=c;
            while(r1>=0 && c1<n)
            {
                if(flag)
                    res[k++]=mat[r1][c1];
                else
                    st.push(mat[r1][c1]);
                r1--;
                c1++;
            }
            while(!st.isEmpty())
                res[k++]=st.pop();
            flag=!flag;
        }
        return res;
    }
}