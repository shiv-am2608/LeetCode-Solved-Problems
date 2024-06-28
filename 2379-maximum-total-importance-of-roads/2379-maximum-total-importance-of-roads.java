class Solution {
    public long maximumImportance(int n, int[][] roads) {
        Map<Integer,Integer> hmap = new HashMap<>();
        for(int i[]:roads){
           hmap.put(i[0],hmap.getOrDefault(i[0],0)+1);
           hmap.put(i[1],hmap.getOrDefault(i[1],0)+1);
        }
        PriorityQueue<int[]>pq = new PriorityQueue<>((t1,t2) -> t2[1]-t1[1]);
        for(Map.Entry<Integer, Integer>x: hmap.entrySet()){
            pq.offer(new int[]{x.getKey(), x.getValue()});
        }
        int count = n;
        int importance[] = new int[n];
        while(pq.size()>0){
            int temp[] = pq.poll();
            importance[temp[0]] = count;
            System.out.println(importance[temp[0]]+" "+temp[0]);
            count--;
        }

        long ans = 0;
        for(int i[]: roads){
            ans+=importance[i[0]] + importance[i[1]];
        }
        return ans;
    }
}