class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int n=cardPoints.length;
        int sum=0;
        for(int i=0;i<k;i++)
            sum+=cardPoints[i];
        int max=sum;
        for(int i=0;i<k;i++)
        {
            int left=cardPoints[k-1-i];
            int right=cardPoints[n-1-i];
            sum=sum-left+right;
            max=Math.max(max,sum);
        }
        return max;
    }
}