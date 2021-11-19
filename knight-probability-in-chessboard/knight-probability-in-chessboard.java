class Solution {
    public double knightProbability(int n, int k, int row, int column) {
        double curr[][]=new double[n][n];
        double next[][]=new double[n][n];
        curr[row][column]=1;
        int dir[][]={{-2,-1},{-2,1},{2,-1},{2,1},{1,2},{1,-2},{-1,2},{-1,-2}};
        while(k-->0)
        {
            for(int i=0;i<n;i++)
            {
                for(int j=0;j<n;j++)
                {
                    if(curr[i][j]==0)
                        continue;
                    for(int move[]:dir)
                    {
                        int currx=i+move[0];
                        int curry=j+move[1];
                        if(currx<n && curry<n && currx>=0 && curry>=0)
                            next[currx][curry]+=curr[i][j]/8.0;
                    }
                }
            }
            curr=next;
            next=new double[n][n];
        }
        double sum=0;
        for(int i=0;i<n;i++)
            for(int j=0;j<n;j++)
                sum+=curr[i][j];
        return sum;
    }
}