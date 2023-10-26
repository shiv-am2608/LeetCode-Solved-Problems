class Solution {
    public int numFactoredBinaryTrees(int[] arr) {
        int ans = 0;
        int mod = (int)1e9+7;
        Arrays.sort(arr);
        HashMap<Integer,Long>hmap=new HashMap<>();
        for(int i:arr){
            long ways = 1;
            int max_factor = (int)Math.sqrt(i);
            for(int j=0,left = arr[0];left<=max_factor;left=arr[++j]){
                if(i%left!=0)
                    continue;
                int right = i/left;
                if(hmap.containsKey(right))
                    ways =   (ways+hmap.get(left)*hmap.get(right)*(left==right?1:2))%mod;
            }
            hmap.put(i,ways);
            ans=(int)(ans+ways)%mod;
        }
        return ans;
    }
}