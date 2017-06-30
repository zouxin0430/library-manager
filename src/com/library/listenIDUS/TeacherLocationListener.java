/**
 * 
 */
package com.library.listenIDUS;

import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import zouxin.library.dao.MainViewDao;
import zouxin.library.view.LibraryAddAndUpdate;
import zouxin.library.view.LocationAddAndUpdate;
import zouxin.library.view.TeacherMainView;

/**
 * @author ZouXin
 *2017-5-11
 */
public class TeacherLocationListener implements ActionListener{
     TeacherMainView mainView;
     public TeacherLocationListener(TeacherMainView mainView){
    	 this.mainView=mainView;
     }
	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		MainViewDao dao=new MainViewDao();
		String command=e.getActionCommand();
		String name=mainView.getTextField_3().getText();
		List<String> list=new ArrayList<String>();
		JTable table=mainView.getTable_3();
		int selectRow=table.getSelectedRow();
		if(command.equals("locationSelect")){
			String sql="select lt.location_number,lt.location_name,lt.location_introduction,lrit.library_room_name||'_'||lrit.library_room_number,lit.library_name||'_'||lit.library_number from location_table lt,library_information_table lit,library_room_information_table lrit where lt.library_room_number=lrit.library_room_number and lrit.library_number=lit.library_number ";
			if(!name.equals("")){
				sql=sql+" and lt.location_name=?";
				list.add(name);
			}
			Object[][] rowsData=dao.getBookInf(sql, list);
			Object[] colunmNames=new Object[]{"库位编号","名称","介绍","库室名称","图书馆"};
			DefaultTableModel dataModel=new DefaultTableModel(rowsData,colunmNames);
			table.setModel(dataModel);
		}else if(command.equals("locationAdd")){
			new LocationAddAndUpdate(0,mainView);
		}else if(command.equals("locationUpdate")){
			if(selectRow<0){
				JOptionPane.showMessageDialog(mainView, "请选择需要修改的数据");
			}else{
//				int select=JOptionPane.showConfirmDialog(mainView, "是否确认修改");
//				if(select==0){
					String lnumber=table.getValueAt(selectRow, 0).toString();
					String lname=table.getValueAt(selectRow, 1).toString();
					String lint=table.getValueAt(selectRow, 2).toString();
					String rnum=table.getValueAt(selectRow, 3).toString();
					String lnum=table.getValueAt(selectRow, 4).toString();
					LocationAddAndUpdate lib=new LocationAddAndUpdate(1, mainView);
					lib.getTextField().setText(lnumber);
					lib.getTextField().setEditable(false);
                    lib.getTextField_2().setText(lname);
                    lib.getTextField_3().setText(lint);
                    lib.getComboBox().setSelectedItem(lnum);
                    lib.getComboBox_1().setSelectedItem(rnum);
//				}
			}
		}else if(command.equals("locationDelete")){
			if(selectRow<0){
				
				JOptionPane.showMessageDialog(mainView, "请选择需要删除的数据");
			}else{
				int selectD=JOptionPane.showConfirmDialog(mainView, "是否确定删除该条数据");
				if(selectD==0){
					String lnumber=table.getValueAt(selectRow, 0).toString();
					String sqlroom="select count(*) from Inventory_Information_table where location_number=?";
					int s=dao.selectCount(sqlroom, lnumber);
					if(s==0){
						String sql="delete location_table where location_number=?";
						int x=dao.insertUpdateDelete(sql, lnumber);
						if(x==1){
							JOptionPane.showMessageDialog(mainView, "删除成功");
							mainView.getLocationSelect().doClick();
						}else{
							JOptionPane.showMessageDialog(mainView, "系统错误");
						}
					}else{
						JOptionPane.showMessageDialog(mainView, "请先删除使用该库位的数据");
					}
				}
				
			}
		}
		
	}

}
