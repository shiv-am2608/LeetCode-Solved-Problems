class Solution {
    public boolean isSafe(int i,int j,char curr,char board[][])
    {
        int N=board.length;
        for(int t=0;t<N;t++)
            if(board[i][t]==curr || board[t][j]==curr)
                return false;
        int s=(int)Math.sqrt(N);
        int rs=i-i%s;
        int cs=j-j%s;
        for(i=0;i<s;i++)
            for(j=0;j<s;j++)
                if(board[i+rs][j+cs]==curr)
                    return false;
        return true;
    }
    public boolean solve(char board[][])
    {
        int N=board.length;
        int i=0,j=0;
        for(i=0;i<N;i++)
        {
            for(j=0;j<N;j++)
                if(board[i][j]=='.')
                    break;
            if(j<N)
                break;
        }
        if(i==N && j==N)
            return true;
        for(int k=1;k<=N;k++)
        {
            char curr=(char)(k+'0');
            if(isSafe(i,j,curr,board))
            {
                board[i][j]=curr;
                if(solve(board))
                    return true;
                board[i][j]='.';
            }
        }
        return false;
    }
    public void solveSudoku(char[][] board) {
        solve(board);
    }
    
}