class Solution {
    public void setZeroes(int[][] matrix) {
        ArrayList<int[]> al = new ArrayList<int[]>();
        for(int i=0;i<matrix.length;i++)
        {
            for(int j=0;j<matrix[i].length;j++)
            {
                int arr[]=new int[2];
                if(matrix[i][j]==0)
                {
                     arr[0]=i;
                     arr[1]=j;
                    al.add(arr);
                }
            }
        }
        for(int i[]:al)
        {
            for(int k=0;k<matrix.length;k++)
            {
                for(int j=0;j<matrix[k].length;j++)
                {
                   if(k==i[0] || j==i[1])
                       matrix[k][j]=0;
                }
            }
        }
    }
}