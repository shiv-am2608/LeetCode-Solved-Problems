class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        // int max=Integer.MIN_VALUE;
        // int index=-1;
        // for(int i=0;i<gas.length;i++)
        //     if(max<gas[i]-cost[i])
        //     {
        //         max=gas[i]-cost[i];
        //         index=i;
        //     }
        // if(max<0)
        //     return -1;
        for(int index=0;index<gas.length;index++)
        {
            if(gas[index]-cost[index]<0)
                continue;
            int j=(index+1)%gas.length;
            int fuel=gas[index]-cost[index];
            while(j!=index)
            {
                fuel+=gas[j]-cost[j];
                if(fuel<0)
                    break;
                j=(j+1)%gas.length;
            }
            if(j==index)
                return index;
        }
        return -1;
            // if(j!=index)
            //     return -1;
            // return index;
    }
}