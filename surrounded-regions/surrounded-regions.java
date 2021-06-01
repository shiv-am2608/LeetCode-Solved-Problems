class Solution {
    public void DFS(char grid[][],int i,int j)
    {
        if(i<0 || j<0 || i>=grid.length || j>=grid[0].length || grid[i][j]=='X'|| grid[i][j]=='$')
            return;
        grid[i][j]='$';
        DFS(grid,i+1,j);
        DFS(grid,i-1,j);
        DFS(grid,i,j+1);
        DFS(grid,i,j-1);
    }
    public void solve(char[][] board) {
        for(int i=0;i<board.length;i++)
        {
            for(int j=0;j<board[0].length;j++)
            {
                if(i==0 || j==0 || i==board.length-1 || j==board[0].length-1)
                    if(board[i][j]=='O')
                        DFS(board,i,j);
            }
        }
        for(int i=0;i<board.length;i++)
            for(int j=0;j<board[0].length;j++)
                if(board[i][j]=='O')
                    board[i][j]='X';
                else if(board[i][j]=='$')
                    board[i][j]='O';
    }
}