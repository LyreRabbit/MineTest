package ms;

import java.awt.Font;
import javax.swing.ImageIcon;

public class Images {
	public static ImageIcon gridIcon;//����ͼƬ
	public static ImageIcon flagIcon;//������ͼƬ
	public static ImageIcon bombIcon;//�ȵ�����
	public static ImageIcon mineIcon;//��
	public static Font fontOne;
	public	Images()
	{
		gridIcon = new ImageIcon("images/grid.jpg");
		flagIcon = new ImageIcon("images/flag.png");
		bombIcon = new ImageIcon("images/dead.png");
		mineIcon = new ImageIcon("images/mine.png");							
		fontOne = new Font("null",Font.BOLD,16);
	}

}
