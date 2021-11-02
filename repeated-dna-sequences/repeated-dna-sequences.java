class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        List<String>ans=new ArrayList<String>();
        HashSet<String>hs=new HashSet<String>();
        for(int i=0;i<=s.length()-10;i++)
        {
            String curr=s.substring(i,i+10);
            if(hs.contains(curr))
            {
                if(!ans.contains(curr))
                    ans.add(curr);
            }
            hs.add(curr);
        }
        return ans;
    }
}