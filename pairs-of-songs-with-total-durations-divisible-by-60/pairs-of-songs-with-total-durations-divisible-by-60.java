class Solution {
    public int numPairsDivisibleBy60(int[] time) {
        HashMap<Integer,Integer>hmap=new HashMap<Integer,Integer>();
        int ans=0;
        for(int i=0;i<time.length;i++)
        {
            if(hmap.containsKey(60-(time[i]%60==0?60:time[i]%60)))
                ans+=hmap.get(60-(time[i]%60==0?60:time[i]%60));
            if(hmap.containsKey(time[i]%60))
                hmap.put(time[i]%60,hmap.get(time[i]%60)+1);
            else
                hmap.put(time[i]%60,1);
        }
        return ans;
    }
}