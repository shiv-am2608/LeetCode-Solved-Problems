class Pair{
    int freq,idx;
    Pair(int freq,int idx){
        this.freq=freq;
        this.idx=idx;
    }
}
class Solution {
    public int[] kWeakestRows(int[][] mat, int k) {
        PriorityQueue<Pair>pq=new PriorityQueue<Pair>((t1,t2)->(t1.freq!=t2.freq?t1.freq-t2.freq:t1.idx-t2.idx));
        for(int i=0;i<mat.length;i++)
        {
            int count=0;
            for(int j=0;j<mat[0].length;j++)
                if(mat[i][j]==1)
                    count++;
            pq.offer(new Pair(count,i));
        }
        int ans[]=new int[k];
        for(int i=0;i<k;i++)
            ans[i]=pq.poll().idx;
        return ans;
        
    }
}