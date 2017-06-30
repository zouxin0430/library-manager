/**
 * 
 */
package zouxin.library.view;

import java.awt.BorderLayout;

import java.awt.EventQueue;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.net.URL;

import javax.swing.ButtonGroup;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;

import zouxin.library.Listen.GeneralMethod;
import zouxin.library.Listen.TeacherMainViewListener;
import zouxin.library.vo.StorageUserInVo;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JTextArea;

import com.library.listenIDUS.AddManagerListener;
import com.library.listenIDUS.ShareAndBorrowListener;
import com.library.listenIDUS.TeacherBookListener;
import com.library.listenIDUS.TeacherLibrarayListener;
import com.library.listenIDUS.TeacherLocationListener;
import com.library.listenIDUS.TeacherRoomListener;
import com.library.listenIDUS.TeacherStoreListener;
import com.library.listenIDUS.TeacherTypeListener;
import com.library.listenIDUS.UpdateMPassWordListener;
import com.library.listenIDUS.UpdateManagerMouseListener;

import javax.swing.JRadioButton;
import java.awt.Color;

/**
 * @author ZouXin
 *2017-3-29
 */
public class TeacherMainView extends JFrame {

	private JPanel contentPane;
	public JTable table;
	public JTextField textField;
	public JComboBox comboBox;
	public JTextField textField_1;
	public JTable table_1;
	public JTextField textField_2;
	public JTextField textField_3;
	public JButton btnNewButton;
	public JTextField textField_4;
	public JTextField textField_5;
	public JTable table_2;
	public JTable table_3;
	public JTable table_4;
	public JTextField textField_6;
	public JTable table_5;
	public JTextField textField_7;
	public JTextField textField_8;
	public JTable table_6;
	public JButton librarySelect;
	public JButton roomSelect;
    public JButton locationSelect;
    public JButton bookSelect;
    public JButton typeSelect;
    public JTextField textField_9;
    public JTable table_7;
    public JTextField textField_10;
    public JTextField textField_11;
    public JTextField textField_12;
    public JTextField textField_13;
    public JTextField textField_14;
    public JTextField textField_15;
    public JTextField textField_16;
    public JTextField textField_17;
    public JTextField textField_18;
    public JRadioButton radioMan;
    public JRadioButton radioWuman;
    public JLabel lblNewLabel_14;
    public JLabel lblNewLabel_15;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TeacherMainView frame = new TeacherMainView();
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
	public TeacherMainView() {
		super.setTitle("欢迎"+StorageUserInVo.userId+"  "+StorageUserInVo.userName+"使用本系统");
		setBounds(100, 100, 842, 486);
//		JTabbedPane pane=new JTabbedPane();
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
//		ImageIcon image=new ImageIcon("yun.jpg");
//		ImageIcon image=new ImageIcon("C:\\Users\\tangzhou\\Desktop\\myImage\\yun.png");
		ImageIcon image1=GeneralMethod.createImage("/images/yun.jpg");
//		ImageIcon img = new ImageIcon("yun.jpg");
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.LEFT);
		tabbedPane.setBounds(10, 10, 806, 428);
		contentPane.add(tabbedPane);
		//u=3576249421,3453762612&fm=21&gp=0.jpg
		JPanel panel = new JPanel();
		tabbedPane.addTab("处理事务", null, panel, "处理学生的请求");
		panel.setLayout(null);
		
