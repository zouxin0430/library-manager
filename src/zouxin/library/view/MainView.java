package zouxin.library.view;

import java.awt.BorderLayout;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Graphics;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.basic.BasicComboBoxUI;
import javax.swing.table.DefaultTableModel;

import java.awt.CardLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

import zouxin.library.Listen.BookNameComboBoxListener;
import zouxin.library.Listen.BorrowBookListenner;
import zouxin.library.Listen.CardSwitchListenner;
import zouxin.library.Listen.GeneralMethod;
import zouxin.library.Listen.LocationComboBoxListener;
import zouxin.library.Listen.PreemptionListnner;
import zouxin.library.Listen.Preemption_CardSwitchListenner;
import zouxin.library.Listen.RenewBookListener;
import zouxin.library.Listen.SharedViewListener;
import zouxin.library.Listen.SharedViewListener1;
import zouxin.library.Listen.UpdateMouseListener;
import zouxin.library.Listen.UpdatePassWordListener;
import zouxin.library.dao.LogInViewDao;
import zouxin.library.dao.MainViewDao;
import zouxin.library.dao.TeacherViewDao;
import zouxin.library.vo.BookInformaticaVo;
import zouxin.library.vo.BookTypeVo;
import zouxin.library.vo.StorageUserInVo;

import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;

import javax.swing.JComboBox;
import java.awt.FlowLayout;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.border.EtchedBorder;

public class MainView extends JFrame {

	public JPanel contentPane;
	public JPanel panel_Card;
	public JPanel preemption_Card;
    public CardLayout card;
    public CardLayout preemption_Card_card;
    public JTextField textField;
    public JTextField textField_1;
    public MyTable table;
    public JRadioButton rdbtnNewRadioButton;
    public JComboBox comboBox;
    public JComboBox library_Combobox;
    public JComboBox library_Room_Combobox;
    public JComboBox location_comboBox;
    public JComboBox book_Name_comboBox;
    public MyTable table_1;
    public MyTable table_2;
    public JButton selectValue;
    public JTextField textField_2;
    public MyTable table_3;
    public JTabbedPane tabbedPane;
    public MyTable table_4;
    public JTextField textField_3;
    public JTextField textField_4;
    public JTextField textField_5;
    
    public JLabel lblNewLabel_9;
    public JLabel lblNewLabel_10;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainView frame = new MainView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MainView() {
		
		super.setTitle("欢迎"+StorageUserInVo.userId+"  "+StorageUserInVo.userName+"使用本系统");
		
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 808, 494);
		contentPane = new JPanel();//
		contentPane.setOpaque(false);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		card=new CardLayout(0,0);
		
		panel_Card = new JPanel();
		panel_Card.setOpaque(false);
		panel_Card.setBounds(102, 10, 690, 444);
		contentPane.add(panel_Card);
		panel_Card.setLayout(card);
		panel_Card.setBorder(BorderFactory.createEtchedBorder(Color.black, Color.gray));//设置panel_Card的边框属性
		JPanel panel_Preemption = new JPanel();
		panel_Preemption.setOpaque(false);
		panel_Preemption.setForeground(Color.BLACK);
		panel_Card.add("Preemption", panel_Preemption);
		panel_Preemption.setLayout(null);
		
		preemption_Card_card=new CardLayout(0, 0);
		preemption_Card = new JPanel();
		preemption_Card.setBounds(0, 22, 686, 418);
		panel_Preemption.add(preemption_Card);
		preemption_Card.setLayout(preemption_Card_card);
		preemption_Card.setBorder(new EtchedBorder(EtchedBorder.LOWERED, Color.ORANGE, new Color(128, 128, 128)));
		
		JPanel panel_BorrowBook = new JPanel();
		panel_BorrowBook.setOpaque(false);
		preemption_Card.add("BorrowBook", panel_BorrowBook);
		panel_BorrowBook.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("书  名:");
		lblNewLabel.setBounds(10, 10, 54, 15);
		panel_BorrowBook.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setOpaque(false);
		textField.setBounds(86, 7, 174, 21);
		panel_BorrowBook.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("作  者:");
		lblNewLabel_1.setBounds(303, 10, 54, 15);
		panel_BorrowBook.add(lblNewLabel_1);
		
