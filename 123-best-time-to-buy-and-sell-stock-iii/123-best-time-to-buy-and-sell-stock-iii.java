class Solution {
    public int maxProfit(int[] prices) {
        int n=prices.length;
        int past[]=new int[n];
        int min=prices[0];
        for(int i=1;i<n;i++){
            min=Math.min(min,prices[i]);
            past[i]=Math.max(past[i-1],prices[i]-min);
        }
        
        int future[]=new int[n];
        int max=prices[n-1];
        for(int i=n-2;i>=0;i--){
            max=Math.max(max,prices[i]);
            future[i]=Math.max(future[i+1],max-prices[i]);
        }
        
        int ans=0;
        for(int i=0;i<n;i++)
            ans=Math.max(past[i]+future[i],ans);
        return ans;
    }
}