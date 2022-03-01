class Solution {
    public int freq(int n)
    {
        int count=0;
        while(n!=0)
        {
            count++;
            n = n&(n-1);
        }
        return count;
    }
    public int[] countBits(int n) {
        int arr[] = new int[n+1];
        for(int i=0;i<=n;i++)
        {
           arr[i] = freq(i); 
        }
        return arr;
    }
}
