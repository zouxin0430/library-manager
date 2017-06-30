/**
 * 
 */
package zouxin.library.Listen;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JTable;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.table.DefaultTableModel;

import zouxin.library.dao.MainViewDao;
import zouxin.library.view.MainView;
import zouxin.library.vo.StorageUserInVo;

/**
 * @author ZouXin
 *2017-4-1
 */
public class SharedViewListener1 implements ChangeListener{
    MainView mainView;
    public SharedViewListener1(MainView mainView){
    	this.mainView=mainView;
    }
	/* (non-Javadoc)
	 * @see javax.swing.event.ChangeListener#stateChanged(javax.swing.event.ChangeEvent)
	 */
	@Override
	public void stateChanged(ChangeEvent e) {
		// TODO Auto-generated method stub
		MainViewDao dao=new MainViewDao();
		int selectIndex=mainView.getTabbedPane().getSelectedIndex();
		if(selectIndex==1){
//			System.out.println(selectIndex);
        JTable table=mainView.getTable_3();
        setTable1(table, dao);	
		}else if(selectIndex==2){
			String sqlR="select lit.library_name||'_'||lit.library_number,lrit.library_room_name||'_'||lrit.library_room_number,lt.location_name||'_'||lt.location_number,bit.book_name||'_'||bit.book_number,sbit.shared_instore_date,sbit.shared_instore_num,sbit.shared_retrieve_date  from shared_book_information_table sbit,book_information_table bit,location_table lt,library_information_table lit,library_room_information_table lrit where lrit.library_room_number=lt.library_room_number and lrit.library_number=lit.library_number and bit.book_number=sbit.book_number and lt.location_number=sbit.shared_location and sbit.student_number=?";
			List<String> listR=new ArrayList<String>();
			listR.add(StorageUserInVo.userId);
			Object[][] rowsData=dao.getBookInf(sqlR, listR);
			Object[] colunmNames=new Object[]{"图书馆","库室","库位","书籍","共享时间","共享数量","可取回时间"};
			DefaultTableModel dataModel=new DefaultTableModel(rowsData,colunmNames);
			mainView.getTable_4().setModel(dataModel);
		}
	}
    public static void setTable1(JTable table,MainViewDao dao){
		String sql="select lit.library_name, "+
				"       lrit.library_room_name, "+
				"       lt.location_name, "+
				"      bit.book_name, "+
				"       tt.transaction_num, "+
				"       btt.book_type_name, "+
				"       bit.book_author, "+
				"       bit.book_price, "+
				"       bit.book_bar_code, "+      
				"       bit.bookr_press, "+
				"       tt.transaction_id, "+
				"       tt.Transaction_Location "+
				"  from Book_Information_Table         bit, "+
				"       Inventory_Information_table    iit, "+
				"       Location_Table                 lt, "+
				"       Library_Room_Information_Table lrit, "+
				"       Library_Information_Table      lit, "+
				"       Book_Type_Table                btt, "+
				"       Transaction_Table              tt "+
				" where bit.book_type_num = btt.book_type_num "+
				"   and bit.book_number = iit.book_number "+
				"   and lt.location_number=iit.location_number "+
				"  and lt.library_room_number = lrit.library_room_number "+
				"   and lrit.library_number = lit.library_number "+
				"   and tt.book_number = bit.book_number "+
				"   and tt.transaction_yes_no = 'N' "+
				"   and tt.transaction_type='学生共享书籍' "+
				"   and tt.transaction_location=iit.location_number" +
				"   and tt.transaction_studnet_num =? ";
//		List<String> list=new ArrayList<String>();
		List<String> list=new ArrayList<String>();
		list.add(StorageUserInVo.userId);
		Object[][] rowsData=dao.getBookInf(sql, list);
		Object[] colunmNames=new Object[]{"图书馆","库室","库位","书名","借阅数量","书籍类型","作者","单价","条形码","出版社","事务ID","库位编号"};
		DefaultTableModel dataModel=new DefaultTableModel(rowsData,colunmNames);
		table.setModel(dataModel);
    }
}
