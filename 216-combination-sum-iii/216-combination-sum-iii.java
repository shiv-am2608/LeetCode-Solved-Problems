class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> dS = new ArrayList<>();
        helper(n, k, ans, dS, 0, 1, 0);
        
        return ans;
    }
    
    public void helper(int n, int k, List<List<Integer>> ans, List<Integer> dS, int sum, int index, int count){
        if(sum == n && count == k){
            ans.add(new ArrayList<>(dS));
            return;
        }
        
        if(sum > n || index > 9 || count == k)
            return;
        
        for(int i = index; i <= 9; ++i){
            sum += i;
            if(sum > n)
                return;
            dS.add(i);
            helper(n, k, ans, dS, sum, i + 1, count + 1);
            dS.remove(dS.size() - 1);
            sum -= i;
        }
    }
}