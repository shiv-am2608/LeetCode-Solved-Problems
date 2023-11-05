class Solution {
    public int getWinner(int[] arr, int k) {
        if(k == 1)
            return Math.max(arr[0], arr[1]);
        if(k >= arr.length)
            return Arrays.stream(arr).max().getAsInt();
        int win_counts = 0, winner = arr[0];
        for(int i=1;i<arr.length;i++){
            if(arr[i] < winner)
                win_counts++;
            else{
                win_counts = 1;
                winner = arr[i];
            }
            if(win_counts == k)
                return winner;
        }
        return winner;
    }
}