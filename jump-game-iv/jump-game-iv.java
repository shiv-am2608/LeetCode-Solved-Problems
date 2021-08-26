class Solution {

    public int minJumps(int[] arr) {
        boolean visited[]=new boolean[arr.length];
        HashMap<Integer,List<Integer>>hmap=new HashMap<Integer,List<Integer>>();
        for(int i=0;i<arr.length;i++)
        {
            if(i>0 && i<arr.length-1 && arr[i]==arr[i-1] && arr[i]==arr[i+1])
                continue;
            if(hmap.containsKey(arr[i]))
            {
                List<Integer>temp=hmap.get(arr[i]);
                temp.add(i);
                Collections.sort(temp, Collections.reverseOrder());
                hmap.put(arr[i],temp);
            }
            else
            {
                List<Integer>temp=new ArrayList<Integer>();
                temp.add(i);
                hmap.put(arr[i],temp);
            }
        }
        int steps=0;
        Queue<Integer>q=new LinkedList<Integer>();
        q.add(0);
        visited[0]=true;
        while(!q.isEmpty())
        {
            int size=q.size();
            while(size-- > 0)
            {
                int curr=q.poll();
                if(curr==arr.length-1)
                    return steps;
                if(curr>0 && !visited[curr-1])
                {
                    visited[curr-1]=true;
                    q.add(curr-1);
                }
                if(curr<arr.length-1 && !visited[curr+1])
                {
                    visited[curr+1]=true;
                    q.add(curr+1);
                }
                for(int i:hmap.get(arr[curr]))
                {
                    if(visited[i])
                        continue;
                    visited[i]=true;
                    q.add(i);
                }
            }
            steps++;
        }
        return -1;
    }
}