class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer>pq=new PriorityQueue<Integer>(Collections.reverseOrder());
        for(int i:stones)
            pq.offer(i);
        while(pq.size()>1){
            int x=pq.poll();
            int y=pq.poll();
            if(x!=y)
                pq.offer(Math.abs(x-y));
        }
        return pq.isEmpty()?0:pq.poll();
    }
}