/**
 * 
 */
package zouxin.library.Listen;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import zouxin.library.dao.TeacherDao;
import zouxin.library.dao.TeacherViewDao;
import zouxin.library.view.TeacherMainView;
import zouxin.library.vo.SharedBookVo;
import zouxin.library.vo.StorageUserInVo;
import zouxin.library.vo.StudentBorrowVo;

/**
 * @author ZouXin
 *2017-4-25
 */
public class TeacherMainViewListener implements ActionListener{
    TeacherMainView mainView;
    public TeacherMainViewListener(TeacherMainView mainView){
    	this.mainView=mainView;
    }
	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String command=e.getActionCommand();
		JTable table=mainView.getTable();
		if(command.equals("查询")){
			String stuNum=mainView.getTextField().getText();
			String type=mainView.getComboBox().getSelectedItem().toString();
			System.out.println(stuNum+"    "+type);
			List<String> list=new ArrayList<String>();
			String sql="select sit.student_name,"+
					"       sit.student_number,"+
					"       tt.transaction_type,"+
					"       bit.book_name,"+
					"       tt.transaction_num,"+
					"       bit.book_author,"+
					"       bit.book_price,"+
					"       lt.location_name,"+
					"       lrit.library_room_name,"+
					"       lit.library_name,"+
					"       tt.transaction_location,"+
					"       bit.book_number,         "+
					"       tt.Transaction_id         "+
					"       from                              " +
					"       transaction_table              tt,"+
					"       book_information_table         bit,"+
					"       library_information_table      lit,"+
					"       library_room_information_table lrit,"+
					"       location_table                 lt,"+
					"       student_information_table      sit"+
					" where bit.book_number = tt.book_number"+
					"   and tt.transaction_location = lt.location_number"+
					"   and lt.library_room_number = lrit.library_room_number"+
					"   and lrit.library_number = lit.library_number"+
					"   and tt.transaction_studnet_num = sit.student_number"+
					"   and tt.transaction_yes_no='N'";
			if(!stuNum.equals("")){
				sql=sql+"and tt.transaction_studnet_num=? ";
				list.add(stuNum);
			}
			if(!type.equals("")){
				sql=sql+"and tt.transaction_type=? ";
				list.add(type);
			}
			TeacherViewDao dao=new TeacherViewDao();
			Object[][] allValue=dao.getTransaction(sql,list);
			Object[] cloumnNames=new Object[]{"学生姓名","学号","事务类型","书名","借书数量","作者","单价","库位","库房","图书馆","库位编号","书籍编号","事务编号"};//列名
            DefaultTableModel dataModel=new DefaultTableModel(allValue, cloumnNames);//(DefaultTableModel)mainView.getTable().getModel();//new DefaultTableModel(rowsData, cloumnNames);//(DefaultTableModel)mainView.getTable().getModel();
//            dataModel.setDataVector(rowsData, cloumnNames);
            table.setModel(dataModel);
		}else if(command.equals("确认")){
			int selectRow=table.getSelectedRow();
			if(selectRow<0){
				JOptionPane.showConfirmDialog(mainView, "请选择需要处理的业务");
			}else{
				 String type=table.getValueAt(selectRow, 2).toString();
				 String bookNumber=table.getValueAt(selectRow, 11).toString();
				 String studentNum=table.getValueAt(selectRow, 1).toString();
				 String t_quantity=table.getValueAt(selectRow, 4).toString();
				 String transactionID=table.getValueAt(selectRow, 12).toString();
				 String location=table.getValueAt(selectRow, 10).toString();
				 TeacherDao dao=new TeacherDao();
				 int select=JOptionPane.showConfirmDialog(mainView, "是否确认该事务");
				 System.out.println(select);
				 if(select==0){
				 if(type.equals("学生借阅书籍")){
					 dao.returnDate(studentNum);
					 StudentBorrowVo vo=new StudentBorrowVo();
					 vo.setBook_Number(bookNumber);
					 vo.setLocation(location);
					 vo.setStudent_Borrow_Number(Integer.parseInt(t_quantity));
					 vo.setStudent_number(studentNum);
					 vo.setArrear(0);
					 vo.setBorrow_Time(GeneralMethod.conversionDate());
					 vo.setStudent_Borrow_Return_Time(GeneralMethod.CalculationDate(new Date() ,StorageUserInVo.Authority_Borrow_Time));
					 vo.setWhether_Return("N");
				
					 String sql="insert into Student_Borrow_Book_Table values(?,?,?,?,?,?,?,?,Borrow_Book_Sequence.nextval,0)";
					 int borrow=dao.insertBorrow(sql, vo);
					 if(borrow==1){
						 String sql_t="update Transaction_Table set transaction_YEs_NO='Y',transaction_name=? where transaction_id=?";//用于修改事务表的sql语句
						 int update=dao.updateValue(sql_t, StorageUserInVo.userId,transactionID);
						 if(update==1){
							 JOptionPane.showMessageDialog(mainView, "学生借书事务处理成功");
						 }else{
							 JOptionPane.showMessageDialog(mainView, "系统错误");
						 }
					 }else{
						 JOptionPane.showMessageDialog(mainView, "系统错误");
					 }
				 }else if(type.equals("学生共享书籍")){
					 SharedBookVo voShared=new SharedBookVo();
					 voShared.setBook_Number(bookNumber);
					 voShared.setShared_InStore_Num(Integer.parseInt(t_quantity));
					 voShared.setShared_InStore_Date(GeneralMethod.conversionDate1());
					 voShared.setShared_Retrieve_Date(GeneralMethod.CalculationDate(new Date() ,12));
					 voShared.setShared_Location(location);
					 voShared.setStudent_number(studentNum);
					 String sqlShared="insert into shared_book_information_table values(?,?,?,?,?,?,Shared_Book_Sequence.nextval)";
					 int shared=dao.insertBorrowShare(sqlShared, voShared);
					 if(shared==1){
						 String sql_t="update Transaction_Table set transaction_YEs_NO='Y',transaction_name=? where transaction_id=?";//用于修改事务表的sql语句
						 int updateS=dao.updateValue(sql_t, StorageUserInVo.userId,transactionID);
						 if(updateS==1){
							 JOptionPane.showMessageDialog(mainView, "学生共享事务处理成功");
						 }else{
							 JOptionPane.showMessageDialog(mainView, "系统错误");
						 }
						 //JOptionPane.showMessageDialog(mainView, "学生共享事务处理成功");
					 }else{
						 JOptionPane.showMessageDialog(mainView, "系统错误");
					 }
				 }
				 mainView.getBtnNewButton().doClick();
			    }

			}
		}
	}

}
