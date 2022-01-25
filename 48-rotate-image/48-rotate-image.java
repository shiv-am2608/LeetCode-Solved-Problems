class Solution {
    public void reverse(int matrix[][])
    {
        for(int i=0;i<matrix.length;i++)
        {
            int start=0,end=matrix.length-1;
            while(start<end)
            {
                int temp=matrix[i][start];
                matrix[i][start]=matrix[i][end];
                matrix[i][end]=temp;
                start++;
                end--;
            }
        }
    }
    public void transpose(int matrix[][])
    {
        for(int i=0;i<matrix.length;i++)
            for(int j=0;j<i;j++)
            {
                int temp=matrix[i][j];
                matrix[i][j]=matrix[j][i];
                matrix[j][i]=temp;
            }
    }
    public void rotate(int[][] matrix) {
        transpose(matrix);
        reverse(matrix);
    }
}