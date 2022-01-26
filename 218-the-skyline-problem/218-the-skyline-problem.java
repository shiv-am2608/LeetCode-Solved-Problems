class Solution {
    public int comparator(int x[],int y[])
    {
        if(x[0]!=y[0])
            return x[0]-y[0];
        return x[1]-y[1];
    }
    public List<List<Integer>> getSkyline(int[][] matrix)
    {
        List<int[]>data=new ArrayList<int[]>();
        for(int i[]:matrix)
        {
            data.add(new int[]{i[0],-i[2]});
            data.add(new int[]{i[1],i[2]});
        }
        Collections.sort(data,(t1,t2)->comparator(t1,t2));
        int curr=0;
        List<List<Integer>>ans=new ArrayList<List<Integer>>();
        PriorityQueue<Integer>pq=new PriorityQueue<Integer>(Collections.reverseOrder());
        pq.offer(0);
        for(int i=0;i<data.size();i++)
        {
            int x=data.get(i)[0];
            int h=data.get(i)[1];
            if(h<0)
                pq.offer(-h);
            else
                pq.remove(h);
            if(curr!=pq.peek())
            {
                
                List<Integer>temp=new ArrayList<Integer>();
                temp.add(x);
                temp.add(pq.peek());
                ans.add(temp);
                curr=pq.peek();
            }
        }
        return ans;
    }
}