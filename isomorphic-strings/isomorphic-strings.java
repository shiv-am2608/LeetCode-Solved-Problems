class Solution {
    public boolean isIsomorphic(String s, String t) {
       HashMap<Character,Character>hmap=new HashMap<Character,Character>();
        int i=0,j=0;
        while(i<s.length() && j<t.length())
        {
            if(hmap.containsKey(s.charAt(i)))
                i++;
            else if(hmap.containsValue(t.charAt(j)))
                j++;
            else
            {
                hmap.put(s.charAt(i),t.charAt(j));
                i++;
                j++;
            }
        }
        while(i<s.length())
        {
            if(!hmap.containsKey(s.charAt(i)))
                return false;
            i++;
        }
        while(j<t.length())
        {
            if(!hmap.containsValue(t.charAt(j)))
                return false;
            j++;
        }
        String temp="";
        for(j=0;j<s.length();j++)
        {
            temp+=hmap.get(s.charAt(j));
        }
        return temp.equals(t);
    }
}