/**
 * 
 */
package zouxin.library.util;

import java.awt.List;
import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.spi.DirStateFactory.Result;

import zouxin.library.vo.UserIdVo;

/**
 * @author ZouXin
 * 2017-3-26
 */
public class JdbcTemplate {
	public static void main(String[] args){
		JdbcTemplate jdbcTemplate=new JdbcTemplate();
		String sql="select bit.book_number+bit.book_number from book_information_table bit";
		int s=Integer.parseInt(jdbcTemplate.selectOne(sql).toString());
		System.out.println(s);
	}
      public int InsertOrUpdateOrDelete(String sql,Object... objects){
    	  Connection conn=null;
    	  PreparedStatement pstmt=null;
    	  int s=0;
    	  try {
			conn=JdbcUtil.getConnection();
			pstmt=conn.prepareStatement(sql);
			for(int i=0;i<objects.length;i++){
				pstmt.setObject(i+1, objects[i]);
			}
			s=pstmt.executeUpdate();
			conn.commit();
		} catch (SQLException e) {
			
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
    	  System.out.println(s+"     调用sql返回的状态值");
    	  return s;
      }
      public ArrayList<Object[]> selectValue(String sql,Object... objects){
    	  Connection conn=null;
    	  PreparedStatement pstmt=null;
    	  ArrayList<Object[]> list=null;
    	  try {
    		list= new ArrayList<Object[]>();
			conn=JdbcUtil.getConnection();
			pstmt=conn.prepareStatement(sql);
			for(int i=0;i<objects.length;i++){
//				System.out.println(objects[i]+"         "+i);
				pstmt.setObject(i+1, objects[i]);
			}
			ResultSet rs=pstmt.executeQuery();
			ResultSetMetaData data=rs.getMetaData();
			while(rs.next()){
				Object[] ob=new Object[data.getColumnCount()];
				for(int s=0;s<data.getColumnCount();s++){
					ob[s]=rs.getObject(s+1);
//					System.out.println(rs.getObject(s+1));
				}
				list.add(ob);
			}
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
    	  return list;
      }
      public Object selectOne(String sql,Object... objects){
    	  Connection conn=null;
    	  PreparedStatement pstmt=null;
    	  Object s=null;
    	  try {
			conn=JdbcUtil.getConnection();
			pstmt=conn.prepareStatement(sql);
			for(int i=0;i<objects.length;i++){
				pstmt.setObject(i+1, objects[i]);
//				System.out.println((i+1)+""+objects[i]);
			}
			ResultSet rs=pstmt.executeQuery();
			while(rs.next()){
				s=rs.getObject(1);
			}
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {		
				if(pstmt!=null){
					pstmt.close();
				}
				if(conn!=null){
					conn.close();
				}

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
    	  return s;
      }
      
      public <T> ArrayList<T>  queryValues(String sql,Class<T> t,Object... objects) throws InstantiationException, IllegalAccessException{
    	  Connection conn=null;
    	  PreparedStatement pstmt=null;
    	  ArrayList<T> list=new ArrayList<T>();
    	  try {
			conn=JdbcUtil.getConnection();
			pstmt=conn.prepareStatement(sql);
			for(int i=0;i<objects.length;i++){
				pstmt.setObject(i+1, objects[i]);
//				System.out.println(objects[i]);
			}
			ResultSet rs=pstmt.executeQuery();
//			System.out.println(rs.next());
			while(rs.next()){
//				System.out.println("我有值返回哦");
//				ResultSetMetaData data=rs.getMetaData();
//				int columnCount=data.getColumnCount();
//				for(int i=0;i<columnCount;i++){
//					System.out.println(rs.getObject("student_name"));
//					Object o=rs.getObject(i+1);
//					//o=o.toString();
//					System.out.println(rs.getObject("ssss"));
//					System.out.println(data.getColumnName(i+1)+"  列名"+"        "+o+"  列值              "+o.getClass().getName()+"  值属性  ");
//				}
				list.add(reflect(rs,t));
			}
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
    	  return list;
      }
//      public static void main(String[] args){
//    	  JdbcTemplate jdbcTemplate=new JdbcTemplate();
////    	  String sql="select * from demo_ceshi";
////    	  try {
////			jdbcTemplate.queryValues(sql, UserIdVo.class);
////		} catch (InstantiationException e) {
////			// TODO Auto-generated catch block
////			e.printStackTrace();
////		} catch (IllegalAccessException e) {
////			// TODO Auto-generated catch block
////			e.printStackTrace();
////		}
////    	  String sql="select s.student_name,s.student_number,s.student_age from Student_Information_table s where s.student_name='ddd'";
//    	  String sql="select student_name,student_number from Student_Information_table where Student_number='13070000' and Student_password='13070000'";
//    	  try {
//			ArrayList<UserIdVo> list=jdbcTemplate.queryValues(sql, UserIdVo.class);
//			for(int i=0;i<list.size();i++){
//				System.out.println(list.get(i).getStudent_Name());
//			}
//		} catch (InstantiationException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IllegalAccessException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//    	  
//      }
      
      public static <T> T reflect(ResultSet rs,Class<T> t) throws InstantiationException, IllegalAccessException, SQLException{
    	  Field[] fields=t.getDeclaredFields();
    	  T o=t.newInstance();
    	  for(Field f:fields){
    		  String name=f.getName();
    		  f.setAccessible(true);
 //   		  System.out.println("字段名："+name);
    		  Object returnValue=null;
    		  try{
    		  returnValue=rs.getObject(name);
    		  }catch (Exception e) {
    			  //break;
				// TODO: handle exception
			}
//    		  System.out.println(returnValue);
    		  if(returnValue!=null){
 //   			  System.out.println(returnValue.getClass().getName());
 //   			  System.out.println(f.getType());
    			  String fieldType=f.getType().getName();
        		  if(returnValue.getClass().getName().equals("java.math.BigDecimal")){
        			  System.out.println("ssss");
        			  System.out.println(f.getType());
        			  System.out.println(f.getType().equals("double"));
        			  if(fieldType.equals("java.lang.Double")||fieldType.equals("double")){
        				  System.out.println("ssss -------------------------------------");
        				  returnValue=Double.parseDouble(returnValue.toString());
        			  }
        			  if(fieldType.equals("int")||fieldType.equals("java.lang.Integer")){
        				  returnValue=Integer.parseInt(returnValue.toString());
        			  }
        			  
//        			  System.out.println(returnValue.getClass().getName()+"转换后");
        		  }
        		  if(returnValue.getClass().getName().equals("java.sql.Timestamp")){
        			  returnValue=returnValue.toString();
        		  }
        		  System.out.println("字段名："+name+"   "+"获取的值："+returnValue+"   "+"返回的类型 : "+returnValue.getClass().getName());
        		  f.set(o, returnValue);
    		  }

    	  }
    	  
    	  return o;
    	  
      }
}
