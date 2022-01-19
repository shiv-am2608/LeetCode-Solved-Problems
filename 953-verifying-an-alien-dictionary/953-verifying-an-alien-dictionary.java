class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        int map[]=new int[26];
        for(int i=0;i<order.length();i++)
            map[order.charAt(i)-'a']=i;
        for(int i=1;i<words.length;i++)
        {
            if(compare(words[i-1],words[i],map)>0)
               return false;
        }
        return true;
    }
    public int compare(String s1,String s2,int map[])
    {
        int comp=0;
        for(int i=0;i<Math.min(s1.length(),s2.length());i++)
        {
            comp=map[s1.charAt(i)-'a']-map[s2.charAt(i)-'a'];
            if(comp!=0)
                break;
        }
        if(comp==0)
            return s1.length()-s2.length();// ["Hel","Hello"] is Valid but ["Hello","Hel"] is not
        return comp;
    }
}