class Solution {
    public int minInsertions(String s) {
        String str="";
        for(int i=s.length()-1;i>=0;i--)
            str+=s.charAt(i);
        int dp[][]=new int[s.length()+1][s.length()+1];
        for(int i=0;i<=s.length();i++)
            for(int j=0;j<=s.length();j++)
            {
                if(i==0 || j==0)
                    continue;
                if(s.charAt(i-1)==str.charAt(j-1))
                    dp[i][j]=1+dp[i-1][j-1];
                else
                    dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
            }
        return s.length()-dp[s.length()][s.length()];
    }
}