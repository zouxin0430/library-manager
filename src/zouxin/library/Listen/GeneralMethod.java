/**
 * 
 */
package zouxin.library.Listen;

import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.swing.ImageIcon;

import zouxin.library.util.JdbcTemplate;

/**
 * @author ZouXin
 *2017-3-27
 */
public class GeneralMethod {
	
	/**
	 * 将当前时间转换为一个指定的类型
	 * @return 一个转换后的时间，为String类型
	 * @author ZouXin
	 * 2017-3-27
	 */
      public static String conversionDate(){
    	  SimpleDateFormat sf=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
    	  String date=sf.format(new Date());
    	  System.out.println("转换后的当前时间为"+date);
    	  return date;
      }
      /**
  	 * 将当前时间转换为一个指定的类型
  	 * @return 一个转换后的时间，为String类型
  	 * @author ZouXin
  	 * 2017-3-27
  	 */
      public static String conversionDate1(){
    	  SimpleDateFormat sf=new SimpleDateFormat("yyyy-MM-dd");
    	  String date=sf.format(new Date());
    	  System.out.println("转换后的当前时间为"+date);
    	  return date;
      }
      /**
       * 计算时间 时间加上
       * @param month
       * @return String 类型的时间
       * @author ZouXin
       * 2017-5-14
       */
      public static String CalculationDate(Date date1,int month){
    	  SimpleDateFormat f=new SimpleDateFormat("yyyy-MM-dd");
    	  Calendar c = Calendar.getInstance();
    	  c.setTime(date1);
          c.add(Calendar.MONTH, month);
          String date=f.format(c.getTime());
          System.out.println("计算后的还书时间为："+ date);
    	  return date;
      }
      /**
       * 
       * @param imageUrl
       * @return
       * @author ZouXin
       * 2017-3-29
       */
      public static ImageIcon createImage(String imageUrl){
  		URL url=GeneralMethod.class.getResource(imageUrl);
//  		System.out.println(url);
  		if(url!=null){
  			return  new ImageIcon(url);
  		}
  		return null;
      }
      /**
       * 拆分字符串
       * @param value
       * @return 拆分后的字符串 
       * @author ZouXin
       * 2017-5-14
       */
      public static String updateString(String value){
    	  String[] s=value.split("_");
    	  return s[1];
      }
      /**
       * 转换时间和计算时间
       * @param date
       * @return String 类型，返回计算后的时间
       * @author ZouXin
       * 2017-5-14
       */
      public static String returnDate(String date){
    	  SimpleDateFormat f=new SimpleDateFormat("yyyy-MM-dd");
    	  Date date1=null;
    	  String returnDate=null;
    	  try {
			date1=f.parse(date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	  if(date1!=null){
    		  returnDate =CalculationDate(date1,2);
    	  }
    	  return returnDate;
      }
      /**
       * 比较时间的大小
       * @param d1 归还时间
       * @param d2 当前时间
       * @return 是否归还时间比当前时间小
       * @author ZouXin
       * 2017-5-14
       */
      public static boolean compareDate(String d1,String d2){
    	  SimpleDateFormat f=new SimpleDateFormat("yyyy-MM-dd");
    	  boolean flag=true;
    	  try {
    		Date date2=f.parse(d2);
			Date date1=f.parse(d1);
			if(date2.getTime()>date1.getTime()){
				flag=false;
			}
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	  return flag;
      }
      public static void main(String[] args){
//    	  Date date=returnDate("2017-05-03");
//    	  System.out.println(CalculationDate(date,2));
    	 System.out.println(compareDate("2016-01-02","2017-01-03"));
      }
}
