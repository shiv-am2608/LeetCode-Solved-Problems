class Solution {
    public boolean find(char board[][],int x,int y,String word,int k,boolean visited[][])
    {
        if(k==word.length())
            return true;
        if(x<0 || y<0 || x>=board.length || y>=board[0].length || board[x][y]!=word.charAt(k) || visited[x][y])
            return false;
        visited[x][y]=true;
        boolean bottom=find(board,x+1,y,word,k+1,visited);
        boolean right=find(board,x,y+1,word,k+1,visited);
        boolean top=find(board,x-1,y,word,k+1,visited);
        boolean left=find(board,x,y-1,word,k+1,visited);
        visited[x][y]=false;
        return left || right || top || bottom;
    }
    public boolean exist(char[][] board, String word) {
        for(int i=0;i<board.length;i++)
        {
            for(int j=0;j<board[0].length;j++)
            {
                boolean visited[][]=new boolean[board.length][board[0].length];
                if(find(board,i,j,word,0,visited))
                    return true;
            }
        }
        return false;
    }
}