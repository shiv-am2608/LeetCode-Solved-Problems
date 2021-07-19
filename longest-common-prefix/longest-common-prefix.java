class Solution {
    public String prefix(String x,String y)
    {
        int i=0,j=0;
        while(i<x.length() && j<y.length() && x.charAt(i)==y.charAt(j))
        {
            i++;
            j++;
        }
        return x.substring(0,i);
    }
    public String longestCommonPrefix(String[] strs) {
        String res=strs[0];
        for(int i=1;i<strs.length;i++)
            res=prefix(res,strs[i]);
        return res;
    }
}