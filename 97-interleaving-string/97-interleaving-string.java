class Solution {
    public boolean dfs(String s1,String s2,String s3,int i,int j,int k,boolean invalid[][])
    {
        if(invalid[i][j])
            return false;
        if(k==s3.length())
            return true;
        boolean valid=false;
        if(i<s1.length() && s1.charAt(i)==s3.charAt(k))
            valid=dfs(s1,s2,s3,i+1,j,k+1,invalid);
        
        //if we get valid=true we dont want to override as we can get false again
        if(!valid && j<s2.length() && s2.charAt(j)==s3.charAt(k))
            valid=dfs(s1,s2,s3,i,j+1,k+1,invalid);
        if(!valid)
            invalid[i][j]=true;
        return valid;
    }
    public boolean isInterleave(String s1, String s2, String s3) {
        if(s1.length()+s2.length()!=s3.length())
            return false;
        return dfs(s1,s2,s3,0,0,0,new boolean[s1.length()+1][s2.length()+1]);
    }
}