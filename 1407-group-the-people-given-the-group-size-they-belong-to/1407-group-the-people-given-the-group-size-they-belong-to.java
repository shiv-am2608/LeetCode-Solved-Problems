class Solution {
    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        List<List<Integer>> temp = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        for(int i=0;i<=groupSizes.length;i++)
        {
            List<Integer>arr=new ArrayList<Integer>();
            temp.add(arr);
        }
        for(int i=0;i<groupSizes.length;i++)
        {
            int groupSize = groupSizes[i];
            temp.get(groupSize).add(i);
            if(temp.get(groupSize).size()==groupSize)
            {
                List<Integer>group = new ArrayList<Integer>(temp.get(groupSize));
                ans.add(group);
                temp.get(groupSize).clear();
            }
        }
        return ans;
    }
}