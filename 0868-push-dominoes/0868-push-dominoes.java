class Solution {
    public String pushDominoes(String dominoes) {
        int leftForce[] = new int[dominoes.length()];
         Arrays.fill(leftForce,-1);
        Stack<Integer> st = new Stack<>();
        for(int i=0;i<dominoes.length();i++){
            char force = dominoes.charAt(i);
            if (force == 'R')
                st.clear();
            else if (force == '.')
                st.push(i);
            else{
                while(!st.isEmpty())
                    leftForce[st.pop()] = i;
            }

        }

        int rightForce[] = new int[dominoes.length()];
        Arrays.fill(rightForce,-1);
        for(int i=dominoes.length()-1;i>=0;i--){
            char force = dominoes.charAt(i);
            if (force == 'L')
                st.clear();
            else if (force == '.')
                st.push(i);
            else{
                while(!st.isEmpty())
                    rightForce[st.pop()] = i;
            }
        }
        String ans = "";
        for(int i=0;i<dominoes.length();i++){
            if (dominoes.charAt(i) == 'L' || dominoes.charAt(i) == 'R')
                ans+=dominoes.charAt(i);
            else if(leftForce[i]!=-1 && rightForce[i]==-1)
                ans+='L';
            else if (leftForce[i]==-1 && rightForce[i]!=-1)
                ans+='R';
            else if(Math.abs(i-leftForce[i])< Math.abs(i-rightForce[i]))
                ans+='L';
            else if(Math.abs(i-leftForce[i])> Math.abs(i-rightForce[i]))
                ans+='R';
            else
                ans+='.';
        }
        return ans;
    }
}