class Solution
{
    public static void gameOfLife(int[][] board)
    {
        int n=board.length;
        int m=board[0].length;
        int temp[][]=new int[n][m];
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                int count=0;
                if(i>0 && j>0 && board[i-1][j-1]==1)
                    count++;
                if(i>0 && board[i-1][j]==1)
                    count++;
                if(i>0 && j<m-1 && board[i-1][j+1]==1)
                    count++;
                if(j>0 && board[i][j-1]==1)
                    count++;
                if(j<m-1 && board[i][j+1]==1)
                    count++;
                if(i<n-1 && j>0 &&board[i+1][j-1]==1)
                    count++;
                if(i<n-1 && board[i+1][j]==1)
                    count++;
                if(i<n-1 && j<m-1 && board[i+1][j+1]==1)
                    count++;
                
                
                if(count<2 || count>3)
                    temp[i][j]=0;  
                else if(board[i][j]==0 && count==3)
                    temp[i][j]=1;
                else
                    temp[i][j]=board[i][j];
            }
        }
        for(int i=0;i<n;i++)
            for(int j=0;j<m;j++)
                board[i][j]=temp[i][j];
    }
}