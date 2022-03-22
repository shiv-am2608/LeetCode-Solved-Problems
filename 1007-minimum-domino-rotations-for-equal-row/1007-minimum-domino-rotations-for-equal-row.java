class Solution {
    public int minDominoRotations(int[] top, int[] bottom) {
        int n = top.length;
        int a = top[0], b = bottom[0];
        for(int i = 1 ; i < n ; i++) {
            if(a != top[i] && a != bottom[i])
                a = -1;
            if(b != top[i] && b != bottom[i])
                b = -1;
            if(a == -1 && b == -1)
                return -1;
        }
        
        a = a != -1 ? a : b;
        int tswap = 0, bswap = 0;
        for(int i = 0 ; i < n ; i++) {
            if(a != top[i])
                tswap++;
            
            if(a != bottom[i])
                bswap++;
        }
        return Math.min(tswap, bswap);
    }
}