		textField_1 = new JTextField();
		textField_1.setOpaque(false);
		textField_1.setBounds(367, 7, 150, 21);
		panel_BorrowBook.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("类型");
		lblNewLabel_2.setBounds(10, 54, 54, 15);
		panel_BorrowBook.add(lblNewLabel_2);
		
		selectValue = new JButton("查询");
//		selectValue.setOpaque(false);
		selectValue.setContentAreaFilled(false); 
		selectValue.setBounds(544, 50, 93, 23);
		panel_BorrowBook.add(selectValue);
		
		comboBox = new JComboBox();
		comboBox.addItem("");
		comboBoxAdd();
		comboBox.setBounds(86, 51, 174, 21);
		panel_BorrowBook.add(comboBox);
		//将有数据的table放入表中
		table = new MyTable();
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);//设置自动调整列宽 
		JScrollPane scrollPane = new JScrollPane(table,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);//将table放入这个组件中，并且需要时出现滚动条
		scrollPane.setBounds(0, 84, 682, 282);
		scrollPane.setOpaque(false);
		scrollPane.getViewport().setOpaque(false);
		panel_BorrowBook.add(scrollPane);
		tableAddcolunmName(table,new Object[]{"图书馆","库室","库位","书名","剩余数量","书籍类型","作者","单价","条形码","出版社","书籍编号","库位编号"});
        scrollPane.setViewportView(table);
		
		JButton preemption_Button = new JButton("预借");
		preemption_Button.setContentAreaFilled(false);
		preemption_Button.setBounds(579, 381, 93, 23);
		panel_BorrowBook.add(preemption_Button);
		
		rdbtnNewRadioButton = new JRadioButton("是否模糊查询");
		rdbtnNewRadioButton.setBounds(303, 50, 121, 23);
		panel_BorrowBook.add(rdbtnNewRadioButton);
		
		JPanel panel_SelectMyBook = new JPanel();
		panel_SelectMyBook.setOpaque(false);
		preemption_Card.add("SelectMyBook", panel_SelectMyBook);
		panel_SelectMyBook.setLayout(null);
		
		table_1 = new MyTable();
		table_1.setOpaque(false);
		table_1.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);//设置自动调整列宽 
		tableAddcolunmName(table_1,new Object[]{"图书馆","库室","库位","书名","借阅数量","书籍类型","作者","单价","条形码","出版社","事务ID","库位编号"});
		JScrollPane scrollPane_1 = new JScrollPane(table_1,JScrollPane.VERTICAL_SCROLLBAR_NEVER,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane_1.setBounds(0, 0, 682, 305);
		panel_SelectMyBook.add(scrollPane_1);
		scrollPane_1.setViewportView(table_1);
		
		JButton cannel_Borrow = new JButton("取消预借");
		cannel_Borrow.setBounds(579, 326, 93, 23);
		panel_SelectMyBook.add(cannel_Borrow);
		
		JButton borrowBookPremption = new JButton("预借");
		borrowBookPremption.setBorder(BorderFactory.createRaisedBevelBorder());
		borrowBookPremption.setBounds(0, 0, 93, 23);
		panel_Preemption.add(borrowBookPremption);
		
		JButton selectMyBookPremption = new JButton("预借的书籍");
		selectMyBookPremption.setContentAreaFilled(false);
		selectMyBookPremption.setBounds(90, 0, 93, 23);
		selectMyBookPremption.setBorder(BorderFactory.createRaisedBevelBorder());
		panel_Preemption.add(selectMyBookPremption);
		
		
		JPanel panel_BackBook = new JPanel();
		panel_BackBook.setOpaque(false);
		panel_Card.add("BackBook", panel_BackBook);
		panel_BackBook.setLayout(null);
		
		table_2 = new MyTable();
		table_2.setOpaque(false);
		table_3Add(table_2);
		table_2.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		JScrollPane scrollPane_3 =new JScrollPane(table_2,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollPane_3.setViewportView(table_2);
		scrollPane_3.setBounds(0, 0, 686, 330);
		panel_BackBook.add(scrollPane_3);
		
		JButton remand_Book = new JButton("续借书籍");
		remand_Book.setContentAreaFilled(false);
		remand_Book.setBounds(572, 350, 93, 23);
		panel_BackBook.add(remand_Book);
		
		JPanel panel_shared = new JPanel();
		panel_shared.setOpaque(false);
		panel_Card.add("shared", panel_shared);
		panel_shared.setLayout(null);
		
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 10, 666, 420);
		panel_shared.add(tabbedPane);
		
		JPanel panel = new JPanel();//共享书籍
		panel.setOpaque(false);
		tabbedPane.addTab("共享书籍", null, panel, null);
		panel.setLayout(null);
		
		book_Name_comboBox = new JComboBox();
		book_Name_comboBox.addItem("");
		comboBoxAdd_Li();
		book_Name_comboBox.setBounds(184, 11, 125, 21);
		panel.add(book_Name_comboBox);
		
		JLabel lblNewLabel_3 = new JLabel("书籍名称 *");
		lblNewLabel_3.setBounds(48, 14, 74, 15);
		panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("库位*");
		lblNewLabel_4.setBounds(48, 61, 54, 15);
		panel.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("库室*");
		lblNewLabel_5.setBounds(48, 108, 54, 15);
		panel.add(lblNewLabel_5);
		
		location_comboBox = new JComboBox();
		location_comboBox.addItem("");
		location_comboBox.setBounds(184, 58, 125, 21);
		panel.add(location_comboBox);
		
		JLabel lblNewLabel_6 = new JLabel("图书馆*");
		lblNewLabel_6.setBounds(48, 153, 54, 15);
		panel.add(lblNewLabel_6);
		
		library_Room_Combobox = new JComboBox();
		library_Room_Combobox.setBounds(184, 105, 125, 21);
		panel.add(library_Room_Combobox);
		
		library_Combobox = new JComboBox();
		library_Combobox.setOpaque(false);
		library_Combobox.setBounds(184, 150, 125, 21);
		panel.add(library_Combobox);
		
		textField_2 = new JTextField();
		textField_2.setBounds(184, 202, 125, 21);
		textField_2.setOpaque(false);
		panel.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblNewLabel_7 = new JLabel("数量*");
		lblNewLabel_7.setBounds(48, 205, 54, 15);
		panel.add(lblNewLabel_7);
		
		JButton sharedButton = new JButton("共享");
		sharedButton.setContentAreaFilled(false);
		sharedButton.setBounds(121, 303, 93, 23);
		panel.add(sharedButton);
//		lblNewLabel_8.setIcon(GeneralMethod.createImage("/images/wuman.jpg"));
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("查看预共享书籍", null, panel_1, null);
		panel_1.setLayout(null);
		
		table_3 = new MyTable();
		table_3.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		JScrollPane scrollPane_2 = new JScrollPane(table_3,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollPane_2.setBounds(10, 10, 641, 302);
		panel_1.add(scrollPane_2);
		scrollPane_2.setViewportView(table_3);
		
		JButton cancelShared = new JButton("取消共享");
		cancelShared.setBounds(558, 340, 93, 23);
		panel_1.add(cancelShared);
		
		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("查看共享书籍", null, panel_2, null);
		panel_2.setLayout(null);
		
		JScrollPane scrollPane_4 = new JScrollPane();
		scrollPane_4.setBounds(10, 10, 641, 312);
		panel_2.add(scrollPane_4);
		
		table_4 = new MyTable();
		scrollPane_4.setViewportView(table_4);
		
		JPanel panel_Update = new JPanel();
		panel_Card.add("Update", panel_Update);
		panel_Update.setLayout(null);
		
		JTabbedPane tabbedPane_1 = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane_1.setBounds(10, 10, 546, 420);
		panel_Update.add(tabbedPane_1);
		
		JPanel panel_3 = new JPanel();
		tabbedPane_1.addTab("修改密码", null, panel_3, null);
		panel_3.setLayout(null);
		
		JLabel lblNewLabel_8 = new JLabel("密码");
		lblNewLabel_8.setBounds(10, 31, 54, 15);
		panel_3.add(lblNewLabel_8);
		
		textField_3 = new JTextField();
		textField_3.setBounds(104, 28, 177, 21);
		panel_3.add(textField_3);
		textField_3.setColumns(10);
		
		JLabel label = new JLabel("新密码");
		label.setBounds(10, 87, 54, 15);
		panel_3.add(label);
		
		JLabel label_1 = new JLabel("确认密码");
		label_1.setBounds(10, 148, 54, 15);
		panel_3.add(label_1);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(104, 84, 177, 21);
		panel_3.add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(104, 145, 177, 21);
		panel_3.add(textField_5);
		
		JButton btnNewButton = new JButton("修改密码");
		btnNewButton.setBounds(188, 265, 93, 23);
		panel_3.add(btnNewButton);
		
		lblNewLabel_9 = new JLabel();
		lblNewLabel_9.setForeground(Color.RED);
		lblNewLabel_9.setBounds(292, 31, 207, 15);
		panel_3.add(lblNewLabel_9);
		
		lblNewLabel_10 = new JLabel();
		lblNewLabel_10.setForeground(Color.RED);
		lblNewLabel_10.setBounds(291, 148, 207, 15);
		panel_3.add(lblNewLabel_10);
		
		JButton borrowBookMain = new JButton("借阅书籍");
		borrowBookMain.setBounds(-1, 10, 103, 23);
//		borrowBookMain.setBorder(BorderFactory.createRaisedBevelBorder());
		contentPane.add(borrowBookMain);
		
		JButton returnBookMain = new JButton("所借书籍");
		returnBookMain.setBounds(-1, 38, 103, 23);
//		returnBookMain.setBorder(BorderFactory.createRaisedBevelBorder());
//		returnBookMain.setBorder(BorderFactory.createEtchedBorder(Color.black, Color.gray));
		contentPane.add(returnBookMain);
		
		JButton sharedBookMain = new JButton("共享书籍");
//		sharedBookMain.setBorder(BorderFactory.createRaisedBevelBorder());
		sharedBookMain.setBounds(-1, 71, 103, 23);
		contentPane.add(sharedBookMain);
		
		JButton updatePWMain = new JButton("修改密码");
//		updatePWMain.setBorder(BorderFactory.createRaisedBevelBorder());
		updatePWMain.setBounds(-1, 104, 103, 23);
		contentPane.add(updatePWMain);
		
		
		
		
	   /*
	    * 为组建注册监听的方法
	    * */
	   //panel_card的通过按钮转换界面
	   CardSwitchListenner cs=new CardSwitchListenner(this);
	   borrowBookMain.addActionListener(cs);
	   returnBookMain.addActionListener(cs);
	   sharedBookMain.addActionListener(cs);
	   updatePWMain.addActionListener(cs);
	   
	   //Preemption_Card的通过按钮转换界面
	   Preemption_CardSwitchListenner pcl=new Preemption_CardSwitchListenner(this);
	   borrowBookPremption.addActionListener(pcl);
	   selectMyBookPremption.addActionListener(pcl);
	   
	   //Preemption_Card的按钮注册监听器
	   BorrowBookListenner bl=new BorrowBookListenner(this);
	   preemption_Button.addActionListener(bl);
	   selectValue.addActionListener(bl);
	   //设置取消预借的监听器
	   PreemptionListnner pl=new PreemptionListnner(this);
	   cannel_Borrow.addActionListener(pl);
	   //设置sharedButton,cancelShared的监听器
	   SharedViewListener svl=new SharedViewListener(this);
	   sharedButton.addActionListener(svl);
	   cancelShared.addActionListener(svl);
	   //设置book_Name_comboBox的监听器
	   BookNameComboBoxListener bcl=new BookNameComboBoxListener(this);
	   book_Name_comboBox.addActionListener(bcl);
	   //设置location_comboBox的监听器
	   LocationComboBoxListener lcl=new LocationComboBoxListener(this);
	   location_comboBox.addActionListener(lcl);
       //设置tabbedPane的监听器
	   SharedViewListener1 svl1=new SharedViewListener1(this);
	   tabbedPane.addChangeListener(svl1);
	   
	   //设置textField3的监听
	   UpdateMouseListener uml=new UpdateMouseListener(this);
	   textField_4.addMouseListener(uml);
//	   UpdateMouseListener1 uml1=new UpdateMouseListener1();
//	   textField_5.addMouseListener(uml1);
	   
	   //设置btnNewButton的监听
	   UpdatePassWordListener upl=new UpdatePassWordListener(this);
	   btnNewButton.addActionListener(upl);
	   
	   
	   
	   
	   RenewBookListener bookListener=new RenewBookListener(this);
	   remand_Book.addActionListener(bookListener);
	   
	   
	   
	   
	   
	   //设置窗口为可见
	   super.setVisible(true);
	   //设置窗口居中
	   super.setLocationRelativeTo(null);
	   //设置窗口不可以改变大小
	   super.setResizable(false);
	   //设置窗口能够正常关闭，通过按钮
	   super.setDefaultCloseOperation (JFrame.DO_NOTHING_ON_CLOSE);
		//为窗口设置一个监听，用来提醒用户是否关闭系统
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing ( WindowEvent e ){
				int showNum=JOptionPane.showConfirmDialog(null, "是否关闭系统", "友情提示", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
				if(showNum==JOptionPane.YES_OPTION){
					System.exit(0);
				}else{
					return;
				}
			}
		});
	}
	/**
	 * 用于设置下拉框的值
	 * 
	 * @author ZouXin
	 * 2017-3-27
	 */
    public  void comboBoxAdd(){
    	MainViewDao dao=new MainViewDao();
    	String sql="select * from Book_Type_Table";
    	List<BookTypeVo> list=dao.getType(sql,BookTypeVo.class);
    	if(list!=null){
    		for(int i=0;i<list.size();i++){
    			comboBox.addItem(list.get(i).getBook_Type_Name());
    		}
    	}
    }
    /**
	 * 用于设置library_combobox下拉框的值,
	 * 
	 * @author ZouXin
	 * 2017-3-27
	 */
    public  void comboBoxAdd_Li(){
    	MainViewDao dao=new MainViewDao();
    	String sql="select bit.book_name||'_'||bit.book_number as book_name from book_information_table bit";
    	List<BookInformaticaVo> list=dao.getType(sql,BookInformaticaVo.class);
    	if(list!=null){
    		for(int i=0;i<list.size();i++){
    			book_Name_comboBox.addItem(list.get(i).getBook_Name());
    		}
    	}
    }
    /**
     * 用于给一个table设置列名
     * @param Object[] 列名的值
     * @author ZouXin
     * 2017-3-27
     */
    public void tableAddcolunmName(JTable table,Object[] cloumnNames){
    	Object[][] ob=new Object[][]{};
//    	Object[] cloumnNames=new Object[]{"图书馆","库室","库位","书名","剩余数量","书籍类型","作者","单价","条形码","出版社","书籍编号"};//列名
    	DefaultTableModel model=new DefaultTableModel(ob,cloumnNames);
    	table.setModel(model);
    }
    public void table_3Add(JTable table){
    	MainViewDao dao=new MainViewDao();
    	Object[][] ob=dao.getBorrow();
    	Object[] cloumnNames=new Object[]{"书籍名称","数量","借书时间","归还时间","图书馆","库室","库位","书籍编号","编号","库位编号"};
//    	Object[] cloumnNames=new Object[]{"图书馆","库室","库位","书名","剩余数量","书籍类型","作者","单价","条形码","出版社","书籍编号"};//列名
    	DefaultTableModel model=new DefaultTableModel(ob,cloumnNames);
    	table.setModel(model);
    }
	public JRadioButton getRdbtnNewRadioButton() {
		return rdbtnNewRadioButton;
	}

	public void setRdbtnNewRadioButton(JRadioButton rdbtnNewRadioButton) {
		this.rdbtnNewRadioButton = rdbtnNewRadioButton;
	}



	public MyTable getTable() {
		return table;
	}

	public void setTable(MyTable table) {
		this.table = table;
	}

	public JComboBox getComboBox() {
		return comboBox;
	}

	public void setComboBox(JComboBox comboBox) {
		this.comboBox = comboBox;
	}

	public CardLayout getCard() {
		return card;
	}

	public void setCard(CardLayout card) {
		this.card = card;
	}

	public JPanel getPanel_Card() {
		return panel_Card;
	}

	public void setPanel_Card(JPanel panel_Card) {
		this.panel_Card = panel_Card;
	}

	public JPanel getPreemption_Card() {
		return preemption_Card;
	}

	public void setPreemption_Card(JPanel preemption_Card) {
		this.preemption_Card = preemption_Card;
	}

	public CardLayout getPreemption_Card_card() {
		return preemption_Card_card;
	}

	public void setPreemption_Card_card(CardLayout preemption_Card_card) {
		this.preemption_Card_card = preemption_Card_card;
	}

	public JTextField getTextField() {
		return textField;
	}

	public void setTextField(JTextField textField) {
		this.textField = textField;
	}

	public JTextField getTextField_1() {
		return textField_1;
	}

	public void setTextField_1(JTextField textField_1) {
		this.textField_1 = textField_1;
	}

	public JButton getSelectValue() {
		return selectValue;
	}

	public void setSelectValue(JButton selectValue) {
		this.selectValue = selectValue;
	}

	public JComboBox getLocation_comboBox() {
		return location_comboBox;
	}

	public void setLocation_comboBox(JComboBox location_comboBox) {
		this.location_comboBox = location_comboBox;
	}

	public JComboBox getBook_Name_comboBox() {
		return book_Name_comboBox;
	}

	public void setBook_Name_comboBox(JComboBox book_Name_comboBox) {
		this.book_Name_comboBox = book_Name_comboBox;
	}

	public JTextField getTextField_2() {
		return textField_2;
	}

	public void setTextField_2(JTextField textField_2) {
		this.textField_2 = textField_2;
	}

	public JComboBox getLibrary_Combobox() {
		return library_Combobox;
	}

	public void setLibrary_Combobox(JComboBox library_Combobox) {
		this.library_Combobox = library_Combobox;
	}

	public JComboBox getLibrary_Room_Combobox() {
		return library_Room_Combobox;
	}

	public void setLibrary_Room_Combobox(JComboBox library_Room_Combobox) {
		this.library_Room_Combobox = library_Room_Combobox;
	}

	public MyTable getTable_1() {
		return table_1;
	}

	public void setTable_1(MyTable table_1) {
		this.table_1 = table_1;
	}

	public MyTable getTable_2() {
		return table_2;
	}

	public void setTable_2(MyTable table_2) {
		this.table_2 = table_2;
	}

	public MyTable getTable_3() {
		return table_3;
	}

	public void setTable_3(MyTable table_3) {
		this.table_3 = table_3;
	}

	public JTabbedPane getTabbedPane() {
		return tabbedPane;
	}

	public void setTabbedPane(JTabbedPane tabbedPane) {
		this.tabbedPane = tabbedPane;
	}

	public MyTable getTable_4() {
		return table_4;
	}

	public void setTable_4(MyTable table_4) {
		this.table_4 = table_4;
	}

	public JTextField getTextField_3() {
		return textField_3;
	}

	public void setTextField_3(JTextField textField_3) {
		this.textField_3 = textField_3;
	}

	public JTextField getTextField_4() {
		return textField_4;
	}

	public void setTextField_4(JTextField textField_4) {
		this.textField_4 = textField_4;
	}

	public JTextField getTextField_5() {
		return textField_5;
	}

	public void setTextField_5(JTextField textField_5) {
		this.textField_5 = textField_5;
	}

	public JLabel getLblNewLabel_9() {
		return lblNewLabel_9;
	}

	public void setLblNewLabel_9(JLabel lblNewLabel_9) {
		this.lblNewLabel_9 = lblNewLabel_9;
	}

	public JLabel getLblNewLabel_10() {
		return lblNewLabel_10;
	}

	public void setLblNewLabel_10(JLabel lblNewLabel_10) {
		this.lblNewLabel_10 = lblNewLabel_10;
	}
	
}
