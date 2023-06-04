class Solution {
    public void dfs(HashSet<Integer>visited,int isConnected[][],int start)
    {
        if(visited.contains(start))
            return;
        visited.add(start);
        for(int i=0;i<isConnected[start].length;i++)
            if(isConnected[start][i]==1)
                dfs(visited,isConnected,i);
    }
    public int findCircleNum(int[][] isConnected) {
        HashSet<Integer>visited = new HashSet<Integer>();
        int count=0;
        for(int i=0;i<isConnected.length;i++)
        {
            if(visited.contains(i))
                continue;
            count++;
            dfs(visited,isConnected,i);
        }
        return count;
    }
}