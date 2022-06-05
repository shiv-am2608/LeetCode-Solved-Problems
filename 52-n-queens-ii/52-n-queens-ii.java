class Solution {
    int count=0;
    boolean isSafe(char board[][],int row,int col)
    {
        for(int i=0;i<col;i++)
            if(board[row][i]=='Q')
                return false;
        for(int i=row,j=col;i>=0 && j>=0; i--,j--)
            if(board[i][j]=='Q')
                return false;
        for(int i=row,j=col;i<board.length && j>=0;i++,j--)
            if(board[i][j]=='Q')
                return false;
        return true;
    }
    void solve(char board[][],int col)
    {
        if(col==board.length)
        {
            count++;
            return;
        }
        for(int i=0;i<board.length;i++)
        {
            if(isSafe(board,i,col))
            {
                board[i][col]='Q';
                solve(board,col+1);
                board[i][col]='.';
            }
        }
    }
    public int totalNQueens(int n) {
        char board[][]=new char[n][n];
        for(char i[]:board)
            Arrays.fill(i,'.');
        solve(board,0);
        return count;
    }
}