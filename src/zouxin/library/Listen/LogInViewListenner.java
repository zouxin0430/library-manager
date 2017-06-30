/**
 * 
 */
package zouxin.library.Listen;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JOptionPane;

import zouxin.library.dao.LogInViewDao;
import zouxin.library.view.LogInView;
import zouxin.library.view.MainView;
import zouxin.library.view.TeacherMainView;
import zouxin.library.vo.StorageUserInVo;

/**
 * @author ZouXin
 * 2017-3-26
 */
public class LogInViewListenner implements ActionListener{
     LogInView logInView;
     public LogInViewListenner(LogInView logInView){
    	 this.logInView=logInView;
     }
	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String command=e.getActionCommand();
		LogInViewDao inViewDao=new LogInViewDao();
//		System.out.println(inView.getTextField());
		if(command.equals("登录")){
			String userId=logInView.getTextField().getText();
//			System.out.println(userId);
			String passWord=new String(logInView.getPasswordField().getPassword());
//			System.out.println(passWord);
			int s=inViewDao.decideUser(userId, passWord);
			System.out.println("返回的判断是管理员还是用户还是用户名密码错误的状态值 : "+s);//0:代表用户名或密码错误  1:管理员 2:学生
			if(s==2){
				new MainView();
				logInView.setVisible(false);
				logInView.dispose();
			}else if(s==1){
				if(StorageUserInVo.manager_sf.equals("超级管理员")){
					new TeacherMainView();
				}else if(StorageUserInVo.manager_sf.equals("管理员")){
					
				}	
				logInView.setVisible(false);
				logInView.dispose();
			}else if(s==0){
				JOptionPane.showMessageDialog(logInView, "您的账号或者密码错误，请确认账号或密码是否输入错误");
				logInView.getPasswordField().setText("");
			}
		}else if(command.equals("取消")){
			logInView.setVisible(false);
			logInView.dispose();
		}
	}
     
}
