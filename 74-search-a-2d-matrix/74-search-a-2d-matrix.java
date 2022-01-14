class Solution {
    public int findRow(int matrix[][],int target)
    {
        int n=matrix[0].length-1;
        int low=0,high=matrix.length-1;
        while(low<=high)
        {
            int mid=high-(high-low)/2;
            if(matrix[mid][0]<=target && matrix[mid][n]>=target)
                return mid;
            if(target<matrix[mid][0])
                high=mid-1;
            else
                low=mid+1;
        }
        return -1;
    }
    public int findCol(int matrix[],int target)
    {
        int low=0,high=matrix.length-1;
        while(low<=high)
        {
            int mid=high-(high-low)/2;
            if(matrix[mid]==target)
                return mid;
            if(target<matrix[mid])
                high=mid-1;
            else
                low=mid+1;
        }
        return -1;
    }
    public boolean searchMatrix(int[][] matrix, int target) {
        int row=findRow(matrix,target);
        if(row==-1)
            return false;
        int col=findCol(matrix[row],target);
        if(col==-1)
            return false;
        return true;
    }
}