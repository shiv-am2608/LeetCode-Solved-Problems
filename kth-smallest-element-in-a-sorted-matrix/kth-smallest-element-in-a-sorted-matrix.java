class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<Integer>pq=new PriorityQueue<Integer>(Collections.reverseOrder());
        int size=0;
        for(int i=0;i<matrix.length;i++)
        {
            for(int j=0;j<matrix[0].length;j++)
            {
                if(size<k)
                {
                    pq.add(matrix[i][j]);
                    size++;
                }
                else
                {
                    if(matrix[i][j]<pq.peek())
                    {
                        pq.poll();
                        pq.add(matrix[i][j]);
                    }
                }
            }
        }
        return pq.poll();
    }
}