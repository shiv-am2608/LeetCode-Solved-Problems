class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> s = new Stack<>();
        int n = pushed.length;
        int Fakepointer = 0;
        for(int i = 0; i<n; i++){
            s.push(pushed[i]);
            while(!s.empty() && s.peek() == popped[Fakepointer]){
                s.pop();
                Fakepointer++;
            }
        }
        return s.empty();
    }
}