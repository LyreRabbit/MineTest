package ms;

import java.awt.Font;
import javax.swing.ImageIcon;

/**
 * ClassName:Images<br>
 * Description:图片资源.
 * @version 1.0
 */
public class Images {
	/**gridIcon:网格图*/
	public static ImageIcon gridIcon;
	/**flagIcon:旗子图标，表示雷的标记*/
	public static ImageIcon flagIcon;
	/**bombIcon:红色叉雷图标，表示踩到的雷*/
	public static ImageIcon bombIcon;
	/**mineIcon:雷图标*/
	public static ImageIcon mineIcon;
	/**fontOne:字体*/
	public static Font fontOne;
	
	/**
	 * Images方法<br>
	 * Description:设置图片及字体.
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
