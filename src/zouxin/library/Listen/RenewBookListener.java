/**
 * 
 */
package zouxin.library.Listen;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import zouxin.library.dao.MainViewDao;
import zouxin.library.view.MainView;

/**
 * @author ZouXin
 *2017-5-14
 */
public class RenewBookListener implements ActionListener{
     MainView mainView;
     public RenewBookListener(MainView mainView){
    	 this.mainView=mainView;
     }
	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		int selectRows=mainView.getTable_2().getSelectedRow();
		if(selectRows<0){
			JOptionPane.showMessageDialog(mainView, "请选择需要续借的书籍");
		}else{
			int select=JOptionPane.showConfirmDialog(mainView, "是否进行续借");
			if(select==0){
				String number=mainView.getTable_2().getValueAt(selectRows, 8).toString();
				String returnDate=mainView.getTable_2().getValueAt(selectRows, 3).toString();
				String sql="update student_borrow_book_table sbbt set sbbt.student_borrow_return_time=? where sbbt.student_borrow_num=?";
				MainViewDao dao = new MainViewDao();
				String sqlR="select sbbt.renewnum from student_borrow_book_table sbbt where sbbt.student_borrow_num=?";
				int renewN=dao.selectCount(sqlR, number);
				if(renewN<=1){
					if(GeneralMethod.compareDate(returnDate, GeneralMethod.conversionDate1())){
						int s=dao.insertUpdateDelete(sql, GeneralMethod.returnDate(returnDate),number);
						if(s==1){
							JOptionPane.showMessageDialog(mainView, "续借成功");
							String sqlUpdate="update student_borrow_book_table sbbt set sbbt.renewnum=sbbt.renewnum+1 where sbbt.student_borrow_num=?";
							dao.insertUpdateDelete(sqlUpdate, number);
							Object[][] ob=dao.getBorrow();
					    	Object[] cloumnNames=new Object[]{"书籍名称","数量","借书时间","归还时间","图书馆","库室","库位","书籍编号","编号","库位编号"};
//					    	Object[] cloumnNames=new Object[]{"图书馆","库室","库位","书名","剩余数量","书籍类型","作者","单价","条形码","出版社","书籍编号"};//列名
					    	DefaultTableModel model=new DefaultTableModel(ob,cloumnNames);
					    	mainView.getTable_2().setModel(model);
						}else{
							JOptionPane.showMessageDialog(mainView, "系统错误");
						}

					}else{
						JOptionPane.showMessageDialog(mainView, "您所借的书籍已经到期,不可进行续借,请前往还书");
					}
				}else{
					JOptionPane.showMessageDialog(mainView, "您续借次数已达上限,不可以继续续借,请归还书籍后继续借阅");
				}
				
			}
			
			}
		
	}
     
}
