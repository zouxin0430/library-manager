/**
 * 
 */
package zouxin.library.vo;

/**
 * @author ZouXin
 *2017-3-27
 */
public class TransactionVo {
    public String book_Number;//书籍编号
    public int transaction_Num;//事务数量
    public String transaction_Type;//事务类型
    public String transaction_Name;//事务处理人
    public String transaction_Date;//事务申请时间
    public String transaction_Studnet_num;//学生学号
    public String transaction_Yes_No;//是否处理
    public String transaction_id;//事务处理编号
    public String transaction_location;//库位编号
    
    
    public String getTransaction_location() {
		return transaction_location;
	}


	public void setTransaction_location(String transaction_location) {
		this.transaction_location = transaction_location;
	}


	public String getBook_Number() {
		return book_Number;
	}


	public void setBook_Number(String book_Number) {
		this.book_Number = book_Number;
	}


	public int getTransaction_Num() {
		return transaction_Num;
	}


	public void setTransaction_Num(int transaction_Num) {
		this.transaction_Num = transaction_Num;
	}


	public String getTransaction_Type() {
		return transaction_Type;
	}


	public void setTransaction_Type(String transaction_Type) {
		this.transaction_Type = transaction_Type;
	}


	public String getTransaction_Name() {
		return transaction_Name;
	}


	public void setTransaction_Name(String transaction_Name) {
		this.transaction_Name = transaction_Name;
	}


	public String getTransaction_Date() {
		return transaction_Date;
	}


	public void setTransaction_Date(String transaction_Date) {
		this.transaction_Date = transaction_Date;
	}


	public String getTransaction_Studnet_num() {
		return transaction_Studnet_num;
	}


	public void setTransaction_Studnet_num(String transaction_Studnet_num) {
		this.transaction_Studnet_num = transaction_Studnet_num;
	}


	public String getTransaction_Yes_No() {
		return transaction_Yes_No;
	}


	public void setTransaction_Yes_No(String transaction_Yes_No) {
		this.transaction_Yes_No = transaction_Yes_No;
	}


	public String getTransaction_id() {
		return transaction_id;
	}


	public void setTransaction_id(String transaction_id) {
		this.transaction_id = transaction_id;
	}


	public TransactionVo(){
    	this.transaction_Num=1;
    	this.transaction_Name="未处理";
    	this.transaction_Yes_No="N";
    }
    
}
