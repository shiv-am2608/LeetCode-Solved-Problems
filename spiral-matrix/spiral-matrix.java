class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<Integer>(); 
        int top=0,bottom=matrix.length-1;
        int i=0,j=matrix[0].length-1;
        
        int dir=0;
        while (top<=bottom && i<=j)
        {
            if(dir%4==0)
            {
                for(int x = i; x <= j; x++)
                    res.add(matrix [top][x]);
             top++;
            }
            else if(dir%4==1)
            {
                for(int x = top; x <= bottom; x++)
                    res.add(matrix[x][j]);
                j--;
            }
            else if(dir%4==2)
            {
                for(int x = j; x >= i; x--)
                    res.add(matrix[bottom][x]);
                bottom--;
            }
            else if(dir%4==3)
            {
                for(int x = bottom; x >= top; x--)
                    res.add(matrix[x][i]);
                i++;
            }
            dir++;;
        }
        return res;
    }
}