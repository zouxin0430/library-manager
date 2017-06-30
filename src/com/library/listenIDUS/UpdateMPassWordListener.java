/**
 * 
 */
package com.library.listenIDUS;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import zouxin.library.dao.MainViewDao;
import zouxin.library.view.MainView;
import zouxin.library.view.TeacherMainView;
import zouxin.library.vo.StorageUserInVo;

/**
 * @author ZouXin
 *2017-4-10
 */
public class UpdateMPassWordListener implements ActionListener{
    TeacherMainView mainView;
    
    public UpdateMPassWordListener(TeacherMainView mainView){
    	this.mainView=mainView;
    }
	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String command=e.getActionCommand();
		if(command.equals("updatePW")){
			//使用update的语句修改
			String passWord1=mainView.getTextField_16().getText();
			String passWord2=mainView.getTextField_17().getText();
			int select=JOptionPane.showConfirmDialog(mainView, "是否确认修改密码");
			if(select==0){
				if(passWord1.equals(passWord2)){
					String sql="update manager_information_table mit set mit.manager_password=? where mit.manager_user_id=? ";				
					Object[] obj=new Object[]{passWord1,StorageUserInVo.userId};
					MainViewDao dao=new MainViewDao();
					int i=dao.updateSurplusQuantityAdd_cancel(sql, obj);
					if(i==1){
						JOptionPane.showMessageDialog(mainView, "密码修改成功");
						mainView.getTextField_15().setText("");
						mainView.getTextField_16().setText("");
						mainView.getTextField_17().setText("");
						mainView.getLblNewLabel_14().setText("");
						mainView.getLblNewLabel_15().setText("");
					}else{
						JOptionPane.showMessageDialog(mainView, "系统异常，请联系管理员");
					}
				}else{
					mainView.getLblNewLabel_15().setText("两次密码输入不一致");
				}
			}
			

		}else if(command.equals("resetUpdate")){
			mainView.getTextField_15().setText("");
			mainView.getTextField_16().setText("");
			mainView.getTextField_17().setText("");
		}
	}

}
