class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n=cost.length;
        int x=cost[0];
        int y=cost[1];
        for(int i=2;i<n;i++)
        {
            int z=cost[i]+Math.min(x,y);
            x=y;
            y=z;
        }
        return Math.min(x,y);
    }
}