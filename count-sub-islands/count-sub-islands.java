class Solution {
    boolean isSubIsland=true;
    public void checkSubIsland(int grid1[][],int grid2[][],int x,int y,boolean visited[][])
    {
        if(x<0 || y<0 || x>=grid2.length || y>=grid2[0].length || grid2[x][y]==0 || visited[x][y])
            return;
        if(grid1[x][y]==0)
            isSubIsland=false;
        visited[x][y]=true;
        checkSubIsland(grid1,grid2,x-1,y,visited);
        checkSubIsland(grid1,grid2,x,y-1,visited);
        checkSubIsland(grid1,grid2,x+1,y,visited);
        checkSubIsland(grid1,grid2,x,y+1,visited);
    }
    public int countSubIslands(int[][] grid1, int[][] grid2) {
        boolean visited[][]=new boolean[grid1.length][grid1[0].length];
        int count=0;
        for(int i=0;i<grid2.length;i++)
        {
            for(int j=0;j<grid2[0].length;j++)
            {
                if(grid2[i][j]==0 || grid1[i][j]==0 || visited[i][j])
                    continue;
                checkSubIsland(grid1,grid2,i,j,visited);
                if(isSubIsland)
                    count++;
                else
                    isSubIsland=true;
            }
        }
        return count;
    }
}