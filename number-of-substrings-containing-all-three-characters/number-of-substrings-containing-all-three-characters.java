class Solution {
    public char[] getOther(char x)
    {
        if(x=='a')
            return new char[]{'b','c'};
        if(x=='b')
            return new char[]{'a','c'};
        return new char[]{'a','b'};
    }
    public int numberOfSubstrings(String s) {
        HashMap<Character,Integer>hmap=new HashMap<Character,Integer>();
        int i=0;
        while(i<s.length() && hmap.size()!=3)
        {
            hmap.put(s.charAt(i),i);
            i++;    
        }
        if(hmap.size()<3)
            return 0;
        
        char curr=s.charAt(i-1);
        char other[]=getOther(curr);
        int min=Math.min(hmap.get(other[0]),hmap.get(other[1]));
        int count=min+1;
        for(int x=i;x<s.length();x++)
        {
            curr=s.charAt(x);
            other=getOther(curr);
            min=Math.min(hmap.get(other[0]),hmap.get(other[1]));
            count+=min+1;
            hmap.put(curr,x);
        }
        return count;
    }
}