class Solution {
    class Pair{
        int plantTime,growTime;
        Pair(int plantTime, int growTime)
        {
            this.plantTime=plantTime;
            this.growTime=growTime;
        }
    }
    public int earliestFullBloom(int[] plantTime, int[] growTime) {
        int n = plantTime.length;
        Pair arr[]=new Pair[n];
        for(int i=0;i<n;i++)
            arr[i]=new Pair(plantTime[i],growTime[i]);
        Arrays.sort(arr,(t1,t2)->t2.growTime - t1.growTime);
        int totalTime=0,currPlantTime=0;
        for(Pair p:arr)
        {
            totalTime=Math.max(totalTime,currPlantTime+p.plantTime+p.growTime);
            currPlantTime+=p.plantTime;
        }
        return totalTime;
    }
}