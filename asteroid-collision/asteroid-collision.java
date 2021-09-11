class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer>st=new Stack<Integer>();
        int i=0;
        while(i<asteroids.length && asteroids[i]<0)
        {
            st.push(asteroids[i]);
            i++;
        }
        if(i!=asteroids.length)
            st.push(asteroids[i]);
        for(int j=i+1;j<asteroids.length;j++)
        {
            if(asteroids[j]>0)
                st.push(asteroids[j]);
            else
            {
                if(st.isEmpty() || st.peek()<0)
                    st.push(asteroids[j]);
                else
                {
                    while(!st.isEmpty() && st.peek()>0 && st.peek()<-1*asteroids[j])
                        st.pop();
                    if(!st.isEmpty() && st.peek()>0 && st.peek()==-1*asteroids[j])
                    {
                        st.pop();
                        continue;
                    }
                    if(!st.isEmpty() && st.peek()>-1*asteroids[j])
                        continue;
                    else
                        st.push(asteroids[j]);                            
                }
            }
        }
        int res[]=new int[st.size()];
        for(int k=res.length-1;k>=0;k--)
        {
            res[k]=st.pop();
        }
        return res;
    }
}