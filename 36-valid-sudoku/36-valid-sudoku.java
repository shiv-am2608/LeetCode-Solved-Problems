class Solution {
    
    //function to check if a row is valid
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
    
    //function to check if a column is valid
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
    
    //function to check if a subgrid is valid
    public boolean gridCheck(char board[][],int i,int j)
    {
        HashSet<Character>hs=new HashSet<Character>();
        for(int x=0;x<3;x++)
        {
            for(int y=0;y<3;y++)
            {
                char temp=board[x+i][y+j];
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
        
        //checking each row
        for(int i=0;i<9;i++)
            if(!rowCheck(board,i))
                return false;
        
        //checking each column
        for(int j=0;j<9;j++)
            if(!colCheck(board,j))
                return false;
        
        ///checking each subgrid
        for(int i=0;i<9;i=i+3)
            for(int j=0;j<9;j=j+3)
                if(!gridCheck(board,i,j))
                    return false;
        return true;
        
    }
}