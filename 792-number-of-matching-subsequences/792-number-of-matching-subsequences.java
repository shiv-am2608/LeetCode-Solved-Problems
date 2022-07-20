class Solution {
    public int numMatchingSubseq(String s, String[] words) {
        HashMap<String,Integer>freq=new HashMap<String,Integer>();
        for(String str:words)
            freq.put(str,freq.getOrDefault(str,0)+1);
        int count=0;
        for(String str:freq.keySet())
        {
            int i=0,j=0;
            while(i<s.length() && j<str.length())
            {
                if(s.charAt(i)==str.charAt(j))
                {
                    i++;
                    j++;
                }
                else
                    i++;
            }
            if(j==str.length())
                count+=freq.get(str);
        }
        return count;
    }
}