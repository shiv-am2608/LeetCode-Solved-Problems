class Solution {
    public boolean isSafe(int i,int j,char n,char[][] board)
    {
        int N = board.length;
        for(int c=0;c<N;c++)
        {
            if(board[c][j] == n || board[i][c] == n)
                return false;
            
        }
        int s = (int)Math.sqrt(N);
        int sr= i-i%s;
        int sc = j - j%s;
        for(int v=0;v<s;v++)
        {
            for(int b=0;b<s;b++)
            {
                if(board[sr+v][sc+b]==n)
                    return false;
            }
        }
        return true;
    }
    public void solveSudoku(char[][] board) {
         
        boolean result = solve(board);
    }
    public boolean solve(char[][] board) {
        int N = board.length;
        int i=0;
        int j=0;
        for(i=0;i<N;i++)
        {
            boolean flag = false;
            for(j=0;j<N;j++)
            {
                if(board[i][j]=='.')
                {
                   flag = true;
                     break;
                }
            }
            if(flag==true)
            {
                break;
            }
        }
        if(i==N && j==N)
            return true;
        for(int k=1;k<=N;k++)
        {
            char n =(char)('0'+k);
            if(isSafe(i,j,n,board))
            {
                board[i][j] = n;
                if(solve(board))
                    return true;
                board[i][j]= '.';
            }
        }
        return false;
    }
}