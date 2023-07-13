class Solution {
    public boolean cycle(int grid[][],int start,boolean visited[],boolean recurr[])
    {
        visited[start]=true;
        recurr[start]=true;
        for(int i=0;i<grid[start].length;i++)
        {
            if(grid[start][i]==0)
                continue;
            if(!visited[i])
            {
                if(cycle(grid,i,visited,recurr))
                    return true;
            }
            else if(recurr[i])
                return true;
        }
        recurr[start]=false;
        return false;
    }
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int grid[][]=new int[numCourses][numCourses];
        for(int i[]:prerequisites)
        {
            grid[i[0]][i[1]]=1;
        }
        boolean visited[]=new boolean[numCourses];
        boolean recurr[]=new boolean[numCourses];
        for(int i=0;i<visited.length;i++)
        {
            if(!visited[i])
                if(cycle(grid,i,visited,recurr))
                    return false;
        }
        return true;
    }
}