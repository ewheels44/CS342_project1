class GenericQueue<T> extends GenericList<T> {

  // data members
  //
  public Node<T> tail;

  //
  // constructor
  //
  GenericQueue() {

    super();
    // TODO Auto-generated constructor stub

    this.tail = getHead();
  }
  //
  // **********************
  //

  //
  // add(T data)
  //
  // add to the back of the list
  // use length to keep track of list size
  //
  @Override
  public void add(T data) {
    
    Node<T> newN = new Node<T>(data);

    // if the list is empty
    //
    if(getLength() == 0){

      setHead(newN);
      tail = newN;

      // this should be 0
      int length = getLength();
      setLength(length +=1);
    }
    else{

      // use tail to add to end of list?
      // constant run time???
      //
      tail.next = newN;
      newN.prev = tail;
      tail = newN;
      
      // System.out.println("This was just added: " + newN.prev.data + " <- "+ newN.data + " -> " + newN.next);
      int length = getLength();
      setLength(length +=1);
    }
  }

  // enqueue
  //
  // calls add()
  //
  public void enqueue(T data) { add(data);}

  // dequeue
  //
  // calls delete()
  //
  public T dequeue() { return delete();}

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
