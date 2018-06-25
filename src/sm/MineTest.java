package test.ms; 

import org.junit.Test; 
import org.junit.Before; 
import org.junit.After;
import ms.Mine;
import static org.junit.Assert.*;


/** 
* Mine Tester. 
* 
* @author <Authors name> 
* @since <pre>ÁùÔÂ 24, 2018</pre> 
* @version 1.0 
*/ 
public class MineTest {
    Mine a = null;

    @Before
    public void before() throws Exception {
        a = new Mine();
    }

    @After
    public void after() throws Exception {
    }

    /**
     * Method: addMine(int a, int b)
     */
    @Test
    public void testAddMine() throws Exception {
        Mine.addMine(9, 9);
        assertEquals("success", Mine.addMine(9, 9));

    }

    /**
     * Method: InitMine()
     */
    @Test
    public void testInitMine() throws Exception {
        a.InitMine();
        assertEquals("success", a.InitMine());
    }

}
