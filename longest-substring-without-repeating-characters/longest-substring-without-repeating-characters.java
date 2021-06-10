class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character,Integer>hs=new HashMap<Character,Integer>();
        int res=0;
        int count=0;
        for(int i=0;i<s.length();i++)
        {
            if(hs.containsKey(s.charAt(i)))
            {
                count=0;
                i=hs.get(s.charAt(i))+1;
                hs.clear();
            }
            hs.put(s.charAt(i),i);
            count++;
            res=Math.max(res,count);
        }
        return res;
    }
}