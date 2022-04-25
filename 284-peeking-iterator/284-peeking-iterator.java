// Java Iterator interface reference:
// https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html

class PeekingIterator implements Iterator<Integer> {
    Iterator<Integer>it;
    Integer peek;
    boolean end;
	public PeekingIterator(Iterator<Integer> iterator) {
	    // initialize any member here.
        this.it=iterator;
        peek=it.next();
	    
	}
	
    // Returns the next element in the iteration without advancing the iterator.
	public Integer peek() {
        return peek;
	}
	
	// hasNext() and next() should behave the same as in the Iterator interface.
	// Override them if needed.
	@Override
	public Integer next() {
	    Integer temp = peek;
        if (it.hasNext())
            peek = it.next();
        else 
            end = true;
        return temp;
	}
	
	@Override
	public boolean hasNext() {
	    return !end;
	}
}