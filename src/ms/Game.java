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
		if(receive.isMine)//�ڵ�����,���ȵ�����Ϊ��X"������ʾ��������
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
			JOptionPane.showMessageDialog(null,"ʧ���ˣ�","��Ϸ����",
            JOptionPane.INFORMATION_MESSAGE,Images.bombIcon);
			int	yourChose = JOptionPane.showConfirmDialog(null,"�Ƿ�ʼ����Ϸ��"	);
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
		{//û�ڵ���
			showMine(receive);
		}
	}
	
	/********************************************************
                                                              �㰡�㣬��ѽ��
    ********************************************************/
	public  void showMine(MyButton in)
	{
		int	numberOfMine = 0;
		in.isClicked = true;
		/********************************************************
                                                                     �����Χ�˸��Ƿ����ף��ط�����
        ********************************************************/
		if(Mine.mine[in.bx-1][in.by-1].isMine==true) 
			numberOfMine++;//����
		if(Mine.mine[in.bx][in.by-1].isMine==true) 
			numberOfMine++;	//��
		if(Mine.mine[in.bx+1][in.by-1].isMine==true) 
			numberOfMine++;//����
		if(Mine.mine[in.bx-1][in.by].isMine==true) 
			numberOfMine++;	//��
		if(Mine.mine[in.bx+1][in.by].isMine==true) 
			numberOfMine++;	//��
		if(Mine.mine[in.bx-1][in.by+1].isMine==true) 
			numberOfMine++;//����
		if(Mine.mine[in.bx][in.by+1].isMine==true) 
			numberOfMine++;	//��
		if(Mine.mine[in.bx+1][in.by+1].isMine==true) 
			numberOfMine++;//����
		in.setIcon(new ImageIcon("images/"+numberOfMine+".png"));
		
		Mine.numberOfClicked++;//����������+1
		
		/********************************************************
                                                              ���û�ڵ�ȫ���ף�����Ϸʤ��
        ********************************************************/
		if(Mine.numberOfClicked == (Mine.row * Mine.column - Mine.row*10/9))
		{
			int	yourChoice = JOptionPane.showConfirmDialog(null,"��Ϸʤ��!\n�Ƿ�ʼ����Ϸ?");
			if(yourChoice == JOptionPane.OK_OPTION)
				this.replay();
			else
				System.exit(0);
		}
		/********************************************************
                                                                      �����Χû�������ڿ�
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
                                                                    ��ʼ����Ϸ
    ********************************************************/
	public void replay()
	{
		mine.dispose();	//�ͷ�
		Mine.timeListen.stop();
		new	Mine();
		//new Mine(Mine.row,Mine.column);
	}
	
	/********************************************************
                                                     ����ף�when click right
    ********************************************************/
	public void mousePressed(MouseEvent e)
	{
		int	mods=e.getModifiers();
		MyButton receive=(MyButton)e.getSource();
		
		if((mods&InputEvent.BUTTON3_MASK)!=0 && !(e.getModifiersEx()==(InputEvent.BUTTON1_DOWN_MASK | InputEvent.BUTTON3_DOWN_MASK)))
		{//�Ҽ�
			if(receive.isClicked ==	false)
			{
				receive.isRight	= receive.isRight?false:true;//�ı�
				/********************************************************
                                                        �Ҽ�֮��set��ǩflag����numberOfUnflaged��ʣ����������1
                      else������ǣ�����+1������������ɫ����
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
				Mine.numberOfUnflagedLabel.setText("ʣ��������"+Mine.numberOfUnflaged);
				//����ʣ������
			}
			
		}
		/********************************************************
                                                                        ������Ҽ�ͬʱ����ʱ
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
