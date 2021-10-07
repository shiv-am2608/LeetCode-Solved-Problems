class Solution {
    // public boolean equal(HashMap<Character,Integer>hmap1,HashMap<Character,Integer>hmap2)
    // {
    //     for (Map.Entry<Character,Integer> entry1 : hmap1.entrySet())
    //     {
    //         Character key = entry1.getKey();
    //         int value1 = entry1.getValue();
    //         int value2 = hmap2.get(key);
    //         if(value1<value2)
    //             return false;
    //     }
    //     return true;
    // }
    public String minWindow(String s, String t) {
        if(t.length()>s.length())
            return "";
        int freq[]=new int[256];
        for(int i=0;i<t.length();i++)
            freq[t.charAt(i)]++;
        int count=0,start=0;
        int len=Integer.MAX_VALUE;
        String ans="";
        for(int i=0;i<s.length();i++)
        {
            char ch=s.charAt(i);
            freq[ch]--;
            if(freq[ch]>=0)
                count++;
            while(count==t.length())
            {
                if(i-start+1<len)
                {
                    len=i-start+1;
                    ans=s.substring(start,i+1);
                }
                freq[s.charAt(start)]++;
                if(freq[s.charAt(start)]>0)
                    count--;
                start++;
            }
        }
        return ans;
    }
}