package ms;

//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.awt.event.InputEvent;
//import java.awt.event.MouseEvent;
//import java.awt.event.MouseListener;
//
//import javax.swing.ImageIcon;
//import javax.swing.JOptionPane;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


/**
 *ClassName:Game<br>
 *Description:游戏执行的主要操作.
 *@version 1.0
 */
public class Game implements ActionListener,MouseListener
{
	Mine mine;
	/**
	 * Game方法
	 * @param in Mine对象
	 */
	public Game(Mine in)
	{
		mine=in;
	}
	
	/**
	 * actionPerformed方法<br>
	 * Description:获取事件.<br>
	 * <p>如果点到了雷，将所有的雷图标设为 雷，停止计时器，显示出所有雷，提示游戏失败,选择是否开始新游戏
	 * <br>如果没有点到雷，执行showMine方法
	 * @param e ActionEvent对象
	 */
	public void actionPerformed(ActionEvent e)
	{
		MyButton receive=(MyButton)e.getSource();
		if(receive.isMine)//挖到雷了,将踩到的设为“X"，并显示出所有雷
		{
			receive.setIcon(Images.bombIcon);
	        for(int	i=1;i<Mine.row+1;i++)
	        {
		        for(int	j=1;j<Mine.column+1;j++)
		        {
	                if(Mine.mine[i][j].isMine)
	                	Mine.mine[i][j].setIcon(Images.mineIcon);
		        }
			}
			Mine.timeListen.stop();
			JOptionPane.showMessageDialog(null,"失败了！","游戏结束",
            JOptionPane.INFORMATION_MESSAGE,Images.bombIcon);
			int	yourChose = JOptionPane.showConfirmDialog(null,"是否开始新游戏？"	);
			if(yourChose ==	JOptionPane.OK_OPTION)
			{
				replay();
			}
			else
			{
				System.exit(0);
			}
		}
		else if(receive.isClicked==false)
		{//没挖到雷
			showMine(receive);
		}
	}
	
	/**
	 * showMine方法<br>
	 * Description:游戏核心算法部分<br>
	 * <p>点到某网格，检查周围八个网格雷的情况，重置雷的数字，将点开的网格数+1
	 * <br>如果没有点开的格子中没有雷，则提示游戏胜利，选择是否开始新游戏
	 * <br>如果周围没有雷则扩展翻开格子
	 * @param in MyButton对象
	 */
	public void showMine(MyButton in)
	{
		/**numberOfMine:记录雷的个数*/
		int	numberOfMine = 0;
		in.isClicked = true;
		/********************************************************
                                                                     检查周围八个是否有雷，重放数字
        ********************************************************/
		if(Mine.mine[in.bx-1][in.by-1].isMine==true) 
			numberOfMine++;//左上
		if(Mine.mine[in.bx][in.by-1].isMine==true) 
			numberOfMine++;	//上
		if(Mine.mine[in.bx+1][in.by-1].isMine==true) 
			numberOfMine++;//右上
		if(Mine.mine[in.bx-1][in.by].isMine==true) 
			numberOfMine++;	//左
		if(Mine.mine[in.bx+1][in.by].isMine==true) 
			numberOfMine++;	//右
		if(Mine.mine[in.bx-1][in.by+1].isMine==true) 
			numberOfMine++;//左下
		if(Mine.mine[in.bx][in.by+1].isMine==true) 
			numberOfMine++;	//下
		if(Mine.mine[in.bx+1][in.by+1].isMine==true) 
			numberOfMine++;//右下
		in.setIcon(new ImageIcon("images/"+numberOfMine+".png"));
		
		Mine.numberOfClicked++;//翻开格子数+1
		
		/********************************************************
                                                              如果没挖的全是雷，则游戏胜利
        ********************************************************/
		if(Mine.numberOfClicked == (Mine.row * Mine.column - Mine.row*10/9))
		{
			int	yourChoice = JOptionPane.showConfirmDialog(null,"游戏胜利!\n是否开始新游戏?");
			if(yourChoice == JOptionPane.OK_OPTION)
				this.replay();
			else
				System.exit(0);
		}
		/********************************************************
                                                                      如果周围没有雷则挖开
        ********************************************************/
		if(numberOfMine==0)
		{
			if(Mine.mine[in.bx-1][in.by-1].isClicked ==	false)
				showMine(Mine.mine[in.bx-1][in.by-1]);
			if(Mine.mine[in.bx][in.by-1].isClicked == false)
				showMine(Mine.mine[in.bx][in.by-1]);
			if(Mine.mine[in.bx+1][in.by-1].isClicked ==	false)
				showMine(Mine.mine[in.bx+1][in.by-1]);
			if(Mine.mine[in.bx+1][in.by].isClicked == false)
				showMine(Mine.mine[in.bx+1][in.by]);
			if(Mine.mine[in.bx+1][in.by+1].isClicked ==	false)
				showMine(Mine.mine[in.bx+1][in.by+1]);
			if(Mine.mine[in.bx][in.by+1].isClicked == false)
				showMine(Mine.mine[in.bx][in.by+1]);
			if(Mine.mine[in.bx-1][in.by+1].isClicked ==	false)
				showMine(Mine.mine[in.bx-1][in.by+1]);
			if(Mine.mine[in.bx-1][in.by].isClicked == false)
				showMine(Mine.mine[in.bx-1][in.by]);
		}

	}
	
