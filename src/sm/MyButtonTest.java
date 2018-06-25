package test.ms; 

import org.junit.Test; 
import org.junit.Before; 
import org.junit.After; 
import ms.MyButton;
import static org.junit.Assert.*;

/** 
* MyButton Tester. 
* 
* @author <Authors name> 
* @since <pre>ÁùÔÂ 24, 2018</pre> 
* @version 1.0 
*/ 
public class MyButtonTest {

    MyButton b=null;


@Before
public void before() throws Exception {
   b=new MyButton(1,2);
} 

@After
public void after() throws Exception { 
} 

/** 
* 
* Method: testMyButton()
* 
*/ 
@Test
public void testMyButton() throws Exception {
    assertEquals(1,b.bx);
    assertEquals(2,b.by);
    assertEquals(true,b.isClicked);
    assertEquals(false,b.isMine);
    assertEquals(false,b.isRight);

} 

} 
