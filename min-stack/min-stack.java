class MinStack {

    /** initialize your data structure here. */
    List<Integer>minValue;
    List<Integer>stack;
    public MinStack() {
        minValue=new ArrayList<Integer>();
        stack=new ArrayList<Integer>();
    }
    
    public void push(int val) {
        if(stack.size()==0)
        {
            stack.add(val);
            minValue.add(val);
        }
        else
        {
            stack.add(val);
            minValue.add(Math.min(val,getMin()));
        }
    }
    
    public void pop() {
        stack.remove(stack.size()-1);
        minValue.remove(minValue.size()-1);
    }
    
    public int top() {
        return stack.get(stack.size()-1);
    }
    
    public int getMin() {
        return minValue.get(minValue.size()-1);
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */