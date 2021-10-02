import java.util.ListIterator;

class GLListIterator<E> implements ListIterator<E>{

  private GenericList<E>.Node<E> cur;
  private int myindex;


  //
  // constructor
  //
  GLListIterator(GenericList<E>.Node<E> _head, int _index){
    
    this.myindex = _index;

    this.cur = _head;
    int indexcounter = 1;

    while(cur != null && indexcounter != _index){
      indexcounter++;
      this.cur = this.cur.next;
    }

    System.out.println("This should be index 2 value: " + this.cur.data);

  }
  //
  // **********************
  //

	@Override
	public boolean hasNext() { return this.cur != null; }

	@Override
	public E next() {
    E data = this.cur.data;
    this.cur = this.cur.next;

    this.myindex++;

    return data;
	}

	@Override
	public boolean hasPrevious() { return this.cur.prev != null; }

	@Override
	public E previous() {
    
    E data = this.cur.prev.data;
    this.cur = cur.prev;

    this.myindex--;

    return data;
	}

	@Override
	public int nextIndex() { return this.myindex;}

	@Override
	public int previousIndex() { return this.myindex;}

  //**************************
  // Do not need to implement
  //
	@Override
	public void remove() {
		// TODO Auto-generated method stub
    		
	}

	@Override
	public void set(E e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void add(E e) {
		// TODO Auto-generated method stub
		
	}

}
