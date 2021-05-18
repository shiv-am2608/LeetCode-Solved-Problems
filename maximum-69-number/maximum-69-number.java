class Solution {
    public int maximum69Number (int num) {
        int size=(int)Math.log10(num)+1;
        int arr[]=new int[size];
        for(int i=size-1;i>=0;i--)
        {
            arr[i]=num%10;
            num=num/10;
        }
        for(int i=0;i<size;i++)
            if(arr[i]==6)
            {
                arr[i]=9;
                break;
            }
        int res=0;
        for(int i:arr)
            res=(res*10)+i;
        return res;
    }
}