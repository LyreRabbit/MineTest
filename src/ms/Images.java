package ms;

import java.awt.Font;
import javax.swing.ImageIcon;

/**
 * ClassName:Images<br>
 * Description:ͼƬ��Դ.
 * @version 1.0
 */
public class Images {
	/**gridIcon:����ͼ*/
	public static ImageIcon gridIcon;
	/**flagIcon:����ͼ�꣬��ʾ�׵ı��*/
	public static ImageIcon flagIcon;
	/**bombIcon:��ɫ����ͼ�꣬��ʾ�ȵ�����*/
	public static ImageIcon bombIcon;
	/**mineIcon:��ͼ��*/
	public static ImageIcon mineIcon;
	/**fontOne:����*/
	public static Font fontOne;
	
	/**
	 * Images����<br>
	 * Description:����ͼƬ������.
	 */
	public	Images()
	{
		gridIcon = new ImageIcon("images/grid.jpg");
		flagIcon = new ImageIcon("images/flag.png");
		bombIcon = new ImageIcon("images/dead.png");
		mineIcon = new ImageIcon("images/mine.png");							
		fontOne = new Font("null",Font.BOLD,16);
	}

}
