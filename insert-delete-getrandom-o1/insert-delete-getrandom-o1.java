class RandomizedSet {

    /** Initialize your data structure here. */
    Random data;
    List<Integer>arr;
    Map<Integer,Integer>hmap;
    public RandomizedSet() {
        arr=new ArrayList<Integer>();
        hmap=new HashMap<Integer,Integer>();
        data=new Random();
    }
    private void fastListRemove(int index) {
        int size = arr.size();
        int last = arr.get(size - 1);
        arr.set(index, last);
        hmap.put(last, index);
        arr.remove(size - 1);
    }
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if (hmap.containsKey(val)) 
            return false;
        hmap.put(val, arr.size());
        arr.add(val);
        return true;
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if(!hmap.containsKey(val))
            return false;
        fastListRemove(hmap.get(val));
        hmap.remove(val);
        return true;
    }
    
    /** Get a random element from the set. */
    public int getRandom() {
        Random rand = new Random();
        return arr.get(rand.nextInt(arr.size()));
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */