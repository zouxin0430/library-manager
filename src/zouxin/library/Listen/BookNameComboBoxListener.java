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
import zouxin.library.vo.LibraryRoomVo;
import zouxin.library.vo.LocationVo;

/**
 * @author ZouXin
 *2017-3-31
 */
public class BookNameComboBoxListener implements ActionListener{
	MainView mainView;
    public BookNameComboBoxListener(MainView mainView){
    	this.mainView=mainView;
    }
	/* (non-Javadoc)
	 * @see java.awt.event.ItemListener#itemStateChanged(java.awt.event.ItemEvent)
	 */
//	@Override
//	public void itemStateChanged(ItemEvent e) {
//		// TODO Auto-generated method stub
//		String selectValue=mainView.getBook_Name_comboBox().getSelectedItem().toString();
//		//select lt.location_name from book_information_table bit,inventory_information_table iit,location_table lt where bit.book_number=iit.book_number and lt.location_number=iit.location_number and bit.book_name='ÕÔÔÆ´«'
//		//select lrit.library_room_name from Library_Room_Information_Table lrit,Library_Information_Table lit where lit.library_number=lrit.library_number and lit.library_name=?
//		String sql="select lt.location_name from book_information_table bit,inventory_information_table iit,location_table lt where bit.book_number=iit.book_number and lt.location_number=iit.location_number and bit.book_name=?";
//		MainViewDao dao=new MainViewDao();
////		System.out.println("hehhehe");
//		List<LocationVo> list=dao.getType(sql, LocationVo.class, new Object[]{selectValue});
//		mainView.getLocation_comboBox().removeAllItems();
////		mainView.getLocation_comboBox().addItem("");
////		System.out.println("hehe"+list.size());
//		mainView.getLocation_comboBox().addItem(1);
//		for(int i=0;i<list.size();i++){
//			mainView.getLocation_comboBox().addItem(list.get(i).getLocation_Name());
//		}
//		return;
//	}
	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(mainView.getBook_Name_comboBox().getSelectedItem()!=null){
			String selectValue=mainView.getBook_Name_comboBox().getSelectedItem().toString();
			selectValue=GeneralMethod.updateString(selectValue);
			String sql="select lt.location_name||'_'||lt.location_number as location_name from  inventory_information_table iit,location_table lt where iit.book_number=? and lt.location_number=iit.location_number";
			MainViewDao dao=new MainViewDao();
//			System.out.println("hehhehe");
			List<LocationVo> list=dao.getType(sql, LocationVo.class, new Object[]{selectValue});
			mainView.getLocation_comboBox().removeAllItems();
//			mainView.getLocation_comboBox().addItem("");
//			System.out.println("hehe"+list.size());
			mainView.getLocation_comboBox().addItem("");
			for(int i=0;i<list.size();i++){
				mainView.getLocation_comboBox().addItem(list.get(i).getLocation_Name());
			}
		}
	}
        
}
