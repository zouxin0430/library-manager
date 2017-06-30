/**
 * 
 */
package zouxin.library.dao;

import javax.swing.JTable;

import zouxin.library.util.JdbcTemplate;
import zouxin.library.vo.SharedBookVo;
import zouxin.library.vo.StorageUserInVo;
import zouxin.library.vo.StudentBorrowVo;

/**
 * @author ZouXin
 *2017-5-10
 */
public class TeacherDao {
     JdbcTemplate jdbcTemplate=new JdbcTemplate();
     /**
      * 插入数据到学生借阅表
      * @param sql
      * @param vo
      * @return 一个整数，判断数据库操作是否正确
      * @author ZouXin
      * 2017-5-11
      */
     public int insertBorrow(String sql,StudentBorrowVo vo){
    	 int s=jdbcTemplate.InsertOrUpdateOrDelete(sql, new Object[]{vo.getBook_Number(),vo.getStudent_number(),vo.getStudent_Borrow_Number(),vo.getArrear(),vo.getStudent_Borrow_Return_Time(),vo.getBorrow_Time(),vo.getWhether_Return(),vo.getLocation()});
    	 return s;
     }
     /**
      * 插入到学生共享表
      * @param sql
      * @param vo
      * @return一个整数，判断数据库操作是否正确
      * @author ZouXin
      * 2017-5-11
      */
     public int insertBorrowShare(String sql,SharedBookVo vo){
    	 int s=jdbcTemplate.InsertOrUpdateOrDelete(sql, new Object[]{vo.getBook_Number(),vo.getStudent_number(),vo.getShared_InStore_Date(),vo.getShared_InStore_Num(),vo.getShared_Retrieve_Date(),vo.getShared_Location()});
    	 return s;
     }
     /**
      * 学生可借书时长
      * @param student_num
      * @author ZouXin
      * 2017-5-11
      */
     public void returnDate(String student_num){
    	 String sql_time="select ait.authority_borrow_time from Authority_Information_Table ait,Student_Information_table sit where sit.student_number=? and sit.authority_num=ait.authority_num";
		 StorageUserInVo.Authority_Borrow_Time=Integer.parseInt(jdbcTemplate.selectOne(sql_time, new Object[]{student_num}).toString());

     }
     /**
      * 修改数据
      * @param sql
      * @param objects
      * @return 一个整数，判断数据库操作是否正确
      * @author ZouXin
      * 2017-5-11
      */
     public int updateValue(String sql,Object... objects){
    	 int s=jdbcTemplate.InsertOrUpdateOrDelete(sql, objects);
    	 return s;
     }
}
