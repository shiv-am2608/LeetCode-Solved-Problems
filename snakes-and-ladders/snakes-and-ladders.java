class Solution {
    public int snakesAndLadders(int[][] board) {
        int n=board.length;
        int arr[]=new int[n*n+1];
        boolean alt=true;
        int k=1;
        for(int i=board.length-1;i>=0;i--)
        {
            if(alt)
            {
                alt=!alt;
                for(int j:board[i])
                    arr[k++]=j;
            }
            else
            {
                alt=!alt;
                for(int j=board[i].length-1;j>=0;j--)
                    arr[k++]=board[i][j];
            }
        }
        // for(int i=1;i<=n*n;i++)
        //     System.out.println(i+" -> "+arr[i]);
        // //return 0;
        Queue<Integer>q=new LinkedList<Integer>();
        int count=1;
        q.add(1);
        boolean steps[]=new boolean[n*n+1];
        steps[1]=true;
        while(!q.isEmpty())
        {
            int size=q.size();
            while(size-->0)
            {
                int curr=q.poll();
                for(int i=1;i<=6;i++)
                {
                    if(curr+i>=n*n+1)
                        break;
                    if(arr[curr+i]!=-1)
                    {
                        if(arr[curr+i]==n*n)
                            return count;
                        if(!steps[arr[curr+i]])
                        {
                            steps[arr[curr+i]]=true;
                            q.offer(arr[curr+i]);
                        }
                    }
                    else
                    {
                        if(curr+i==n*n)
                            return count;
                        if(!steps[curr+i])
                        {
                            steps[curr+i]=true;
                            q.offer(curr+i);
                        }
                    }                    
                }
            }
            count++;
        }
        return -1;
    }
}