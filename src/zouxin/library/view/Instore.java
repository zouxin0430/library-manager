/**
 * 
 */
package zouxin.library.view;

import java.awt.BorderLayout;

import java.awt.EventQueue;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;

import oracle.net.aso.b;

import com.library.listenIDUS.InStoreComboxListener;
import com.library.listenIDUS.InStoreComboxListener1;
import com.library.listenIDUS.InStoreListener;

import zouxin.library.dao.MainViewDao;
import zouxin.library.vo.LibraryVo;

/**
 * @author ZouXin
 *2017-5-11
 */
public class Instore extends JFrame {

	private JPanel contentPane;
	public JTextField textField;
	public JTextField textField_1;
	public JComboBox comboBox;
	public JComboBox comboBox_1;
	public JComboBox comboBox_2;
    public JButton select;
	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					Instore frame = new Instore();
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
	public Instore() {
		setBounds(100, 100, 356, 497);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("入库书籍");
		lblNewLabel.setBounds(43, 30, 54, 15);
		contentPane.add(lblNewLabel);
		
		JLabel label = new JLabel("图书馆");
		label.setBounds(43, 83, 54, 15);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("库室");
		label_1.setBounds(43, 143, 54, 15);
		contentPane.add(label_1);
		
		JLabel label_2 = new JLabel("库位");
		label_2.setBounds(43, 207, 54, 15);
		contentPane.add(label_2);
		
		JLabel label_3 = new JLabel("入库数量");
		label_3.setBounds(43, 277, 54, 15);
		contentPane.add(label_3);
		
	    comboBox = new JComboBox();
		comboBox.setBounds(172, 80, 122, 21);
		contentPane.add(comboBox);
		addComboBox(comboBox);
		
	    comboBox_1 = new JComboBox();
		comboBox_1.setBounds(172, 140, 122, 21);
		contentPane.add(comboBox_1);
		
	    comboBox_2 = new JComboBox();
		comboBox_2.setBounds(172, 204, 122, 21);
		contentPane.add(comboBox_2);
		
		textField = new JTextField();
		textField.setBounds(172, 274, 122, 21);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(172, 27, 122, 21);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		select = new JButton("查询");
		select.setBounds(304, 26, 25, 23);
		contentPane.add(select);
		
		JButton btnNewButton_1 = new JButton("确定");
		btnNewButton_1.setBounds(30, 364, 93, 23);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("取消");
		btnNewButton_2.setBounds(201, 364, 93, 23);
		contentPane.add(btnNewButton_2);
		
		InStoreComboxListener il=new InStoreComboxListener(this);
		InStoreComboxListener1 il1=new InStoreComboxListener1(this);
		
		comboBox.addActionListener(il);
		comboBox_1.addActionListener(il1);
		
		InStoreListener isl=new InStoreListener(this);
		btnNewButton_1.addActionListener(isl);
		btnNewButton_2.addActionListener(isl);
		select.addActionListener(isl);
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
	public void addComboBox(JComboBox comboBox){
		MainViewDao dao=new MainViewDao();
    	String sql="select * from library_information_table";
    	List<LibraryVo> list=dao.getType(sql,LibraryVo.class);
    	System.out.println(list.size());
    	comboBox.removeAllItems();
    	if(list!=null){
    		comboBox.addItem("");
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

	public JComboBox getComboBox_1() {
		return comboBox_1;
	}

	public void setComboBox_1(JComboBox comboBox_1) {
		this.comboBox_1 = comboBox_1;
	}

	public JComboBox getComboBox_2() {
		return comboBox_2;
	}

	public void setComboBox_2(JComboBox comboBox_2) {
		this.comboBox_2 = comboBox_2;
	}

	public JButton getSelect() {
		return select;
	}

	public void setSelect(JButton select) {
		this.select = select;
	}
	
}
