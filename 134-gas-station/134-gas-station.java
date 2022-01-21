class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int start=0;
        int tank=0;
        int extra=0;
        for(int i=0;i<gas.length;i++)
        {
            tank+=gas[i]-cost[i];
            if(tank<0)
            {
                start=i+1;
                extra+=tank;
                tank=0;
            }
        }
        return tank+extra>=0?start:-1;
    }
}