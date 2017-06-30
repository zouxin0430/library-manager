/**
 * 
 */
package zouxin.library.Listen;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import zouxin.library.dao.MainViewDao;
import zouxin.library.view.MainView;
import zouxin.library.vo.StorageUserInVo;

/**
 * @author ZouXin
 *2017-4-10
 */
public class UpdatePassWordListener implements ActionListener{
    MainView mainView;
    
    public UpdatePassWordListener(MainView mainView){
    	this.mainView=mainView;
    }
	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String command=e.getActionCommand();
		if(command.equals("修改密码")){
			//使用update的语句修改
			String passWord1=mainView.getTextField_4().getText();
			String passWord2=mainView.getTextField_5().getText();
			if(passWord1.equals(passWord2)){
				String sql="update student_information_table set student_password=? where student_number=?";
				Object[] obj=new Object[]{passWord1,StorageUserInVo.userId};
				MainViewDao dao=new MainViewDao();
				int i=dao.updateSurplusQuantityAdd_cancel(sql, obj);
				if(i==1){
					JOptionPane.showMessageDialog(mainView, "密码修改成功");
					mainView.getTextField_3().setText("");
					mainView.getTextField_4().setText("");
					mainView.getTextField_5().setText("");
					mainView.getLblNewLabel_10().setText("");
					mainView.getLblNewLabel_9().setText("");
				}else{
					JOptionPane.showMessageDialog(mainView, "系统异常，请联系管理员");
				}
			}else{
				mainView.getLblNewLabel_10().setText("两次密码输入不一致");
			}

		}
	}

}
