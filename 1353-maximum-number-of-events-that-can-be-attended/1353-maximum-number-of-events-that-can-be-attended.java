class Solution {
    public int maxEvents(int[][] events) {
        int n=events.length;
        Arrays.sort(events,(t1,t2)->(t1[0]-t2[0]));
        int day=0;
        int count=0;
        int i=0;
        PriorityQueue<Integer>pq=new PriorityQueue<Integer>();
        while(i<n || !pq.isEmpty())
        {
            if(pq.isEmpty())
                day=events[i][0];
            while(i<n && events[i][0]==day)
            {
                pq.offer(events[i][1]);
                i++;
            }
            day++;
            count++;
            pq.poll();
            while(!pq.isEmpty() && pq.peek()<day)
                pq.poll();
        }
        return count;
    }
}