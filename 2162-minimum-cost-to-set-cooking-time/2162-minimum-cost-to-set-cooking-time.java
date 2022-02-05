class Solution {
    public int minCostSetTime(int startAt, int moveCost, int pushCost, int targetSeconds)     {
        int maxMin=targetSeconds/60;
        int ans=Integer.MAX_VALUE;
        for(int i=0;i<=maxMin;i++)
        {
            int secs=targetSeconds-(60*i);
            if(i>99 || secs>99)
                continue;
            ans=Math.min(ans,getCost(startAt,moveCost,pushCost,i,secs));
        }
        return ans;
    }
    public int getCost(int startAt,int moveCost,int pushCost,int min,int sec)
    {
        String s=Integer.toString(min*100 + sec);
        char curr=(char)(startAt+'0');
        int cost=0;
        for(int i=0;i<s.length();i++)
        {
            if(curr==s.charAt(i))
                cost+=pushCost;
            else
            {
                cost+=pushCost+moveCost;
                curr=s.charAt(i);
            }
        }
        return cost;
    }
}