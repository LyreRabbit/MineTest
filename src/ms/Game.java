package ms;
import javax.swing.*;
import java.awt.event.*;

public class Game implements ActionListener,MouseListener
{
	 Mine mine=null;
	public Game(Mine in)
	{
		mine=in;
	}

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
	
	/********************************************************
                                                              点啊点，挖呀挖
    ********************************************************/
	public  void showMine(MyButton in)
	{
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
	
	/********************************************************
                                                                    开始新游戏
    ********************************************************/
	public void replay()
	{
		mine.dispose();	//释放
		Mine.timeListen.stop();
		new	Mine();
		//new Mine(Mine.row,Mine.column);
	}
	
	/********************************************************
                                                     标记雷，when click right
    ********************************************************/
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
	public void	mouseReleased(MouseEvent e)
	{
		
	}
	public void	mouseExited(MouseEvent e)	
	{
		
	}
	public void	mouseClicked(MouseEvent	e)
	{
		
	}
	public void	mouseEntered(MouseEvent	e)
	{
		
	}
}
