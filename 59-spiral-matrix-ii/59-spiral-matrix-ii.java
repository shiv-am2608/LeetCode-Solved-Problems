class Solution {
    public int[][] generateMatrix(int n) {
        int matrix[][]=new int[n][n];
        int count=1;
        int left=0,right=matrix[0].length-1;
        int top=0,bottom=matrix.length-1;
        int flag=0;
        while(top<=bottom && left<=right)
        {
            if(flag%4==0)
            {
                for(int i=left;i<=right;i++)
                    matrix[top][i]=count++;
                top++;
            }
            else if(flag%4==1)
            {
                for(int i=top;i<=bottom;i++)
                    matrix[i][right]=count++;
                right--;
            }
            else if(flag%4==2)
            {
                for(int i=right;i>=left;i--)
                    matrix[bottom][i]=count++;
                bottom--;
            }
            else
            {
                for(int i=bottom;i>=top;i--)
                    matrix[i][left]=count++;
                left++;
            }
            flag++;
        }
        return matrix;
    }
}