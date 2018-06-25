package test.ms; 

import org.junit.Test; 
import org.junit.Before; 
import org.junit.After;
import ms.Images;
import static org.junit.Assert.*;

/** 
* Images Tester. 
* 
* @author <Authors name> 
* @since <pre>ÁùÔÂ 24, 2018</pre> 
* @version 1.0 
*/ 
public class ImagesTest {
    Images a=null;
@Before
public void before() throws Exception {

} 

@After
public void after() throws Exception { 
} 
@Test
    public void TestImages()throws Exception{
    assertNull(a.gridIcon);
    assertNull(a.flagIcon);
    assertNull(a.bombIcon);
    assertNull(a.mineIcon);
    assertNull(a.fontOne);
    a=new Images();
    assertNotNull(a.gridIcon);
    assertNotNull(a.flagIcon);
    assertNotNull(a.bombIcon);
    assertNotNull(a.mineIcon);
    assertNotNull(a.fontOne);
}

} 
