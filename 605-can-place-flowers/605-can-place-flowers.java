class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        for(int i=0;i<flowerbed.length;i++)
        {
            if(flowerbed[i]==1)
                continue;
            boolean canPlace=true;
            if(i>0 && flowerbed[i-1]==1)
                canPlace=false;
            if(i<flowerbed.length-1 && flowerbed[i+1]==1)
                canPlace=false;
            if(canPlace)
            {
                flowerbed[i]=1;
                n--;
            }
        }
        return n<=0;
    }
}