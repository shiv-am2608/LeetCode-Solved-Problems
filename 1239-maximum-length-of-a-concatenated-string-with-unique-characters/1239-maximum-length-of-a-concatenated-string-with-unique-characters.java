class Solution {
    int ans=0;
    public void backtrack(int start,String curr,List<String>arr,HashSet<Character>hs)
    {
        ans=Math.max(ans,curr.length());
        for(int i=start+1;i<arr.size();i++)
        {
            String word=arr.get(i);
            char iter[]=word.toCharArray();
            int j=0;
            while(j<iter.length)
            {
                if(hs.contains(iter[j]))
                    break;
                else
                    hs.add(iter[j]);
                j++;
            }
            if(j!=iter.length)
                while(j>0)
                    hs.remove(iter[--j]);
            if(j==0)
                continue;
            backtrack(i,curr+word,arr,hs);
            for(char ch:iter)
                hs.remove(ch);
        }
    }
    public int maxLength(List<String> arr) {
        HashSet<Character>hs=new HashSet<Character>();
        backtrack(-1,"",arr,hs);
        return ans;
    }
}