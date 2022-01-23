class Solution {
    public boolean check(String permutation,int n,int arr[][])
    {
        while(permutation.length()<n)
            permutation='0'+permutation;
        for(int i=0;i<n;i++)
        {
            if(permutation.charAt(i)=='0')
                continue;
            for(int j=0;j<n;j++)
            {
                if(arr[i][j]==2)
                    continue;
                if((arr[i][j]==0 && permutation.charAt(j)=='1') || 
                   (arr[i][j]==1 && permutation.charAt(j)=='0'))
                        return false;
            }
        }
        return true;
    }
    public int maximumGood(int[][] arr) {
        int n=arr.length;
        int ans=0;
        for(int i=0;i<Math.pow(2,n);i++)
        {
            String permutation=Integer.toBinaryString(i);
            if(check(permutation,n,arr))
            {
                int bitCount=Integer.bitCount(Integer.parseInt(permutation, 2));
                ans=Math.max(ans,bitCount);
            }
        }
        return ans;
    }
}