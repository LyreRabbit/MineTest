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
 * Mine类
 * Description：游戏主界面
 * 
 */
public class Mine extends JFrame implements ActionListener
{
	public static boolean bool=true;
	
	/**mine:游戏主区域按钮*/
	public static MyButton [][] mine;
	/**numberOfUnflaged:未标记个数，即剩余雷数*/
	public static int numberOfUnflaged;
	/**numberOfUnflagedLabel:剩余雷数标签*/
	public static JLabel numberOfUnflagedLabel = new JLabel();
	/**numberOfFlaged:已标记雷数*/
	public static int numberOfFlaged ;
	/**numberOfClicked:已点开的方格数*/
	public static int numberOfClicked;			
	
	/**row:面板行数*/
	public static int row=9;
	/**column:面板列数*/
	public static int column=9;
	JMenuBar menubar;
	/**minePanel:游戏主面板标签*/
	JPanel minePanel=new JPanel();
	/**topPanel:游戏顶部面板标签*/
	JPanel topPanel=new JPanel();
	//JPanel botPanel=new JPanel();//底部
	
	/**timeLabel:时间标签*/
	public static JLabel timeLabel = new JLabel();
	/**timeLabel:时间监听，用于计时*/
	public static Timer timeListen;
	/**usedTime:记录已用时间*/
	public static int usedTime;
	
	/**listener:用于监听游戏主面板（地雷区域）动作*/
	Game listener=new Game(this);
	
	
	
	public Mine()
	{
		super("扫雷-MineSweeper");
		numberOfUnflaged=10;
		InitMine();
		GridLayout lay2=new	GridLayout(row,column);//创建默认值的网格布局
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
		addMine(9,9);//放雷
		timeListen.start();//启动计时
		setVisible(true);//显示
	}
	
	public Mine(int a,int b)
	{
		super("扫雷-MineSweeper");
		Mine.row = a;
		Mine.column = b;
		numberOfUnflaged=a*10/9;
		InitMine();
		GridLayout lay2=new	GridLayout(a,b);//创建默认值的网格布局
		minePanel.setLayout(lay2);
		
		for(int	i=1;i<a;i++)
		{
			for(int	j=1;j<b;j++)
			{
				 minePanel.add(mine[i][j]);
				 mine[i][j].setIcon(Images.gridIcon);//初始蓝色格子
				 mine[i][j].isClicked=false;//未挖开
				 mine[i][j].addActionListener(listener);
				 mine[i][j].addMouseListener(listener);	
				        
			}
		}
		add(minePanel,BorderLayout.CENTER);
		addMine(a,b);//放雷
		timeListen.start();//启动计时器
		setVisible(true);//显示
	}
	
	/********************************************************
                                                                         随机放雷
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
                                                                  初始化游戏面板
    ********************************************************/
	void InitMine()
	{
		setBounds(700,300,330,440);//size
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//
		
		BorderLayout lay1=new BorderLayout();//布局管理器
		setLayout(lay1);
		
		
		
		/********************************************************
                              topPanel设置
        ********************************************************/
		JMenuBar menuBar=new JMenuBar();
		JMenu menu1=new JMenu("选项");
		JMenuItem start=new JMenuItem("开始");
		JRadioButton level1=new JRadioButton("初级");
		JRadioButton level2=new JRadioButton("中级");
		JRadioButton level3=new JRadioButton("高级");
		JMenuItem quit=new JMenuItem("退出");
		start.addActionListener(this);
		menu1.add(start);//开始
		level1.addActionListener(this);
		menu1.add(level1);//初级
		level2.addActionListener(this);
	    menu1.add(level2);//中级
		level3.addActionListener(this);
		menu1.add(level3);//高级
		quit.addActionListener(this);
		menu1.add(quit);//退出
		menuBar.add(menu1); 
		//JMenu menu2=new JMenu("");
		
		numberOfClicked	= 0;
		usedTime = 0;
		
		add(topPanel,BorderLayout.NORTH);
		
		topPanel.add(menuBar);
		
		numberOfUnflagedLabel.setText("剩余雷数："+numberOfUnflaged);
		numberOfUnflagedLabel.setFont(Images.fontOne);
		topPanel.add(numberOfUnflagedLabel);
		timeLabel.setText("用时：" + usedTime); 
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
                                                                      时间监听
    ********************************************************/
	class TimerListener	implements ActionListener
	{
		public void actionPerformed(ActionEvent	e)
		{
			usedTime++;
			timeLabel.setText("用时：" + usedTime);
		}
	}
	

	public void actionPerformed(ActionEvent e) 
	{
		if(e.getActionCommand()=="开始")
		{
			this.dispose();
			Mine.timeListen.stop();
			new Mine();
		}
		
		else if(e.getActionCommand()=="初级")
		{
			this.dispose();
			Mine.timeListen.stop();
			new Mine();
			
		}
		
		/**else if(e.getActionCommand()=="中级")
		{
			
			this.dispose();
			Mine.timeListen.stop();
			new Mine(      );
			
		}
		
		if(e.getActionCommand()=="高级")
		{
			this.dispose();
			Mine.timeListen.stop();
			new Mine(     );
		}*/
	}
	
}
