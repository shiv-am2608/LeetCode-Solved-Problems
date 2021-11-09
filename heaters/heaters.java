class Solution {
    public int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(houses);
        Arrays.sort(heaters);
        int currHeater=0;
        int max=0;
        for(int i=0;i<houses.length;i++)
        {
            int min=Math.abs(houses[i]-heaters[currHeater]);
            while(currHeater+1<heaters.length && heaters[currHeater+1]<houses[i])
                currHeater++;
            min=Math.min(min,Math.abs(houses[i]-heaters[currHeater]));
            if(currHeater+1<heaters.length)
                min=Math.min(min,Math.abs(heaters[currHeater+1]-houses[i]));
            max=Math.max(max,min);
        }
        return max;
    }
}