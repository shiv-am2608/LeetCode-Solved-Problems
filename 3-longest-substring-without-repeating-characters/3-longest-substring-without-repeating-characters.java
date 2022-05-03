class Solution {
    public int lengthOfLongestSubstring(String s) {
        //hashmap stores character and index of last occurance of character
        HashMap<Character,Integer>hmap=new HashMap<Character,Integer>();
        int length=0,res=0,j=-1;
        for(int i=0;i<s.length();i++)
        {
            if(hmap.containsKey(s.charAt(i)))
                j=Math.max(j,hmap.get(s.charAt(i)));
            hmap.put(s.charAt(i),i);
            length=i-j;;
            res=Math.max(res,length);//storing the max result
        }
        return res;
    }
}