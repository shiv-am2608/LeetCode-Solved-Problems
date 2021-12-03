class Solution {
    public boolean backTrack(String s,List<String> wordDict,HashMap<String,Boolean>hmap)
    {
        if(s.length()==0)
            return true;
        if(hmap.containsKey(s))
            return hmap.get(s);
        boolean ans=false;
        for(int i=1;i<=s.length();i++)
        {
            if(wordDict.contains(s.substring(0,i)))
            {
                if(backTrack(s.substring(i),wordDict,hmap))
                {
                    ans=true;
                    break;
                }
            }
        }
        hmap.put(s,ans);
        return ans;
    }
    public boolean wordBreak(String s, List<String> wordDict) {
        HashMap<String,Boolean>hmap=new HashMap<String,Boolean>();
        return backTrack(s,wordDict,hmap);
    }
}