	/**
	 * replay方法<br>
	 * Description:开始新游戏.
	 * <p>释放窗体资源，停止计时，实例化新Mine
	 */
	public void replay()
	{
		mine.dispose();	//释放
		Mine.timeListen.stop();
		new	Mine();
		//new Mine(Mine.row,Mine.column);
	}
	
	/**
	 *mousePressed方法<br>
	 *Description:鼠标按下时调用此函数.
	 *<p>按下鼠标右键时，右键之后set标签flag，将numberOfUnflaged（剩余雷数）减1，else撤掉标记，雷数+1，重新设置蓝色格子。更新标签
	 *@param e MouseEvent对象，获取鼠标事件
	 */
	public void mousePressed(MouseEvent e)
	{
		int	mods=e.getModifiers();
		MyButton receive=(MyButton)e.getSource();
		
		if((mods&InputEvent.BUTTON3_MASK)!=0 && !(e.getModifiersEx()==(InputEvent.BUTTON1_DOWN_MASK | InputEvent.BUTTON3_DOWN_MASK)))
		{//右键
			if(receive.isClicked ==	false)
			{
				receive.isRight	= receive.isRight?false:true;//改变
				/********************************************************
                                                        右键之后set标签flag，将numberOfUnflaged（剩余雷数）减1
                      else撤掉标记，雷数+1，重新设置蓝色格子
                ********************************************************/
				if(receive.isRight)
				{
						Mine.numberOfUnflaged-=1;
						receive.setIcon(Images.flagIcon);
				}
				else
				{
						Mine.numberOfUnflaged++;
						receive.setIcon(Images.gridIcon);
				}
				Mine.numberOfUnflagedLabel.setText("剩余雷数："+Mine.numberOfUnflaged);
				//更新剩余雷数
			}
			
		}
		/********************************************************
                                                                        鼠标左右键同时按下时
        ********************************************************/
		/***if( e.getModifiersEx() == ( InputEvent.BUTTON1_DOWN_MASK | InputEvent.BUTTON3_DOWN_MASK))
		{
			
				
		}*/
		
	
	}
	
	/**
	 *mouseReleased方法<br>
	 *Description:松开鼠标按钮时调用.
	 */
	public void	mouseReleased(MouseEvent e)
	{
		
	}
	/**
	 *mouseExited方法<br>
	 *Description:离开你所监听的组件时调用. 
	 */
	public void	mouseExited(MouseEvent e)	
	{
		
	}
	/**
	 *mouseClicked方法<br>
	 *Description:按下并松开鼠标按钮时调用.
	 *<p>用户在选择或双击图标的时候通常会点击鼠标按钮. 用户如果在松开鼠标之前移动鼠标,点击不会导致鼠标相应事件出现.
	 */
	public void	mouseClicked(MouseEvent	e)
	{
		
	}
	/**
	 *mouseEntered方法<br>
	 *Description:鼠标离开当前组件并进入你所监听的组件时激活事件. 
	 */
	public void	mouseEntered(MouseEvent	e)
	{
		
	}
}
