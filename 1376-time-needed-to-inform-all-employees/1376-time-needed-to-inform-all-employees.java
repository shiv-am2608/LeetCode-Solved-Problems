class Solution {
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        HashSet<Integer>hs = new HashSet<Integer>();
        int ans=0;
        for(int i=0;i<informTime.length;i++)
        {
            if(informTime[i]!=0 || hs.contains(manager[i]))
                continue;
            int man = manager[i];
            int val=0;
            hs.add(manager[i]);
            while(man!=-1)
            {
                val+=informTime[man];
                man = manager[man];
            }
            ans=Math.max(ans,val);
        }
        return ans;
    }
}