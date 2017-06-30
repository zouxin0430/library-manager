/**
 * 
 */
package com.library.listenIDUS;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import zouxin.library.dao.MainViewDao;
import zouxin.library.view.LibraryAddAndUpdate;
import zouxin.library.view.LocationAddAndUpdate;
import zouxin.library.view.RoomAddAndUpdate;

/**
 * @author ZouXin
 *2017-5-11
 */
public class LocationAddAndUpdateListener implements ActionListener{
     LocationAddAndUpdate addAndUpdate;
     public LocationAddAndUpdateListener(LocationAddAndUpdate addAndUpdate){
    	 this.addAndUpdate=addAndUpdate;
     }
	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		MainViewDao dao=new MainViewDao();
		String command=e.getActionCommand();
		String number=addAndUpdate.getTextField().getText();
		String name=addAndUpdate.getTextField_2().getText();
		String introduction=addAndUpdate.getTextField_3().getText();
		String rlall=addAndUpdate.getComboBox().getSelectedItem().toString();
		String llrall=addAndUpdate.getComboBox_1().getSelectedItem().toString();
		String rnumber=llrall.split("_")[1];
		if(command.equals("确定")){
			if(addAndUpdate.getJudge()==0){
				int select=JOptionPane.showConfirmDialog(addAndUpdate, "是否确定添加");
				if(select==0){
					String sqll="select count(*) from location_table lt where lt.location_number=?";
					int judge=dao.selectCount(sqll, number);
					if(judge==0){
						String sqlI="insert into location_table values(?,?,?,?)";
						int s=dao.insertUpdateDelete(sqlI, number,rnumber,introduction,name);
						if(s==1){
							JOptionPane.showMessageDialog(addAndUpdate, "添加成功");
							if(addAndUpdate.getMainView().getTable_3().getSelectedRow()>=0){
								addAndUpdate.getMainView().setVisible(true);
								addAndUpdate.getMainView().getLocationSelect().doClick();
							}

							addAndUpdate.setVisible(false);
							addAndUpdate.dispose();
						}else{
							JOptionPane.showMessageDialog(addAndUpdate, "系统错误");
						}
					}else{
						JOptionPane.showMessageDialog(addAndUpdate, "该库位编号已存在，请重新输入");
					}
				}
			}else if(addAndUpdate.getJudge()==1){
				int select=JOptionPane.showConfirmDialog(addAndUpdate, "是否确定修改");
				if(select==0){
					    String sqlU="update location_table lt set lt.library_room_number=?,lt.location_introduction=?,lt.location_name=? where lt.location_number=?";
						int s=dao.insertUpdateDelete(sqlU,rnumber,introduction,name,number);
						if(s==1){
							JOptionPane.showMessageDialog(addAndUpdate, "修改成功");
							addAndUpdate.getMainView().setVisible(true);
							addAndUpdate.getMainView().getLocationSelect().doClick();
							addAndUpdate.setVisible(false);
							addAndUpdate.dispose();
							
						}else{
							JOptionPane.showMessageDialog(addAndUpdate, "系统错误");
						}
					
				}
			}
		}else if(command.equals("取消")){
			addAndUpdate.setVisible(false);
			addAndUpdate.dispose();
		}
	}
      
}
