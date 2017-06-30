/**
 * 
 */
package zouxin.library.Listen;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import zouxin.library.dao.MainViewDao;
import zouxin.library.view.MainView;
import zouxin.library.vo.StorageUserInVo;

/**
 * @author ZouXin
 * 2017-3-26
 */
public class Preemption_CardSwitchListenner implements ActionListener{
     MainView mainView;
     public Preemption_CardSwitchListenner(MainView mainView){
    	 this.mainView=mainView;
     }
	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String command=e.getActionCommand();
		if(command.equals("预借")){
			mainView.getPreemption_Card_card().show(mainView.getPreemption_Card(), "BorrowBook");
		}else if(command.equals("预借的书籍")){
			mainView.getPreemption_Card_card().show(mainView.getPreemption_Card(), "SelectMyBook");
			MainViewDao dao=new MainViewDao();
			JTable table=mainView.getTable_1();
			setTable(table, dao);
		}
	}
	public static void setTable(JTable table,MainViewDao dao){
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
				"   and tt.transaction_type='学生借阅书籍' "+
				"   and tt.transaction_location=iit.location_number" +
				"   and tt.transaction_studnet_num =? ";
				List<String> list=new ArrayList<String>();
				list.add(StorageUserInVo.userId);
				Object[][] rowsData=dao.getBookInf(sql, list);
				Object[] colunmNames=new Object[]{"图书馆","库室","库位","书名","借阅数量","书籍类型","作者","单价","条形码","出版社","事务ID","库位编号"};
				DefaultTableModel dataModel=new DefaultTableModel(rowsData,colunmNames);
				table.setModel(dataModel);
	}
           
}
