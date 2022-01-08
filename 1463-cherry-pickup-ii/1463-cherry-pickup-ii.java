class Solution {
    public int cherryPickup(int[][] grid) {
        int n=grid.length,m=grid[0].length;
        return dfs(grid,0,0,0,m-1,new Integer[n][m][n][m]);
    }
    public int dfs(int grid[][],int r1,int c1,int r2,int c2,Integer memo[][][][])
    {
        if(r1<0 || r2<0 || c1<0 || c2<0 || r1>=grid.length || r2>=grid.length || c1>=grid[0].length || c2>=grid[0].length)
            return 0;
        if(memo[r1][c1][r2][c2]!=null)
            return memo[r1][c1][r2][c2];
        int curr=grid[r1][c1]+grid[r2][c2];
        if(r1==r2 && c1==c2)
            curr/=2;
        int ans=0;
        int dir[][]={{-1,-1},{-1,0},{-1,1},{0,-1},{0,0},{0,1},{1,-1},{1,0},{1,1}};
        for(int i[]:dir)
            ans=Math.max(ans,dfs(grid,r1+1,c1+i[0],r2+1,c2+i[1],memo));
        curr+=ans;
        memo[r1][c1][r2][c2]=curr;
        return curr;
    }
}