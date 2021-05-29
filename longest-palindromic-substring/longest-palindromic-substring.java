class Solution {
    public String longestPalindrome(String s) {
        int start=0;
        int end=0;
        for(int i=0;i<s.length();i++)
        {
            int len1=func(s,i,i);
            int len2=func(s,i,i+1);
            int len=Math.max(len1,len2);
            if(len>end-start)
            {
                start=i-((len-1)/2);
                end=i+(len/2);
            }
        }
        return s.substring(start,end+1);
    }
    public int func(String s,int i,int j)
    {
        if(i<0 || j>=s.length() || s.charAt(i)!=s.charAt(j))
            return 0;
        while(i>=0 && j<s.length() && s.charAt(i)==s.charAt(j))
        {
            i--;
            j++;
        }
        return j-i-1;
    }
}