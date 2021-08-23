class Solution {
    public boolean wordPattern(String pattern, String s) {
        String words[]=s.split(" ");
        HashMap<Character,String>hmap=new HashMap<Character,String>();
        int i=0;
        for(i=0;i<pattern.length();i++)
        {
            if(i==words.length)
                return false;
            if(hmap.containsKey(pattern.charAt(i)))
            {
                if(!words[i].equals(hmap.get((pattern.charAt(i)))))
                   return false;
            }
            else if(hmap.containsValue(words[i]))
                   return false;
            else
                   hmap.put(pattern.charAt(i),words[i]);
        }
        if(i!=words.length)
            return false;
        return true;
    }
}