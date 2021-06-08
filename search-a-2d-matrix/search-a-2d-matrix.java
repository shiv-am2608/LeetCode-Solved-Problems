class Solution {
    public int searchRow(int matrix[][],int target,int top,int bottom)
    {
        if(top>bottom)
            return -1;
        int row=(top+bottom)/2;
        if(matrix[row][0]<=target && matrix[row][matrix[row].length-1]>=target)
            return row;
        else if(matrix[row][0]>target)
            return searchRow(matrix,target,top,bottom-1);
        return searchRow(matrix,target,top+1,bottom);     
    }
    public boolean searchElement(int arr[],int target,int left,int right)
    {
        if(left>right)
            return false;
        int mid=(left+right)/2;
        if(arr[mid]==target)
            return true;
        else if(arr[mid]<target)
            return searchElement(arr,target,mid+1,right);
        return searchElement(arr,target,left,mid-1);
    }
    public boolean searchMatrix(int[][] matrix, int target) {
       int rowNum=searchRow(matrix,target,0,matrix.length-1);
        if(rowNum==-1)
            return false;
        int arr[]=matrix[rowNum];
        return searchElement(arr,target,0,arr.length-1);
        
    }
}