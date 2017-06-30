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
import zouxin.library.view.BookTypeAddAndUpdate;
import zouxin.library.view.LibraryAddAndUpdate;
import zouxin.library.view.LocationAddAndUpdate;
import zouxin.library.view.TeacherMainView;

/**
 * @author ZouXin
 *2017-5-11
 */
public class TeacherTypeListener implements ActionListener{
     TeacherMainView mainView;
     public TeacherTypeListener(TeacherMainView mainView){
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
		String name=mainView.getTextField_6().getText();
		List<String> list=new ArrayList<String>();
		JTable table=mainView.getTable_5();
		int selectRow=table.getSelectedRow();
		System.out.println(selectRow +"呵呵呵呵呵呵");
		if(command.equals("typeSelect")){
			String sql="select * from book_type_table btt where 1=1";
			if(!name.equals("")){
				sql=sql+" and btt.book_type_name=?";
				list.add(name);
			}
			Object[][] rowsData=dao.getBookInf(sql, list);
			Object[] colunmNames=new Object[]{"书籍类型编号","类型名称","介绍"};
			DefaultTableModel dataModel=new DefaultTableModel(rowsData,colunmNames);
			table.setModel(dataModel);
		}else if(command.equals("typeAdd")){
			new BookTypeAddAndUpdate(0,mainView);
		}else if(command.equals("typeUpdate")){
			if(selectRow<0){
				JOptionPane.showMessageDialog(mainView, "请选择需要修改的数据");
			}else{
//				int select=JOptionPane.showConfirmDialog(mainView, "是否确认修改");
//				if(select==0){
					String tnumber=table.getValueAt(selectRow, 0).toString();
					String tname=table.getValueAt(selectRow, 1).toString();
					String tint=table.getValueAt(selectRow, 2).toString();
					BookTypeAddAndUpdate lib=new BookTypeAddAndUpdate(1, mainView);
					lib.getTextField().setText(tnumber);
					lib.getTextField_2().setText(tname);
					lib.getTextField_3().setText(tint);
//				}
			}
		}else if(command.equals("typeDelete")){
			if(selectRow<0){
				
				JOptionPane.showMessageDialog(mainView, "请选择需要删除的数据");
			}else{
				int selectD=JOptionPane.showConfirmDialog(mainView, "是否确定删除该条数据");
				if(selectD==0){
					String tnumber=table.getValueAt(selectRow, 0).toString();
					String sqlbook="select count(*) from book_information_table where book_type_num=?";
					int s=dao.selectCount(sqlbook, tnumber);
					if(s==0){
						String sql="delete book_type_table where book_type_num=?";
						int x=dao.insertUpdateDelete(sql, tnumber);
						if(x==1){
							JOptionPane.showMessageDialog(mainView, "删除成功");
							mainView.getTypeSelect().doClick();
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
