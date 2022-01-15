class Solution {
    public int minJumps(int[] arr) {
        HashMap<Integer,ArrayList<Integer>>hmap=new HashMap<Integer,ArrayList<Integer>>();
        for(int i=0;i<arr.length;i++)
        {
            if(i>0 && i<arr.length-1 && arr[i]==arr[i-1] && arr[i]==arr[i+1])
                continue;
            if(hmap.containsKey(arr[i]))
                hmap.get(arr[i]).add(i);
            else
            {
                hmap.put(arr[i],new ArrayList<Integer>());
                hmap.get(arr[i]).add(i);
            }
        }
        boolean visited[]=new boolean[arr.length];
        Queue<Integer>q=new LinkedList<Integer>();
        q.offer(0);
        visited[0]=true;
        int dist=0;
        while(!q.isEmpty())
        {
            int size=q.size();
            while(size-- >0)
            {
                int curr=q.poll();
                if(curr==arr.length-1)
                    return dist;
                if(curr-1>=0 && !visited[curr-1])
                {
                    q.offer(curr-1);
                    visited[curr-1]=true;
                }
                if(curr+1<arr.length && !visited[curr+1])
                {
                    q.offer(curr+1);
                    visited[curr+1]=true;
                }
                if(hmap.containsKey(arr[curr]))
                    for(int i:hmap.get(arr[curr]))
                        if(!visited[i])
                        {
                            q.offer(i);
                            visited[i]=true;
                        }
                hmap.remove(arr[curr]);
            }
            dist++;
        }
        return -1;
    }
}