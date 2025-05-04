class Solution {
    public int numEquivDominoPairs(int[][] dominoes) {
        Map<Integer,HashMap<Integer,Integer>> hmap = new HashMap<>();
        int count =0;
        for(int i[]: dominoes){
            int first = i[0], second =i[1];
            if(first>second){
                first = i[1];
                second = i[0];
            }
            if(hmap.containsKey(first)){
                if(hmap.get(first).containsKey(second)){
                    int value = hmap.get(first).get(second);
                    count += value;
                    hmap.get(first).put(second, value+1);
                } else {
                    hmap.get(first).put(second, 1);
                } 
            } else {
                    hmap.put(first, new HashMap<Integer,Integer>());
                    hmap.get(first).put(second,1);
            }
        }
        return count;
    }
}