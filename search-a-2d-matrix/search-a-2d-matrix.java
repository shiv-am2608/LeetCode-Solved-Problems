class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int i=0,j=matrix[0].length-1;
        while(i<matrix.length && matrix[i][j]<target)
            i++;
        if(i==matrix.length)
            return false;
        while(j>=0 && matrix[i][j]>target)
            j--;
        if(j<0)
            return false;
        if(matrix[i][j]==target)
            return true;
        return false;
    }
}