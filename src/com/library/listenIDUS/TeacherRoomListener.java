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
import zouxin.library.view.RoomAddAndUpdate;
import zouxin.library.view.TeacherMainView;

/**
 * @author ZouXin
 *2017-5-11
 */
public class TeacherRoomListener implements ActionListener{
     TeacherMainView mainView;
     public TeacherRoomListener(TeacherMainView mainView){
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
		String name=mainView.getTextField_2().getText();
		List<String> list=new ArrayList<String>();
		JTable table=mainView.getTable_2();
		int selectRow=table.getSelectedRow();
		if(command.equals("roomSelect")){
			String sql="select lrit.library_room_number,lrit.library_room_name,lrit.library_room_location,lrit.library_room_introduction,lit.library_name||'_'||lit.library_number from library_room_information_table lrit,library_information_table lit where lrit.library_number=lit.library_number";
			if(!name.equals("")){
				sql=sql+" and lrit.library_room_name=?";
				list.add(name);
			}
			Object[][] rowsData=dao.getBookInf(sql, list);
			Object[] colunmNames=new Object[]{"库室编号","名称","位置","介绍","所属图书馆"};
			DefaultTableModel dataModel=new DefaultTableModel(rowsData,colunmNames);
			table.setModel(dataModel);
		}else if(command.equals("roomAdd")){
			new RoomAddAndUpdate(0,mainView);
		}else if(command.equals("roomUpdate")){
			if(selectRow<0){
				JOptionPane.showMessageDialog(mainView, "请选择需要修改的数据");
			}else{
//				int select=JOptionPane.showConfirmDialog(mainView, "是否确认修改");
//				if(select==0){
					String rnumber=table.getValueAt(selectRow, 0).toString();
					String rname=table.getValueAt(selectRow, 1).toString();
					String rlocation=table.getValueAt(selectRow, 2).toString();
					String rint=table.getValueAt(selectRow, 3).toString();
					String rlbAll=table.getValueAt(selectRow, 4).toString();
					RoomAddAndUpdate lib=new RoomAddAndUpdate(1,mainView);
					lib.getTextField().setText(rnumber);
					lib.getTextField().setEditable(false);
					lib.getTextField_2().setText(rname);
					lib.getTextField_3().setText(rlocation);
					lib.getTextField_4().setText(rint);
					lib.getComboBox().setSelectedItem(rlbAll);
					
					
//				}
			}
		}else if(command.equals("roomDelete")){
			if(selectRow<0){
				
				JOptionPane.showMessageDialog(mainView, "请选择需要删除的数据");
			}else{
				int selectD=JOptionPane.showConfirmDialog(mainView, "是否确定删除该条数据");
				if(selectD==0){
					String rnumber=table.getValueAt(selectRow, 0).toString();
					String sqlloca="select count(*) from location_table where library_room_number=?";
					int s=dao.selectCount(sqlloca, rnumber);
					if(s==0){
						String sql="delete library_room_information_table where library_room_number=?";
						int x=dao.insertUpdateDelete(sql, rnumber);
						if(x==1){
							JOptionPane.showMessageDialog(mainView, "删除成功");
							mainView.getRoomSelect().doClick();
						}else{
							JOptionPane.showMessageDialog(mainView, "系统错误");
						}
					}else{
						JOptionPane.showMessageDialog(mainView, "请先删除使用该图书馆的数据");
					}
				}
				
			}
		}
		
	}

}
