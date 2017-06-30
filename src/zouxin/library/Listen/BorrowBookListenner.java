/**
 * 
 */
package zouxin.library.Listen;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.Action;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import zouxin.library.dao.MainViewDao;
import zouxin.library.util.JdbcTemplate;
import zouxin.library.view.MainView;
import zouxin.library.vo.StorageUserInVo;
import zouxin.library.vo.TransactionVo;

/**
 * @author ZouXin
 * 2017-3-26
 */
public class BorrowBookListenner implements ActionListener{
     MainView mainView;
     public BorrowBookListenner(MainView mainView){
    	 this.mainView=mainView;
     }
	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
        MainViewDao dao=new MainViewDao();
		String command = e.getActionCommand();
		JTable table=mainView.getTable();
		if(command.equals("预借")){
			int selectedRow=mainView.getTable().getSelectedRow();			
			if(selectedRow<0){//判断是否选中行
				JOptionPane.showMessageDialog(mainView, "请选择需要借阅的书籍");
			}else{
				if(StorageUserInVo.User_YN.equals("N")){
					JOptionPane.showConfirmDialog(mainView, "对不起，你有欠费未缴清，请前往缴费");
				}else{
				int borrowNum=dao.selectBorrowBookNum();
				System.out.println("学生借了 "+borrowNum+"本书");
				if(borrowNum<StorageUserInVo.Authority_Borrow_Num){//判断是否还有权限借阅书籍
				int remaining=Integer.parseInt(table.getValueAt(selectedRow, 4).toString());
				String library=table.getValueAt(selectedRow, 0).toString();
				String library_Room=table.getValueAt(selectedRow, 1).toString();
				String location=table.getValueAt(selectedRow, 2).toString();
				String loaction_number=table.getValueAt(selectedRow, 11).toString();
				String bookName=table.getValueAt(selectedRow, 3).toString();
				if(remaining<1){//判断是否还有书籍可借
					JOptionPane.showMessageDialog(mainView, "您选择的"+library+" "+library_Room+" "+location+" "+" "+bookName+"库存不足,请选择其他库室或借阅其他书籍");
				}else{
				int returnFlag=JOptionPane.showConfirmDialog(mainView, "是否确定预借书籍");
				if(returnFlag==0){
				System.out.println(returnFlag);
				String bookNum=table.getValueAt(selectedRow, 10).toString();
				TransactionVo vo=new TransactionVo();
				vo.setBook_Number(bookNum);
				vo.setTransaction_Studnet_num(StorageUserInVo.userId);
				vo.setTransaction_Type("学生借阅书籍");
				vo.setTransaction_Date(GeneralMethod.conversionDate());
				vo.setTransaction_location(loaction_number);
				int j=dao.updateSurplusQuantityReduce(bookNum, loaction_number);
				if(j==1){
					int i=dao.insertTransaction(vo);
					if(i==1){
						JOptionPane.showMessageDialog(mainView, "预借成功,请前往图书馆取图书");
                        mainView.getSelectValue().doClick();
					}else{
                        dao.updateSurplusQuantityAdd(bookNum, loaction_number);
                        JOptionPane.showMessageDialog(mainView, "对不起,系统错误,请稍后重试,或者联系管理员");
					}
				}else{
					JOptionPane.showMessageDialog(mainView, "对不起,系统错误,请稍后重试,或者联系管理员");
				}
				}
				}//判断是否有书籍可以借的结束
			}else{
				JOptionPane.showMessageDialog(mainView, "对不起您借书的数量已达上限，请还书后预借，或者提高权限");
			}//判断是否还有权限借阅书籍结束
		    }//判断是否欠费
			}//判断是否选中行的if语句结束
			
			System.out.println(selectedRow+"   选中表格行数");
		}else if(command.equals("查询")){
			String author=mainView.getTextField_1().getText();//获取作者数据
			String bookName=mainView.getTextField().getText();//获取书籍名称数据
			Object type=mainView.getComboBox().getSelectedItem();//获取书籍类型数据
			System.out.println("作者:"+author+"    "+"书名:"+bookName+"          "+"类型:"+type);
			String sql=null;//数据库运行语句
            List<String> sqlList=new ArrayList<String>();//需要传入到sql中的数据
            //通过获得单选框的是否选中的属性，来判断是否模糊查询
			if(mainView.getRdbtnNewRadioButton().isSelected()){
				       sql="select lit.library_name, "+
					       "lrit.library_room_name, "+
					       "lt.location_name, "+
					       "bit.book_name, "+
					       "iit.surplus_quantity, "+
					       "btt.book_type_name, "+
					       "bit.book_author, "+
					       "bit.book_price, "+				       
					       "bit.book_bar_code, "+					       					       
					       "bit.bookr_press, "+
					       "bit.book_number, "+
					       "lt.location_number "+
					  "from Book_Information_Table         bit, "+
					      "Inventory_Information_table    iit, "+
					      "Location_Table                 lt, "+
					       "Library_Room_Information_Table lrit, "+
					       "Library_Information_Table      lit, "+
					       "Book_Type_Table                btt "+
					 "where bit.book_type_num=btt.book_type_num "+
					   "and bit.book_number = iit.book_number "+
					   "and iit.location_number = lt.location_number "+
					   "and lt.library_room_number = lrit.library_room_number "+
					   "and lrit.library_number = lit.library_number ";
				//判断取出的值是否为空，不为空时修改sql语句和将值放入sqlOb中
				if(!type.equals("")){
					sqlList.add(type.toString());
					sql=sql+"and btt.book_type_name =? ";
				}
				if(!author.equals("")){
					sql=sql+"and bit.book_author like '%"+author+"%' ";
				}
				if(!bookName.equals("")){
					sql=sql+"and bit.book_name like '%"+bookName+"%' ";
				}
			}else{
				       sql="select lit.library_name, "+
						       "lrit.library_room_name, "+
						       "lt.location_name, "+
						       "bit.book_name, "+
						       "iit.surplus_quantity, "+
						       "btt.book_type_name, "+
						       "bit.book_author, "+
						       "bit.book_price, "+				       
						       "bit.book_bar_code, "+					       					       
						       "bit.bookr_press, "+
						       "bit.book_number, "+
						       "lt.location_number "+
					  "from Book_Information_Table         bit, "+
					      "Inventory_Information_table    iit, "+
					      "Location_Table                 lt, "+
					       "Library_Room_Information_Table lrit, "+
					       "Library_Information_Table      lit, "+
					       "Book_Type_Table                btt "+
					 "where bit.book_type_num=btt.book_type_num "+
					   "and bit.book_number = iit.book_number "+
					   "and iit.location_number = lt.location_number "+
					   "and lt.library_room_number = lrit.library_room_number "+
					   "and lrit.library_number = lit.library_number ";
				if(!type.equals("")){
					sqlList.add(type.toString());
					sql=sql+"and btt.book_type_name =? ";
				}
				if(!author.equals("")){
					sqlList.add(author);
					sql=sql+"and bit.book_author=? ";
				}
				if(!bookName.equals("")){
					sqlList.add(bookName);
					sql=sql+"and bit.book_name=? ";					
				}

			}
			System.out.println(sql);

            Object[][] rowsData=dao.getBookInf(sql, sqlList);//存储行的数据
            Object[] cloumnNames=new Object[]{"图书馆","库室","库位","书名","剩余数量","书籍类型","作者","单价","条形码","出版社","书籍编号","库位编号"};//列名
            DefaultTableModel dataModel=new DefaultTableModel(rowsData, cloumnNames);//(DefaultTableModel)mainView.getTable().getModel();//new DefaultTableModel(rowsData, cloumnNames);//(DefaultTableModel)mainView.getTable().getModel();
//            dataModel.setDataVector(rowsData, cloumnNames);
            mainView.getTable().setModel(dataModel);
		}
	}
       
}
