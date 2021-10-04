import java.util.ArrayList;
import java.lang.Iterable;
import java.util.ListIterator;
import java.util.Iterator;

abstract class GenericList<T> implements Iterable<T> {

  // private data members
  //
  private Node<T> head;
  private int length = 0;

  // inner class Node
  //
  class Node<T> {
    T data;
    Node<T> next;
    Node<T> prev;

    Node(T val) {
      this.data = val;
      this.next = null;
      this.prev = null;
    }

  }

  //
  // constructor
  //
  GenericList() {

    this.length = 0;
    this.head = new Node<T>(null);

  }
  //
  // **********************
  //

  //
  // getters
  //
  public Node<T> getHead() {

    return this.head;

  }

  public int getLength() {

    return this.length;

  }
  //
  // **********************
  //

  //
  // setters
  //
  public void setHead(Node<T> _head) {

    // System.out.println("This is head in GenericList: " + head.data);
    this.head = _head;

    // System.out.println("This is head in GenericList: " + head.data);

  }

  public void setLength(int _length) {

    this.length = _length;

  }
  //
  // **********************
  //

  //
  // implementation of abstract method from Iterable
  //
  public Iterator<T> iterator() {
    return new GLLIterator<T>(this.head);

  }
  //
  // **********************
  //

  //
  // print()
  //
  // prints the items of the list, one value per line.
  // If the list is empty, print "Empty List"
  //
  public void print() {

    if (this.length == 0)
      System.out.println("Empty Listy" + '\n');
    else {

      GLLIterator<T> myI = new GLLIterator<>(this.head);

      while (myI.hasNext()) {
        System.out.println(myI.next());
      }

    }

  }

  //
  // add(T data)
  //
  // adds the value to the list. This method is abstract since the
  // implementation depends on what the data structure is
  //
  public abstract void add(T data);

  //
  // delete()
  //
  // returns the first value of the list and deletes the node. If the list is
  // empty, return null.
  //
  public T delete() {

    // if (this.head == null)
    //   return null;
    if(this.length == 0) return null;

    // not sure if this deletes it??
    //
    T curdata = this.head.data;
    this.head = this.head.next;

    // reduce count of list
    //
    this.length -= 1;

    return curdata;
  }

  //
  // dumplist()
  //
  // this method stores and returns all values currently in
  // the list into an ArrayList and returns it. At the end of this method, your
  // list should be empty.
  //
  public ArrayList<T> dumplist() {

    ArrayList<T> myArray = new ArrayList<>();
    GLLIterator<T> myI = new GLLIterator<>(this.head);

    // while the list is not empty
    // add contents to arrylist
    // also removing nodes from list
    //
    while (myI.hasNext()) {
      myArray.add(myI.next());
      delete();
    }

    return myArray; // place holder
  }

  //
  // get(int index)
  //
  // returns the value at the specified index or null if the index is
  // out of bounds.
  //
  public T get(int index) {

    if (index > this.length || index < 0)
      return null;

    Node<T> cur = this.head;
    int indexcounter = 1;

    while (cur != null) {

      if (index == indexcounter)
        return cur.data;
      else {
        indexcounter++;
        cur = cur.next;
      }

    }

    return null; // place holder
  }

  //
  // set(int index, T element)
  //
  // replace the element at specified position in the list
  // with the specified element and return the element previously at the specified
  // position.
  // Return null if index is out of bounds
  //
  public T set(int index, T element) {

    if (index > this.length || index < 0)
      return null;

    Node<T> cur = this.head;
    int indexcounter = 1;

    while (cur != null) {

      if (index == indexcounter) {
        cur.data = element;
        return cur.data;
      } else {
        indexcounter++;
        cur = cur.next;
      }

    }

    return null; // place holder
  }

  //
  // listiterator(int index)
  //
  // returns a list-iterator of the elements of
  // this list starting at the specified position
  //
  public ListIterator<T> listiterator(int index) {

    if (index > this.length || index < 0)
      return null;

    return new GLListIterator<>(getHead(), index);

  }

  // returns an iterator over the elements of the
  // list in reverse order( tail to head)
  //
  public Iterator<T> decendingIterator() {

    // this will not scale well !!!
    // 
    Node<T> cur = this.head;
    int indexcounter = 0;

    while (cur.next != null) {
      if(indexcounter == getLength()){
        break;
      } 
      else{
        cur = cur.next;
        indexcounter++;
      }
    }
    
    return new ReverseGLLIterator<>(cur);
  }

}
