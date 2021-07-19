class Solution {
    public int count(String s,int start,int end)
    {
        int count=0;
        while(start>=0 && end<s.length() && s.charAt(start)==s.charAt(end))
        {
            start--;
            count++;
            end++;
        }
        return count;
    }
    public int countSubstrings(String s) {
        int ans=0;
        for(int i=0;i<s.length();i++)
        {
            ans+=count(s,i,i);
            ans+=count(s,i,i+1);
        }
        return ans;
    }
}