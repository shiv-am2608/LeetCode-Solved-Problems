class Solution {
    public int eliminateMaximum(int[] dist, int[] speed) {
        int n = dist.length;
        int arrival[] = new int[n];
        for(int i=0;i<n;i++){
            int time =(int)Math.ceil((double)dist[i]/speed[i]);
            if(time<n)  
                arrival[time]++;
        }

        int eliminated = 0;
        for(int i=0;i<n;i++){
            if(eliminated + arrival[i] > i)
                return i;
            eliminated+=arrival[i];
        }
        return n;
    }
}