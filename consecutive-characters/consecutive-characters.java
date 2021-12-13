class Solution {
    public int maxPower(String s) {
        int max=1,len=1;
        for(int i=1;i<s.length();i++)
        {
            if(s.charAt(i)==s.charAt(i-1))
                len++;
            else
                len=1;
            max=Math.max(len,max);
        }
        return max;
    }
}