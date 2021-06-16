class Solution {
    public boolean DFS(boolean visited[][],char board[][],String word,int i,int j,int k)
    {
        if(i<0 || j<0 || i>=board.length || j>=board[0].length || visited[i][j])
            return false;
        if(k==word.length())
            return true;
        visited[i][j]=true;
        boolean top=false,bottom=false,right=false,left=false;
        if(i!=0 && word.charAt(k)==board[i-1][j])
            top=DFS(visited,board,word,i-1,j,k+1);
        if(i!=board.length-1 && word.charAt(k)==board[i+1][j])
            bottom=DFS(visited,board,word,i+1,j,k+1);
        if(j!=0 && word.charAt(k)==board[i][j-1])
            left=DFS(visited,board,word,i,j-1,k+1);
        if(j!=board[0].length-1 && word.charAt(k)==board[i][j+1])
            right=DFS(visited,board,word,i,j+1,k+1);
        visited[i][j]=false;
        return top || bottom || right || left;
        
        
    }
    public boolean exist(char[][] board, String word) {
        boolean visited[][]=new boolean[board.length][board[0].length];
        for(int i=0;i<board.length;i++)
            for(int j=0;j<board[0].length;j++)
                if(board[i][j]==word.charAt(0))
                {
                    if(DFS(visited,board,word,i,j,1))
                        return true;
                }
        return false;
    }
}