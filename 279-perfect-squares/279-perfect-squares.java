class Solution {
    public List<Integer> getAllSquares(int n)
    {
        ArrayList<Integer>squares = new ArrayList<Integer>();
        for(int i=1;i*i<=n;i++)
            squares.add(i*i);
        return squares;
    }
    
    public int minPrimes(List<Integer>squares,int n)
    {
        int dp[][]=new int[squares.size()+1][n+1];
        for(int i=1;i<=n;i++)
        {
            dp[0][i]=Integer.MAX_VALUE-1;
            if(i%squares.get(0)==0)
                dp[1][i]=i/squares.get(0);
            else
                dp[1][i]=Integer.MAX_VALUE-1;
        }
        for(int i=2;i<=squares.size();i++)
        {
            for(int j=1;j<=n;j++)
            {
                if(squares.get(i-1)<=j)
                    dp[i][j]=Math.min(dp[i-1][j],dp[i][j-squares.get(i-1)]+1);
                else
                    dp[i][j]=dp[i-1][j];
            }
        }
        return dp[squares.size()][n];
    }
    public int numSquares(int n) {
        List<Integer>squares = getAllSquares(n);
        return minPrimes(squares,n);
    }
}