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
 *Description:��Ϸִ�е���Ҫ����.
 *@version 1.0
 */
public class Game implements ActionListener,MouseListener
{
	Mine mine;
	/**
	 * Game����
	 * @param in Mine����
	 */
	public Game(Mine in)
	{
		mine=in;
	}
	
	/**
	 * actionPerformed����<br>
	 * Description:��ȡ�¼�.<br>
	 * <p>����㵽���ף������е���ͼ����Ϊ �ף�ֹͣ��ʱ������ʾ�������ף���ʾ��Ϸʧ��,ѡ���Ƿ�ʼ����Ϸ
	 * <br>���û�е㵽�ף�ִ��showMine����
	 * @param e ActionEvent����
	 */
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
	
	/**
	 * showMine����<br>
	 * Description:��Ϸ�����㷨����<br>
	 * <p>�㵽ĳ���񣬼����Χ�˸������׵�����������׵����֣����㿪��������+1
	 * <br>���û�е㿪�ĸ�����û���ף�����ʾ��Ϸʤ����ѡ���Ƿ�ʼ����Ϸ
	 * <br>�����Χû��������չ��������
	 * @param in MyButton����
	 */
	public void showMine(MyButton in)
	{
		/**numberOfMine:��¼�׵ĸ���*/
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
	
	/**
	 * replay����<br>
	 * Description:��ʼ����Ϸ.
	 * <p>�ͷŴ�����Դ��ֹͣ��ʱ��ʵ������Mine
	 */
	public void replay()
	{
		mine.dispose();	//�ͷ�
		Mine.timeListen.stop();
		new	Mine();
		//new Mine(Mine.row,Mine.column);
	}
	
	/**
	 *mousePressed����<br>
	 *Description:��갴��ʱ���ô˺���.
	 *<p>��������Ҽ�ʱ���Ҽ�֮��set��ǩflag����numberOfUnflaged��ʣ����������1��else������ǣ�����+1������������ɫ���ӡ����±�ǩ
	 *@param e MouseEvent���󣬻�ȡ����¼�
	 */
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
	
	/**
	 *mouseReleased����<br>
	 *Description:�ɿ���갴ťʱ����.
	 */
	public void	mouseReleased(MouseEvent e)
	{
		
	}
	/**
	 *mouseExited����<br>
	 *Description:�뿪�������������ʱ����. 
	 */
	public void	mouseExited(MouseEvent e)	
	{
		
	}
	/**
	 *mouseClicked����<br>
	 *Description:���²��ɿ���갴ťʱ����.
	 *<p>�û���ѡ���˫��ͼ���ʱ��ͨ��������갴ť. �û�������ɿ����֮ǰ�ƶ����,������ᵼ�������Ӧ�¼�����.
	 */
	public void	mouseClicked(MouseEvent	e)
	{
		
	}
	/**
	 *mouseEntered����<br>
	 *Description:����뿪��ǰ����������������������ʱ�����¼�. 
	 */
	public void	mouseEntered(MouseEvent	e)
	{
		
	}
}
