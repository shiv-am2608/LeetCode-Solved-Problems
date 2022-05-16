class Solution {
    public int bfs(int grid[][])
    {
        Queue<Integer>xco=new LinkedList<Integer>();
        Queue<Integer>yco=new LinkedList<Integer>();
        xco.add(0);
        yco.add(0);
        int steps=1;
        int dir[][] ={{0,1},{-1,0},{1,0},{0,-1},{1,1},{-1,-1},{-1,1},{1,-1}};
        while(!xco.isEmpty())
        {
            int size=xco.size();
            while(size-->0)
            {
                int x=xco.poll();
                int y=yco.poll();
                if(x==grid.length-1 && y== grid[0].length-1)
                        return steps;
                for(int i[]:dir)
                {
                    int currx=x+i[0];
                    int curry=y+i[1];
                    if(currx<0 || curry<0 || currx>=grid.length || curry>=grid[0].length || grid[currx][curry]==1)
                        continue;
                    grid[currx][curry]=1;
                    xco.add(currx);
                    yco.add(curry);
                }
            }
            steps++;
        }
        return -1;
    }
    public int shortestPathBinaryMatrix(int[][] grid) {
        if(grid[0][0]==1)
            return -1;
        return bfs(grid);
    }
}