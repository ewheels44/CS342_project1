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

@DisplayName("GSTest")
@TestMethodOrder(OrderAnnotation.class)
class GSTest {

  static private GenericStack<Integer> myTestStack;

  @BeforeAll
  static void setop() {

    myTestStack = new GenericStack<>();
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

}
