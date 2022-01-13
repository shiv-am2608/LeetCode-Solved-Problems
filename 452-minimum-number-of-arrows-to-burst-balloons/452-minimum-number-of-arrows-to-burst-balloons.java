class Solution {
    public int findMinArrowShots(int[][] points) {
        
        Arrays.sort(points,(t1,t2)->t1[0]-t2[0]);
        // for(int x[]:points)
        //     System.out.println(x[0]+" "+x[1]);
        int low=points[0][0],high=points[0][1];
        int i=1;
        int count=1;
        while(i<points.length)
        {
            if(points[i][0]<=high && points[i][0]>=low)
            {
                low=Math.max(low,points[i][0]);
                high=Math.min(high,points[i][1]);
            }
            else
            {
                count++;
                low=points[i][0];
                high=points[i][1];
            }
            i++;
        }
        return count;
    }
}