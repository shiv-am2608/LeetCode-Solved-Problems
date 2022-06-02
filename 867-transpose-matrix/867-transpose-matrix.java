class Solution {
    public int[][] transpose(int[][] matrix) {
         int[][] array = new int[matrix[0].length][matrix.length];
        for(int i=0;i<array.length;i++){
            for(int j=0;j<array[i].length;j++){
                array[i][j]=matrix[j][i];
            }
        }
        return array;
    }
}