package ms;

import javax.swing.JButton;

/**
 * ClassName:MyButton<br>
 * Description:��ť��.
 * @version 1.0
 *
 */
public class MyButton extends JButton
{
	/**bx,by:��ť�ĺ�������*/
	public int bx,by;
	/**isClicked:�жϸ����Ƿ񱻵㿪*/
	public boolean isClicked;
	/**isMine:�ж��Ƿ�����*/
	public boolean isMine;
	/**isRight:�ж��Ƿ񵥻��Ҽ��������*/
	public boolean isRight;

	/**
	 * MyButton����<br>
	 * @param x ������
	 * @param y ������
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
