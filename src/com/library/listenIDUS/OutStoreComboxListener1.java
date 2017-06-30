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
public class OutStoreComboxListener1 implements ActionListener{
     Outstore store;
     
     public OutStoreComboxListener1(Outstore store){
    	 this.store=store;
     }
	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String room=store.getComboBox_1().getSelectedItem().toString();
		System.out.println(room);
		String roomNum=room.split("_")[1];
		System.out.println(roomNum+"    ¿âÎ»µÄ±àºÅ");
		JComboBox comboBox=store.getComboBox_2();
		MainViewDao dao=new MainViewDao();
    	String sql="select lit.* from library_information_table lit,library_room_information_table lrit where lrit.library_number=lit.library_number and lrit.library_room_number=?";
    	List<LibraryVo> list=dao.getType(sql,LibraryVo.class,roomNum);
    	System.out.println(list.size());
    	comboBox.removeAllItems();
    	if(list!=null){
    		//comboBox.addItem("");
    		for(int i=0;i<list.size();i++){
    			comboBox.addItem(list.get(i).getLibrary_Name()+"_"+list.get(i).getLibrary_Number());
    		}
    	}
	}
    
}
