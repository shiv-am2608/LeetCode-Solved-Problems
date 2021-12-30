class Solution {
    public boolean isToeplitzMatrix(int[][] matrix) {
        for(int i=0;i<matrix[0].length;i++)
        {
            int x=0,y=i;
            int val=matrix[x][y];
            while(x<matrix.length && y<matrix[0].length)
            {
                if(matrix[x][y]!=val)
                    return false;
                x++;
                y++;
            }
        }
        for(int i=0;i<matrix.length;i++)
        {
            int x=i,y=0;
            int val=matrix[x][y];
            while(x<matrix.length && y<matrix[0].length)
            {
                if(matrix[x][y]!=val)
                    return false;
                x++;
                y++;
            }
        }
        return true;
    }
}