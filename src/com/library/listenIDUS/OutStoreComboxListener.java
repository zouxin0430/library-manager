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
import zouxin.library.view.Outstore;
import zouxin.library.vo.LibraryRoomVo;
import zouxin.library.vo.LibraryVo;

/**
 * @author ZouXin
 *2017-5-13
 */
public class OutStoreComboxListener implements ActionListener{
     Outstore store;
     
     public OutStoreComboxListener(Outstore store){
    	 this.store=store;
     }
	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String location=store.getComboBox().getSelectedItem().toString();
		String locationNum=location.split("_")[1];
		JComboBox comboBox=store.getComboBox_1();
		MainViewDao dao=new MainViewDao();
    	String sql="select lirt.* from library_room_information_table lirt,location_table lt where lt.library_room_number=lirt.library_room_number and lt.location_number=?";
    	List<LibraryRoomVo> list=dao.getType(sql,LibraryRoomVo.class,locationNum);
    	System.out.println(list.size());
    	comboBox.removeAllItems();
    	if(list!=null){
 //   		comboBox.addItem("");
    		for(int i=0;i<list.size();i++){
    			comboBox.addItem(list.get(i).getLibrary_Room_Name()+"_"+list.get(i).getLibrary_Room_Number());
    		}
    	}
	}
    
}
