class Solution {
    public boolean canFormArray(int[] arr, int[][] pieces) {
        HashMap<Integer, Integer> hm = new HashMap<>();

        for(int i=0; i<arr.length; i++)
            hm.put(arr[i], i);
        
        for(int[] i: pieces)
        {
            if(!hm.containsKey(i[0]))
                return false;    
            for(int j=1; j<i.length; j++)
            {
                if(!hm.containsKey(i[j]))
                    return false;
                if(hm.get(i[j]) - hm.get(i[j-1]) != 1)
                    return false;
            }
        }
        return true;
    }
}