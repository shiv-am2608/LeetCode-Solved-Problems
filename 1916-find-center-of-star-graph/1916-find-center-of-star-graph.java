class Solution {
    public int findCenter(int[][] edges) {
        Map<Integer, List<Integer>> hmap = new HashMap<>();
        int count = 0;
        for(int i[]:edges){
            count = Math.max(count, Math.max(i[0], i[1]));
            hmap.putIfAbsent(i[0], new ArrayList<Integer>());
            hmap.putIfAbsent(i[1], new ArrayList<Integer>());
            hmap.get(i[0]).add(i[1]);
            hmap.get(i[1]).add(i[0]);
        }

        for(Map.Entry<Integer, List<Integer>> x : hmap.entrySet()){
            if(x.getValue().size() == count-1)
                return x.getKey();
        }
        return -1;
    }
}