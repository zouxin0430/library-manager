/**
 * 
 */
package com.library.listenIDUS;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import zouxin.library.dao.MainViewDao;
import zouxin.library.view.TeacherMainView;

/**
 * @author ZouXin
 *2017-5-14
 */
public class AddManagerListener implements ActionListener{
     TeacherMainView mainView;
     public AddManagerListener(TeacherMainView mainView){
    	 this.mainView=mainView;
     }
	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String command=e.getActionCommand();
		String username=mainView.getTextField_10().getText();
		String password=mainView.getTextField_11().getText();
		String name=mainView.getTextField_12().getText();
		String age=mainView.getTextField_13().getText();
		String card=mainView.getTextField_14().getText();
		String telphone=mainView.getTextField_18().getText();
		String sex="";
		if(mainView.getRadioMan().isSelected()){
			sex="男";
		}
		if(mainView.getRadioWuman().isSelected()){
			sex="女";
		}
		MainViewDao dao=new MainViewDao();
		if(command.equals("addManager")){
			if(!username.equals("")&&!password.equals("")&&!name.equals("")&&!age.equals("")&&!card.equals("")&&!telphone.equals("")&&!sex.equals("")){
				int select = JOptionPane.showConfirmDialog(mainView, "是否添加管理员");
				if(select==0){
					String sqlcount="select count(*) from manager_information_table mit where mit.manager_user_id=?";
					int count=dao.selectCount(sqlcount, username);
					if(count>0){
						JOptionPane.showMessageDialog(mainView, "该账号已存在,请重新输入");
					}else{
						String sql="insert into manager_information_table values(?,?,?,?,?,?,'管理员')";
						int s=dao.insertUpdateDelete(sql, username,password,name,sex,age,card);
						if(s==1){
							JOptionPane.showMessageDialog(mainView, "管理员添加成功");
							mainView.getTextField_10().setText("");
							mainView.getTextField_11().setText("");
							mainView.getTextField_12().setText("");
							mainView.getTextField_13().setText("");
							mainView.getTextField_14().setText("");
							mainView.getTextField_18().setText("");
						}else{
							JOptionPane.showMessageDialog(mainView, "系统错误");
						}
					}
				}
			}else{
				JOptionPane.showMessageDialog(mainView, "您有未填写的值，请完善空格");
			}
		}else if(command.equals("resetAdd")){
			mainView.getTextField_10().setText("");
			mainView.getTextField_11().setText("");
			mainView.getTextField_12().setText("");
			mainView.getTextField_13().setText("");
			mainView.getTextField_14().setText("");
			mainView.getTextField_18().setText("");
		}
	}

}
