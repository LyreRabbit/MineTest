package ms;

import javax.swing.JButton;

/**
 * ClassName:MyButton<br>
 * Description:按钮类.
 * @version 1.0
 *
 */
public class MyButton extends JButton
{
	/**bx,by:按钮的横纵坐标*/
	public int bx,by;
	/**isClicked:判断格子是否被点开*/
	public boolean isClicked;
	/**isMine:判断是否有雷*/
	public boolean isMine;
	/**isRight:判断是否单击右键标记了雷*/
	public boolean isRight;

	/**
	 * MyButton方法<br>
	 * @param x 横坐标
	 * @param y 纵坐标
	 */
	public MyButton(int x, int y)
	{
		bx=x;
		by=y;
		isClicked=true;
		isMine=false;
		isRight=false;
	}
}
