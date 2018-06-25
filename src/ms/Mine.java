package ms;

//import java.awt.BorderLayout;
//import java.awt.GridLayout;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;

//import javax.swing.JDialog;
//import javax.swing.JFrame;
//import javax.swing.JLabel;
//import javax.swing.JMenu;
//import javax.swing.JMenuBar;
//import javax.swing.JMenuItem;
//import javax.swing.JPanel;
//import javax.swing.JRadioButton;
//import javax.swing.Timer;
import javax.swing.*;


import java.awt.*;
import java.awt.event.*;



/**
 * Mine��
 * Description����Ϸ������
 * 
 */
public class Mine extends JFrame implements ActionListener
{
	public static boolean bool=true;
	
	/**mine:��Ϸ������ť*/
	public static MyButton [][] mine;
	/**numberOfUnflaged:δ��Ǹ�������ʣ������*/
	public static int numberOfUnflaged;
	/**numberOfUnflagedLabel:ʣ��������ǩ*/
	public static JLabel numberOfUnflagedLabel = new JLabel();
	/**numberOfFlaged:�ѱ������*/
	public static int numberOfFlaged ;
	/**numberOfClicked:�ѵ㿪�ķ�����*/
	public static int numberOfClicked;			
	
	/**row:�������*/
	public static int row=9;
	/**column:�������*/
	public static int column=9;
	JMenuBar menubar;
	/**minePanel:��Ϸ������ǩ*/
	JPanel minePanel=new JPanel();
	/**topPanel:��Ϸ��������ǩ*/
	JPanel topPanel=new JPanel();
	//JPanel botPanel=new JPanel();//�ײ�
	
	/**timeLabel:ʱ���ǩ*/
	public static JLabel timeLabel = new JLabel();
	/**timeLabel:ʱ����������ڼ�ʱ*/
	public static Timer timeListen;
	/**usedTime:��¼����ʱ��*/
	public static int usedTime;
	
	/**listener:���ڼ�����Ϸ����壨�������򣩶���*/
	Game listener=new Game(this);
	
	
	
	public Mine()
	{
		super("ɨ��-MineSweeper");
		numberOfUnflaged=10;
		InitMine();
		GridLayout lay2=new	GridLayout(row,column);//����Ĭ��ֵ�����񲼾�
		minePanel.setLayout(lay2);
		
		for(int	i=1;i<10;i++)
		{
			for(int	j=1;j<10;j++)
			{
				 minePanel.add(mine[i][j]);
				 mine[i][j].setIcon(Images.gridIcon);
				 mine[i][j].isClicked=false;
				 mine[i][j].addActionListener(listener);
				 mine[i][j].addMouseListener(listener);	
				        
			}
		}
		add(minePanel,BorderLayout.CENTER);
		addMine(9,9);//����
		timeListen.start();//������ʱ
		setVisible(true);//��ʾ
	}
	
	public Mine(int a,int b)
	{
		super("ɨ��-MineSweeper");
		Mine.row = a;
		Mine.column = b;
		numberOfUnflaged=a*10/9;
		InitMine();
		GridLayout lay2=new	GridLayout(a,b);//����Ĭ��ֵ�����񲼾�
		minePanel.setLayout(lay2);
		
		for(int	i=1;i<a;i++)
		{
			for(int	j=1;j<b;j++)
			{
				 minePanel.add(mine[i][j]);
				 mine[i][j].setIcon(Images.gridIcon);//��ʼ��ɫ����
				 mine[i][j].isClicked=false;//δ�ڿ�
				 mine[i][j].addActionListener(listener);
				 mine[i][j].addMouseListener(listener);	
				        
			}
		}
		add(minePanel,BorderLayout.CENTER);
		addMine(a,b);//����
		timeListen.start();//������ʱ��
		setVisible(true);//��ʾ
	}
	
	/********************************************************
                                                                         �������
    ********************************************************/
	public static void addMine(int a,int b)
	{
		for(int i=0; i<a*10/9; )
		{
			int	r=(int)(Math.random()*100%a+1);
			int	c=(int)(Math.random()*100%b+1);
			if(mine[r][c].isMine==false)
			{
				mine[r][c].isMine=true;
				i++;
			}
		}
	}
	
	/********************************************************
                                                                  ��ʼ����Ϸ���
    ********************************************************/
	void InitMine()
	{
		setBounds(700,300,330,440);//size
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//
		
		BorderLayout lay1=new BorderLayout();//���ֹ�����
		setLayout(lay1);
		
		
		
		/********************************************************
                              topPanel����
        ********************************************************/
		JMenuBar menuBar=new JMenuBar();
		JMenu menu1=new JMenu("ѡ��");
		JMenuItem start=new JMenuItem("��ʼ");
		JRadioButton level1=new JRadioButton("����");
		JRadioButton level2=new JRadioButton("�м�");
		JRadioButton level3=new JRadioButton("�߼�");
		JMenuItem quit=new JMenuItem("�˳�");
		start.addActionListener(this);
		menu1.add(start);//��ʼ
		level1.addActionListener(this);
		menu1.add(level1);//����
		level2.addActionListener(this);
	    menu1.add(level2);//�м�
		level3.addActionListener(this);
		menu1.add(level3);//�߼�
		quit.addActionListener(this);
		menu1.add(quit);//�˳�
		menuBar.add(menu1); 
		//JMenu menu2=new JMenu("");
		
		numberOfClicked	= 0;
		usedTime = 0;
		
		add(topPanel,BorderLayout.NORTH);
		
		topPanel.add(menuBar);
		
		numberOfUnflagedLabel.setText("ʣ��������"+numberOfUnflaged);
		numberOfUnflagedLabel.setFont(Images.fontOne);
		topPanel.add(numberOfUnflagedLabel);
		timeLabel.setText("��ʱ��" + usedTime); 
		timeLabel.setFont(Images.fontOne);	
		topPanel.add(timeLabel);					
		
		timeListen=new Timer(1000,new TimerListener());
		
		mine= new MyButton[31][31];
		for(int	i=0; i<31; ++i)
		{
			for(int	j=0; j<31; ++j)
			{
				mine[i][j] =new	MyButton(i,j);
			}
		}
		
	}

	/********************************************************
                                                                      ʱ�����
    ********************************************************/
	class TimerListener	implements ActionListener
	{
		public void actionPerformed(ActionEvent	e)
		{
			usedTime++;
			timeLabel.setText("��ʱ��" + usedTime);
		}
	}
	

	public void actionPerformed(ActionEvent e) 
	{
		if(e.getActionCommand()=="��ʼ")
		{
			this.dispose();
			Mine.timeListen.stop();
			new Mine();
		}
		
		else if(e.getActionCommand()=="����")
		{
			this.dispose();
			Mine.timeListen.stop();
			new Mine();
			
		}
		
		/**else if(e.getActionCommand()=="�м�")
		{
			
			this.dispose();
			Mine.timeListen.stop();
			new Mine(      );
			
		}
		
		if(e.getActionCommand()=="�߼�")
		{
			this.dispose();
			Mine.timeListen.stop();
			new Mine(     );
		}*/
	}
	
}
