class GenericStack<T> extends GenericList<T> {

  // data members
  //
  public Node<T> tail;

  //
  // constructor
  //
  GenericStack() {

    super();

    this.tail = getHead();
  }
  //
  // **********************
  //

  //
  // add(T data)
  //
  // adds to top of stack
  //
  @Override
  public void add(T data) {

    Node<T> newN = new Node<T>(data);
    newN.next = getHead();

    int length = getLength();
    setLength(length += 1);
  }

  //
  // push(T data)
  //
  // calls add(T data)
  //
  public void push(T data) { add(data);}

  //
  // pop()
  //
  // calls delete()
  //
  public T pop() {return delete();}

  //
  // removeTail
  //
  // retrieves and removes the tail of the list using the tail data
  // member
  //
  public T removeTail() {

    T returnme = this.tail.data;
    this.tail = this.tail.prev;
    this.tail.next = null;

    setLength(getLength() - 1);

    return returnme;

  }
}
