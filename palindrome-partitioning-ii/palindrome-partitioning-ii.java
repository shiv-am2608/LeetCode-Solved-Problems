class Solution {
    boolean isPallindrome(char str[],int i,int j)
    {
        while(i<j)
        {
            if(str[i]!=str[j])
                return false;
            i++;
            j--;
        }
        return true;
    }
    int memo(char str[],int i,int j,int dp[][])
    {
        if(i>=j)
            return 0;
        if(isPallindrome(str,i,j))
        {
            dp[i][j]=0;
            return 0;
        }
        if(dp[i][j]!=-1)
            return dp[i][j];
        int res=Integer.MAX_VALUE;
        for(int k=i;k<j;k++)
        {
            if(isPallindrome(str,i,k))
                res=Math.min(res,1+memo(str,k+1,j,dp));
        }
        dp[i][j]=res;
        return res;
    }
    public int minCut(String s) {
        char str[]=s.toCharArray();
        int dp[][]=new int[s.length()+1][s.length()+1];
        for(int i[]:dp)
            Arrays.fill(i,-1);
        return memo(str,0,s.length()-1,dp);
    }
}