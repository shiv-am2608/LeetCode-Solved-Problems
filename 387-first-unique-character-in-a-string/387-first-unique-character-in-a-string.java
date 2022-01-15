class Solution {
    public int firstUniqChar(String s) {
        HashMap<Character,Integer>hmap=new LinkedHashMap<Character,Integer>();
        for(int i=0;i<s.length();i++)
        {
            if(hmap.containsKey(s.charAt(i)))
                hmap.put(s.charAt(i),-1);
            else
                hmap.put(s.charAt(i),i);
        }
        for(Map.Entry<Character,Integer>x:hmap.entrySet())
            if(x.getValue()!=-1)
                return x.getValue();
        return -1;
    }
}