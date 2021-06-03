class Solution {
    public int maxTurbulenceSize(int[] arr) {
        int k=1;
        int res=-1;
        for(int i=1;i<arr.length-1;i++)
        {
            if((arr[i]>arr[i-1] && arr[i]>arr[i+1])||(arr[i]<arr[i-1] && arr[i]<arr[i+1]))
            {
                k++;
                res=Math.max(res,k+1);
            }
            else
                k=1;
        }
        if(res<3)
        {
            if(arr.length<=1)
                return arr.length;
            else
            {
              for(int i=1;i<arr.length;i++)  
                  if(arr[i]!=arr[i-1])
                    return 2;
                return 1;
            }
        }
        return res;
    }
}