/**
 * 
 */
package zouxin.library.Listen;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import zouxin.library.dao.MainViewDao;
import zouxin.library.view.MainView;
import zouxin.library.vo.StorageUserInVo;

/**
 * @author ZouXin
 *2017-3-28
 */
public class PreemptionListnner implements ActionListener{
    MainView mainView;
    public PreemptionListnner(MainView mainView){
    	this.mainView=mainView;
    }
	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String command=e.getActionCommand();
		if(command.equals("取消预借")){
			JTable table=mainView.getTable_1();
			int selectRows=table.getSelectedRow();
			if(selectRows<0){
				JOptionPane.showMessageDialog(mainView, "请选择需要取消预借的书籍");
			}else{
				int returnFlag=JOptionPane.showConfirmDialog(mainView, "是否取消预借","友情提示",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
				if(returnFlag==JOptionPane.YES_OPTION){//判断是否取消预借
				String location_num=table.getValueAt(selectRows, 11).toString();
				System.out.println(location_num);
				String transaction_id=table.getValueAt(selectRows, 10).toString();
				System.out.println(transaction_id);
				String book_name=table.getValueAt(selectRows, 3).toString();
				System.out.println(book_name);
				String sql_t="update Transaction_Table set transaction_YEs_NO='C',transaction_name=? where transaction_id=?";//用于修改事务表的sql语句
				String sql_i="update Inventory_Information_table set Surplus_Quantity=Surplus_Quantity+1 where location_number=? and book_number=(select book_number from Book_Information_Table where book_name=?) ";//用于修改库存的sql语句
				MainViewDao dao=new MainViewDao();
				int return_i=dao.updateSurplusQuantityAdd_cancel(sql_i, new Object[]{location_num,book_name});
				System.out.println(return_i+"返回的状态值");
				if(return_i==1){
					int return_T=dao.updateSurplusQuantityAdd_cancel(sql_t, new Object[]{StorageUserInVo.userId,transaction_id});
					System.out.println(return_T+"返回的状态值");
					if(return_T==1){
						JOptionPane.showMessageDialog(mainView, "取消预借成功");
						Preemption_CardSwitchListenner.setTable(table, dao);
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
