class Solution {
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        PriorityQueue<Integer>pq=new PriorityQueue<Integer>(Collections.reverseOrder());
        for(int i=0;i<heights.length-1;i++)
        {
            if(heights[i]>=heights[i+1])
                continue;
            int diff=heights[i+1]-heights[i];
            pq.offer(diff);
            bricks-=diff;
            if(bricks<0)
            {
                bricks+=pq.poll();
                if(ladders==0)
                    return i;
                ladders--;
            }
        }
        return heights.length-1;
    }
}