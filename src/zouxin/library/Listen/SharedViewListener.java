/**
 * 
 */
package zouxin.library.Listen;

import java.awt.JobAttributes;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.JTable;

import zouxin.library.dao.MainViewDao;
import zouxin.library.util.JdbcTemplate;
import zouxin.library.view.MainView;
import zouxin.library.vo.StorageUserInVo;
import zouxin.library.vo.TransactionVo;

/**
 * @author ZouXin
 *2017-3-31
 */
public class SharedViewListener implements ActionListener{
     MainView mainView;
     public SharedViewListener(MainView mainView){
    	 this.mainView=mainView;
     }
	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String command=e.getActionCommand();
		MainViewDao dao=new MainViewDao();
		if(command.equals("共享")){
			int ssss=mainView.getTabbedPane().getSelectedIndex();
			System.out.println(ssss);
			if(mainView.getBook_Name_comboBox().getSelectedItem()!=null&&mainView.getLocation_comboBox().getSelectedItem()!=null&&mainView.getLibrary_Room_Combobox().getSelectedItem()!=null&&mainView.getLibrary_Combobox().getSelectedItem()!=null&&!mainView.getTextField_2().getText().equals("")&&!mainView.getBook_Name_comboBox().getSelectedItem().equals("")&&!mainView.getLocation_comboBox().getSelectedItem().equals("")){
				String bookNumber=mainView.getBook_Name_comboBox().getSelectedItem().toString();
				bookNumber=GeneralMethod.updateString(bookNumber);
				String locationNumber=mainView.getLocation_comboBox().getSelectedItem().toString();
				locationNumber=GeneralMethod.updateString(locationNumber);
				String sharedNum=mainView.getTextField_2().getText();
				TransactionVo vo=new TransactionVo();
						
				vo.setTransaction_location(locationNumber);
				vo.setTransaction_Num(Integer.parseInt(sharedNum));
				vo.setTransaction_Studnet_num(StorageUserInVo.userId);
				vo.setTransaction_Type("学生共享书籍");
				vo.setBook_Number(bookNumber);
				vo.setTransaction_Date(GeneralMethod.conversionDate());			
				int j=dao.updateSurplusQuantity(bookNumber, locationNumber,Integer.parseInt(sharedNum),Integer.parseInt(sharedNum));
				if(j==1){
					int i=dao.insertTransaction(vo);
					if(i==1){
						JOptionPane.showMessageDialog(mainView, "共享成功,请将共享的书籍送往图书馆,由图书馆管理员确认");
//                        mainView.getSelectValue().doClick();
					}else{
                        dao.updateSurplusQuantityReduce(bookNumber, locationNumber);
                        JOptionPane.showMessageDialog(mainView, "对不起,系统错误,请稍后重试,或者联系管理员");
					}
				}else{
					JOptionPane.showMessageDialog(mainView, "对不起,系统错误,请稍后重试,或者联系管理员");
				}
			}else {
				JOptionPane.showMessageDialog(mainView, "请确认信息都已填写");
			}
		}else if(command.equals("取消共享")){
			JTable table=mainView.getTable_3();
			int selectRows=table.getSelectedRow();
			if(selectRows<0){
				JOptionPane.showMessageDialog(mainView, "请选择需要取消共享的书籍");
			}else{
				int returnFlag=JOptionPane.showConfirmDialog(mainView, "是否取消共享","友情提示",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
				if(returnFlag==JOptionPane.YES_OPTION){//判断是否取消预借
				String location_num=table.getValueAt(selectRows, 11).toString();
				System.out.println(location_num);
				String transaction_id=table.getValueAt(selectRows, 10).toString();
				System.out.println(transaction_id);
				String book_name=table.getValueAt(selectRows, 3).toString();
				System.out.println(book_name);
				String sql_t="update Transaction_Table set transaction_YEs_NO='C',transaction_name=? where transaction_id=?";//用于修改事务表的sql语句
				String sql_i="update Inventory_Information_table set Surplus_Quantity=Surplus_Quantity-1 where location_number=? and book_number=(select book_number from Book_Information_Table where book_name=?) ";//用于修改库存的sql语句
				int return_i=dao.updateSurplusQuantityAdd_cancel(sql_i, new Object[]{location_num,book_name});
				System.out.println(return_i+"返回的状态值");
				if(return_i==1){
					int return_T=dao.updateSurplusQuantityAdd_cancel(sql_t, new Object[]{StorageUserInVo.userId,transaction_id});
					System.out.println(return_T+"返回的状态值");
					if(return_T==1){
						JOptionPane.showMessageDialog(mainView, "取消共享成功");
						SharedViewListener1.setTable1(table, dao);
					}else{
						String sql_i_c="update Inventory_Information_table set Surplus_Quantity=Surplus_Quantity-1 where location_number=? and book_number=(select book_number from Book_Information_Table where book_name=?";
						dao.updateSurplusQuantityAdd_cancel(sql_i_c, new Object[]{location_num,book_name} );
						JOptionPane.showMessageDialog(mainView, "系统异常，请联系管理员或稍后重试");
					}
				}else{
					JOptionPane.showMessageDialog(mainView, "系统异常，请联系管理员或稍后重试");
				}
				
			}//是否取消预借的结束
			}
			
		}
	}

}
