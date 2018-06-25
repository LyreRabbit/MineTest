package ms;

import javax.swing.JButton;

public class MyButton extends JButton
{
	public int bx,by;
	public boolean isClicked;
	public boolean isMine;
	public boolean isRight;//ÓÒ¼ü±ê¼Ç

	public MyButton(int x, int y)
	{
		bx=x;
		by=y;
		isClicked=true;
		isMine=false;
		isRight=false;
	}
}
