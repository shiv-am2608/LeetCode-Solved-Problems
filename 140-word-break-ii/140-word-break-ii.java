class Solution {
    public void dfs(List<String>ans,String str,String res,List<String>dict)
    {
        if(str.length()==0)
        {
            res=res.trim();
            ans.add(new String(res));
            return;
        }
        for(int i=1;i<=str.length();i++)
        {
            if(dict.contains(str.substring(0,i)))
                dfs(ans,str.substring(i),res+str.substring(0,i)+" ",dict);
        }
    }
    public List<String> wordBreak(String s, List<String> wordDict) {
        List<String>ans=new ArrayList<String>();
        dfs(ans,s,"",wordDict);
        return ans;
    }
}