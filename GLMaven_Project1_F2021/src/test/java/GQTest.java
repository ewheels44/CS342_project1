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


@DisplayName("GQTest")
@TestMethodOrder(OrderAnnotation.class)
class GQTest {

  static int iter;

  static GenericQueue<Integer> myTestQueue;


  @BeforeAll
  static void setup(){

    iter = 0;

    myTestQueue = new GenericQueue<Integer>();        

    constructortestOne();
    constructortestTwo();
    constructortestThree();
  }

  // @BeforeEach
  // void resetIter(){
  //   iter = 0;
  // }

  //
  // constructor test case(s)
  //
  @Test
  static void constructortestOne(){
    assertNotNull(myTestQueue.tail, "This should not be Null");
  }

  @Test
  static void constructortestTwo(){
    assertEquals(0, myTestQueue.getLength(), "This should be zero as nothing was added yet");
  }

  // testing private data member: data 
  //
  @Test
  static void constructortestThree(){
    assertNull(myTestQueue.get(myTestQueue.getLength()), "This should be null"); 
  }
  //
  // **************************************
  //

  //
  // enqueue() test case(s)
  // 
  @Test
  @Order(1)
  void enqueueOne(){
    // System.out.println("enqueue");
    myTestQueue.enqueue(7); 
    assertEquals(7, myTestQueue.get(1), "Check you @Override add() funct");
  }
  //
  // **************************************
  //

  //
  // dequeue() test case(s)
  //
  @Test
  @Order(2)
  void dequeueOne(){
    // System.out.println("dequeue");
    myTestQueue.dequeue();
    assertEquals(0, myTestQueue.getLength(), "Check you delete() funct");
  }

  @Test
  @Order(3)
  void dequeueTwo(){
    // System.out.println("dequeue");
    assertNull(myTestQueue.dequeue(), "This should be null becuase the list is empty");
  }
  //
  // **************************************
  //

  //
  // enqueue() stress test case(s)
  //
  @ParameterizedTest
  @ValueSource(ints = {13, 14, 15, 16, 36, })
  @Order(4)
  void paratest(int val){
    // System.out.println(val);
    myTestQueue.add(val);

    assertEquals(myTestQueue.get(iter+1), val, "Check you @Override add() func");
    iter++;

    if(iter == 5) iter = 0;
  }
  //
  // **************************************
  //

  //
  // removeTail() test case(s)
  //
  @Test
  @Order(5)
  void removeTail(){
    myTestQueue.removeTail();

    assertEquals(4, myTestQueue.getLength(), "Off by one?");
  }

  @ParameterizedTest
  @ValueSource(ints = {13, 14, 15, 16})
  @Order(6)
  void paratestTwo(int val){
    // System.out.println(val);
    assertEquals(myTestQueue.get(iter+1), val, "Check your removeTail() func");
    iter++;
  }
  //
  // **************************************
  //


}
