class Solution {
    char board[][];
    int count=0;
    boolean isSafe(int row,int col)
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
    void solve(List<List<String>> res, int col)
    {
        if(col==board.length)
        {
            count++;
            return;
        }
        for(int i=0;i<board.length;i++)
        {
            if(isSafe(i,col))
            {
                board[i][col]='Q';
                solve(res,col+1);
                board[i][col]='.';
            }
        }
    }
    public int totalNQueens(int n) {
        board=new char[n][n];
        for(char i[]:board)
            Arrays.fill(i,'.');
        List<List<String>>res=new ArrayList<List<String>>();
        solve(res,0);
        return count;
    }
}