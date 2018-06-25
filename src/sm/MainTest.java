package test.ms; 

import org.junit.Test; 
import org.junit.Before; 
import org.junit.After; 
import ms.*;
/** 
* Main Tester. 
* 
* @author <Authors name> 
* @since <pre>ÁùÔÂ 24, 2018</pre> 
* @version 1.0 
*/ 
public abstract class MainTest {



@Before
public void before() throws Exception {
    new Images();
    new Mine();
} 

@After
public void after() throws Exception { 
} 

/** 
* 
* Method: main(String[] args) 
* 
*/ 
@Test
public void testMain() throws Exception {
    new Images();
    new Mine();
} 


} 
