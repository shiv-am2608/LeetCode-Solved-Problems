class Solution {
    public boolean checkStraightLine(int[][] coordinates) {
        if(coordinates.length == 2)
            return true;  
        int num = coordinates[1][1]-coordinates[0][1];
        int den = coordinates[1][0]-coordinates[0][0];
        boolean isVertical = den == 0 ? true : false;
        if(isVertical)
        {
            for(int i=2;i<coordinates.length;i++)
                if(coordinates[i][0]!=coordinates[i-1][0])
                    return false;
            return true;
        }
        float slope = (float)num/den;
        for(int i=2;i<coordinates.length;i++)
        {
            num = coordinates[i][1]-coordinates[i-1][1];
            den = coordinates[i][0]-coordinates[i-1][0];
            if(den == 0)
                return false;
            float sl = (float)num/den;
            if(slope!=sl)
                return false;
        }
        return true;
    }
}