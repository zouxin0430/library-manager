/**
 * 
 */
package zouxin.library.Listen;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.List;

import zouxin.library.dao.MainViewDao;
import zouxin.library.view.MainView;
import zouxin.library.vo.LibraryAndRoomVo;

/**
 * @author ZouXin
 *2017-3-30
 */
public class LocationComboBoxListener implements ActionListener{
    MainView mainView;
    public LocationComboBoxListener(MainView mainView){
    	this.mainView=mainView;
    }
	/* (non-Javadoc)
	 * @see java.awt.event.ItemListener#itemStateChanged(java.awt.event.ItemEvent)
	 */
//	@Override
//	public void itemStateChanged(ItemEvent e) {
//		System.out.println(mainView.getLocation_comboBox());
//		// TODO Auto-generated method stub
//		String selectValue=mainView.getLocation_comboBox().getSelectedItem().toString();
//		System.out.println(selectValue);
//		String sql="select lrit.library_room_name,lit.library_name from library_information_table lit,library_room_information_table lrit,location_table lt where lit.library_number=lrit.library_number and lrit.library_room_number=lt.library_room_number and lt.location_name=?";
//		MainViewDao dao=new MainViewDao();
//		
//		List<LibraryAndRoomVo> list=dao.getType(sql, LibraryAndRoomVo.class, new Object[]{selectValue});
//		System.out.println(list.size());
//		mainView.getLibrary_Room_Combobox().removeAllItems();
//		
////		mainView.getLibrary_Combobox().addItem("");
////		mainView.getLibrary_Room_Combobox().addItem("");
//		for(int i=0;i<list.size();i++){
////			System.out.println(mainView.getLibrary_Combobox());
////			System.out.println(list.get(i).getLibrary_Name());
//			mainView.getLibrary_Combobox().addItem(list.get(i).getLibrary_Room_Name());
//			mainView.getLibrary_Room_Combobox().addItem(list.get(i).getLibrary_Room_Name());
//		}
//	}
	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(mainView.getLocation_comboBox().getSelectedItem()!=null&&!mainView.getLocation_comboBox().getSelectedItem().equals("")){
			String selectValue=mainView.getLocation_comboBox().getSelectedItem().toString();
			selectValue=GeneralMethod.updateString(selectValue);
//			System.out.println(selectValue);
			String sql="select lrit.library_room_name||'_'||lrit.library_room_number as library_room_name,lit.library_name||'_'||lit.library_number as library_name from library_information_table lit,library_room_information_table lrit,location_table lt where lit.library_number=lrit.library_number and lrit.library_room_number=lt.library_room_number and lt.location_number=?";
			MainViewDao dao=new MainViewDao();
			
			List<LibraryAndRoomVo> list=dao.getType(sql, LibraryAndRoomVo.class, new Object[]{selectValue});
			System.out.println(list.size());
			mainView.getLibrary_Room_Combobox().removeAllItems();
			
//			mainView.getLibrary_Combobox().addItem("");
//			mainView.getLibrary_Room_Combobox().addItem("");
			for(int i=0;i<list.size();i++){
//				System.out.println(mainView.getLibrary_Combobox());
//				System.out.println(list.get(i).getLibrary_Name());
				mainView.getLibrary_Combobox().addItem(list.get(i).getLibrary_Room_Name());
				mainView.getLibrary_Room_Combobox().addItem(list.get(i).getLibrary_Room_Name());
			}
		}
	}
    
}
