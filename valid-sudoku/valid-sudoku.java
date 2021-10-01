class Solution {
    public boolean rowCheck(char board[][],int i)
    {
        HashSet<Character>hs=new HashSet<Character>();
        for(int x=0;x<9;x++)
        {
            if(board[i][x]=='.')
                continue;
            if(hs.contains(board[i][x]))
                return false;
            hs.add(board[i][x]);
        }
        return true;
    }
    public boolean colCheck(char board[][],int j)
    {
        HashSet<Character>hs=new HashSet<Character>();
        for(int x=0;x<9;x++)
        {
            if(board[x][j]=='.')
                continue;
            if(hs.contains(board[x][j]))
                return false;
            hs.add(board[x][j]);
        }
        return true;
    }
    public boolean gridCheck(char board[][],int i,int j)
    {
        int rowStart=i-(i%3);
        int colStart=j-(j%3);
        HashSet<Character>hs=new HashSet<Character>();
        for(int x=0;x<3;x++)
        {
            for(int y=0;y<3;y++)
            {
                char temp=board[x+rowStart][y+colStart];
                if(temp=='.')
                    continue;
                if(hs.contains(temp))
                    return false;
                hs.add(temp);
            }
        }
        return true;
    }
    public boolean isValidSudoku(char[][] board) {
        for(int i=0;i<9;i++)
            for(int j=0;j<9;j++)
                if(!(rowCheck(board,i) && colCheck(board,j) && gridCheck(board,i,j)))
                    return false;
        return true;
    }
}