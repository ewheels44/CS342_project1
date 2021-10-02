// Ethan wheeler
// ewheel5
// ewheel5@uic.edu
// 
// This project is going to implement a custom 
// version of a stack and queue data structure

import java.util.ArrayList;
import java.util.ListIterator;


public class GLProject {

  public static void main(String[] args) {
    // TODO Auto-generated method stub
    System.out.println("Welcome to project 1");

    System.out.println("GenericQueue testing");

    GenericQueue<Integer> myQueue = new GenericQueue<Integer>();

    int size = myQueue.getLength();
    System.out.println("this is size: " + size);
    myQueue.print();


    System.out.println("Adding '1' with add()");
    myQueue.add(1);
    size = myQueue.getLength();
    System.out.println("this is size: " + size);
    System.out.println("Queue:");
    myQueue.print();


    System.out.println("Adding '2' with enqueue()");
    myQueue.enqueue(2);
    size = myQueue.getLength();
    System.out.println("this is size: " + size);
    System.out.println("Queue:");
    myQueue.print();

    System.out.println("removeTail()");
    myQueue.removeTail();
    size = myQueue.getLength();
    System.out.println("this is size: " + size);
    System.out.println("Queue:");
    myQueue.print();

    System.out.println('\n');

    System.out.println("dumplist()");
    ArrayList<Integer> newArray = myQueue.dumplist();
    size = myQueue.getLength();
    System.out.println("this is size(and should be 0): " + size);
    System.out.println("Queue:");
    myQueue.print();
    System.out.println("Array:");
    newArray.forEach(e -> System.out.println(e));

    
    System.out.println("Adding '100' with add()");
    myQueue.add(100);
    size = myQueue.getLength();
    System.out.println("this is size: " + size);
    System.out.println("Queue:");
    myQueue.print();


    System.out.println("Adding '2432' with enqueue()");
    myQueue.enqueue(2432);
    size = myQueue.getLength();
    System.out.println("this is size: " + size);
    System.out.println("Queue:");
    myQueue.print();

    System.out.println("get index with get(2)");
    int index2 = myQueue.get(2);
    System.out.println("This is the value of the index that was requested: " + index2);

    System.out.println("get index with get(1)");
    index2 = myQueue.get(1);
    System.out.println("This is the value of the index that was requested: " + index2);

    System.out.println("set index with set(1, 445)");
    int setme = myQueue.set(1, 445);
    System.out.println("This is value of index 1 after set() " + setme);
    System.out.println("Queue:");
    myQueue.print();

    System.out.println("getting a list iterator with listiterator(2)");
    ListIterator<Integer> newlistiter = myQueue.listiterator(2);
    if(newlistiter.hasPrevious()){
      System.out.println("this should be 445: " + newlistiter.previous());
    }
    else{
      System.out.println("no prev");
    }

    int nextindex = newlistiter.nextIndex();
    System.out.println("This is next index: " + nextindex);

    int previndex = newlistiter.previousIndex();
    System.out.println("This is prev index: " + previndex);




  }
}
