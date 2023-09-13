class Solution {
    public int candy(int[] ratings) {
        int candies[]=new int[ratings.length];
        for(int i=0;i<ratings.length;i++)
            candies[i]=1;
        for(int i=1;i<ratings.length;i++)
            candies[i]=ratings[i]>ratings[i-1]?candies[i-1]+1:candies[i];
        for(int i=ratings.length-2;i>=0;i--)
            candies[i]=Math.max(candies[i],ratings[i]>ratings[i+1]?candies[i+1]+1:candies[i]);
        int ans=0;
        for(int i=0;i<ratings.length;i++)
            ans+=candies[i];
        return ans;
    }
}