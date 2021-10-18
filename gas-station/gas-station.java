class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int tank=0; //current amount in tank
        int shortage=0; //shortage in tank
        int start=0;    //staring point
        for(int i=0;i<gas.length;i++)
        {
            tank+=gas[i]-cost[i];
            
            //if their is a shortage,ww will assume next point as start
            if(tank<0)
            {
                shortage+=tank;
                tank=0;
                start=i+1;
            }
        }
        
        //checking if final shortage can be covered with the remaining fuel in tank
        return shortage+tank>=0?start:-1;
    }
}