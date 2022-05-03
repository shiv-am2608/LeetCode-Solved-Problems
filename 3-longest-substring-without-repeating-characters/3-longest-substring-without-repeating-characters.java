class Solution {
    public int lengthOfLongestSubstring(String s) {
        //hashmap stores character and index of last occurance of character
        HashMap<Character,Integer>hmap=new HashMap<Character,Integer>();
        int length=0,res=0,j=-1;
        
        //iterating over the string
        for(int i=0;i<s.length();i++)
        {
            //if we find duplicate we begin again from next index of last occurance of                  repeating character
            if(hmap.containsKey(s.charAt(i)))
            {
                j=Math.max(j,hmap.get(s.charAt(i)));//updates the i value for loop to go back in                      index
            }
            hmap.put(s.charAt(i),i);
            length=i-j;;
            res=Math.max(res,length);//storing the max result
        }
        return res;
    }
}