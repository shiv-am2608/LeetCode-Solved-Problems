class Solution {
    public int countNegatives(int[][] grid) {
        int i = 0 ,j = grid[0].length - 1, count =0 ;
        while(i<grid.length && j>=0)
        {
            if(grid[i][j]<0)
                j--;
            else
            {
                count+=grid[0].length-1 -j;
                i++; 
            }
        }
        if(j<0)
            count+=(grid[0].length)*(grid.length-i);
        return count;
    }
}