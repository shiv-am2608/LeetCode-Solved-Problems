class Solution {
    public int removeCoveredIntervals(int[][] intervals) {
        Arrays.sort(intervals,(t1,t2)->(t1[0]-t2[0]==0)?(t2[1]-t1[1]):(t1[0]-t2[0]));
        int count=1;
        int start=intervals[0][0];
        int end=intervals[0][1];
        for(int i=1;i<intervals.length;i++)
        {
            if(intervals[i][0]>=start && intervals[i][1]<=end)
                continue;;
            start=intervals[i][0];
            end=intervals[i][1];
            count++;
        }
        return count;
    }
}