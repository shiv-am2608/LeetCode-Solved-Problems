class Solution {
    public boolean isSubsequence(String s, String t) {
        if(s.length()==0)
            return true;
        int i=0,j=0;
        while(i<s.length() && j<t.length())
        {
            while(j<t.length() && s.charAt(i)!=t.charAt(j))
                j++;
            if(j==t.length())
                break;
            i++;
            j++;
        }
        return (i==s.length());
    }
}