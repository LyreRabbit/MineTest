package test.ms; 

import ms.Game;
import ms.Mine;
import ms.MyButton;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After;
import static org.junit.Assert.*;
import java.awt.event.ActionEvent;

/** 
* Game Tester. 
* 
* @author <Authors name> 
* @since <pre>ÁùÔÂ 24, 2018</pre> 
* @version 1.0 
*/ 
public class GameTest {
    MyButton a=null;


@Before
public void before() throws Exception {
   a=new MyButton(1,1);
} 

@After
public void after() throws Exception { 
} 

/** 
* 
* Method: actionPerformed(ActionEvent e) 
* 
*/ 
@Test
public void testActionPerformed() throws Exception {

} 

/** 
* 
* Method: showMine(MyButton in) 
* 
*/ 
@Test
public void testShowMine() throws Exception {
       assertTrue(a.isClicked);
} 

/** 
* 
* Method: replay() 
* 
*/ 
@Test
public void testReplay() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: mousePressed(MouseEvent e) 
* 
*/ 
@Test
public void testMousePressed() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: mouseReleased(MouseEvent e) 
* 
*/ 
@Test
public void testMouseReleased() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: mouseExited(MouseEvent e) 
* 
*/ 
@Test
public void testMouseExited() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: mouseClicked(MouseEvent	e) 
* 
*/ 
@Test
public void testMouseClicked() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: mouseEntered(MouseEvent	e) 
* 
*/ 
@Test
public void testMouseEntered() throws Exception { 
//TODO: Test goes here... 
} 


} 
