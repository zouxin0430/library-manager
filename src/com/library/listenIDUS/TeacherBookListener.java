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
import zouxin.library.view.BookAddAndUpdate;
import zouxin.library.view.LibraryAddAndUpdate;
import zouxin.library.view.TeacherMainView;

/**
 * @author ZouXin
 *2017-5-11
 */
public class TeacherBookListener implements ActionListener{
     TeacherMainView mainView;
     public TeacherBookListener(TeacherMainView mainView){
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
		String booknumber=mainView.getTextField_4().getText();
		String name=mainView.getTextField_5().getText();;
		List<String> list=new ArrayList<String>();
		JTable table=mainView.getTable_4();
		int selectRow=table.getSelectedRow();
		if(command.equals("bookSelect")){
			String sql="select bit.book_number,bit.book_name,btt.book_type_name||'_'||btt.book_type_num,bit.book_price,bit.book_bar_code,bit.book_author,bit.bookr_press from book_information_table bit,book_type_table btt where bit.book_type_num=btt.book_type_num";
			if(!name.equals("")){
				sql=sql+" and bit.book_name=?";
				list.add(name);
			}
			if(!booknumber.equals("")){
				 
				 sql=sql+" and bit.book_number=? ";
				 list.add(booknumber);
			}
			Object[][] rowsData=dao.getBookInf(sql, list);
			Object[] colunmNames=new Object[]{"书籍编号","书籍名","类型","单价","条形码","作者","出版社"};
			DefaultTableModel dataModel=new DefaultTableModel(rowsData,colunmNames);
			table.setModel(dataModel);
		}else if(command.equals("bookAdd")){
			new BookAddAndUpdate(0,mainView);
		}else if(command.equals("bookUpdate")){
			if(selectRow<0){
				JOptionPane.showMessageDialog(mainView, "请选择需要修改的数据");
			}else{
//				int select=JOptionPane.showConfirmDialog(mainView, "是否确认修改");
//				if(select==0){
					String bnumber=table.getValueAt(selectRow, 0).toString();
					String bname=table.getValueAt(selectRow, 1).toString();
					String btype=table.getValueAt(selectRow, 2).toString();
					String bprice=table.getValueAt(selectRow, 3).toString();
					String bbarcode=table.getValueAt(selectRow, 4).toString();
					String bauther=table.getValueAt(selectRow, 5).toString();
					String bcbs=table.getValueAt(selectRow, 6).toString();
					BookAddAndUpdate lib=new BookAddAndUpdate(1,mainView);
					lib.getTextField().setText(bnumber);
					lib.getTextField().setEditable(false);
					lib.getTextField_1().setText(bcbs);
					lib.getTextField_2().setText(bname);
					lib.getTextField_3().setText(bprice);
					lib.getTextField_4().setText(bbarcode);
					lib.getTextField_5().setText(bauther);
					lib.getComboBox().setSelectedItem(btype);
//				}
			}
		}else if(command.equals("bookDelete")){
			if(selectRow<0){
				
				JOptionPane.showMessageDialog(mainView, "请选择需要删除的数据");
			}else{
				int selectD=JOptionPane.showConfirmDialog(mainView, "是否确定删除该条数据");
				if(selectD==0){
					String bnumber=table.getValueAt(selectRow, 0).toString();
					String sqld="select count(*) from Inventory_Information_table where book_number=?";
					int s=dao.selectCount(sqld, bnumber);
					if(s==0){
						String sql="delete book_information_table where book_number=?";
						int x=dao.insertUpdateDelete(sql, bnumber);
						if(x==1){
							JOptionPane.showMessageDialog(mainView, "删除成功");
							mainView.getBookSelect().doClick();
						}else{
							JOptionPane.showMessageDialog(mainView, "系统错误");
						}
					}else{
						JOptionPane.showMessageDialog(mainView, "请先删除使用该书籍的数据");
					}
				}
				
			}
		}
		
	}

}
