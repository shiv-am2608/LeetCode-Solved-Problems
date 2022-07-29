class Solution {
    public int waysToMakeFair(int[] A) {
        int n=A.length;
        long pre_even[]=new long[A.length];
        long pre_odd[]=new long[A.length];
        
        pre_even[0]=A[0];
        for(int i=1;i<A.length;i++)
            if(i%2==0)
                pre_even[i]+=pre_even[i-1]+A[i];
            else
                pre_even[i]=pre_even[i-1];
        
        for(int i=1;i<A.length;i++)
            if(i%2==1)
                pre_odd[i]+=pre_odd[i-1]+A[i];
            else
                pre_odd[i]=pre_odd[i-1];
        
        int count=0;
        for(int i=0;i<A.length;i++)
        {
            long even=0,odd=0;
            if(i==0)
            {
                even=pre_odd[n-1]-pre_odd[0];
                odd=pre_even[n-1]-pre_even[0];
            }
            else
            {
                even = pre_even[i-1]+pre_odd[n-1]-pre_odd[i];
                odd = pre_odd[i-1]+pre_even[n-1]-pre_even[i];
            }
            if(even==odd)
                count++;
        }
        return count;
    }
}