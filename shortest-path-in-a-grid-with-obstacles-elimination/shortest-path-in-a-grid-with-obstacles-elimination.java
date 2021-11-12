class Solution {
    public int shortestPath(int[][] grid, int k) {
        Queue<int[]>q=new LinkedList<int[]>();
        q.offer(new int[]{0,0,k});
        int visited[][]=new int[grid.length][grid[0].length];
        for(int rows[]:visited)
            Arrays.fill(rows,-1);
        int minDistance=0;
        while(!q.isEmpty())
        {
            int size=q.size();
            while(size-- >0)
            {
                int curr[]=q.poll();
                int x=curr[0];
                int y=curr[1];
                int d=curr[2];
                if(x<0 || y<0 || x>=grid.length || y>=grid[0].length)
                    continue;
                if(x==grid.length-1 && y==grid[0].length-1)
                    return minDistance;
                
                //will keep as much destroyable value we can keep
                if(d<=visited[x][y])
                    continue;
                visited[x][y]=d;
                if(grid[x][y]==1)
                    d--;
                if(d<0)
                    continue;
                
                q.offer(new int[]{x+1,y,d});
                q.offer(new int[]{x-1,y,d});
                q.offer(new int[]{x,y+1,d});
                q.offer(new int[]{x,y-1,d});
            }
            minDistance++;
        }
        return -1;
    }
}