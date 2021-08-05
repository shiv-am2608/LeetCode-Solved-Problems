class Solution {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int pre_sum[]=new int[arr.length];
        pre_sum[0]=arr[0];
        for(int i=1;i<arr.length;i++)
            pre_sum[i]=pre_sum[i-1]+arr[i];
        double average=pre_sum[k-1]/k;
        int count=0;
        if(average>=threshold)
            count++;
        for(int i=k;i<arr.length;i++)
        {
            average=(pre_sum[i]-pre_sum[i-k])/k;
            if(average>=threshold)
                count++;
        }
        return count;
    }
}