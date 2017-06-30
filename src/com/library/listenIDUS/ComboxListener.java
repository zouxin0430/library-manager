/**
 * 
 */
package com.library.listenIDUS;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JComboBox;

import zouxin.library.dao.MainViewDao;
import zouxin.library.view.LocationAddAndUpdate;
import zouxin.library.vo.LibraryRoomVo;
import zouxin.library.vo.LibraryVo;

/**
 * @author ZouXin
 *2017-5-13
 */
public class ComboxListener implements ActionListener{
     LocationAddAndUpdate addAndUpdate;
     
     public ComboxListener(LocationAddAndUpdate addAndUpdate){
    	 this.addAndUpdate=addAndUpdate;
     }
	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String library=addAndUpdate.getComboBox().getSelectedItem().toString();
		String libraryNum=library.split("_")[1];
		JComboBox comboBox=addAndUpdate.getComboBox_1();
		MainViewDao dao=new MainViewDao();
    	String sql="select * from library_room_information_table lirt where lirt.library_number=?";
    	List<LibraryRoomVo> list=dao.getType(sql,LibraryRoomVo.class,libraryNum);
    	System.out.println(list.size());
    	comboBox.removeAllItems();
    	if(list!=null){
    		comboBox.addItem("");
    		for(int i=0;i<list.size();i++){
    			comboBox.addItem(list.get(i).getLibrary_Room_Name()+"_"+list.get(i).getLibrary_Room_Number());
    		}
    	}
	}
    
}
