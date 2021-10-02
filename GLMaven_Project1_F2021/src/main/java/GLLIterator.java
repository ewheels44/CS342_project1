import java.util.Iterator;

class GLLIterator<E> implements Iterator<E>{

  // setting private data member for cur
  //
  private GenericList<E>.Node<E> cur;

  //
  // constructor
  //
  GLLIterator(GenericList<E>.Node<E> _head){
    this.cur = _head;
  }
  //
  // **********************
  //

	@Override
	public boolean hasNext() {

//   System.out.println("This is cur data in GLLIterator: " + cur.data);
//   System.out.println("This is cur next in GLLIterator: " + cur.next);
// 
// 		return cur.next != null;
		return cur != null;
	}

	@Override
	public E next() {

    // if next exsits, its returned
    // 
//     if(hasNext()){
//       cur = cur.next;
//     }
// 
//     // returing that last value
//     return cur.data;

    E data = cur.data;
    cur = cur.next;

    return data;
	}

}
