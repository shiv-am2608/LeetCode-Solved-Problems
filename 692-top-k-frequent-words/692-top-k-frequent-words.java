class myPair
{
    String word;
    int freq;
    myPair(String word,Integer freq)
    {
        this.word=word;
        this.freq=freq;
    }
}
class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        HashMap<String,myPair>hmap=new HashMap<String,myPair>();
        for(String x:words)
        {
            if(hmap.containsKey(x))
                hmap.get(x).freq++;
            else
                hmap.put(x,new myPair(x,1));
        }
        PriorityQueue<myPair>pq=new PriorityQueue<myPair>((t1,t2)->(t2.freq-t1.freq)==0?(t1.word).compareTo(t2.word):t2.freq-t1.freq);
        for(Map.Entry<String,myPair>entry:hmap.entrySet())
            pq.offer(entry.getValue());
        List<String>ans=new ArrayList<String>();
        for(int i=0;i<k;i++)
            ans.add(pq.poll().word);
        return ans;
    }
}