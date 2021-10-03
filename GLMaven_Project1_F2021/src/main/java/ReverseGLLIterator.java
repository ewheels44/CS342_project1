import java.util.Iterator;

class ReverseGLLIterator<E> implements Iterator<E>{

  // setting private data member for cur
  //
  private GenericList<E>.Node<E> cur;

  //
  // constructor
  //
  ReverseGLLIterator(GenericList<E>.Node<E> _tail){
    this.cur = _tail;
    System.out.println("this is cur in ReverseGLLIterator: " + this.cur.data);
  }
  //
  // **********************
  //

  //
  // hasNext() == hasPrev()
  //
	@Override
	public boolean hasNext() {
		return cur != null;
	}

  //
  // next() == prev()
  // 
	@Override
	public E next() {
    E data = cur.data;
    cur = cur.prev;
		return data;
	}

}
