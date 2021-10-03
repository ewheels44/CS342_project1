// test file

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;

import java.util.ArrayList;
import java.util.ListIterator;
import java.util.Iterator;

@DisplayName("GSTest")
@TestMethodOrder(OrderAnnotation.class)
class GSTest {

  static private int iter;

  static private GenericStack<Integer> myTestStack;
  static private ArrayList<Integer> myTestArray;
  static private ListIterator<Integer> myTestListI;

  @BeforeAll
  static void setop() {

    iter = 0;

    myTestStack = new GenericStack<>();

    constructortestOne();
    constructortestTwo();
    constructortestThree();
  }

  //
  // constructor test case(s)
  //
  @Test
  static void constructortestOne(){
    assertNotNull(myTestStack.tail, "This should not be Null");
  }

  @Test
  static void constructortestTwo(){
    assertEquals(0, myTestStack.getLength(), "This should be zero as nothing was added yet");
  }

  // testing private data member: data 
  //
  @Test
  static void constructortestThree(){
    assertNull(myTestStack.get(myTestStack.getLength()), "This should be null"); 
  }
  //
  // **************************************
  //

  //
  // push() test case(s)
  // 
  @Test
  @Order(1)
  void enqueueOne(){
    // System.out.println("enqueue");
    myTestStack.push(7); 
    assertEquals(7, myTestStack.get(1), "Check you @Override add() funct");
  }
  //
  // **************************************
  //

  //
  // pop() test case(s)
  //
  @Test
  @Order(2)
  void dequeueOne(){
    // System.out.println("dequeue");
    myTestStack.pop();
    assertEquals(0, myTestStack.getLength(), "Check you delete() funct");
  }

  @Test
  @Order(3)
  void dequeueTwo(){
    // System.out.println("dequeue");
    assertNull(myTestStack.pop(), "This should be null becuase the list is empty");
  }
  //
  // **************************************
  //

  //
  // push() stress test case(s)
  //
  @ParameterizedTest
  @ValueSource(ints = {100, 123, 432, 5234, 56345, 5812, 234, 4323})
  @Order(4)
  void pushtest(int sourcevals){
    myTestStack.push(sourcevals);
    // System.out.println(myTestStack.getLength());
    // System.out.println(myTestStack.get(1));

    assertEquals(myTestStack.get(1), sourcevals, "Check your @Override add() func");
  }

  //
  // removeTail() test case(s)
  //
  @Test
  @Order(5)
  void removeTail(){
    myTestStack.removeTail();

    assertEquals(7, myTestStack.getLength(), "Check your removeTail() func");
  }

  @ParameterizedTest
  // @ValueSource(ints = {123, 432, 5234, 56345, 5812, 234, 4323})
  @ValueSource(ints = {4323, 234, 5812, 56345, 5234, 432, 123})
  @Order(6)
  void paratest(int sourcevals){

    assertEquals(myTestStack.get(iter+1), sourcevals, "Check your removeTail() func");
    iter++;

    if(iter == 7) iter = 0;
  }
  //
  // **************************************
  //

  //
  // set() test case(s)
  //
  @Test
  @Order(7)
  void setme(){

    myTestStack.set(4, 123123);

    assertEquals(123123, myTestStack.get(4), "Check your set() func");
      
  }
  //
  // **************************************
  //

  //
  // iterator() test case(s)
  //
  @Test
  @Order(8)
  void iteratortest(){
    Iterator<Integer> myI = myTestStack.iterator();

    assertNotNull(myI.hasNext());
    
    assertEquals(4323, myI.next(), "Check your next() in iterator()");
    assertEquals(234, myI.next(), "Check your next() in iterator()");
  }
  //
  // **************************************
  //

  //
  // listiterator()
  //
  @Test
  @Order(9)
  void listiterator(){
    myTestListI = myTestStack.listiterator(3); 
    
    assertNotNull(myTestListI.hasNext());
    assertNotNull(myTestListI.hasPrevious());

    assertEquals(5812, myTestListI.next(), "Check you next() func in listiterator()");
    assertEquals(4, myTestListI.nextIndex(), "Check your nextIndex() in listiterator()");

    assertEquals(123123, myTestListI.previous(), "Check your previous() func() in listiterator()");
    assertEquals(3, myTestListI.previousIndex(), "Check your nextIndex() in listiterator()");
  }
  //
  // **************************************
  //
  
  //
  // decendingIterator() test case(s)
  //
  @Test
  @Order(10)
  void reverse(){
    Iterator<Integer> myI = myTestStack.decendingIterator();

    assertNotNull(myI.hasNext());

    assertEquals(123, myI.next(), "Check your decendingIterator() func");
    assertEquals(432, myI.next(), "Check your decendingIterator() func");

  }
  //
  // **************************************
  //

  //
  // dumplist() test case(s)
  //
  @Test
  @Order(11)
  void dumplist() {
    int testvalues[] = {4323, 234, 5812, 56345, 5234, 432, 123};
    myTestArray = myTestStack.dumplist();

    assertEquals(myTestArray.get(iter), testvalues[iter] , "Check your dumplist() func"); 
    iter++;
  }
  //
  // **************************************
  //

}
