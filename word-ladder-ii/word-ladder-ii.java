class Solution {
    public boolean diff(String a,String b)
    {
        int count=0;
        for(int i=0;i<a.length();i++)
        {
            if(a.charAt(i)!=b.charAt(i))
                count++;
            if(count>1)
                return false;
        }
        return true;
    }
    public void updateSet(HashSet<String>x,HashSet<String>y)
    {
        for(String t:y)
            x.remove(t);
    }
    public int ladderLength(String beginWord, String endWord, List<String> wordList,HashMap<String,List<String>>hmap) {
        HashSet<String>hs=new HashSet<String>();
        Queue<String>q=new LinkedList<String>();
        for(String x:wordList)
            hs.add(x);
        if(!hs.contains(endWord))
            return 0;
        if(hs.contains(beginWord))
            hs.remove(beginWord);
        int count=0;
        q.offer(beginWord);
        while(!q.isEmpty())
        {
            count++;
            int size=q.size();
            HashSet<String>consider=new HashSet<String>();
            while(size-->0)
            {
                String curr=q.poll();
                hmap.put(curr,new ArrayList<String>());
                if(curr.compareTo(endWord)==0)
                    return count;
                for(String x:hs)
                    if(diff(x,curr))
                    {
                        consider.add(x);
                        q.offer(x);
                        hmap.get(curr).add(x);
                    }
            }
            updateSet(hs,consider);
        }
        return 0;
    }
    public void findWordLadder(List<List<String>>ans,List<String>res,String beginWord,String endWord,int depth,HashMap<String,List<String>>hmap)
    {
        if(depth==0)
        {
            if(beginWord.compareTo(endWord)==0)
            {
                res.add(beginWord);
                ans.add(new ArrayList<String>(res));
                res.remove(beginWord);
                //System.out.println();
            }
            return;
        }
        res.add(beginWord);
        //System.out.println(beginWord+" ->");
        for(String x:hmap.get(beginWord))
        {
            findWordLadder(ans,res,x,endWord,depth-1,hmap);
        }
        res.remove(beginWord);
    }
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        HashMap<String,List<String>>hmap=new HashMap<String,List<String>>();
        int depth=ladderLength(beginWord,endWord,wordList,hmap);
        List<List<String>>ans=new ArrayList<List<String>>();
        if(depth==0)
            return ans;
        List<String>res=new ArrayList<String>();
       //System.out.println(hmap);
        findWordLadder(ans,res,beginWord,endWord,depth-1,hmap);
        return ans;
    }
}