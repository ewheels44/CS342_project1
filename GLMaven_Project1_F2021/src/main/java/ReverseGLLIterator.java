import java.util.Iterator;

class ReverseGLLIterator<E> implements Iterator<E>{

  // setting private data member for cur
  //
  private GenericList<E>.Node<E> cur;

  // this might cause problems
  //
  private GenericQueue<E> myQueue;

  //
  // constructor
  //
  ReverseGLLIterator(){
    this.cur = this.myQueue.tail;
  }
  //
  // **********************
  //

  //
  // hasNext() == hasPrev()
  //
	@Override
	public boolean hasNext() {
		return cur.prev != null;
	}

  //
  // next() == prev()
  // 
	@Override
	public E next() {
    E data = cur.prev.data;
    cur = cur.prev;
		return data;
	}

}
