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

import com.library.listenIDUS.ComboxListener;
import com.library.listenIDUS.LocationAddAndUpdateListener;

import zouxin.library.dao.MainViewDao;
import zouxin.library.vo.BookTypeVo;
import zouxin.library.vo.LibraryRoomVo;
import zouxin.library.vo.LibraryVo;

/**
 * @author ZouXin
 *2017-5-11
 */
public class LocationAddAndUpdate extends JFrame {

	private JPanel contentPane;
	public JTextField textField;
	public JTextField textField_2;
	public JTextField textField_3;
	public JComboBox comboBox;
	public JComboBox comboBox_1;
    public int judge;
    public TeacherMainView mainView;
	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					LocationAddAndUpdate frame = new LocationAddAndUpdate();
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
	public LocationAddAndUpdate(int judge,TeacherMainView mainView) {
		this.judge=judge;
		this.mainView=mainView;
		setBounds(100, 100, 330, 433);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("编号");
		lblNewLabel.setBounds(35, 26, 54, 15);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(144, 23, 136, 21);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel label = new JLabel("图书馆");
		label.setBounds(35, 75, 80, 15);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("名称");
		label_1.setBounds(35, 186, 54, 15);
		contentPane.add(label_1);
		
		JLabel label_4 = new JLabel("介绍");
		label_4.setBounds(35, 242, 54, 15);
		contentPane.add(label_4);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(144, 183, 136, 21);
		contentPane.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(144, 239, 136, 21);
		contentPane.add(textField_3);
		
		JButton btnNewButton = new JButton("确定");
		btnNewButton.setBounds(37, 316, 93, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("取消");
		btnNewButton_1.setBounds(176, 316, 93, 23);
		contentPane.add(btnNewButton_1);
		
		comboBox = new JComboBox();
		comboBox.setBounds(143, 72, 137, 21);
		contentPane.add(comboBox);
		comboBoxAdd();
		JLabel label_2 = new JLabel("库室");
		label_2.setBounds(35, 128, 80, 15);
		contentPane.add(label_2);
		
		comboBox_1 = new JComboBox();
		comboBox_1.setBounds(143, 125, 137, 21);
		contentPane.add(comboBox_1);
		
		ComboxListener l=new ComboxListener(this);
		comboBox.addActionListener(l);
		
		LocationAddAndUpdateListener lil=new LocationAddAndUpdateListener(this);
		btnNewButton.addActionListener(lil);
		btnNewButton_1.addActionListener(lil);
		
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
    	String sql="select * from Library_Information_Table";
    	List<LibraryVo> list=dao.getType(sql,LibraryVo.class);
    	System.out.println(list.size());
    	comboBox.addItem("");
    	if(list!=null){
    		for(int i=0;i<list.size();i++){
    			comboBox.addItem(list.get(i).getLibrary_Name()+"_"+list.get(i).getLibrary_Number());
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

	public JComboBox getComboBox() {
		return comboBox;
	}

	public void setComboBox(JComboBox comboBox) {
		this.comboBox = comboBox;
	}

	public JComboBox getComboBox_1() {
		return comboBox_1;
	}

	public void setComboBox_1(JComboBox comboBox_1) {
		this.comboBox_1 = comboBox_1;
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
