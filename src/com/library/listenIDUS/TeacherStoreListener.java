/**
 * 
 */
package com.library.listenIDUS;

import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import zouxin.library.dao.MainViewDao;
import zouxin.library.view.BookTypeAddAndUpdate;
import zouxin.library.view.Instore;
import zouxin.library.view.LibraryAddAndUpdate;
import zouxin.library.view.LocationAddAndUpdate;
import zouxin.library.view.Outstore;
import zouxin.library.view.TeacherMainView;
import zouxin.library.vo.LibraryRoomVo;
import zouxin.library.vo.LibraryVo;

/**
 * @author ZouXin
 *2017-5-11
 */
public class TeacherStoreListener implements ActionListener{
     TeacherMainView mainView;
     public TeacherStoreListener(TeacherMainView mainView){
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
		String number=mainView.getTextField_7().getText();
		String name=mainView.getTextField_8().getText();
		List<String> list=new ArrayList<String>();
		JTable table=mainView.getTable_6();
		int selectRow=table.getSelectedRow();
		if(command.equals("selectStore")){
			String sql="select lit.library_name||'_'||lit.library_number, "+
				       "lrit.library_room_name||'_'||lrit.library_room_number, "+
				       "lt.location_name||'_'||lt.location_number, "+
				       "bit.book_name||'_'||bit.book_number, "+
				       "iit.surplus_quantity, "+
				       "btt.book_type_name, "+
				       "bit.book_author, "+
				       "bit.book_price, "+				       
				       "bit.book_bar_code, "+					       					       
				       "bit.bookr_press "+
				  "from Book_Information_Table         bit, "+
				      "Inventory_Information_table    iit, "+
				      "Location_Table                 lt, "+
				       "Library_Room_Information_Table lrit, "+
				       "Library_Information_Table      lit, "+
				       "Book_Type_Table                btt "+
				 "where bit.book_type_num=btt.book_type_num "+
				   "and bit.book_number = iit.book_number "+
				   "and iit.location_number = lt.location_number "+
				   "and lt.library_room_number = lrit.library_room_number "+
				   "and lrit.library_number = lit.library_number ";
			if(!name.equals("")){
				sql=sql+" and bit.book_name=?";
				list.add(name);
			}
			if(!number.equals("")){
				sql=sql+" and bit.book_number=?";
				list.add(number);
			}
			Object[][] rowsData=dao.getBookInf(sql, list);
            Object[] cloumnNames=new Object[]{"图书馆","库室","库位","书名","剩余数量","书籍类型","作者","单价","条形码","出版社"};//列名
			DefaultTableModel dataModel=new DefaultTableModel(rowsData,cloumnNames);
			table.setModel(dataModel);
		}else if(command.equals("inStore")){
			new Instore();
		}else if(command.equals("outStore")){
			if(selectRow<0){
				new Outstore();
			}else{
				String library=table.getValueAt(selectRow, 0).toString();
				String room=table.getValueAt(selectRow, 1).toString();
				String location=table.getValueAt(selectRow, 2).toString();
				String book=table.getValueAt(selectRow, 3).toString();
				String locationNum=location.split("_")[1];
				System.out.println(locationNum+"库位编号");
				String libraryNum=library.split("_")[1];
				Outstore out=new Outstore();
				out.getTextField_1().setText(book);
//				addComboBox(out.getComboBox_1(),locationNum);
//				addComboBox1(out.getComboBox_2(),libraryNum);
				out.getComboBox().setSelectedItem(location);
				out.getComboBox_1().setSelectedItem(room);
				out.getComboBox_2().setSelectedItem(library);

			}
		}
		
	}
	public void addComboBox(JComboBox comboBox,String number){
		MainViewDao dao=new MainViewDao();
    	String sql="select lrit.* from location_table lt,library_room_information_table lrit where lrit.library_room_number=lt.library_room_number and lt.location_number=?";
    	List<LibraryRoomVo> list=dao.getType(sql,LibraryRoomVo.class,number);
    	System.out.println(list.size()+"集合的长度为");
    	comboBox.removeAllItems();
    	if(list!=null){
    		//comboBox.addItem("");
    		for(int i=0;i<list.size();i++){
    			comboBox.addItem(list.get(i).getLibrary_Room_Name()+"_"+list.get(i).getLibrary_Room_Number());
    		}
    	}
	}
	public void addComboBox1(JComboBox comboBox,String number){
		MainViewDao dao=new MainViewDao();
    	String sql="select lit.* from library_information_table lit,library_room_information_table lrit where lrit.library_number=lit.library_number and lrit.library_room_number=?";
    	List<LibraryVo> list=dao.getType(sql,LibraryVo.class,number);
    	System.out.println(list.size()+"第二个集合的长度为");
    	comboBox.removeAllItems();
    	if(list!=null){
    		//comboBox.addItem("");
    		for(int i=0;i<list.size();i++){
    			comboBox.addItem(list.get(i).getLibrary_Name()+"_"+list.get(i).getLibrary_Number());
    		}
    	}
	}
}
