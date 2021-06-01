class Solution {
    public void countIslands(char grid[][],boolean visited[][],int x,int y)
    {
        if(x<0 ||y<0 ||x>=grid.length || y>=grid[0].length || visited[x][y])
            return;
        visited[x][y]=true;
        countIslands(grid,visited,x-1,y);
        countIslands(grid,visited,x,y-1);
        countIslands(grid,visited,x+1,y);
        countIslands(grid,visited,x,y+1);
    }
    public int numIslands(char[][] grid) {
        boolean visited[][]=new boolean[grid.length][grid[0].length];
        for(int i=0;i<grid.length;i++)
        {
            for(int j=0;j<grid[0].length;j++)
                if(grid[i][j]=='0')
                    visited[i][j]=true;
        }
        int count=0;
        for(int i=0;i<grid.length;i++)
        {
            for(int j=0;j<grid[0].length;j++)
                if(visited[i][j]==false)
                {
                    countIslands(grid,visited,i,j);
                    count++;
                }
        }
        return count;
    }
}