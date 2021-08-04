class Solution {
    public void reverse(int arr[],int start)
    {
        int end=arr.length-1;
        while(start<end)
        {
            int temp=arr[start];
            arr[start]=arr[end];
            arr[end]=temp;
            start++;
            end--;
        }
    }
    public int nextGreaterElement(int n) {
        //splitting the number in an array
        int arr[]=new int[(int)Math.log10(n)+1];
        for(int i=arr.length-1;i>=0;i--)
        {
                arr[i]=n%10;
                n/=10;
        }
        
        //checking if digits of the number is in descending order
        int i=arr.length-2;
        while(i>=0 && arr[i]>=arr[i+1])
            i--;
        if(i<0)
            return -1;
        
        //find the closest greater element to ith element
        int j=arr.length-1;
        while(arr[j]<=arr[i])
            j--;
        
        //swapping the number with closest greater digit to minimize the value
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
        
        //as the array traversed was in decreasing order,we reverse it to minimize the value
        reverse(arr,i+1);
        
        //recreating the number from the array
        String str="";
        for(int x:arr)
            str+=x+"";
        try
        {
            return Integer.parseInt(str);
        }
        catch(Exception e)
        {
            return -1;
        }
    }
}