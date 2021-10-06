class Solution {
    public int orangesRotting(int[][] grid) {
        boolean visited[][]=new boolean[grid.length][grid[0].length];
        Queue<int[]>q=new LinkedList<int[]>();
        for(int i=0;i<grid.length;i++)
        {
            for(int j=0;j<grid[0].length;j++)
            {
                if(grid[i][j]==2)
                {
                    visited[i][j]=true;
                    q.offer(new int[]{i,j});
                    grid[i][j]=0;
                }
                else if(grid[i][j]==0)
                    visited[i][j]=true;
            }
        }
        int time=1;
        int dir[][]={{1,0},{-1,0},{0,1},{0,-1}};
        while(!q.isEmpty())
        {
                int size=q.size();
                int loc[]=q.poll();
                int x=loc[0];
                int y=loc[1];
                for(int i[]:dir)
                {
                    int currx=x+i[0];
                    int curry=y+i[1];
                    if(currx<0 || curry<0 || currx>=grid.length || curry>=grid[0].length || visited[currx][curry])
                        continue;
                    visited[currx][curry]=true;
                    grid[currx][curry]=grid[x][y]+1;
                    q.offer(new int[]{currx,curry});
                }
        }
        int min=0;
        for(int i=0;i<grid.length;i++)
        {
            for(int j=0;j<grid[0].length;j++)
            {
                min=Math.max(min,grid[i][j]);
                if(!visited[i][j])
                    return -1;
            }
        }
        return min;
    }
}