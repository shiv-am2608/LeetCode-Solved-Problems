class Solution {
    public int maxSumSubmatrix(int[][] matrix, int k) {
        int res = Integer.MIN_VALUE;
        for(int leftCol = 0; leftCol < matrix[0].length; leftCol++) {
            int[] tempRowsSum = new int[matrix.length];
            for(int rightCol = leftCol; rightCol < matrix[0].length; rightCol++) {
                for(int row = 0; row < matrix.length; row++) {
                    tempRowsSum[row] += matrix[row][rightCol];
                }
                TreeSet<Integer> set = new TreeSet<>();
                set.add(0);
                int cSum = 0;
                for(int a : tempRowsSum) {
                    cSum += a;
                    //cSum is y & target is x here. cSum-k = y-k = x+k-k = x. 
                    Integer target = set.ceiling(cSum - k);
                    //cSum-target = y-x = k
                    if(target != null) res = Math.max(res, cSum - target);
                    set.add(cSum);
                }
            }
        }
        return res;
    }
}