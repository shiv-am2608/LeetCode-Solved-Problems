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
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashSet<String>hs=new HashSet<String>();
        Queue<String>q=new LinkedList<String>();
        for(String x:wordList)
            hs.add(x);
        if(!hs.contains(endWord))
            return 0;
        int count=0;
        q.offer(beginWord);
        while(!q.isEmpty())
        {
            count++;
            int size=q.size();
            while(size-->0)
            {
                HashSet<String>consider=new HashSet<String>();
                String curr=q.poll();
                if(curr.compareTo(endWord)==0)
                    return count;
                for(String x:hs)
                    if(diff(x,curr))
                    {
                        consider.add(x);
                        q.offer(x);
                    }
                updateSet(hs,consider);
            }
        }
        return 0;
    }
}