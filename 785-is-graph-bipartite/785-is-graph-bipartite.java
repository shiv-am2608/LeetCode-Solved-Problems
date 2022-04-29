class Solution {
    public boolean DFS(int color[],int src,int grid[][])
    {
        for(int temp:grid[src])
        {
            if(color[temp]==color[src])
                return false;
            else if(color[temp]==0)
            {
                if(color[src]==1)
                    color[temp]=2;
                else
                    color[temp]=1;
               if(!DFS(color,temp,grid))
                   return false;
            }
        }
        return true;
            
    }
    public boolean isBipartite(int[][] graph) {
        int color[]=new int[graph.length];
        for(int i=0;i<graph.length;i++)
            if(color[i]==0)
            {
                color[i]=1;
                if(!DFS(color,i,graph))
                    return false;
            }
        return true;
    }
}