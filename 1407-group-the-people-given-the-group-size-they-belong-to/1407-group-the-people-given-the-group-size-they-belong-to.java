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
            int group = groupSizes[i];
            temp.get(group).add(i);
            if(temp.get(group).size()==group)
            {
                List<Integer>final_list = new ArrayList<Integer>(temp.get(group));
                ans.add(final_list);
                temp.get(group).clear();
            }
        }
        return ans;
    }
}