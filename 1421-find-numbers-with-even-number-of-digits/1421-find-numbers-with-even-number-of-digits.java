class Solution {
    public boolean isEvenDigits(int num){
        int count =0;
        while(num>0){
            num/=10;
            count++;
        }
        return count%2==0;
    }
    public int findNumbers(int[] nums) {
        int count = 0;
        for(int i: nums){
            if (isEvenDigits(i))
                count++;
        }
        return count;
    }
}