class Solution {
    public int len(String s,int start,int end)
    {
        if(start<0 || end>=s.length())
            return 0;
        while(start>=0 && end<s.length() && s.charAt(start)==s.charAt(end))
        {
            start--;
            end++;
        }
        return end-start-1;
    }
    public String longestPalindrome(String s) {
        int start=0,end=0;
        for(int i=0;i<s.length();i++)
        {
            int len1=len(s,i,i);
            int len2=len(s,i,i+1);
            int max=len1>len2?len1:len2;
            if(max>end-start)
            {
                start=i-((max-1)/2);
                end=i+(max/2);
            }
        }
        return s.substring(start,end+1);
    }
}