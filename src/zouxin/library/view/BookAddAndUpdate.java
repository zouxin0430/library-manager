/**
 * 
 */
package zouxin.library.view;

import java.awt.BorderLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.EventQueue;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;

import com.library.listenIDUS.BookAddAndUpdateListener;

import zouxin.library.dao.MainViewDao;
import zouxin.library.vo.BookTypeVo;

/**
 * @author ZouXin
 *2017-5-11
 */
public class BookAddAndUpdate extends JFrame {

	private JPanel contentPane;
	public JTextField textField;
	public JTextField textField_2;
	public JTextField textField_3;
	public JTextField textField_4;
	public JTextField textField_5;
	public JTextField textField_1;
    public JComboBox comboBox;
    public int judge;
    public TeacherMainView mainView;
	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					BookAddAndUpdate frame = new BookAddAndUpdate();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 */
	public BookAddAndUpdate(int judge,TeacherMainView mainView) {
		this.judge=judge;
		this.mainView=mainView;
		setBounds(100, 100, 330, 499);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("编号");
		lblNewLabel.setBounds(35, 26, 54, 15);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(144, 23, 118, 21);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel label = new JLabel("类型");
		label.setBounds(35, 75, 54, 15);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("名称");
		label_1.setBounds(35, 130, 54, 15);
		contentPane.add(label_1);
		
		JLabel label_4 = new JLabel("单价");
		label_4.setBounds(35, 190, 54, 15);
		contentPane.add(label_4);
		
		JLabel label_3 = new JLabel("条形码");
		label_3.setBounds(35, 246, 54, 15);
		contentPane.add(label_3);
		
		JLabel label_5 = new JLabel("作者");
		label_5.setBounds(35, 302, 54, 15);
		contentPane.add(label_5);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(144, 127, 118, 21);
		contentPane.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(144, 187, 118, 21);
		contentPane.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(144, 243, 118, 21);
		contentPane.add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(144, 299, 118, 21);
		contentPane.add(textField_5);
		
		JButton btnNewButton = new JButton("确定");
		btnNewButton.setBounds(35, 412, 93, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("取消");
		btnNewButton_1.setBounds(169, 412, 93, 23);
		contentPane.add(btnNewButton_1);
		
	    comboBox = new JComboBox();
		comboBox.setBounds(144, 72, 118, 21);
		contentPane.add(comboBox);
		comboBoxAdd();
		
		JLabel lblNewLabel_1 = new JLabel("出版社");
		lblNewLabel_1.setBounds(35, 357, 54, 15);
		contentPane.add(lblNewLabel_1);
		
		textField_1 = new JTextField();
		textField_1.setBounds(144, 354, 118, 21);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		BookAddAndUpdateListener bl=new BookAddAndUpdateListener(this);
		btnNewButton.addActionListener(bl);
		btnNewButton_1.addActionListener(bl);
		
		
		//设置窗口为可见
		   super.setVisible(true);
		   //设置窗口居中
		   super.setLocationRelativeTo(null);
		   //设置窗口不可以改变大小
		   super.setResizable(false);
		   //设置窗口能够正常关闭，通过按钮
		   super.setDefaultCloseOperation (JFrame.DISPOSE_ON_CLOSE);
			//为窗口设置一个监听，用来提醒用户是否关闭系统
	}
	public  void comboBoxAdd(){
    	MainViewDao dao=new MainViewDao();
    	String sql="select * from Book_Type_Table";
    	List<BookTypeVo> list=dao.getType(sql,BookTypeVo.class);
    	System.out.println(list.size());
    	if(list!=null){
    		for(int i=0;i<list.size();i++){
    			comboBox.addItem(list.get(i).getBook_Type_Name()+"_"+list.get(i).getBook_Type_Num());
    		}
    	}
    }

	public JTextField getTextField() {
		return textField;
	}

	public void setTextField(JTextField textField) {
		this.textField = textField;
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

	public JTextField getTextField_1() {
		return textField_1;
	}

	public void setTextField_1(JTextField textField_1) {
		this.textField_1 = textField_1;
	}

	public JComboBox getComboBox() {
		return comboBox;
	}

	public void setComboBox(JComboBox comboBox) {
		this.comboBox = comboBox;
	}

	public int getJudge() {
		return judge;
	}

	public void setJudge(int judge) {
		this.judge = judge;
	}

	public TeacherMainView getMainView() {
		return mainView;
	}

	public void setMainView(TeacherMainView mainView) {
		this.mainView = mainView;
	}
	
}
