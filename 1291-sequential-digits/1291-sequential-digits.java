class Solution {
    public int getNumber(int n)
    {
        int num=0;
        for(int i=1;i<=n;i++)
            num=(num*10)+i;
        return num;
    }
    public List<Integer> sequentialDigits(int low, int high) {
        List<Integer>ans=new ArrayList<Integer>();
        int noOfDigitsLow=(int)Math.log10(low)+1;
        int noOfDigitsHigh=(int)Math.log10(high)+1;
        while(noOfDigitsLow<=noOfDigitsHigh)
        {
            int initNo=getNumber(noOfDigitsLow);
            int last=noOfDigitsLow+1;
            while(last<=10)
            {
                if(low<=initNo && initNo<=high)
                    ans.add(initNo);
                initNo=(int)(((initNo)%(Math.pow(10,noOfDigitsLow-1)))*10)+last;
                last++;
                if(last==11)
                    break;
            }
            noOfDigitsLow++;
        }
        return ans;
    }
}