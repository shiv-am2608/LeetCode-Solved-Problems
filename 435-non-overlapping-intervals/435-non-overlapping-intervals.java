class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals,(t1,t2)->t1[0]-t2[0]);
        int end=intervals[0][1];
        int count=1;
        for(int i=1;i<intervals.length;i++)
        {
            if(end<=intervals[i][0])
            {
                count++;
                end=intervals[i][1];
            }
            else
                end=Math.min(end,intervals[i][1]);
        }
        return intervals.length-count;
    }
}