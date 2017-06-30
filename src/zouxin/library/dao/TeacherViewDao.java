/**
 * 
 */
package zouxin.library.dao;

import java.util.List;

import zouxin.library.util.JdbcTemplate;
import zouxin.library.vo.StorageUserInVo;

/**
 * @author ZouXin
 *2017-4-25
 */
public class TeacherViewDao {
      JdbcTemplate jdbcTemplate=new JdbcTemplate();
      
      public Object[][] getTransaction(String sql,List<String> list){
    	  Object[] ob=new Object[list.size()];
      	for(int i=0;i<list.size();i++){
      		ob[i]=list.get(i);
//      		System.out.println(list.get(i)+i);
      	}
      	List<Object[]> listReturn=jdbcTemplate.selectValue(sql,ob);
      	System.out.println(listReturn.size());
      	if(listReturn.size()==0){
      		return new Object[][]{{}};
      	}else{
      		Object[][] objects=new Object[listReturn.size()][listReturn.get(0).length];
      		for(int j=0;j<listReturn.size();j++){
      			objects[j]=listReturn.get(j);
      		}
      		return objects;
      	}
      }

}
