class Solution {
    public int countPrimes(int n) {
         int[] arr=new int[n];
        for(int i=2;i<arr.length;i++){
           for(int j=i+i;j<arr.length;j=j+i){
               arr[j]=1;
           }
        }
        int out=0;
        for(int i=2;i<arr.length;i++){
            if(arr[i]==0)
                out++;
        }
        return out;
    }
}