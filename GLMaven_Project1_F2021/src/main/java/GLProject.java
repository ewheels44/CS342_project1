// Ethan wheeler
// ewheel5
// ewheel5@uic.edu
// 
// This project is going to implement a custom 
// version of a stack and queue data structure

import java.util.ArrayList;
import java.util.ListIterator;
import java.util.Iterator;


public class GLProject {

  public static void main(String[] args) {
    // TODO Auto-generated method stub
    System.out.println("Welcome to project 1");

    System.out.println("GenericList testing");

    // GenericQueue<Integer> list = new GenericQueue<Integer>();
    GenericStack<Integer> list = new GenericStack<>();

    int size = list.getLength();
    System.out.println("this is size: " + size);
    list.print();


    System.out.println("Adding '1' with add()");
    list.add(1);
    size = list.getLength();
    System.out.println("this is size: " + size);
    System.out.println("List:");
    list.print();


    System.out.println("Adding '2' with add()");
    list.add(2);
    size = list.getLength();
    System.out.println("this is size: " + size);
    System.out.println("List:");
    list.print();

    System.out.println("foreach test, List: ");
    list.forEach(e -> System.out.println(e));

    System.out.println("removeTail()");
    list.removeTail();
    size = list.getLength();
    System.out.println("this is size: " + size);
    System.out.println("List:");
    list.print();

    System.out.println('\n');

    System.out.println("dumplist()");
    ArrayList<Integer> newArray = list.dumplist();
    size = list.getLength();
    System.out.println("this is size(and should be 0): " + size);
    System.out.println("List:");
    list.print();
    System.out.println("Array:");
    newArray.forEach(e -> System.out.println(e));

    
    System.out.println("Adding '100' with add()");
    list.add(100);
    size = list.getLength();
    System.out.println("this is size: " + size);
    System.out.println("List:");
    list.print();


    System.out.println("Adding '2432' with add()");
    list.add(2432);
    size = list.getLength();
    System.out.println("this is size: " + size);
    System.out.println("List:");
    list.print();

    System.out.println("get index with get(2)");
    int index2 = list.get(2);
    System.out.println("This is the value of the index that was requested: " + index2);

    System.out.println("get index with get(1)");
    index2 = list.get(1);
    System.out.println("This is the value of the index that was requested: " + index2);

    System.out.println("set index with set(1, 445)");
    int setme = list.set(1, 445);
    System.out.println("This is value of index 1 after set() " + setme);
    System.out.println("List:");
    list.print();

    System.out.println("getting a list iterator with listiterator(2)");
    ListIterator<Integer> newlistiter = list.listiterator(2);
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

    System.out.println("getting reverse iterator with ReverseGLLIterator");
    Iterator<Integer> reverse = list.decendingIterator();
    while(reverse.hasNext()){
      System.out.println(reverse.next());
    }


  }
}
