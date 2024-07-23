class Solution {
    public int[] frequencySort(int[] nums) {
        Map<Integer, Integer> tmap = new TreeMap<>();
        for(int i: nums)
            tmap.put(i, tmap.getOrDefault(i,0)+1);
        List<Map.Entry<Integer, Integer>> entryList = new ArrayList<>(tmap.entrySet());
        entryList.sort((t1,t2) -> {
            return t1.getValue() != t2.getValue() ? t1.getValue()-t2.getValue() : t2.getKey() - t1.getKey();
        });
        int i=0;
        for(Map.Entry<Integer, Integer> x: entryList){
            int freq = x.getValue();
            for(int j=i;j<i+freq;j++)
                nums[j] = x.getKey();
            i+=freq;
        }
        return nums;
    }
}