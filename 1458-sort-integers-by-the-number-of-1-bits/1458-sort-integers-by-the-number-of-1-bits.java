class Solution {
    public int count1Bits(int n){
        int count=0;
        while(n>0)
        {
            count++;
            n = n&(n-1);
        }
        return count;
    }
    public int compare(int t1, int t2){
        int count1 = count1Bits(t1);
        int count2 = count1Bits(t2);
        return count1 - count2;
    }
    public int[] sortByBits(int[] arr) {
        Integer[] nums = Arrays.stream(arr).boxed().toArray(Integer[]::new);
        Arrays.sort(nums,(t1,t2)->{
            int val = compare(t1,t2);
            return val==0?t1-t2:val;
        });
        return Arrays.stream(nums).mapToInt(Integer::intValue).toArray();
    }
}