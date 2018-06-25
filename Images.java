package ms;

import java.awt.Font;
import javax.swing.ImageIcon;

public class Images {
	public static ImageIcon gridIcon;//Íø¸ñÍ¼Æ¬
	public static ImageIcon flagIcon;//²åÆì×ÓÍ¼Æ¬
	public static ImageIcon bombIcon;//²Èµ½µÄÀ×
	public static ImageIcon mineIcon;//À×
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
