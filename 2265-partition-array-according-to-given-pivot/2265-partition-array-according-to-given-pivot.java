class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        Queue<Integer> less = new LinkedList<>();
        Queue<Integer> more = new LinkedList<>();
        int count = 0;
        for(int i:nums){
            if(i<pivot)
                less.add(i);
            else if(i==pivot)
                count++;
            else
                more.add(i);
        }
        int ans[]=new int[nums.length];
        int i=0;
        while(!less.isEmpty())
            ans[i++] = less.poll();
        while(count-->0)
            ans[i++] = pivot;
        while(!more.isEmpty())
            ans[i++] = more.poll();
        return ans;
    }
}