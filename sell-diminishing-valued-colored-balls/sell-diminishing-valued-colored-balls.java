class Solution {
    public int maxProfit(int[] inventory, int orders) {
        PriorityQueue<Long>pq=new PriorityQueue<Long>(Collections.reverseOrder());
        HashMap<Long,Long>hmap=new HashMap<Long,Long>();
        pq.offer(0L);
        hmap.put(0L,0L);
        for(long i:inventory)
        {
            if(hmap.containsKey(i))
                hmap.put(i,hmap.get(i)+1);
            else
            {
                hmap.put(i,1L);
                pq.offer(i);
            }
        }
        long res=0;
        long mod=1000000007;
        while(orders>0)
        {
            long current=pq.poll();
            long smaller=pq.peek();
            long currQuantity=hmap.get(current);
            long diff=Math.min(current-smaller,orders/currQuantity);
            if(diff==0)
            {
                res=(res+orders*current)%mod;
                break;
            }
            //long sum=((current+smaller+1)*diff/2)*currQuantity;
            long sum=((current*2+1-diff)*diff/2)*currQuantity;
            res=(res+sum)%mod;
            orders-=diff*currQuantity;
            if(hmap.containsKey(current-diff))
                hmap.put(current-diff,hmap.get(current-diff)+currQuantity);
            else
            {
                hmap.put(current-diff,currQuantity);
                pq.offer(current-diff);
            }
            hmap.remove(current);
        }
        return (int)res;
    }
}