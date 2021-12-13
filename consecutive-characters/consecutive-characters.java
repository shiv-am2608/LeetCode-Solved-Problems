class Solution {
    public int maxPower(String s) {
        int max=0,len=1;
        for(int i=1;i<s.length();i++)
        {
            if(s.charAt(i)==s.charAt(i-1))
                len++;
            else
            {
                max=Math.max(len,max);
                len=1;
            }
        }
        return Math.max(max,len);
    }
}