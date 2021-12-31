class Solution {
    public void updateVisited(int startx,int endx,int starty,int endy,boolean visited[][])
    {
        for(int i=startx;i<=endx;i++)
            for(int j=starty;j<=endy;j++)
                visited[i][j]=true;
    }
    public int[][] findFarmland(int[][] land) {
        ArrayList<int[]>arr=new ArrayList<int[]>();
        boolean visited[][]=new boolean[land.length][land[0].length];
        for(int i=0;i<land.length;i++)
        {
            for(int j=0;j<land[0].length;j++)
            {
                if(land[i][j]==0 || visited[i][j])
                    continue;
                int startx=i,endx=i;
                int starty=j,endy=j;
                while(endx<land.length && land[endx][starty]==1)
                    endx++;
                endx--;
                while(endy<land[0].length && land[endx][endy]==1)
                    endy++;
                endy--;
                updateVisited(startx,endx,starty,endy,visited);
                arr.add(new int[]{startx,starty,endx,endy});
            }
        }
        int ans[][]=new int[arr.size()][4];
        for(int i=0;i<arr.size();i++)
            ans[i]=arr.get(i);
        return ans;
    }
}