/**
 * 
 */
package com.library.listenIDUS;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import zouxin.library.dao.MainViewDao;
import zouxin.library.view.MainView;
import zouxin.library.view.TeacherMainView;
import zouxin.library.vo.StorageUserInVo;

/**
 * @author ZouXin
 *2017-4-10
 */
public class UpdateManagerMouseListener implements MouseListener{
    TeacherMainView mainView;
    
    
    public UpdateManagerMouseListener(TeacherMainView mainView){
    	this.mainView=mainView;
    }
	/* (non-Javadoc)
	 * @see java.awt.event.MouseListener#mouseClicked(java.awt.event.MouseEvent)
	 */
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		String passWord=mainView.getTextField_15().getText();//获取密码的值
		System.out.println(passWord);
		String sql="select count(*) from manager_information_table mit where mit.manager_user_id=? and mit.manager_password=?";
		MainViewDao dao=new MainViewDao();
		Object[] obj=new Object[]{StorageUserInVo.userId,passWord};
		int i=dao.selectStu(sql, obj);
		if(i==0){
			mainView.getLblNewLabel_14().setText("密码错误，请重新输入正确密码");
		}else if(i==1){
			mainView.getLblNewLabel_14().setText("密码正确");
		}
	}

	/* (non-Javadoc)
	 * @see java.awt.event.MouseListener#mousePressed(java.awt.event.MouseEvent)
	 */
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see java.awt.event.MouseListener#mouseReleased(java.awt.event.MouseEvent)
	 */
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see java.awt.event.MouseListener#mouseEntered(java.awt.event.MouseEvent)
	 */
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see java.awt.event.MouseListener#mouseExited(java.awt.event.MouseEvent)
	 * 当鼠标指针从textfield3中移出时，判断密码是否正确
	 */
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
//		String passWord=mainView.getTextField_3().getText();//获取密码的值
//		System.out.println(passWord);
//		String sql="select count(*) from student_information_table sit where sit.student_number=? and sit.student_password=?";
//		MainViewDao dao=new MainViewDao();
//		Object[] obj=new Object[]{StorageUserInVo.userId,passWord};
//		int i=dao.selectStu(sql, obj);
//		if(i==0){
//			mainView.getLblNewLabel_9().setText("密码错误，请重新输入正确密码");
//		}else if(i==1){
//			mainView.getLblNewLabel_9().setText("密码正确");
//		}
//		System.out.println(i);
		
	}

}
