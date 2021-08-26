class Solution {
    public int dfs(int[] A, int i, int d, int[] dp)
    {
        if(dp[i] != 0) 
            return dp[i];
        int res = 0;
        int L = Math.max(0, i - d);
        int R = Math.min(A.length - 1, i + d);
        for(int j = i - 1; j >= L && A[i] > A[j]; j--) 
            res = Math.max(res, dfs(A, j, d, dp));
        for(int j = i + 1; j <= R && A[i] > A[j]; j++) 
            res = Math.max(res, dfs(A, j, d, dp));
        return dp[i] = 1 + res;
    }
    public int maxJumps(int[] arr, int d) {
        int res = 0;
        int[] dp = new int[arr.length];
        for(int i = 0; i < arr.length; i++) 
            res = Math.max(res, dfs(arr, i, d, dp));
        return res;
            
    }
}