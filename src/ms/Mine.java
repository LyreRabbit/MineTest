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
 * ClassName:Mine<br>
 * Description:游戏主界面.
 * @version 1.0
 */
public class Mine extends JFrame implements ActionListener
{
	public static boolean bool=true;
	
	/**mine:游戏主区域按钮*/
	public static MyButton [][] mine;
	/**
	 * numberOfUnflaged:未标记个数，即剩余雷数
	*/
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
	
	
	/**
	 * 构造方法Mine<br>
	 * Description:设置雷区面板
	 * <p>完成加入面板、设置图标、布雷、启动计时器等.
	 */
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
	
	
	/**
	 * 构造方法Mine<br>
	 * Description:设置雷区面板.
	 * <p>完成加入面板、设置图标、布雷、启动计时器等.
	 * @param a 面板行数
	 * @param b 面板列数
	 */
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
	
	/**
	 * addMine方法<br>
	 * Description：完成随机布雷.
	 * <p>10个雷，随机标记isMine,设为真
	 * @param a 行
	 * @param b 列
	 */
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
	
	/**
	 * InitMine方法<br>
	 * Description：初始化游戏面板.<br>
	 * <p>设置窗口位置及大小,创建布局管理器并关联,设置顶部面板
	 * <br>初始化一些数据：已点击数及时间
	 * <br>显示剩余雷数、时间及菜单选项，添加各种标签，设置时间监听等
	 * <br>创建下标为0—199的button，30x30矩阵(最多button个数)
	 */
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

	/**
	 * ClassName:TimerListener<br>
	 * Description:内部类,用于时间监听
	 */
	class TimerListener	implements ActionListener
	{
		/**
		 * actionPerformed方法<br>
		 * Description:获取事件.
		 * @param e ActionEvent对象
		 */
		public void actionPerformed(ActionEvent	e)
		{
			usedTime++;
			timeLabel.setText("用时：" + usedTime);
		}
	}
	
	/**
	 * actionPerformed方法<br>
	 * Description:获取事件.<br>
	 * <p>当点击“开始”、“初级”“中级”“高级”时，释放窗体资源，停止计时，实例化新Mine
	 * @param e ActionEvent对象
	 */
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
		if(e.getActionCommand()=="退出")
		{
			this.dispose();
			System.exit(0);
		}
	}
	
}
