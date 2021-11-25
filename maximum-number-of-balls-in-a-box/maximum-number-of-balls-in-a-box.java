class Solution {
    public int findSumOfDigits(int n)
    {
        int sum=0;
        while(n!=0)
        {
            sum+=n%10;
            n/=10;
        }
        return sum;
    }
    public int countBalls(int lowLimit, int highLimit) {
        HashMap<Integer,Integer>hmap=new HashMap<Integer,Integer>();
        int max=0;
        for(int i=lowLimit;i<=highLimit;i++)
        {
            int sumOfDigits=findSumOfDigits(i);
            if(hmap.containsKey(sumOfDigits))
                hmap.put(sumOfDigits,hmap.get(sumOfDigits)+1);
            else
                hmap.put(sumOfDigits,1);
            max=Math.max(max,hmap.get(sumOfDigits));
        }
        return max;        
    }
}