/**
 * 
 */
package com.library.listenIDUS;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JComboBox;

import zouxin.library.dao.MainViewDao;
import zouxin.library.view.Instore;
import zouxin.library.view.LocationAddAndUpdate;
import zouxin.library.vo.LibraryRoomVo;
import zouxin.library.vo.LibraryVo;
import zouxin.library.vo.LocationVo;

/**
 * @author ZouXin
 *2017-5-13
 */
public class InStoreComboxListener1 implements ActionListener{
     Instore store;
     
     public InStoreComboxListener1(Instore store){
    	 this.store=store;
     }
	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String room=store.getComboBox_1().getSelectedItem().toString();
		String roomNum=room.split("_")[1];
		JComboBox comboBox=store.getComboBox_2();
		MainViewDao dao=new MainViewDao();
    	String sql="select * from location_table lt where lt.library_room_number=?";
    	List<LocationVo> list=dao.getType(sql,LocationVo.class,roomNum);
    	System.out.println(list.size());
    	comboBox.removeAllItems();
    	if(list!=null){
    		comboBox.addItem("");
    		for(int i=0;i<list.size();i++){
    			comboBox.addItem(list.get(i).getLocation_Name()+"_"+list.get(i).getLocation_Number());
    		}
    	}
	}
    
}
