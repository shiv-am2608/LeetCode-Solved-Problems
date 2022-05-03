class Solution {
    public boolean isIsomorphic(String s, String t) {
        if(s.length() != t.length())
            return false;
        HashMap<Character,Character>hmap=new HashMap<Character,Character>();
        for(int i=0;i<s.length();i++)
        {
            char ch1=s.charAt(i);
            char ch2=t.charAt(i);
            if(hmap.containsKey(ch1))
            {
                if(hmap.get(ch1)==ch2)
                    continue;
                else
                    return false;
            }
            else if(hmap.containsValue(ch2))
                return false;
            else
                hmap.put(ch1,ch2);
        }
        return true;
    }
}