		table = new JTable();
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		JScrollPane scrollPane = new JScrollPane(table,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollPane.setBounds(0, 64, 737, 306);
		panel.add(scrollPane);
		scrollPane.setViewportView(table);
		
		textField = new JTextField();
		textField.setBounds(52, 22, 169, 21);
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("学号");
		lblNewLabel.setBounds(10, 25, 54, 15);
		panel.add(lblNewLabel);
		
		btnNewButton = new JButton("查询");
		btnNewButton.setBounds(580, 21, 93, 23);
		panel.add(btnNewButton);
		
		JLabel lblNewLabel_1 = new JLabel("类型");
		lblNewLabel_1.setBounds(252, 25, 54, 15);
		panel.add(lblNewLabel_1);
		
		comboBox = new JComboBox();
		comboBox.addItem("");
		comboBox.addItem("学生借阅书籍");
		comboBox.addItem("学生共享书籍");
		comboBox.setBounds(316, 22, 177, 21);
		panel.add(comboBox);
		
		JButton btnNewButton_1 = new JButton("确认");
		btnNewButton_1.setBounds(634, 380, 93, 23);
		panel.add(btnNewButton_1);
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("信息管理", null, panel_1, "添加图书，图书馆，库室，库位信息，图书类型信息");
		panel_1.setLayout(null);
		
		JTabbedPane tabbedPane_1 = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane_1.setBounds(0, 0, 737, 423);
		panel_1.add(tabbedPane_1);
		
		JPanel addLibrary = new JPanel();
		tabbedPane_1.addTab("图书馆信息", null, addLibrary, "图书馆信息的增删改查");
		addLibrary.setLayout(null);
		table_1 = new JTable();
		tableAddcolunmName(table_1, new Object[]{"图书馆编号","名称","位置","介绍","服务内容","馆藏类型"});
	//	table_1.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		JScrollPane scrollPane_1 = new JScrollPane(table_1,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		//scrollPane_1.setViewportView(table_1);
		scrollPane_1.setBounds(10, 62, 712, 245);
		addLibrary.add(scrollPane_1);
		
		
		
		
		JLabel lblNewLabel_2 = new JLabel("图书馆名称:");
		lblNewLabel_2.setBounds(35, 20, 109, 18);
		addLibrary.add(lblNewLabel_2);
		
		textField_1 = new JTextField();
		textField_1.setBounds(219, 19, 182, 21);
		addLibrary.add(textField_1);
		textField_1.setColumns(10);
		
		librarySelect = new JButton("librarySelect");
		librarySelect.setBounds(542, 20, 133, 23);
		addLibrary.add(librarySelect);
		
		JButton libraryAdd = new JButton("libraryAdd");
		libraryAdd.setBounds(35, 336, 93, 23);
		addLibrary.add(libraryAdd);
		
		JButton libraryUpdate = new JButton("libraryUpdate");
		libraryUpdate.setBounds(297, 336, 126, 23);
		addLibrary.add(libraryUpdate);
		
		JButton libraryDelete = new JButton("libraryDelete");
		libraryDelete.setBounds(555, 336, 116, 23);
		addLibrary.add(libraryDelete);
		
		JPanel addRoom = new JPanel();
		tabbedPane_1.addTab("库室信息", null, addRoom, "对库室信息进行增删改查");
		addRoom.setLayout(null);
		
		table_2 = new JTable();
//		table_2.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		JScrollPane scrollPane_2 = new JScrollPane(table_2,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollPane_2.setViewportView(table_2);
		scrollPane_2.setBounds(10, 53, 712, 247);
		addRoom.add(scrollPane_2);
		
		
		
		
		JLabel lblNewLabel_3 = new JLabel("库室名称");
		lblNewLabel_3.setBounds(34, 20, 101, 15);
		addRoom.add(lblNewLabel_3);
		
		textField_2 = new JTextField();
		textField_2.setBounds(201, 17, 168, 21);
		addRoom.add(textField_2);
		textField_2.setColumns(10);
		
		roomSelect = new JButton("roomSelect");
		roomSelect.setBounds(559, 16, 93, 23);
		addRoom.add(roomSelect);
		
		JButton roomAdd = new JButton("roomAdd");
		roomAdd.setBounds(42, 336, 93, 23);
		addRoom.add(roomAdd);
		
		JButton roomUpdate = new JButton("roomUpdate");
		roomUpdate.setBounds(323, 336, 115, 23);
		addRoom.add(roomUpdate);
		
		JButton roomDelete = new JButton("roomDelete");
		roomDelete.setBounds(585, 336, 93, 23);
		addRoom.add(roomDelete);
		
		JPanel addLocation = new JPanel();
		tabbedPane_1.addTab("库位信息", null, addLocation, "库位信息的增删改查");
		addLocation.setLayout(null);
		
		table_3 = new JTable();
		JScrollPane scrollPane_3 = new JScrollPane(table_3,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollPane_3.setViewportView(table_3);
		scrollPane_3.setBounds(10, 58, 712, 263);
		addLocation.add(scrollPane_3);
		
		
		
		
		JLabel lblNewLabel_4 = new JLabel("库位名称");
		lblNewLabel_4.setBounds(47, 22, 54, 15);
		addLocation.add(lblNewLabel_4);
		
		textField_3 = new JTextField();
		textField_3.setBounds(138, 19, 159, 21);
		addLocation.add(textField_3);
		textField_3.setColumns(10);
		
	    locationSelect = new JButton("locationSelect");
		locationSelect.setBounds(537, 18, 130, 23);
		addLocation.add(locationSelect);
		
		JButton locationAdd = new JButton("locationAdd");
		locationAdd.setBounds(45, 343, 113, 23);
		addLocation.add(locationAdd);
		
		JButton locationUpdate = new JButton("locationUpdate");
		locationUpdate.setBounds(280, 343, 125, 23);
		addLocation.add(locationUpdate);
		
		JButton locationDelete = new JButton("locationDelete");
		locationDelete.setBounds(548, 343, 125, 23);
		addLocation.add(locationDelete);
		
		JPanel addBook = new JPanel();
		tabbedPane_1.addTab("书籍信息", null, addBook, "对书籍信息进行增删改查操作");
		addBook.setLayout(null);
		
		table_4 = new JTable();
		JScrollPane scrollPane_4 = new JScrollPane(table_4,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollPane_4.setViewportView(table_4);
		scrollPane_4.setBounds(10, 78, 712, 222);
		addBook.add(scrollPane_4);
		
		
		
		
		textField_4 = new JTextField();
		textField_4.setBounds(86, 10, 146, 21);
		addBook.add(textField_4);
		textField_4.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("书籍编号");
		lblNewLabel_5.setBounds(22, 13, 54, 15);
		addBook.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("书籍名称");
		lblNewLabel_6.setBounds(288, 13, 54, 15);
		addBook.add(lblNewLabel_6);
		
		textField_5 = new JTextField();
		textField_5.setBounds(352, 10, 146, 21);
		addBook.add(textField_5);
		textField_5.setColumns(10);
		
	    bookSelect = new JButton("bookSelect");
		bookSelect.setBounds(611, 45, 93, 23);
		addBook.add(bookSelect);
		
		JButton bookAdd = new JButton("bookAdd");
		bookAdd.setBounds(59, 335, 93, 23);
		addBook.add(bookAdd);
		
		JButton bookUpdate = new JButton("bookUpdate");
		bookUpdate.setBounds(279, 335, 110, 23);
		addBook.add(bookUpdate);
		
		JButton bookDelete = new JButton("bookDelete");
		bookDelete.setBounds(545, 335, 93, 23);
		addBook.add(bookDelete);
		
		JPanel addBookType = new JPanel();
		tabbedPane_1.addTab("书籍类型信息", null, addBookType, "对书籍类型进行增删改查操作");
		addBookType.setLayout(null);
		
		
		table_5 = new JTable();
		JScrollPane scrollPane_5 = new JScrollPane(table_5,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollPane_5.setViewportView(table_5);
		scrollPane_5.setBounds(10, 76, 712, 237);
		addBookType.add(scrollPane_5);
		
		
		
		
		JLabel lblNewLabel_7 = new JLabel("类型名称");
		lblNewLabel_7.setBounds(34, 26, 54, 15);
		addBookType.add(lblNewLabel_7);
		
		textField_6 = new JTextField();
		textField_6.setBounds(151, 23, 130, 21);
		addBookType.add(textField_6);
		textField_6.setColumns(10);
		
		typeSelect = new JButton("typeSelect");
		typeSelect.setBounds(518, 22, 93, 23);
		addBookType.add(typeSelect);
		
		JButton typeAdd = new JButton("typeAdd");
		typeAdd.setBounds(34, 345, 93, 23);
		addBookType.add(typeAdd);
		
		JButton typeUpdate = new JButton("typeUpdate");
		typeUpdate.setBounds(259, 345, 93, 23);
		addBookType.add(typeUpdate);
		
		JButton typeDelete = new JButton("typeDelete");
		typeDelete.setBounds(518, 345, 93, 23);
		addBookType.add(typeDelete);
		
		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("库存管理", null, panel_2, "入库,出库,查看库存");
		panel_2.setLayout(null);
		
		table_6 = new JTable();
		table_6.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		JScrollPane scrollPane_6 = new JScrollPane(table_6,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollPane_6.setViewportView(table_6);
		scrollPane_6.setBounds(10, 90, 717, 264);
		panel_2.add(scrollPane_6);
		
		
		JLabel lblNewLabel_8 = new JLabel("书籍编号");
		lblNewLabel_8.setBounds(10, 27, 97, 15);
		panel_2.add(lblNewLabel_8);
		
		textField_7 = new JTextField();
		textField_7.setBounds(117, 24, 137, 21);
		panel_2.add(textField_7);
		textField_7.setColumns(10);
		
		JLabel lblNewLabel_9 = new JLabel("书籍名称");
		lblNewLabel_9.setBounds(290, 27, 54, 15);
		panel_2.add(lblNewLabel_9);
		
		textField_8 = new JTextField();
		textField_8.setBounds(402, 24, 124, 21);
		panel_2.add(textField_8);
		textField_8.setColumns(10);
		
		JButton selectStore = new JButton("selectStore");
		selectStore.setBounds(622, 58, 93, 23);
		panel_2.add(selectStore);
		
		JButton outStore = new JButton("outStore");
		outStore.setBounds(181, 379, 93, 23);
		panel_2.add(outStore);
		
		JButton inStore = new JButton("inStore");
		inStore.setBounds(500, 379, 93, 23);
		panel_2.add(inStore);
		
		JPanel panel_3 = new JPanel();
		tabbedPane.addTab("借阅管理", null, panel_3, "查看学生所借书籍，以及处理还书操作");
		panel_3.setLayout(null);
		
		table_7 = new JTable();
		table_7.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		JScrollPane scrollPane_7 = new JScrollPane(table_7,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollPane_7.setViewportView(table_7);
		scrollPane_7.setBounds(10, 62, 717, 282);
		panel_3.add(scrollPane_7);
		
		
	
		
		textField_9 = new JTextField();
		textField_9.setBounds(141, 23, 145, 21);
		panel_3.add(textField_9);
		textField_9.setColumns(10);
		
		JLabel lblNewLabel_10 = new JLabel("学生学号");
		lblNewLabel_10.setBounds(38, 26, 54, 15);
		panel_3.add(lblNewLabel_10);
		
		JButton borrowSelect = new JButton("borrowSelect");
		borrowSelect.setBounds(546, 22, 122, 23);
		panel_3.add(borrowSelect);
		
		JButton borrowOk = new JButton("borrowOk");
		borrowOk.setBounds(604, 374, 93, 23);
		panel_3.add(borrowOk);
		
		JPanel panel_4 = new JPanel();
		tabbedPane.addTab("管理员", null, panel_4, "管理管理人信息");
		panel_4.setLayout(null);
		
		JTabbedPane tabbedPane_2 = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane_2.setBounds(10, 10, 717, 403);
		panel_4.add(tabbedPane_2);
		
		JPanel panel_5 = new JPanel();
		tabbedPane_2.addTab("添加管理员", null, panel_5, "超级管理员才有的权限");
		panel_5.setLayout(null);
		
		textField_10 = new JTextField();
		textField_10.setBounds(181, 31, 164, 21);
		panel_5.add(textField_10);
		textField_10.setColumns(10);
		
		JLabel lblNewLabel_11 = new JLabel("账号");
		lblNewLabel_11.setBounds(78, 34, 54, 15);
		panel_5.add(lblNewLabel_11);
		
		JLabel label = new JLabel("姓名");
		label.setBounds(78, 85, 54, 15);
		panel_5.add(label);
		
		JLabel label_1 = new JLabel("年龄");
		label_1.setBounds(78, 147, 54, 15);
		panel_5.add(label_1);
		
		JLabel label_2 = new JLabel("身份证号");
		label_2.setBounds(78, 217, 54, 15);
		panel_5.add(label_2);
		
		JLabel label_3 = new JLabel("密码");
		label_3.setBounds(408, 34, 54, 15);
		panel_5.add(label_3);
		
		textField_11 = new JTextField();
		textField_11.setColumns(10);
		textField_11.setBounds(504, 31, 164, 21);
		panel_5.add(textField_11);
		
		textField_12 = new JTextField();
		textField_12.setColumns(10);
		textField_12.setBounds(181, 82, 164, 21);
		panel_5.add(textField_12);
		
	    radioMan = new JRadioButton("男");
	    radioMan.setBounds(504, 81, 54, 23);
		panel_5.add(radioMan);
		
		JLabel label_4 = new JLabel("性别");
		label_4.setBounds(408, 85, 54, 15);
		panel_5.add(label_4);
		
		radioWuman = new JRadioButton("女");
		radioWuman.setBounds(614, 81, 54, 23);
		panel_5.add(radioWuman);
		//实现单选效果
		ButtonGroup group = new ButtonGroup();
		group.add(radioMan);
		group.add(radioWuman);
		
		textField_13 = new JTextField();
		textField_13.setColumns(10);
		textField_13.setBounds(181, 144, 164, 21);
		panel_5.add(textField_13);
		
		textField_14 = new JTextField();
		textField_14.setColumns(10);
		textField_14.setBounds(181, 214, 164, 21);
		panel_5.add(textField_14);
		
		JButton AddManager = new JButton("addManager");
		AddManager.setBounds(127, 299, 105, 23);
		panel_5.add(AddManager);
		
		JButton cancelAdd = new JButton("resetAdd");
		cancelAdd.setBounds(433, 299, 112, 23);
		panel_5.add(cancelAdd);
		
		JLabel lblNewLabel_13 = new JLabel("联系方式");
		lblNewLabel_13.setBounds(408, 147, 54, 15);
		panel_5.add(lblNewLabel_13);
		
		textField_18 = new JTextField();
		textField_18.setColumns(10);
		textField_18.setBounds(504, 144, 164, 21);
		panel_5.add(textField_18);
		
		JPanel panel_6 = new JPanel();
		tabbedPane_2.addTab("密码修改", null, panel_6, "修改密码");
		panel_6.setLayout(null);
		
		textField_15 = new JTextField();
		textField_15.setBounds(309, 53, 163, 21);
		panel_6.add(textField_15);
		textField_15.setColumns(10);
		
		JLabel lblNewLabel_12 = new JLabel("旧密码");
		lblNewLabel_12.setBounds(199, 56, 75, 15);
		panel_6.add(lblNewLabel_12);
		
		JLabel label_5 = new JLabel("新密码");
		label_5.setBounds(199, 133, 75, 15);
		panel_6.add(label_5);
		
		JLabel label_6 = new JLabel("确认密码");
		label_6.setBounds(199, 222, 75, 15);
		panel_6.add(label_6);
		
		textField_16 = new JTextField();
		textField_16.setColumns(10);
		textField_16.setBounds(309, 130, 163, 21);
		panel_6.add(textField_16);
		
		textField_17 = new JTextField();
		textField_17.setColumns(10);
		textField_17.setBounds(309, 219, 163, 21);
		panel_6.add(textField_17);
		
		JButton UpdatePW = new JButton("updatePW");
		UpdatePW.setBounds(199, 301, 118, 23);
		panel_6.add(UpdatePW);
		
		JButton cancelUpdate = new JButton("resetUpdate");
		cancelUpdate.setBounds(379, 301, 118, 23);
		panel_6.add(cancelUpdate);
		
	    lblNewLabel_14 = new JLabel("");
	    lblNewLabel_14.setForeground(Color.RED);
		lblNewLabel_14.setBounds(482, 56, 203, 15);
		panel_6.add(lblNewLabel_14);
		
	    lblNewLabel_15 = new JLabel("");
	    lblNewLabel_15.setForeground(Color.RED);
		lblNewLabel_15.setBounds(482, 222, 163, 15);
		panel_6.add(lblNewLabel_15);
		
		
		
		
		TeacherMainViewListener tmv=new TeacherMainViewListener(this);
		btnNewButton.addActionListener(tmv);
		btnNewButton_1.addActionListener(tmv);
		
		//图书馆管理监听
		TeacherLibrarayListener tll=new TeacherLibrarayListener(this);
		libraryAdd.addActionListener(tll);
		libraryDelete.addActionListener(tll);
		libraryUpdate.addActionListener(tll);
		librarySelect.addActionListener(tll);
		
		//库室管理监听
		TeacherRoomListener trl=new TeacherRoomListener(this);
		roomAdd.addActionListener(trl);
		roomDelete.addActionListener(trl);
		roomSelect.addActionListener(trl);
		roomUpdate.addActionListener(trl);
		
	//库位管理监听
	   TeacherLocationListener tl=new TeacherLocationListener(this);
	   locationAdd.addActionListener(tl);
	   locationDelete.addActionListener(tl);
	   locationSelect.addActionListener(tl);
	   locationUpdate.addActionListener(tl);
	
	   
	   //图书管理监听
	   TeacherBookListener tbl=new TeacherBookListener(this);
	   bookAdd.addActionListener(tbl);
	   bookDelete.addActionListener(tbl);
	   bookUpdate.addActionListener(tbl);
	   bookSelect.addActionListener(tbl);
	   
	   //图书类型管理监听
	   TeacherTypeListener btl=new TeacherTypeListener(this);
	   typeAdd.addActionListener(btl);
	   typeUpdate.addActionListener(btl);
	   typeSelect.addActionListener(btl);
	   typeDelete.addActionListener(btl);
	
	   //库存管理监听
	   TeacherStoreListener tsl=new TeacherStoreListener(this);
	   selectStore.addActionListener(tsl);
	   inStore.addActionListener(tsl);
	   outStore.addActionListener(tsl);
		
	   //设置添加管理员的监听
	   AddManagerListener al=new AddManagerListener(this);
	   AddManager.addActionListener(al);
	   cancelAdd.addActionListener(al);
	   
	   //设置修改密码的监听
	   UpdateManagerMouseListener ul=new UpdateManagerMouseListener(this);
	   textField_16.addMouseListener(ul);
	   
	   UpdateMPassWordListener uml=new UpdateMPassWordListener(this);
	   UpdatePW.addActionListener(uml);
	   cancelUpdate.addActionListener(uml);
	   
	   
	   //设置处理学生取回共享数据和还书的监听
	   ShareAndBorrowListener sabl=new ShareAndBorrowListener(this);
	   borrowSelect.addActionListener(sabl);
	   borrowOk.addActionListener(sabl);
	   
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
	 public void tableAddcolunmName(JTable table,Object[] cloumnNames){
	    	Object[][] ob=new Object[][]{};
//	    	Object[] cloumnNames=new Object[]{"图书馆","库室","库位","书名","剩余数量","书籍类型","作者","单价","条形码","出版社","书籍编号"};//列名
	    	DefaultTableModel model=new DefaultTableModel(ob,cloumnNames);
	    	table.setModel(model);
	    }
	public JTable getTable() {
		return table;
	}

	public void setTable(JTable table) {
		this.table = table;
	}

	public JTextField getTextField() {
		return textField;
	}

	public void setTextField(JTextField textField) {
		this.textField = textField;
	}

	public JComboBox getComboBox() {
		return comboBox;
	}

	public void setComboBox(JComboBox comboBox) {
		this.comboBox = comboBox;
	}

	public JButton getBtnNewButton() {
		return btnNewButton;
	}

	public void setBtnNewButton(JButton btnNewButton) {
		this.btnNewButton = btnNewButton;
	}

	public JTextField getTextField_1() {
		return textField_1;
	}

	public void setTextField_1(JTextField textField_1) {
		this.textField_1 = textField_1;
	}

	public JTable getTable_1() {
		return table_1;
	}

	public void setTable_1(JTable table_1) {
		this.table_1 = table_1;
	}

	public JTextField getTextField_2() {
		return textField_2;
	}

	public void setTextField_2(JTextField textField_2) {
		this.textField_2 = textField_2;
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

	public JTable getTable_2() {
		return table_2;
	}

	public void setTable_2(JTable table_2) {
		this.table_2 = table_2;
	}

	public JTable getTable_3() {
		return table_3;
	}

	public void setTable_3(JTable table_3) {
		this.table_3 = table_3;
	}

	public JTable getTable_4() {
		return table_4;
	}

	public void setTable_4(JTable table_4) {
		this.table_4 = table_4;
	}

	public JTextField getTextField_6() {
		return textField_6;
	}

	public void setTextField_6(JTextField textField_6) {
		this.textField_6 = textField_6;
	}

	public JTable getTable_5() {
		return table_5;
	}

	public void setTable_5(JTable table_5) {
		this.table_5 = table_5;
	}

	public JTextField getTextField_7() {
		return textField_7;
	}

	public void setTextField_7(JTextField textField_7) {
		this.textField_7 = textField_7;
	}

	public JTextField getTextField_8() {
		return textField_8;
	}

	public void setTextField_8(JTextField textField_8) {
		this.textField_8 = textField_8;
	}

	public JTable getTable_6() {
		return table_6;
	}

	public void setTable_6(JTable table_6) {
		this.table_6 = table_6;
	}

	public JButton getLibrarySelect() {
		return librarySelect;
	}

	public void setLibrarySelect(JButton librarySelect) {
		this.librarySelect = librarySelect;
	}

	public JButton getRoomSelect() {
		return roomSelect;
	}

	public void setRoomSelect(JButton roomSelect) {
		this.roomSelect = roomSelect;
	}

	public JButton getLocationSelect() {
		return locationSelect;
	}

	public void setLocationSelect(JButton locationSelect) {
		this.locationSelect = locationSelect;
	}

	public JButton getBookSelect() {
		return bookSelect;
	}

	public void setBookSelect(JButton bookSelect) {
		this.bookSelect = bookSelect;
	}

	public JButton getTypeSelect() {
		return typeSelect;
	}

	public void setTypeSelect(JButton typeSelect) {
		this.typeSelect = typeSelect;
	}

	public JTextField getTextField_9() {
		return textField_9;
	}

	public void setTextField_9(JTextField textField_9) {
		this.textField_9 = textField_9;
	}

	public JTable getTable_7() {
		return table_7;
	}

	public void setTable_7(JTable table_7) {
		this.table_7 = table_7;
	}

	public JTextField getTextField_10() {
		return textField_10;
	}

	public void setTextField_10(JTextField textField_10) {
		this.textField_10 = textField_10;
	}

	public JTextField getTextField_11() {
		return textField_11;
	}

	public void setTextField_11(JTextField textField_11) {
		this.textField_11 = textField_11;
	}

	public JTextField getTextField_12() {
		return textField_12;
	}

	public void setTextField_12(JTextField textField_12) {
		this.textField_12 = textField_12;
	}

	public JTextField getTextField_13() {
		return textField_13;
	}

	public void setTextField_13(JTextField textField_13) {
		this.textField_13 = textField_13;
	}

	public JTextField getTextField_14() {
		return textField_14;
	}

	public void setTextField_14(JTextField textField_14) {
		this.textField_14 = textField_14;
	}

	public JTextField getTextField_15() {
		return textField_15;
	}

	public void setTextField_15(JTextField textField_15) {
		this.textField_15 = textField_15;
	}

	public JTextField getTextField_16() {
		return textField_16;
	}

	public void setTextField_16(JTextField textField_16) {
		this.textField_16 = textField_16;
	}

	public JTextField getTextField_17() {
		return textField_17;
	}

	public void setTextField_17(JTextField textField_17) {
		this.textField_17 = textField_17;
	}

	public JTextField getTextField_18() {
		return textField_18;
	}

	public void setTextField_18(JTextField textField_18) {
		this.textField_18 = textField_18;
	}

	public JRadioButton getRadioMan() {
		return radioMan;
	}

	public void setRadioMan(JRadioButton radioMan) {
		this.radioMan = radioMan;
	}

	public JRadioButton getRadioWuman() {
		return radioWuman;
	}

	public void setRadioWuman(JRadioButton radioWuman) {
		this.radioWuman = radioWuman;
	}

	public JLabel getLblNewLabel_14() {
		return lblNewLabel_14;
	}

	public void setLblNewLabel_14(JLabel lblNewLabel_14) {
		this.lblNewLabel_14 = lblNewLabel_14;
	}

	public JLabel getLblNewLabel_15() {
		return lblNewLabel_15;
	}

	public void setLblNewLabel_15(JLabel lblNewLabel_15) {
		this.lblNewLabel_15 = lblNewLabel_15;
	}
	
}
