package test.ms; 

import org.junit.Test; 
import org.junit.Before; 
import org.junit.After;
import static org.junit.Assert.*;
import ms.test;

/** 
* test Tester. 
* 
* @author <Authors name> 
* @since <pre>ÁùÔÂ 24, 2018</pre> 
* @version 1.0 
*/ 
public class testTest { 

@Before
public void before() throws Exception { 
} 

@After
public void after() throws Exception { 
} 

/** 
* 
* Method: add(int a, int b) 
* 
*/ 
@Test
public void testAdd() throws Exception {
    assertEquals(2,new test().add(1,1));
} 


} 
