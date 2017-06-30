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

import com.library.listenIDUS.RoomAddAndUpdateListener;

import zouxin.library.dao.MainViewDao;
import zouxin.library.vo.LibraryVo;

/**
 * @author ZouXin
 *2017-5-11
 */
public class RoomAddAndUpdate extends JFrame {

	private JPanel contentPane;
	public JTextField textField;
	public JTextField textField_2;
	public JTextField textField_3;
	public JTextField textField_4;
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
//					RoomAddAndUpdate frame = new RoomAddAndUpdate();
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
	public RoomAddAndUpdate(int i,TeacherMainView mainView) {
		this.judge=i;
		this.mainView=mainView;
		setBounds(100, 100, 330, 449);
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
		
		JLabel label = new JLabel("图书馆编号");
		label.setBounds(35, 75, 80, 15);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("名称");
		label_1.setBounds(35, 130, 54, 15);
		contentPane.add(label_1);
		
		JLabel label_4 = new JLabel("介绍");
		label_4.setBounds(35, 190, 54, 15);
		contentPane.add(label_4);
		
		JLabel label_3 = new JLabel("位置");
		label_3.setBounds(35, 246, 54, 15);
		contentPane.add(label_3);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(144, 127, 136, 21);
		contentPane.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(144, 187, 136, 21);
		contentPane.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(144, 243, 136, 21);
		contentPane.add(textField_4);
		
		JButton btnNewButton = new JButton("确定");
		btnNewButton.setBounds(35, 336, 93, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("取消");
		btnNewButton_1.setBounds(169, 336, 93, 23);
		contentPane.add(btnNewButton_1);
		
		comboBox = new JComboBox();
		comboBox.setBounds(143, 72, 137, 21);
		contentPane.add(comboBox);
		comboBoxAdd(comboBox); 
		
		RoomAddAndUpdateListener rul=new RoomAddAndUpdateListener(this);
		btnNewButton.addActionListener(rul);
		btnNewButton_1.addActionListener(rul);
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
	public  void comboBoxAdd(JComboBox comboBox1){
    	MainViewDao dao=new MainViewDao();
    	String sql="select * from Library_Information_Table";
    	List<LibraryVo> list=dao.getType(sql,LibraryVo.class);
    	System.out.println(list.size());
    	if(list!=null){
    		for(int i=0;i<list.size();i++){
    			System.out.println(list.get(i).getLibrary_Name()+"_"+list.get(i).getLibrary_Number() +"名字名字");
    			comboBox1.addItem(list.get(i).getLibrary_Name()+"_"+list.get(i).getLibrary_Number());
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
